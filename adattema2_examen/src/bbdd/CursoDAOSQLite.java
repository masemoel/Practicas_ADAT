package bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Curso;

public class CursoDAOSQLite {
	// Variables
	private Connection con = null;
	private static CursoDAOSQLite instance = null;
	
	// Constructor
	private CursoDAOSQLite() throws SQLException, ClassNotFoundException {
		con = DBConexionSQLite.getConnection();
	}
	
	// Métodos
	public static CursoDAOSQLite getInstance() throws SQLException, ClassNotFoundException {
		if (instance == null) {
			instance = new CursoDAOSQLite();
		}
		return instance;
	}
	
	public void insert(Curso c) throws SQLException {
		PreparedStatement ps = con.prepareStatement("INSERT INTO cursos (codigo, curso, nombre, nivel, fpdual, clase) VALUES (?, ?, ?, ?, ?, ?)");
		ps.setInt(1, c.getCodigo());
		ps.setInt(2, c.getCurso());
		ps.setString(3, c.getNombre());
		ps.setString(4, c.getNivel());
		ps.setBoolean(5, c.isFpdual());
		ps.setInt(6, c.getClase());
		ps.executeUpdate();
		ps.close();
	}
	
	public List<Curso> findAll() throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM cursos");
		ResultSet rs = ps.executeQuery();
		List<Curso> result = null;
		while (rs.next( )) {
			if (result == null) {
				result = new ArrayList<>();
			}
			result.add(new Curso(rs.getInt("codigo"), rs.getInt("curso"), rs.getString("nombre"), rs.getString("nivel"), rs.getBoolean("fpdual"), rs.getInt("clase")));
		}
		rs.close();
		ps.close();
		return result;
	}
	
	public Curso findByPk(int cod) throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM cursos WHERE codigo=?");
		ps.setInt(1, cod);
		ResultSet rs = ps.executeQuery();
		Curso result = null;
		if (rs.next()) {
			result = new Curso(rs.getInt("codigo"), rs.getInt("curso"), rs.getString("nombre"), rs.getString("nivel"), rs.getBoolean("fpdual"), rs.getInt("clase"));
		}
		rs.close();
		ps.close();
		return result;
	}
	
	public void delete(Curso c) throws SQLException {
		delete(c.getCodigo());
	}
	
	public void delete(int id) throws SQLException {
		if (id <= 0) {
			return;
		}
		PreparedStatement ps = con.prepareStatement("DELETE FROM cursos WHERE codigo=?");
		ps.setInt(1, id);
		ps.executeUpdate();
		ps.close();
	}
	
	public void update(Curso c) throws SQLException {
		if (c.getCodigo() < 0) {
			return;
		}
		PreparedStatement ps = con.prepareStatement("UPDATE cursos SET curso = ?, nombre = ?, nivel = ?, fpdual = ?, clase = ? WHERE codigo = ?");
		ps.setInt(1, c.getCurso());
		ps.setString(2, c.getNombre());
		ps.setString(3, c.getNivel());
		ps.setBoolean(4, c.isFpdual());
		ps.setInt(5, c.getClase());
		ps.setInt(6, c.getCodigo());
		ps.executeUpdate();
		ps.close();
	}
	
	public void cerrarConexion() throws SQLException {
		con.close();
	}
}