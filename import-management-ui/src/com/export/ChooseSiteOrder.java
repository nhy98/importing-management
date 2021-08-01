package com.export;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ChooseSiteOrder {

	/**
	 * Create the panel.
	 */
	public ChooseSiteOrder() {

	}
	/**
	 * @wbp.parser.entryPoint
	 */
	public void ChooseSiteOrder(JFrame frame) {
		frame.getContentPane().setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1182, 853);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 102, 255));
		panel_1.setBounds(0, 0, 1182, 322);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblHome = new JLabel("Home");
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setForeground(Color.WHITE);
		lblHome.setFont(new Font("Verdana", Font.BOLD, 24));
		lblHome.setIcon(new ImageIcon(HomeFrame.class.getResource("/main/images/home_48px_1.png")));
		lblHome.setBounds(177, 57, 227, 155);
		panel_1.add(lblHome);
		
		JLabel lblImportAssignmentSystem = new JLabel("Choose Site");
		lblImportAssignmentSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblImportAssignmentSystem.setForeground(Color.WHITE);
		lblImportAssignmentSystem.setFont(new Font("Verdana", Font.BOLD, 32));
		lblImportAssignmentSystem.setBounds(164, 168, 572, 56);
		panel_1.add(lblImportAssignmentSystem);
	}
}
