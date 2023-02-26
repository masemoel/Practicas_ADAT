package bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConexionMySQL {
	// Variables
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/examen2adat";
	private static Connection instance = null;
	
	// Constructor
	public DBConexionMySQL() {
		
	}
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		if (instance == null) {
			instance = DriverManager.getConnection(JDBC_URL, "masemoel", "0201");
		}
		return instance;
	}
}