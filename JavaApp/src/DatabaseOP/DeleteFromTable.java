package DatabaseOP;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import DatabaseCon.Connect;

public class DeleteFromTable {

	public static Connection conn = Connect.setDataBaseConn();
	

	
	public static void DeleteDatePersoana(String cnp, String NrPermis, String nume,String adresa) {

		String queryDelete = "DELETE FROM DatePersoane WHERE CNP=\'"+cnp+ "\' AND NrPermis=\'"+NrPermis + "\' AND Nume=\'" + nume + "\' AND Adresa=\'" + adresa + "\';";
		System.out.println("queryDelete : " + queryDelete);
		 Statement st = null;
		try {
			st = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		 try {
			st.executeUpdate(queryDelete);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	public static void DeleteDateAutoturism(String NrInmatriculare, String Model, String an,String CNPProp) {

		String queryDelete = "DELETE FROM DateAutoturism WHERE NrInmatriculare=\'" + NrInmatriculare + "\' AND Model=\'" + Model + "\' AND An=\'" + an + "\' AND CNPProp=\'" + CNPProp + "\';";
		System.out.println("queryDelete : " + queryDelete);
		 Statement st = null;
		try {
			st = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		 try {
			st.executeUpdate(queryDelete);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void DeleteDateAccident(String NrProcesVerbal, String Data, String Locatie) {

		String queryDelete = "DELETE FROM DateAccident WHERE NrProcesVerbal=\'" + NrProcesVerbal + "\' AND Data=\'" + Data + "\' AND Locatie=\'" + Locatie +  "\';";
		System.out.println("queryDelete : " + queryDelete);
		 Statement st = null;
		try {
			st = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		 try {
			st.executeUpdate(queryDelete);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public static void DeletePersImplicateInAcc(String NrProcesVerbal, String NrInMatriculare, String CNP,String Daune) {

		String queryDelete = "DELETE FROM PersImplicateInAcc WHERE NrProcesVerbal=\'" + NrProcesVerbal + "\' AND NrInMatriculare=\'" + NrInMatriculare + "\' AND CNP=\'" + CNP + "\' AND Daune=\'" + Daune +  "\';";
		System.out.println("queryDelete : " + queryDelete);
		 Statement st = null;
		try {
			st = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		 try {
			st.executeUpdate(queryDelete);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////
	

	

	
}
