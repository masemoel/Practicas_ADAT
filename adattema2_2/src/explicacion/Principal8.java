package explicacion;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class Principal8 {
	static Connection con;
	
	public static void main(String[] args) {
		CallableStatement cs;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tubalcain", "root", "1609");
			String dep = "7";
			String sql = "{ call datos_dep(?, ?, ?)}";
			cs = con.prepareCall(sql);
			cs.setInt(1, Integer.parseInt(dep));
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.execute();
			System.out.println("Número de departamento: "+dep+", nombre: "+cs.getString(2)+", localidad: "+cs.getString(3));
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