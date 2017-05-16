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

public class InterfataDateAccident {

	private JFrame frame;
	private JTable tableAfisareDate;
	private JTextField txtDateAccident;

	/**
	 * Launch the application.
	 */
	public static void apelare() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					InterfataDateAccident window = new InterfataDateAccident();
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
	public InterfataDateAccident() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(255, 255, 255));
		frame.getContentPane().setBackground(new Color(211, 211, 211));
		frame.setBounds(100, 100, 672, 479);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnInsertDatePers = new JButton("Insert");
		btnInsertDatePers.setForeground(new Color(255, 255, 255));
		btnInsertDatePers.setFont(new Font("Aharoni", Font.PLAIN, 15));
		btnInsertDatePers.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				FrameAdd.add("Add..", new String[]{"NrProcesVerbal", "Data", "Locatie"}, new RunnableWithParam() {
					
					@Override
					public void run(String... params) {
						
						AddInformationInTable.addDateAccident(params[0], params[1], params[2]);
						
						updateTableAccident();
						
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
						updateTableAccident();
					}
				});
			}
		});
		btnUpdate.setBounds(12, 332, 157, 37);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.setFont(new Font("Aharoni", Font.PLAIN, 15));
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int columnNumber = tableAfisareDate.getSelectedRow();
				String nrProcesVerbal = (String) tableAfisareDate.getModel().getValueAt(columnNumber, 0);
				String data = (String) tableAfisareDate.getModel().getValueAt(columnNumber, 1);
				String locatie = (String) tableAfisareDate.getModel().getValueAt(columnNumber, 2);
				
				
				DeleteFromTable.DeleteDateAccident(nrProcesVerbal, data, locatie);
				
				updateTableAccident();
			}
			
		});
		btnDelete.setBackground(new Color(153, 0, 51));
		btnDelete.setBounds(473, 332, 157, 37);
		frame.getContentPane().add(btnDelete);
		
		JButton btnAfisare = new JButton("Afisare");
		btnAfisare.setForeground(new Color(255, 255, 255));
		btnAfisare.setFont(new Font("Aharoni", Font.PLAIN, 15));
		
		btnAfisare.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				updateTableAccident();
			}
		});
		
		btnAfisare.setBackground(new Color(153, 0, 51));
		btnAfisare.setBounds(12, 34, 157, 37);
		frame.getContentPane().add(btnAfisare);
		
		tableAfisareDate = new JTable();
		tableAfisareDate.setBackground(new Color(176, 196, 222));
		tableAfisareDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tableAfisareDate.setBounds(101, 84, 410, 235);
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
		btnBack.setBounds(555, 394, 97, 32);
		frame.getContentPane().add(btnBack);
		
		txtDateAccident = new JTextField();
		txtDateAccident.setBackground(new Color(255, 255, 204));
		txtDateAccident.setFont(new Font("Aharoni", Font.PLAIN, 16));
		txtDateAccident.setText("Date Accident");
		txtDateAccident.setBounds(237, 13, 116, 22);
		frame.getContentPane().add(txtDateAccident);
		txtDateAccident.setColumns(10);
	}
	
	public void updateTableAccident() {
		System.out.println("UPDATETALBE");
		String[][] contentForTable = null;
		String[] columnNames = {"NrProcesVerbal", "Data", "Locatie"};
		try {
			contentForTable = GetValueFromTable.getContentForTable("DateAccident", columnNames);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tableAfisareDate.setModel(new DefaultTableModel(contentForTable, columnNames));
	}

}
