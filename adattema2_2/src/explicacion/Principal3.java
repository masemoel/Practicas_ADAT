package explicacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Principal3 {
	static Connection con;
	
	public static void main(String[] args) {
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tubalcain", "masemoel", "1609");
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM departamentos");
			ResultSetMetaData rsmd = rs.getMetaData();
			int n_columnas = rsmd.getColumnCount();
			String nulo;
			//System.out.println("Número de columnas restante"+n_columnas);
			for (int i=1;i<=n_columnas;i++) {
				System.out.println("Columna: "+i);
				System.out.println("Nombre: "+rsmd.getColumnName(i));
				System.out.println("Tipo de columna: "+rsmd.getColumnTypeName(i));
				if (rsmd.isNullable(i)==0) {
					nulo = "No";
				} else {
					nulo = "Sí";
				}
				System.out.println("Nulo: "+nulo);
				System.out.println("Ancho de la columna: "+rsmd.getColumnDisplaySize(i));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
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