package explicacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PrincipalAccess {
	static Connection con;
	public static void main(String[] args) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			con = DriverManager.getConnection("jdbc:ucanaccess://./Database1.accdb");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}