package DatabaseOP;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import DatabaseCon.Connect;

public class UpdateTabel {
	public static Connection conn = Connect.setDataBaseConn();
	
	public static void UpdateTable(String tableName,String numeColoana,String valuare,String coloanaCond,String valuareCond){

		String queryUpdate = "UPDATE "+tableName + " SET " + numeColoana + "="+ valuare + " WHERE " + coloanaCond + "=" + valuareCond + ";";
		System.out.println("queryUpdate : " + queryUpdate);
		
		Statement st = null;
		
		try {
			st = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		 try {
			st.executeUpdate(queryUpdate);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
