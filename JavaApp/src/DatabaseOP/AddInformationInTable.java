package DatabaseOP;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import DatabaseCon.Connect;

public class AddInformationInTable {

	public static Connection conn = Connect.setDataBaseConn();
	
	public static void addDatePersoana(String cnp, String NrPermis, String nume,String adresa) {

		String queryInsert = "insert into DatePersoane(CNP,NrPermis,Nume,Adresa) values (\'"+cnp+"\',"+ NrPermis + ", '" + nume +"','" + adresa + "\');";
		System.out.println("queryInsert : " + queryInsert);
		 Statement st = null;
		try {
			st = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		 try {
			st.executeUpdate(queryInsert);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void addDateAutoturism(String NrInmatriculare, String Model, String An,String CNPProp) {

		String queryInsert = "insert into DateAutoturism(NrInmatriculare,Model,An,CNPProp) values (\'"+NrInmatriculare+"\',"+ Model + ", '" + An +"','" + CNPProp + "\');";
		System.out.println("queryInsert : " + queryInsert);
		 Statement st = null;
		try {
			st = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		 try {
			st.executeUpdate(queryInsert);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


}
	
	public static void addDateAccident(String NrProcesVerbal, String Data, String Locatie) {

		String queryInsert = "insert into DateAccident(NrProcesVerbal,Data,Locatie) values (\'"+NrProcesVerbal+"\',"+ Data + ", '" + Locatie + "\');" ;
		System.out.println("queryInsert : " + queryInsert);
		 Statement st = null;
		try {
			st = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		 try {
			st.executeUpdate(queryInsert);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


    }
	
	public static void addPersImplicateInAcc(String NrProcesVerbal, String NrInMatriculare, String CNP,String Daune) {

		String queryInsert = "insert into PersImplicateInAcc(NrProcesVerbal,NrInMatriculare,CNP,Daune) values (\'"+NrProcesVerbal+"\',"+ NrInMatriculare + ", '" + CNP +"','" + Daune + "\');";
		System.out.println("queryInsert : " + queryInsert);
		 Statement st = null;
		try {
			st = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		 try {
			st.executeUpdate(queryInsert);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


    }
	
}
