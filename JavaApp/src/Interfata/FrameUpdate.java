package Interfata;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class FrameUpdate {
	
public static void update(String frameName, String[] labels, RunnableWithParam r) {
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				System.out.println("addPr14");
				JFrame add = new JFrame();
				add.setTitle(frameName);
				JFrame mainFrame = new JFrame("Update");
				mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				JPanel panel = new JPanel(new GridBagLayout());		
				GridBagConstraints c = new GridBagConstraints();
				c.anchor = GridBagConstraints.FIRST_LINE_START;
			
				c.gridx = 0;
				c.gridy = 0;
				c.insets = new Insets(2, 5, 2, 2);
			
				for (int i = 0; i < labels.length; i++) {
					panel.add(new Label(labels[i] + ":"), c);
					c.gridy++;
				}
				
				c.gridy = 0;
				c.gridx++;
				c.weightx = 1;
				c.gridwidth = GridBagConstraints.REMAINDER;
				c.insets = new Insets(2, 15, 2, 5);
				c.fill = GridBagConstraints.HORIZONTAL;
				
				ArrayList<JTextField> textFields = new ArrayList<>();
				for (int i = 0; i < labels.length; i++) {
					JTextField field = new JTextField();
					textFields.add(field);
					panel.add(field, c);
					c.gridy++;
				}
				
				add.add(panel, BorderLayout.CENTER);
				
				c.gridx = 1;
				c.gridy++;
				c.gridwidth = GridBagConstraints.RELATIVE;
				c.anchor = GridBagConstraints.LAST_LINE_END;
				c.insets = new Insets(20, 0, 0, 0);
				c.fill = GridBagConstraints.NONE;
				
				JButton okButton = new JButton("OK");
				panel.add(okButton, c);
				
				okButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							String[] input = new String[labels.length];
							for (int i = 0; i < labels.length; i++) {
								input[i] = textFields.get(i).getText(); 
							}
							
							r.run(input);
						} catch (NumberFormatException e1) 
						{
							e1.printStackTrace();
						}
						add.setVisible(false);
					}
				});
				c.gridx++;
				JButton cancel = new JButton("Cancel");
				cancel.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						add.setVisible(false);
					}
				});
				panel.add(cancel, c);
				
				add.setMinimumSize(new Dimension(300, 200));
				add.pack();
				add.setVisible(true);
			}
		});
	}
}
