package edu.fa.frame;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent; 

public class SiteCreateUpdateFrame { 
	// frame 
	JFrame f; 
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	public SiteCreateUpdateFrame() {
		// TODO Auto-generated constructor stub

	}
	/**
	 * @wbp.parser.entryPoint
	 */

	// Constructor 
	void createUserUpdateFrame(final JFrame frame) 
	{ 
		// Frame initialization 
		frame.getContentPane().removeAll();
		frame.setVisible(false);

		// Data to be displayed in the JTable 
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 12, 1182, 853);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(65, 105, 225));
		panel_1.setBounds(0, 0, 1182, 88);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblHome = new JLabel("Home");
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setForeground(Color.WHITE);
		lblHome.setFont(new Font("Verdana", Font.BOLD, 24));
		lblHome.setIcon(new ImageIcon(SiteCreateUpdateFrame.class.getResource("/icon/home_48px_1.png")));
		lblHome.setBounds(45, 12, 227, 65);
		panel_1.add(lblHome);
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Verdana", Font.BOLD, 18));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
		
			}
		});
		btnSave.setBounds(794, 711, 113, 40);
		panel.add(btnSave);
		
		JLabel lblDisplayName = new JLabel("Site Name");
		lblDisplayName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDisplayName.setFont(new Font("Verdana", Font.BOLD, 18));
		lblDisplayName.setBounds(121, 157, 234, 40);
		panel.add(lblDisplayName);
		
		textField = new JTextField();
		textField.setFont(new Font("Verdana", Font.PLAIN, 20));
		textField.setBounds(416, 157, 555, 43);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Verdana", Font.BOLD, 18));
		btnBack.setBounds(950, 711, 113, 40);
		panel.add(btnBack);
		
		JLabel lblChangePassword = new JLabel("Address");
		lblChangePassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblChangePassword.setFont(new Font("Verdana", Font.BOLD, 18));
		lblChangePassword.setBounds(121, 246, 234, 40);
		panel.add(lblChangePassword);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Verdana", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(416, 246, 555, 43);
		panel.add(textField_1);
		
		JLabel lblOldPassword = new JLabel("Mail");
		lblOldPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOldPassword.setFont(new Font("Verdana", Font.BOLD, 18));
		lblOldPassword.setBounds(121, 336, 234, 40);
		panel.add(lblOldPassword);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Verdana", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(416, 336, 555, 43);
		panel.add(textField_2);
		
		JLabel lblNewPassword = new JLabel("Phone");
		lblNewPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewPassword.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewPassword.setBounds(121, 430, 234, 40);
		panel.add(lblNewPassword);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Verdana", Font.PLAIN, 20));
		textField_3.setColumns(10);
		textField_3.setBounds(416, 430, 555, 43);
		panel.add(textField_3);

		// Frame Visible = true 
		frame.setVisible(true); 
	} 
} 
