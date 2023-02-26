package explicacionMVC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JugadorDAOMySQL {
	// Variables
	private Connection con = null;
	private static JugadorDAOMySQL instance = null;
	
	// Constructor
	private JugadorDAOMySQL() throws SQLException {
		con = DBConexion.getConnection();
	}
	
	// Métodos
	public static JugadorDAOMySQL getInstance() throws SQLException {
		if (instance == null) {
			instance = new JugadorDAOMySQL();
		}
		return instance;
	}
	
	public void insert(Jugador j) throws SQLException {
		PreparedStatement ps = con.prepareStatement("INSERT INTO jugadores (codigo, nombre, procedencia, altura, peso, posicion, nombre_equipo) VALUES (?, ?, ?, ?, ?, ?, ?)");
		ps.setInt(1, j.getCodigo());
		ps.setString(2, j.getNombre());
		ps.setString(3, j.getProcedencia());
		ps.setString(4, j.getAltura());
		ps.setInt(5, j.getPeso());
		ps.setString(6, j.getPosicion());
		ps.setString(7, j.getNombre_equipo());
		ps.executeUpdate();
		ps.close();
	}
	
	public List<Jugador> findAll() throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM jugadores");
		ResultSet rs = ps.executeQuery();
		List<Jugador> result = null;
		while (rs.next( )) {
			if (result == null) {
				result = new ArrayList<>();
			}
			result.add(new Jugador(rs.getInt("codigo"), rs.getString("nombre"), rs.getString("nombre_equipo"), rs.getString("procedencia"), rs.getString("altura"), rs.getString("posicion"), rs.getInt("peso")));
			rs.close();
			ps.close();
		}
		return result;
	}
	
	public Jugador findByPk(int id) throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM jugadores WHERE codigo=?");
		ResultSet rs = ps.executeQuery();
		ps.setInt(1, id);
		Jugador result = null;
		if (rs.next()) {
			result = new Jugador(rs.getInt("codigo"), rs.getString("nombre"), rs.getString("nombre_equipo"), rs.getString("procedencia"), rs.getString("altura"), rs.getString("posicion"), rs.getInt("peso"));
		}
		rs.close();
		ps.close();
		return result;
	}
	
	public void delete(Jugador j) throws SQLException {
		delete(j.getCodigo());
	}
	
	public void delete(int id) throws SQLException {
		if (id <= 0) {
			return;
		}
		PreparedStatement ps = con.prepareStatement("SELECT * FROM jugadores WHERE codigo=?");
		ps.setInt(1, id);
		ps.executeUpdate();
		ps.close();
	}
	
	public void update(Jugador j) throws SQLException {
		if (j.getCodigo() <= 0) {
			return;
		}
		PreparedStatement ps = con.prepareStatement("UPDATE jugadores SET nombre = ?, procedencia = ?, altura = ?, peso = ?, posicion = ?, nombre_equipo = ? WHERE codigo = ?");
		ps.setString(1, j.getNombre());
		ps.setString(2, j.getProcedencia());
		ps.setString(3, j.getAltura());
		ps.setInt(4, j.getPeso());
		ps.setString(5, j.getPosicion());
		ps.setString(6, j.getNombre_equipo());
		ps.setInt(7, j.getCodigo());
		ps.executeUpdate();
		ps.close();
	}
	
	public void cerrarConexion() throws SQLException {
		con.close();
	}
}