package Interfata;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DatabaseOP.AddInformationInTable;
import DatabaseOP.DeleteFromTable;
import DatabaseOP.GetValueFromTable;
import DatabaseOP.UpdateTabel;

import java.awt.Font;
import javax.swing.JTextField;

public class InterfataPersImplicateInAccident {

	private JFrame frame;
	private JTable tableAfisareDate;
	private JTextField txtPersoaneimplicateinaccident;

	/**
	 * Launch the application.
	 */
	public static void apelare() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					InterfataPersImplicateInAccident window = new InterfataPersImplicateInAccident();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfataPersImplicateInAccident() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
private void initialize() {
			frame = new JFrame();
			frame.getContentPane().setBackground(new Color(211, 211, 211));
			frame.setBounds(100, 100, 672, 463);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			JButton btnInsertDatePers = new JButton("Insert");
			btnInsertDatePers.setForeground(new Color(255, 255, 255));
			btnInsertDatePers.setFont(new Font("Aharoni", Font.PLAIN, 15));
			btnInsertDatePers.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					FrameAdd.add("Add..", new String[]{"NrProcesVerbal", "NrInMatriculare", "CNP","Daune"}, new RunnableWithParam() {
						
						@Override
						public void run(String... params) {
							
							AddInformationInTable.addPersImplicateInAcc(params[0], params[1], params[2], params[3]);
							
							updateTableImplicati();
						}
					});
				}
			});
			btnInsertDatePers.setBackground(new Color(153, 0, 51));
			btnInsertDatePers.setBounds(465, 34, 165, 37);
			frame.getContentPane().add(btnInsertDatePers);
			
			JButton btnUpdate = new JButton("Update");
			btnUpdate.setForeground(new Color(255, 255, 255));
			btnUpdate.setFont(new Font("Aharoni", Font.PLAIN, 15));
			btnUpdate.setBackground(new Color(153, 0, 51));
			btnUpdate.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					FrameUpdate.update("Update..", new String[]{"NumeColoana","Valuare","ColoanaConditie","ValuareConditie"}, new RunnableWithParam() {
						@Override
						public void run(String... params) {
							UpdateTabel.UpdateTable("DatePersoane",params[0], params[1], params[2], params[3]);
							updateTableImplicati();
						}
					});
				}
			});
			btnUpdate.setBounds(47, 327, 157, 37);
			frame.getContentPane().add(btnUpdate);
			
			JButton btnDelete = new JButton("Delete");
			btnDelete.setForeground(new Color(255, 255, 255));
			btnDelete.setFont(new Font("Aharoni", Font.PLAIN, 15));
			btnDelete.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int columnNumber = tableAfisareDate.getSelectedRow();
					String nrPrVerb = (String) tableAfisareDate.getModel().getValueAt(columnNumber, 0);
					String nrInMatriculare = (String) tableAfisareDate.getModel().getValueAt(columnNumber, 1);
					String CNP = (String) tableAfisareDate.getModel().getValueAt(columnNumber, 2);
					String Daune = (String) tableAfisareDate.getModel().getValueAt(columnNumber, 3);
					
					DeleteFromTable.DeletePersImplicateInAcc(nrPrVerb, nrInMatriculare, CNP, Daune);
					
					updateTableImplicati();
				}
				
			});
			btnDelete.setBackground(new Color(153, 0, 51));
			btnDelete.setBounds(465, 327, 157, 37);
			frame.getContentPane().add(btnDelete);
			
			JButton btnAfisare = new JButton("Afisare");
			btnAfisare.setForeground(new Color(255, 255, 255));
			btnAfisare.setFont(new Font("Aharoni", Font.PLAIN, 15));
			
			btnAfisare.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					updateTableImplicati();
				}
			});
			
			btnAfisare.setBackground(new Color(153, 0, 51));
			btnAfisare.setBounds(47, 34, 157, 37);
			frame.getContentPane().add(btnAfisare);
			
			tableAfisareDate = new JTable();
			tableAfisareDate.setBackground(new Color(176, 196, 222));
			tableAfisareDate.setForeground(new Color(0, 0, 0));
			tableAfisareDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
			tableAfisareDate.setBounds(83, 87, 444, 227);
			frame.getContentPane().add(tableAfisareDate);
			
			JButton btnBack = new JButton("Back");
			btnBack.setFont(new Font("Aharoni", Font.BOLD, 15));
			btnBack.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					InterfataGraficaAfisareTabele.SetFrameVisible();
					frame.setVisible(false);
				}
			});
			btnBack.setForeground(new Color(255, 51, 0));
			btnBack.setBackground(new Color(0, 0, 0));
			btnBack.setBounds(555, 385, 97, 25);
			frame.getContentPane().add(btnBack);
			
			txtPersoaneimplicateinaccident = new JTextField();
			txtPersoaneimplicateinaccident.setFont(new Font("Aharoni", Font.BOLD, 15));
			txtPersoaneimplicateinaccident.setBackground(new Color(255, 255, 204));
			txtPersoaneimplicateinaccident.setForeground(new Color(0, 0, 102));
			txtPersoaneimplicateinaccident.setText("Persoane Implicate In Accident");
			txtPersoaneimplicateinaccident.setBounds(221, 0, 238, 22);
			frame.getContentPane().add(txtPersoaneimplicateinaccident);
			txtPersoaneimplicateinaccident.setColumns(10);
		}
		
public void updateTableImplicati() {
	System.out.println("UPDATETALBE");
	String[][] contentForTable = null;
	String[] columnNames = {"NrProcesVerbal", "NrInMatriculare", "CNP","Daune"};
	try {
		contentForTable = GetValueFromTable.getContentForTable("PersImplicateInAcc", columnNames);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	tableAfisareDate.setModel(new DefaultTableModel(contentForTable, columnNames));
}
}
