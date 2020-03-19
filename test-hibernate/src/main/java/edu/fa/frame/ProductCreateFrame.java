package edu.fa.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;


public class ProductCreateFrame extends JFrame{
	private JTextField textId;
	private JTable table;
	
	public ProductCreateFrame() {
	}
	/**
	 * @wbp.parser.entryPoint
	 */
	public void createProductCreateUpdateFrame(JFrame frame) {
		frame.getContentPane().removeAll();
		frame.setVisible(false);

		String[] columnNames = { "Product Name", "Unit"}; 

		
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
		lblNewLabel.setIcon(new ImageIcon(ProductCreateFrame.class.getResource("/icon/home_48px_1.png")));

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
		lblNewLabel_3.setIcon(new ImageIcon(ProductCreateFrame.class.getResource("/icon/home_48px.png")));

		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(68, 67, 280, 55);
		panel.add(lblNewLabel_3);
		
		textId = new JTextField();
		textId.setHorizontalAlignment(SwingConstants.CENTER);
		textId.setBounds(237, 160, 242, 33);
		panel.add(textId);
		textId.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Product Name");
		lblNewLabel_4.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(63, 160, 152, 28);
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
		
		JLabel lblNewLabel_5 = new JLabel("Unit");
		lblNewLabel_5.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(499, 160, 114, 28);
		panel.add(lblNewLabel_5);
		
		final JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Pack", "Pair"}));
		comboBox.setFont(new Font("Verdana", Font.PLAIN, 16));
		comboBox.setBounds(625, 158, 133, 33);
		panel.add(comboBox);
		
		final Object[] row = new Object[2];
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Dialog", Font.BOLD, 14));
		btnAdd.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				row[0] = textId.getText();
				row[1] = comboBox.getSelectedItem().toString();
			
				model.addRow(row);
			}
		});
		btnAdd.setBounds(823, 159, 129, 33);
		panel.add(btnAdd);
		
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
		btnDelete.setBounds(964, 159, 120, 33);
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
