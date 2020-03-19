package edu.fa.frame;

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
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginFrame{
	private JTextField textField;
	private JPasswordField passwordField;
	public LoginFrame() {}
	
	/**
	 * @wbp.parser.entryPoint
	 */

	public void createLoginFrame(final JFrame frame) {
		frame.getContentPane().removeAll();
		frame.setVisible(false);
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
		lblHome.setIcon(new ImageIcon(LoginFrame.class.getResource("/icon/home_48px_1.png")));
		lblHome.setBounds(177, 57, 227, 155);
		panel_1.add(lblHome);
		
		JLabel lblImportAssignmentSystem = new JLabel("Import Assignment System");
		lblImportAssignmentSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblImportAssignmentSystem.setForeground(Color.WHITE);
		lblImportAssignmentSystem.setFont(new Font("Verdana", Font.BOLD, 32));
		lblImportAssignmentSystem.setBounds(192, 169, 572, 56);
		panel_1.add(lblImportAssignmentSystem);
		
		textField = new JTextField();
		textField.setBounds(506, 470, 311, 36);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(506, 554, 311, 36);
		panel.add(passwordField);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.BLUE);
		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsername.setFont(new Font("Verdana", Font.BOLD, 18));
		lblUsername.setBounds(297, 470, 180, 36);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.BLUE);
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setFont(new Font("Verdana", Font.BOLD, 18));
		lblPassword.setBounds(297, 554, 180, 36);
		panel.add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				HomeFrame homeFrame= new HomeFrame();
				homeFrame.createHomeFrame(frame);
			}
		});
		btnLogin.setForeground(SystemColor.textHighlight);
		btnLogin.setFont(new Font("Verdana", Font.BOLD, 18));
		btnLogin.setBounds(705, 625, 112, 41);
		panel.add(btnLogin);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(321, 409, 560, 297);
		panel.add(panel_2);
		panel_2.setBackground(SystemColor.inactiveCaption);
		panel_2.setLayout(null);
		
		JLabel lblSignUp = new JLabel("Sign up?");
		lblSignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				RegisterFrame registerFrame= new RegisterFrame();
				registerFrame.createRegisterFrame(frame);
			}
		});
		lblSignUp.setForeground(Color.BLUE);
		lblSignUp.setFont(new Font("Verdana", Font.BOLD, 18));
		lblSignUp.setBounds(270, 208, 118, 51);
		panel_2.add(lblSignUp);
		
		JLabel label = new JLabel("____________");
		label.setForeground(Color.BLUE);
		label.setBounds(270, 235, 160, 16);
		panel_2.add(label);
		
		frame.setVisible(true);
	}
}
