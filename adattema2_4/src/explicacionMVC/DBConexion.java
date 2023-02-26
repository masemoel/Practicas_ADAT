package explicacionMVC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConexion {
	// Variables
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/nba";
	private static Connection instance = null;
	
	// Constructor
	public DBConexion() {
		
	}
	
	public static Connection getConnection() throws SQLException {
		if (instance == null) {
			instance = DriverManager.getConnection(JDBC_URL, "masemoel", "1609");
		}
		return instance;
	}
}