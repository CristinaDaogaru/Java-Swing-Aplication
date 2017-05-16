package DatabaseCon;

import java.sql.*;
import javax.swing.*;

public class Connect {

	public static Connection setDataBaseConn() {
		// TODO Auto-generated method stub
		Connection conn = null;
		
		String password = "calculatoare";
		String userName = "sa";
		
		String url = "jdbc:sqlserver://localhost:1433;databaseName=Problema14";
		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, userName, password);
			JOptionPane.showMessageDialog(null, "Exista conexiune");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	/////////////////////////////////////////////////////////////////////////////////////////////
	


}




