package explicacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Principal5 {
	static Connection con;
	
	public static void main(String[] args) {
		Statement stmt = null;
		PreparedStatement ps;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tubalcain", "masemoel", "1609");
			stmt = con.createStatement();
			String depnombre = "RRHH";
			String dep = "10";
			String loc = "Planta 5";
			String sql = "INSERT INTO departamentos VALUES (?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, depnombre);
			ps.setInt(2, Integer.parseInt(dep));
			ps.setString(3, loc);
			int filas;
			filas = ps.executeUpdate();
			System.out.println("Filas afectadas: "+filas);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
					System.out.println("Se ha cerrado la conexión.");
				}
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}