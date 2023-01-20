package explicacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Principal4 {
	static Connection con;
	
	public static void main(String[] args) {
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tubalcain", "masemoel", "1609");
			stmt = con.createStatement();
			boolean valor = stmt.execute("SELECT * FROM departamentos");
			if (valor) {
				ResultSet rs = stmt.getResultSet();
				while (rs.next()) {
					System.out.println(rs.getString(1)+rs.getInt(2)+rs.getString(3));
				}
			} else {
				int num = stmt.getUpdateCount();
				System.out.println("Filas afectadas: "+num);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}