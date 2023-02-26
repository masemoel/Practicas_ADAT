package bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConexionSQLite {
	// Variables
	private static final String JDBC_URL = "jdbc:sqlite:C:\\\\Users\\Masemoel\\eclipse-adat\\adattema2_examen\\examen2adat.db3";
	private static Connection instance = null;
	
	// Constructor
	public DBConexionSQLite() {
		
	}
	
	public static Connection getConnection() throws SQLException {
		if (instance == null) {
			instance = DriverManager.getConnection(JDBC_URL);
		}
		return instance;
	}
}