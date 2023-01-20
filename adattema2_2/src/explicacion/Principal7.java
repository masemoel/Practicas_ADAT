package explicacion;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class Principal7 {
	static Connection con;

	public static void main(String[] args) {
		CallableStatement cs;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tubalcain", "masemoel", "1609");
			String dep = "7";
			String sql = "{ ? = call nombre_dep_alex(?) }";
			cs = con.prepareCall(sql);
			cs.setInt(2, Integer.parseInt(dep));
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.execute();
			System.out.println("Número de departamento: "+dep+", nombre: "+cs.getString(1));
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