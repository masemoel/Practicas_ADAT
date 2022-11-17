package ej1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Manuel José Moral Eliche
 * Tema 2 - Ejercicio 2.1 - Acceso a datos
 */
public class Principal {
	// Variables
	private static Connection conexion = null;
	private static Statement statement, statement2;
	private static ResultSet resultset, resultset2;
	
	public static void main(String[] args) {
		try {
			// Se inicializa la conexión
			conexion = DriverManager.getConnection("jdbc:sqlite:C:\\\\Users\\Masemo\\eclipse-adat\\adattema2_1\\departamentos.dat");
			statement = conexion.createStatement();
			statement2 = conexion.createStatement();
			
			statement.executeUpdate("CREATE TABLE IF NOT EXISTS departamentos (id integer primary key autoincrement, nombre string, descripcion string, telefono integer, direccion string, ciudad string)");
			insertarDepartamentos("Consulta", "'Solucionamos las consultas de los clientes.'", 953159753, "Calle Menor", "Jaén");
			insertarDepartamentos("Marketing", "'Realizamos campañas de publicidad para la empresa.'", 953852147, "Calle Mayor", "Jamilena");
			actualizarDepartamentos(1, "Contabilidad", "'Gestionamos las cuentas de la empresa.'", 953159753, "Calle Menor", "Jaén");
			insertarDepartamentos("Administración", "'Gestión burocrática'", 953121512, "Calle Menor", "Jaén");
			mostrarDepartamentos();
			
			statement.executeUpdate("CREATE TABLE IF NOT EXISTS empleados (id integer primary key autoincrement, nombre string, apellidos string, cargo string, edad int, telefono int, depempleado int, FOREIGN KEY(depempleado) REFERENCES departamentos(id))");
			insertarEmpleados("Manuel José", "Moral Eliche", "Jefe", 19, 953567195, 1);
			insertarEmpleados("Pepito", "Pérez Contreras", "Empleado", 91, 958946532, 2);
			insertarEmpleados("Sole", "Sole", "Secretaria", 20, 953656565, 3);
			mostrarEmpleados();
			
			borrarEmpleadosConCuidado(3);
			mostrarDepartamentosVacios();
			mostrarDepartamentosConEmpleados();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conexion != null) {
					conexion.close();
					statement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	// Métodos CRUD departamentos
	public static void insertarDepartamentos(String nombre, String descripcion, int telefono, String direccion, String ciudad) throws SQLException {
		statement.executeUpdate("INSERT INTO departamentos (nombre, descripcion, telefono, direccion, ciudad) VALUES('"+nombre+"', "+descripcion+", "+telefono+", '"+direccion+"', '"+ciudad+"')");
	}
	
	public static void mostrarDepartamentos() throws SQLException {
		resultset=statement.executeQuery("SELECT * FROM departamentos");
		while (resultset.next()) {
			System.out.println("ID: "+resultset.getInt("id")+", nombre: "+resultset.getString("nombre")+", descripción: "+resultset.getString("descripcion")+", teléfono: "+resultset.getInt("telefono")+", dirección: "+resultset.getString("direccion")+", ciudad: "+resultset.getString("ciudad"));
		}
	}
	
	public static void actualizarDepartamentos(int id, String nombre, String descripcion, int telefono, String direccion, String ciudad) throws SQLException {
		statement.executeUpdate("UPDATE departamentos SET nombre='"+nombre+"', descripcion="+descripcion+", telefono="+telefono+", direccion='"+direccion+"', ciudad='"+ciudad+"' where id="+id);
	}
	
	public static void borrarDepartamentos(int id) throws SQLException {
		statement.executeUpdate("DELETE FROM departamentos WHERE id="+id);
	}
	
	public static void buscarDepartamentos(int id) throws SQLException {
		resultset=statement.executeQuery("SELECT * FROM departamentos WHERE id="+id);
		while (resultset.next()) {
			System.out.println("ID: "+resultset.getInt("id")+", edad: "+resultset.getString("nombre")+", teléfono: "+resultset.getInt("telefono")+", dirección: "+resultset.getString("direccion")+", ciudad: "+resultset.getString("ciudad"));
		}
	}
	
	// Métodos CRUD empleados
	public static void insertarEmpleados(String nombre, String apellidos, String cargo, int edad, int telefono, int depempleado) throws SQLException {
		statement.executeUpdate("INSERT INTO empleados (nombre, apellidos, cargo, edad, telefono, depempleado) VALUES('"+nombre+"', '"+apellidos+"', '"+cargo+"', "+edad+", "+telefono+", "+depempleado+")");
	}
	
	public static void mostrarEmpleados() throws SQLException {
		resultset=statement.executeQuery("SELECT * FROM empleados");
		while (resultset.next()) {
			System.out.println("ID: "+resultset.getInt("id")+", nombre: "+resultset.getString("nombre")+", apellidos: "+resultset.getString("apellidos")+", cargo: "+resultset.getString("cargo")+", edad: "+resultset.getInt("edad")+", teléfono: "+resultset.getInt("telefono")+", departamento del empleado: "+resultset.getInt("depempleado"));
		}
	}
	
	public static void actualizarEmpleados(int id, String nombre, String apellidos, String cargo, int edad, int telefono, int depempleado) throws SQLException {
		statement.executeUpdate("UPDATE empleados SET nombre='"+nombre+"', apellidos='"+apellidos+"', cargo='"+cargo+"', edad="+edad+", telefono="+telefono+", depempleado="+depempleado+" where id="+id);
	}
	
	public static void borrarEmpleados(int id) throws SQLException {
		statement.executeUpdate("DELETE FROM empleados WHERE id="+id);
	}
	
	public static void buscarEmpleados(int id) throws SQLException {
		resultset=statement.executeQuery("SELECT * FROM empleados WHERE id="+id);
		while (resultset.next()) {
			System.out.println("ID: "+resultset.getInt("id")+", nombre: "+resultset.getString("nombre")+", apellidos: "+resultset.getString("apellidos")+", cargo: "+resultset.getString("cargo")+", edad: "+resultset.getInt("edad")+", teléfono: "+resultset.getInt("telefono")+", departamento del empleado: "+resultset.getInt("depempleado"));
		}
	}
	
	public static void buscarEmpleadosPorDepartamento(int depempleado) throws SQLException {
		resultset=statement.executeQuery("SELECT * FROM empleados WHERE depempleado="+depempleado);
		while (resultset.next()) {
			System.out.println("\tID: "+resultset.getInt("id")+", nombre: "+resultset.getString("nombre")+", apellidos: "+resultset.getString("apellidos")+", cargo: "+resultset.getString("cargo")+", edad: "+resultset.getInt("edad")+", teléfono: "+resultset.getInt("telefono")+", departamento del empleado: "+resultset.getInt("depempleado"));
		}
	}
	
	// Ejercicio 3
	public static void mostrarDepartamentosConEmpleados() throws SQLException {
		resultset2=statement2.executeQuery("SELECT * FROM departamentos");
		while (resultset2.next()) {
			System.out.println("ID: "+resultset2.getInt("id")+", edad: "+resultset2.getString("nombre")+", descripción: "+resultset2.getString("descripcion")+", teléfono: "+resultset2.getInt("telefono")+", dirección: "+resultset2.getString("direccion")+", ciudad: "+resultset2.getString("ciudad"));
			buscarEmpleadosPorDepartamento(resultset2.getInt("id"));
		}
	}
	
	public static void mostrarDepartamentosVacios() throws SQLException {
		resultset=statement.executeQuery("SELECT * FROM departamentos WHERE id NOT IN (SELECT DISTINCT depempleado FROM empleados)");
		while (resultset.next()) {
			System.out.println("ID: "+resultset.getInt("id")+", nombre: "+resultset.getString("nombre")+", descripción: "+resultset.getString("descripcion")+", teléfono: "+resultset.getInt("telefono")+", dirección: "+resultset.getString("direccion")+", ciudad: "+resultset.getString("ciudad"));
		}
	}
	
	public static void borrarEmpleadosConCuidado(int id) throws SQLException {
		statement.executeUpdate("DELETE FROM departamentos WHERE id="+id+" AND id NOT IN (SELECT DISTINCT depempleado FROM empleados WHERE depempleado IS NOT NULL)");
	}
}