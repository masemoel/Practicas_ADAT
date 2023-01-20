package explicacion;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Principal2 {
	static Connection con;
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tubalcain", "masemoel", "1609");
			DatabaseMetaData dbmd = con.getMetaData();
			String nombre = dbmd.getDatabaseProductName();
			String driver = dbmd.getDriverName();
			String url = dbmd.getURL();
			String usuario = dbmd.getUserName();
			System.out.println("Información de la base de datos:");
			System.out.println("Nombre: "+nombre);
			System.out.println("Driver: "+driver);
			System.out.println("URL: "+url);
			System.out.println("Usuario: "+usuario);
			ResultSet rs = dbmd.getTables(null, "usuario", null, null);
			while (rs.next()) {
				String catalogo = rs.getString(1);
				String esquema = rs.getString(2);
				String tabla = rs.getString(3);
				String tipo = rs.getString(4);
				System.out.println("Catálogo: " +catalogo+", "+esquema+", "+tabla+", "+tipo);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}