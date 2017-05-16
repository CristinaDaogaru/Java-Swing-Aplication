package DatabaseOP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DatabaseCon.Connect;

public class GetValueFromTable {

	public static Connection conn = Connect.setDataBaseConn();
	
	public static String[][] getContentForTable(String tableName, String... columnNames) throws SQLException {
		Statement stmt = null;
	
		System.out.println("Creating statement...");
		stmt = conn.createStatement();
		String sql;
		sql = "SELECT * FROM " + tableName;
		ResultSet rs = stmt.executeQuery(sql);

		ArrayList<String[]> collector = new ArrayList<>();

		//STEP 5: Extract data from result set
		while(rs.next()){

			String[] line = new String[columnNames.length];
			
			for (int i = 0; i < columnNames.length; i++) {
				String columnName = columnNames[i];
				String content  = rs.getString(columnName);
				line[i] = content;
			}

			collector.add(line);
		}
	
		rs.close();
		stmt.close();

		String[][] toReturn  = new String[collector.size()][4];
		for( int i = 0; i < collector.size(); i++) {
			toReturn[i] = collector.get(i);
		}
		
		return toReturn;
	}
	public static ResultSet getResult(String query)
	{
		PreparedStatement sqlQuery1 = null;
		ResultSet result = null;
		try {
			sqlQuery1 = conn.prepareStatement(query);
			result = sqlQuery1.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
		
		return result;
	}
}
