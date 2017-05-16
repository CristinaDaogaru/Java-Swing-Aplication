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

public class InterfataDateAutoturism {

	private JFrame frame;
	private JTable tableAfisareDate;
	private JTextField txtDateAutoturism;

	/**
	 * Launch the application.
	 */
	public static void apelare() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					InterfataDateAutoturism window = new InterfataDateAutoturism();
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
	public InterfataDateAutoturism() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
			frame = new JFrame();
			frame.getContentPane().setBackground(new Color(211, 211, 211));
			frame.setBounds(100, 100, 672, 467);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			JButton btnInsertDatePers = new JButton("Insert");
			btnInsertDatePers.setForeground(new Color(255, 255, 255));
			btnInsertDatePers.setFont(new Font("Aharoni", Font.PLAIN, 15));
			btnInsertDatePers.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					FrameAdd.add("Add..", new String[]{"NrInmatriculare", "Model", "An", "CNPProp"}, new RunnableWithParam() {
						
						@Override
						public void run(String... params) {
							
							AddInformationInTable.addDateAutoturism(params[0], params[1], params[2], params[3]);
							
							updateTableAutoturism();
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
							UpdateTabel.UpdateTable("DateAutoturism",params[0], params[1], params[2], params[3]);
							updateTableAutoturism();
						}
					});
				}
			});
			btnUpdate.setBounds(12, 327, 157, 37);
			frame.getContentPane().add(btnUpdate);
			
			JButton btnDelete = new JButton("Delete");
			btnDelete.setForeground(new Color(255, 255, 255));
			btnDelete.setFont(new Font("Aharoni", Font.PLAIN, 15));
			btnDelete.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int columnNumber = tableAfisareDate.getSelectedRow();
					
					String nrImatr = (String) tableAfisareDate.getModel().getValueAt(columnNumber, 0);
					String model = (String) tableAfisareDate.getModel().getValueAt(columnNumber, 1);
					String an =  (String) tableAfisareDate.getModel().getValueAt(columnNumber, 2);
					String cnpProp = (String) tableAfisareDate.getModel().getValueAt(columnNumber, 3);
					
					DeleteFromTable.DeleteDateAutoturism(nrImatr, model, an, cnpProp);
					
					updateTableAutoturism();
				}
				
			});
			btnDelete.setBackground(new Color(153, 0, 51));
			btnDelete.setBounds(429, 327, 157, 37);
			frame.getContentPane().add(btnDelete);
			
			JButton btnAfisare = new JButton("Afisare");
			btnAfisare.setForeground(new Color(255, 255, 255));
			btnAfisare.setFont(new Font("Aharoni", Font.PLAIN, 15));
			
			btnAfisare.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					updateTableAutoturism();
				}
			});
			
			btnAfisare.setBackground(new Color(153, 0, 51));
			btnAfisare.setBounds(12, 34, 157, 37);
			frame.getContentPane().add(btnAfisare);
			
			tableAfisareDate = new JTable();
			tableAfisareDate.setBackground(new Color(176, 196, 222));
			tableAfisareDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
			tableAfisareDate.setBounds(101, 84, 428, 230);
			frame.getContentPane().add(tableAfisareDate);
			
			JButton btnBack = new JButton("Back");
			btnBack.setFont(new Font("Aharoni", Font.BOLD, 15));
			btnBack.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					InterfataGraficaAfisareTabele.SetFrameVisible();
				}
			});
			btnBack.setBackground(new Color(0, 0, 0));
			btnBack.setForeground(new Color(255, 51, 0));
			btnBack.setBounds(555, 389, 97, 25);
			frame.getContentPane().add(btnBack);
			
			txtDateAutoturism = new JTextField();
			txtDateAutoturism.setBackground(new Color(255, 255, 204));
			txtDateAutoturism.setFont(new Font("Aharoni", Font.PLAIN, 16));
			txtDateAutoturism.setText("Date Autoturism");
			txtDateAutoturism.setBounds(255, 13, 157, 22);
			frame.getContentPane().add(txtDateAutoturism);
			txtDateAutoturism.setColumns(10);
		}
	public void updateTableAutoturism() {
		System.out.println("UPDATETALBE");
		String[][] contentForTable = null;
		String[] columnNames = {"NrInmatriculare", "Model", "An", "CNPProp"};
		try {
			contentForTable = GetValueFromTable.getContentForTable("DateAutoturism", columnNames);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tableAfisareDate.setModel(new DefaultTableModel(contentForTable, columnNames));
	}


}
