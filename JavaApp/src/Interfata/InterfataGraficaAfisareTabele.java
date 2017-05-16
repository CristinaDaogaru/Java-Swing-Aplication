package Interfata;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class InterfataGraficaAfisareTabele {

	private static JFrame frame;

	Connection connection = null;
	/**
	 * Launch the application.
	 */
	public static void actiune() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					InterfataGraficaAfisareTabele window = new InterfataGraficaAfisareTabele();
					InterfataGraficaAfisareTabele.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfataGraficaAfisareTabele() throws SQLException {
		//Connect.setDataBaseConn();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(51, 0, 51));
		frame.setBounds(100, 100, 669, 523);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnDPersoane = new JButton("DatePersoane");
		btnDPersoane.setForeground(new Color(255, 255, 255));
		btnDPersoane.setFont(new Font("Aharoni", Font.PLAIN, 15));
		btnDPersoane.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				InterfataDatePers.apelare();
				frame.setVisible(false);
			}
		});
		btnDPersoane.setBackground(Color.RED);
		btnDPersoane.setBounds(76, 120, 171, 59);
		frame.getContentPane().add(btnDPersoane);
		
		JButton btnDAutoturism = new JButton("DateAutoturism");
		btnDAutoturism.setForeground(new Color(255, 255, 255));
		btnDAutoturism.setFont(new Font("Aharoni", Font.PLAIN, 15));
		btnDAutoturism.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				InterfataDateAutoturism.apelare();
				frame.setVisible(false);
				
			}
		});
		btnDAutoturism.setBackground(Color.RED);
		btnDAutoturism.setBounds(421, 120, 171, 59);
		frame.getContentPane().add(btnDAutoturism);
		
		JButton btnDAccident = new JButton("DateAccident");
		btnDAccident.setForeground(new Color(255, 255, 255));
		btnDAccident.setFont(new Font("Aharoni", Font.PLAIN, 15));
		btnDAccident.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				InterfataDateAccident.apelare();
				frame.setVisible(false);
			}
		});
		btnDAccident.setBackground(Color.RED);
		btnDAccident.setBounds(76, 247, 171, 53);
		frame.getContentPane().add(btnDAccident);
		
		JButton btnPersImplicate = new JButton("PersoaneImplicate");
		btnPersImplicate.setForeground(new Color(255, 255, 255));
		btnPersImplicate.setFont(new Font("Aharoni", Font.PLAIN, 15));
		btnPersImplicate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				InterfataPersImplicateInAccident.apelare();
				frame.setVisible(false);
			}
		});
		
		
		btnPersImplicate.setBackground(Color.RED);
		btnPersImplicate.setBounds(421, 247, 171, 53);
		frame.getContentPane().add(btnPersImplicate);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Aharoni", Font.BOLD, 15));
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				InterfataInceput.SetFrameVisible();
				frame.setVisible(false);
			}
		});
		btnBack.setForeground(new Color(255, 0, 0));
		btnBack.setBackground(new Color(0, 0, 0));
		btnBack.setBounds(272, 341, 110, 44);
		frame.getContentPane().add(btnBack);
	}
	
	
	public static void SetFrameVisible()
	{
		frame.setVisible(true);
	}
	
	
	
}
