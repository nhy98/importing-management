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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HomeFrame{
	
	public HomeFrame() {
	}
	/**
	 * @wbp.parser.entryPoint
	 */
	public void createHomeFrame(JFrame frame) {
		frame.getContentPane().setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1182, 853);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.textHighlight);
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
		
		JLabel lblImportAssignmentSystem = new JLabel("Import Assignment System");
		lblImportAssignmentSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblImportAssignmentSystem.setForeground(Color.WHITE);
		lblImportAssignmentSystem.setFont(new Font("Verdana", Font.BOLD, 32));
		lblImportAssignmentSystem.setBounds(192, 169, 572, 56);
		panel_1.add(lblImportAssignmentSystem);
		
		JPanel panel_2 = new JPanel();
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("panel_2 clicked");
			}
		});
		panel_2.setBackground(SystemColor.inactiveCaption);
		panel_2.setBounds(268, 426, 120, 120);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(HomeFrame.class.getResource("/main/images/download_52px.png")));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.BLUE);
		label_2.setFont(new Font("Verdana", Font.BOLD, 12));
		label_2.setBounds(0, 26, 120, 52);
		panel_2.add(label_2);
		
		JLabel label_3 = new JLabel("Import Order");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.BLUE);
		label_3.setFont(new Font("Verdana", Font.BOLD, 12));
		label_3.setBounds(0, 68, 120, 52);
		panel_2.add(label_3);
		
		JPanel panel_3 = new JPanel();
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("panel_3 clicked");
			}
		});
		panel_3.setBackground(SystemColor.inactiveCaption);
		panel_3.setBounds(529, 426, 120, 120);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(60, 5, 0, 0);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLUE);
		label.setFont(new Font("Verdana", Font.BOLD, 12));
		panel_3.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(HomeFrame.class.getResource("/main/images/list_64px.png")));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.BLUE);
		label_1.setFont(new Font("Verdana", Font.BOLD, 12));
		label_1.setBounds(0, 27, 120, 52);
		panel_3.add(label_1);
		
		JLabel lblImportOrder = new JLabel("Import Order");
		lblImportOrder.setHorizontalAlignment(SwingConstants.CENTER);
		lblImportOrder.setForeground(Color.BLUE);
		lblImportOrder.setFont(new Font("Verdana", Font.BOLD, 12));
		lblImportOrder.setBounds(0, 68, 120, 52);
		panel_3.add(lblImportOrder);
		
		JPanel panel_4 = new JPanel();
		panel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("panel_3 clicked");
			}
		});
		panel_4.setBackground(SystemColor.inactiveCaption);
		panel_4.setBounds(790, 426, 120, 120);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblUser_1 = new JLabel("User");
		lblUser_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser_1.setForeground(Color.BLUE);
		lblUser_1.setFont(new Font("Verdana", Font.BOLD, 12));
		lblUser_1.setBounds(0, 68, 120, 52);
		panel_4.add(lblUser_1);
		
		JLabel lblUser = new JLabel("");
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setBounds(0, 26, 120, 52);
		lblUser.setIcon(new ImageIcon(HomeFrame.class.getResource("/main/images/group_52px.png")));
		lblUser.setForeground(Color.BLUE);
		lblUser.setFont(new Font("Verdana", Font.BOLD, 12));
		panel_4.add(lblUser);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(SystemColor.inactiveCaption);
		panel_5.setBounds(268, 616, 120, 120);
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(SystemColor.inactiveCaption);
		panel_6.setBounds(529, 616, 120, 120);
		panel.add(panel_6);
		panel_6.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(SystemColor.inactiveCaption);
		panel_7.setBounds(790, 616, 120, 120);
		panel.add(panel_7);
		panel_7.setLayout(null);
	}
}
