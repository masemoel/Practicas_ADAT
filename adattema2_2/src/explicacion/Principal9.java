package explicacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Principal9 {
	static Connection con;
	
	public static void main(String[] args) {
		System.out.println("Iniciando...\n");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tubalcain", "root", "1609");
			//insertarDepartamento(1, "Contabilidad", "Jaén");
			//Departamento dep1 = new Departamento(2, "Ventas", "Torredelcampo");
			//insertarDepartamento(dep1);
			//mostrarDepartamentos();
			consultarDepartamento(2);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	// CRUD
	public static void insertarDepartamento(int numero, String nombre, String localidad) {
		String query = "INSERT INTO departamentos (dpto_no, dnombre, loc) VALUES (?, ?, ?)";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, numero);
			ps.setString(2, nombre);
			ps.setString(3, localidad);
			ps.executeUpdate();
			System.out.println("Departamento insertado correctamente.");
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void insertarDepartamento (Departamento d) {
		String query = "INSERT INTO departamentos (dpto_no, dnombre, loc) VALUES (?, ?, ?)";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, d.getNumero());
			ps.setString(2, d.getNombre());
			ps.setString(3, d.getLocalidad());
			ps.executeUpdate();
			System.out.println("Departamento insertado correctamente.");
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static List<Departamento> mostrarDepartamentos() {
		List<Departamento> lista = new ArrayList<Departamento>();
		String query = "SELECT * FROM departamentos";
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			int numero;
			String nombre, localidad;
			while (rs.next( )) {
				numero = rs.getInt("dpto_no");
				nombre = rs.getString("dnombre");
				localidad = rs.getString("loc");
				Departamento depar = new Departamento (numero, nombre, localidad);
				lista.add(depar);
				System.out.println(depar.toString());
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public static Departamento consultarDepartamento(int numero) {
		String query = "SELECT * FROM departamentos where dpto_no="+numero;
		Statement stmt = null;
		Departamento depar = new Departamento();
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			int num;
			String nombre, localidad;
			while (rs.next( )) {
				num = rs.getInt("dpto_no");
				nombre = rs.getString("dnombre");
				localidad = rs.getString("loc");
				depar = new Departamento (num, nombre, localidad);
				System.out.println(depar.toString());
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return depar;
	}
}