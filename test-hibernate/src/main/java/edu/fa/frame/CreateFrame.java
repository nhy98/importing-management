package edu.fa.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;


public class CreateFrame{
	private JTextField textId;
	private JTable table;
	private JTextField textCode;
	private JTextField textName;
	private JTextField textQuantity;
	private JTextField textUnit;
	
	public CreateFrame() {
	}
	/**
	 * @wbp.parser.entryPoint
	 */
	public void createImportFrame(final JFrame frame) {
		frame.getContentPane().removeAll();
		frame.setVisible(false);
		
		String[] columnNames = { "ID", "Site Code", "Site Name","In Stock-Quantity","Unit"}; 

		
		frame.getContentPane().setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1182, 853);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 102, 255));
		panel_1.setBounds(0, 0, 1182, 55);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Home");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel.setIcon(new ImageIcon(CreateFrame.class.getResource("/icon/home_48px_1.png")));

		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(46, 0, 144, 52);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Import Order");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(237, 0, 144, 52);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Create");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(393, 0, 144, 52);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Create Import Order");
		lblNewLabel_3.setForeground(new Color(51, 0, 255));
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_3.setIcon(new ImageIcon(CreateFrame.class.getResource("/icon/list_64px.png")));

		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(68, 67, 280, 55);
		panel.add(lblNewLabel_3);
		
		textId = new JTextField();
		textId.setHorizontalAlignment(SwingConstants.CENTER);
		textId.setBounds(63, 190, 114, 19);
		panel.add(textId);
		textId.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Id");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(63, 150, 93, 28);
		panel.add(lblNewLabel_4);
//		
		final DefaultTableModel model = new DefaultTableModel(); 
		table = new JTable(model);
		model.setColumnIdentifiers(columnNames);
		table.setModel(model);
		
//		table.setCellSelectionEnabled(true);
//		table.setColumnSelectionAllowed(true);
		
		Font font = new Font("",1,22);
		table.setFont(font);
		table.setRowHeight(30);
		table.setBounds(78, 229, 947, 428);
		
//		panel.add(table);
		
		JScrollPane sp = new JScrollPane(table); 
		sp.setBounds(63, 224, 1021, 370);
		panel.add(sp);
		
		textCode = new JTextField();
		textCode.setHorizontalAlignment(SwingConstants.CENTER);
		textCode.setBounds(234, 190, 114, 19);
		panel.add(textCode);
		textCode.setColumns(10);
		
		textName = new JTextField();
		textName.setHorizontalAlignment(SwingConstants.CENTER);
		textName.setBounds(429, 190, 114, 19);
		panel.add(textName);
		textName.setColumns(10);
		
		textQuantity = new JTextField();
		textQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		textQuantity.setBounds(609, 190, 114, 19);
		panel.add(textQuantity);
		textQuantity.setColumns(10);
		
		textUnit = new JTextField();
		textUnit.setHorizontalAlignment(SwingConstants.CENTER);
		textUnit.setBounds(799, 190, 114, 19);
		panel.add(textUnit);
		textUnit.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Site code");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(234, 150, 114, 28);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Site name");
		lblNewLabel_6.setBounds(449, 150, 94, 15);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("In Stock Quantity");
		lblNewLabel_7.setBounds(609, 150, 144, 28);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Unit");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(799, 150, 114, 28);
		panel.add(lblNewLabel_8);
		
		final Object[] row = new Object[5];
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Dialog", Font.BOLD, 14));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				row[0] = textId.getText();
				row[1] = textCode.getText();
				row[2] = textName.getText();
				row[3] = textQuantity.getText();
				row[4] = textUnit.getText();
			
				model.addRow(row);
			}
		});
		btnAdd.setBounds(964, 67, 117, 25);
		panel.add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Dialog", Font.BOLD, 14));
		btnUpdate.addActionListener(new ActionListener() {
				
				
				public void actionPerformed(ActionEvent e) {
					int i = table.getSelectedRow();
					if(i >= 0) {
						model.setValueAt(textId.getText(), i, 0);
						model.setValueAt(textCode.getText(), i, 1);
						model.setValueAt(textName.getText(), i, 2);
						model.setValueAt(textQuantity.getText(), i, 3);
						model.setValueAt(textUnit.getText(), i, 4);
					}
					else {
						System.out.println("Update Error");
					}
				}
			});
		btnUpdate.setBounds(964, 125, 117, 25);
		panel.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Dialog", Font.BOLD, 14));
        btnDelete.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if(i >= 0) {
					model.removeRow(i);
				}
				else {
					System.out.println("Delete Error");
				}
			}
		});
		btnDelete.setBounds(964, 187, 117, 25);
		panel.add(btnDelete);
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Dialog", Font.BOLD, 14));
		btnSave.setBounds(552, 650, 117, 25);
		panel.add(btnSave);
		
		JButton btnclear = new JButton("Clear");
		btnclear.setFont(new Font("Dialog", Font.BOLD, 14));
		btnclear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnclear.setBounds(752, 650, 117, 25);
		panel.add(btnclear);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.setFont(new Font("Dialog", Font.BOLD, 14));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(952, 650, 117, 25);
		panel.add(btnNewButton_2);
		
		frame.setVisible(true);
	}
}
