package Interfata;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import DatabaseOP.AddInformationInTable;
import DatabaseOP.DeleteFromTable;
import DatabaseOP.GetValueFromTable;
import DatabaseOP.UpdateTabel;

import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JTextField;
public class InterfataDatePers {

	private JFrame frame;
	private JTable tableAfisareDate;
	private JTextField txtDatePersoane;

	/**
	 * Launch the application.
	 */
	public static void apelare() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					InterfataDatePers window = new InterfataDatePers();
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
	public InterfataDatePers() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(211, 211, 211));
		frame.setBounds(100, 100, 672, 464);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnInsertDatePers = new JButton("Insert");
		btnInsertDatePers.setForeground(new Color(255, 255, 255));
		btnInsertDatePers.setFont(new Font("Aharoni", Font.PLAIN, 15));
		btnInsertDatePers.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				FrameAdd.add("Add..", new String[]{"CNP", "NrPermis", "Nume", "Adresa"}, new RunnableWithParam() {
					
					@Override
					public void run(String... params) {
						
						AddInformationInTable.addDatePersoana(params[0], params[1], params[2], params[3]);
						
						updateTablePersoane();
					}
				});
			}
		});
		btnInsertDatePers.setBackground(new Color(153, 0, 51));
		btnInsertDatePers.setBounds(475, 21, 165, 37);
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
						updateTablePersoane();
					}
				});
			}
		});
		btnUpdate.setBounds(29, 327, 157, 37);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.setFont(new Font("Aharoni", Font.PLAIN, 15));
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int columnNumber = tableAfisareDate.getSelectedRow();
				String cnp = (String) tableAfisareDate.getModel().getValueAt(columnNumber, 0);
				String NrPermis = (String) tableAfisareDate.getModel().getValueAt(columnNumber, 1);
				String nume = (String) tableAfisareDate.getModel().getValueAt(columnNumber, 2);
				String adresa = (String) tableAfisareDate.getModel().getValueAt(columnNumber, 3);
				
				DeleteFromTable.DeleteDatePersoana(cnp, NrPermis, nume, adresa);
				
				updateTablePersoane();
			}
			
		});
		btnDelete.setBackground(new Color(102, 0, 51));
		btnDelete.setBounds(483, 327, 157, 37);
		frame.getContentPane().add(btnDelete);
		
		JButton btnAfisare = new JButton("Afisare");
		btnAfisare.setForeground(new Color(255, 255, 255));
		btnAfisare.setFont(new Font("Aharoni", Font.PLAIN, 15));
		
		btnAfisare.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				updateTablePersoane();
			}
		});
		
		btnAfisare.setBackground(new Color(153, 0, 51));
		btnAfisare.setBounds(29, 21, 157, 37);
		frame.getContentPane().add(btnAfisare);
		
		tableAfisareDate = new JTable();
		tableAfisareDate.setBackground(new Color(176, 196, 222));
		tableAfisareDate.setFont(new Font("Aharoni", Font.PLAIN, 15));
		tableAfisareDate.setBounds(89, 71, 437, 245);
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
		btnBack.setBounds(555, 386, 97, 25);
		frame.getContentPane().add(btnBack);
		
		txtDatePersoane = new JTextField();
		txtDatePersoane.setBackground(new Color(255, 255, 204));
		txtDatePersoane.setFont(new Font("Aharoni", Font.PLAIN, 16));
		txtDatePersoane.setText("Date Persoane");
		txtDatePersoane.setBounds(246, 0, 132, 22);
		frame.getContentPane().add(txtDatePersoane);
		txtDatePersoane.setColumns(10);
	}
	
	public void updateTablePersoane() {
		System.out.println("UPDATETALBE");
		String[][] contentForTable = null;
		String[] columnNames = {"CNP", "NrPermis", "Nume", "Adresa"};
		try {
			contentForTable = GetValueFromTable.getContentForTable("DatePersoane", columnNames);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tableAfisareDate.setModel(new DefaultTableModel(contentForTable, columnNames));
	}

}
