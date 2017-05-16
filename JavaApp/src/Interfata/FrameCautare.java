package Interfata;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import DatabaseOP.GetValueFromTable;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;

public class FrameCautare {

	private JFrame frame;
	private JTextField textField;
	
	JTextArea txtrRezultat = new JTextArea();
	/**
	 * Launch the application.
	 */
	public static void actiune() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					FrameCautare window = new FrameCautare();
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
	public FrameCautare() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(51, 0, 51));
		frame.setBounds(100, 100, 568, 494);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(60, 35, 431, 62);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.setForeground(new Color(255, 255, 255));
		btnOk.setFont(new Font("Aharoni", Font.PLAIN, 16));
		btnOk.setBackground(new Color(102, 0, 51));
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String[] rezultate;
				
				try {
					
					String query = textField.getText();
					System.out.println("Q : "  + query);
					
				
					
					ResultSet result = GetValueFromTable.getResult(query);
					
					String text = "";
					
					
					while( result.next() ){

						ResultSetMetaData rsmd = result.getMetaData();
						
						int columnsNumber = rsmd.getColumnCount();
						
						for(int index = 1; index <= columnsNumber; ++index){
							text += result.getObject(index) + "   ";
						}
						
					text+="\n";
					}
					
					txtrRezultat.append(text);
					
				} catch (Exception ex) {
					
				}
				
			}
			
			
		});
		btnOk.setBounds(121, 130, 97, 25);
		frame.getContentPane().add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setForeground(new Color(255, 255, 255));
		btnCancel.setFont(new Font("Aharoni", Font.PLAIN, 16));
		btnCancel.setBackground(new Color(102, 0, 51));
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnCancel.setBounds(336, 130, 97, 25);
		frame.getContentPane().add(btnCancel);
		txtrRezultat.setFont(new Font("Arial", Font.PLAIN, 16));
		
		
		txtrRezultat.setBounds(60, 192, 431, 236);
		frame.getContentPane().add(txtrRezultat);
	}
}
