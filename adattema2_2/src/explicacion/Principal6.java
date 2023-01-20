package explicacion;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Principal6 {
	static Connection con;
	
	public static void main(String[] args) {
		CallableStatement cs;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tubalcain", "masemoel", "1609");
			String dep = "5";
			String subida = "1000";
			String sql = "{ call subida_sal_alex(?, ?) }";
			cs = con.prepareCall(sql);
			cs.setInt(1, Integer.parseInt(dep));
			cs.setFloat(2, Float.parseFloat(subida));
			cs.executeUpdate();
			System.out.println("Subida realizada.");
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
}