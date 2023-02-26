package explicacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PrincipalH2 {
	static Connection con;
	public static void main(String[] args) {
		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:~/Desktop/tubalcain_h2.dat.mv.db");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}