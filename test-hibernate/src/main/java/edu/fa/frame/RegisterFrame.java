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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegisterFrame{
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	public RegisterFrame() {}
	
	/**
	 * @wbp.parser.entryPoint
	 */

	public void createRegisterFrame(final JFrame frame) {
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
		lblHome.setIcon(new ImageIcon(RegisterFrame.class.getResource("/icon/home_48px_1.png")));
		lblHome.setBounds(177, 57, 227, 155);
		panel_1.add(lblHome);
		
		JLabel lblImportAssignmentSystem = new JLabel("Import Assignment System");
		lblImportAssignmentSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblImportAssignmentSystem.setForeground(Color.WHITE);
		lblImportAssignmentSystem.setFont(new Font("Verdana", Font.BOLD, 32));
		lblImportAssignmentSystem.setBounds(192, 169, 572, 56);
		panel_1.add(lblImportAssignmentSystem);
		
		textField = new JTextField();
		textField.setBounds(506, 408, 311, 36);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(506, 482, 311, 36);
		panel.add(passwordField);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.BLUE);
		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsername.setFont(new Font("Verdana", Font.BOLD, 18));
		lblUsername.setBounds(297, 408, 180, 36);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.BLUE);
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setFont(new Font("Verdana", Font.BOLD, 18));
		lblPassword.setBounds(297, 482, 180, 36);
		panel.add(lblPassword);
		
		JButton btnLogin = new JButton("Sign Up");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				LoginFrame loginFrame= new LoginFrame();
				loginFrame.createLoginFrame(frame);
			}
		});
		btnLogin.setForeground(SystemColor.textHighlight);
		btnLogin.setFont(new Font("Verdana", Font.BOLD, 18));
		btnLogin.setBounds(691, 682, 126, 41);
		panel.add(btnLogin);
		
		JLabel lblReenterPassword = new JLabel("Re-enter Password");
		lblReenterPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblReenterPassword.setForeground(Color.BLUE);
		lblReenterPassword.setFont(new Font("Verdana", Font.BOLD, 18));
		lblReenterPassword.setBounds(216, 552, 261, 36);
		panel.add(lblReenterPassword);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(506, 552, 311, 36);
		panel.add(passwordField_1);
		
		JLabel lblRole = new JLabel("Role");
		lblRole.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRole.setForeground(Color.BLUE);
		lblRole.setFont(new Font("Verdana", Font.BOLD, 18));
		lblRole.setBounds(297, 593, 180, 83);
		panel.add(lblRole);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Sale Order", "Import Order", "Site"}));
		comboBox.setBounds(506, 620, 311, 32);
		panel.add(comboBox);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(268, 361, 613, 401);
		panel.add(panel_2);
		panel_2.setBackground(SystemColor.inactiveCaption);
		
		frame.setVisible(true);
	}
}
