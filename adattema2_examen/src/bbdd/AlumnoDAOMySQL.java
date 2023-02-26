package bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Alumno;

public class AlumnoDAOMySQL {
	// Variables
	private Connection con = null;
	private static AlumnoDAOMySQL instance = null;
	
	// Constructor
	private AlumnoDAOMySQL() throws SQLException, ClassNotFoundException {
		con = DBConexionMySQL.getConnection();
	}
	
	// Métodos
	public static AlumnoDAOMySQL getInstance() throws SQLException, ClassNotFoundException {
		if (instance == null) {
			instance = new AlumnoDAOMySQL();
		}
		return instance;
	}
	
	public void insert(Alumno a) throws SQLException {
		PreparedStatement ps = con.prepareStatement("INSERT INTO alumnos (dni, nombre, apellido1, apellido2, repetidor, edad, cod_curso) VALUES (?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, a.getDni());
		ps.setString(2, a.getNombre());
		ps.setString(3, a.getApellido1());
		ps.setString(4, a.getApellido2());
		ps.setBoolean(5, a.isRepetidor());
		ps.setInt(6, a.getEdad());
		ps.setInt(7, a.getCod_curso());
		ps.executeUpdate();
		ps.close();
	}
	
	public List<Alumno> findAll() throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM alumnos");
		ResultSet rs = ps.executeQuery();
		List<Alumno> result = null;
		while (rs.next( )) {
			if (result == null) {
				result = new ArrayList<>();
			}
			result.add(new Alumno(rs.getString("dni"), rs.getString("nombre"), rs.getString("apellido1"), rs.getString("apellido2"), rs.getBoolean("repetidor"), rs.getInt("edad"), rs.getInt("cod_curso")));
		}
		rs.close();
		ps.close();
		return result;
	}
	
	public Alumno findByPk(String dni) throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM alumnos WHERE dni=?");
		ps.setString(1, dni);
		ResultSet rs = ps.executeQuery();
		Alumno result = null;
		if (rs.next()) {
			result = new Alumno(rs.getString("dni"), rs.getString("nombre"), rs.getString("apellido1"), rs.getString("apellido2"), rs.getBoolean("repetidor"), rs.getInt("edad"), rs.getInt("cod_curso"));
		}
		rs.close();
		ps.close();
		return result;
	}
	
	public void delete(Alumno a) throws SQLException {
		delete(a.getDni());
	}
	
	public void delete(String dni) throws SQLException {
		if (dni == "") {
			return;
		}
		PreparedStatement ps = con.prepareStatement("DELETE FROM alumnos WHERE dni=?");
		ps.setString(1, dni);
		ps.executeUpdate();
		ps.close();
	}
	
	public void update(Alumno a) throws SQLException {
		if (a.getDni() == "") {
			return;
		}
		PreparedStatement ps = con.prepareStatement("UPDATE alumnos SET nombre = ?, apellido1 = ?, apellido2 = ?, repetidor = ?, edad = ?, cod_curso = ? WHERE dni = ?");
		ps.setString(1, a.getNombre());
		ps.setString(2, a.getApellido1());
		ps.setString(3, a.getApellido2());
		ps.setBoolean(4, a.isRepetidor());
		ps.setInt(5, a.getEdad());
		ps.setInt(6, a.getCod_curso());
		ps.setString(7, a.getDni());
		ps.executeUpdate();
		ps.close();
	}
	
	public void cerrarConexion() throws SQLException {
		con.close();
	}
}