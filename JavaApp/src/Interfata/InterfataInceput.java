package Interfata;

import java.awt.EventQueue;

import javax.swing.JFrame;

import DatabaseCon.Connect;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class InterfataInceput {

	private static JFrame frame;
	Connection connection = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					InterfataInceput window = new InterfataInceput();
					InterfataInceput.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfataInceput() throws SQLException {
		Connect.setDataBaseConn();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(173, 216, 230));
		frame.setBounds(100, 100, 776, 471);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnCautareInBaza = new JButton("Cautare in baza de Date");
		btnCautareInBaza.setForeground(new Color(255, 255, 255));
		btnCautareInBaza.setFont(new Font("Algerian", Font.PLAIN, 18));
		btnCautareInBaza.setBackground(new Color(51, 0, 51));
		btnCautareInBaza.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				FrameCautare.actiune();
			}
		});
		btnCautareInBaza.setBounds(218, 88, 280, 72);
		frame.getContentPane().add(btnCautareInBaza);
		
		JButton btnAfisareTabele = new JButton("Afisare Tabele");
		btnAfisareTabele.setForeground(new Color(255, 255, 255));
		btnAfisareTabele.setFont(new Font("Algerian", Font.PLAIN, 18));
		btnAfisareTabele.setBackground(new Color(51, 0, 51));
		btnAfisareTabele.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				InterfataGraficaAfisareTabele.actiune();
				frame.setVisible(false);
			}
		});
		btnAfisareTabele.setBounds(218, 231, 280, 65);
		frame.getContentPane().add(btnAfisareTabele);
	}

	public static void SetFrameVisible()
	{
		frame.setVisible(true);
	}
}
