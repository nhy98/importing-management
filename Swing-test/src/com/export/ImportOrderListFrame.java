package com.export;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class ImportOrderListFrame extends JFrame{
	public ImportOrderListFrame() {
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1182, 853);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.textHighlight);
		panel_1.setBounds(0, 0, 1182, 84);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblHome = new JLabel("Home");
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setForeground(Color.WHITE);
		lblHome.setFont(new Font("Verdana", Font.BOLD, 24));
		lblHome.setIcon(new ImageIcon(HomeFrame.class.getResource("/main/images/home_48px_1.png")));
		lblHome.setBounds(0, 0, 227, 82);
		panel_1.add(lblHome);
	}
}
