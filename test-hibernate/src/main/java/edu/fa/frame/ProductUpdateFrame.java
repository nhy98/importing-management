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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel; 

public class ProductUpdateFrame { 
	// frame 
	JFrame f; 
	private JTextField textField;
	public ProductUpdateFrame() {
		// TODO Auto-generated constructor stub

	}
	/**
	 * @wbp.parser.entryPoint
	 */

	// Constructor 
	void createUserUpdateFrame(final JFrame frame) 
	{ 
		// Frame initiallization 
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
		lblHome.setIcon(new ImageIcon(ProductUpdateFrame.class.getResource("/icon/home_48px_1.png")));
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
		
		JLabel lblDisplayName = new JLabel("Product Name");
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
		
		JLabel lblChangePassword = new JLabel("Unit");
		lblChangePassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblChangePassword.setFont(new Font("Verdana", Font.BOLD, 18));
		lblChangePassword.setBounds(121, 246, 234, 40);
		panel.add(lblChangePassword);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Verdana", Font.PLAIN, 18));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Pack", "Pair"}));
		comboBox.setBounds(416, 246, 555, 40);
		panel.add(comboBox);

		// Frame Visible = true 
		frame.setVisible(true); 
	} 
} 
