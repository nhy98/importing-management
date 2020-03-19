package com.export.saleOrder;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;


import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

import com.export.HomeFrame;

public class SaleOrder{
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public SaleOrder() {

	}
	/**
	 * @wbp.parser.entryPoint
	 */
	public void createSaleOrder(JFrame frame) {
		frame.getContentPane().setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1182, 853);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 102, 255));
		panel_1.setBounds(0, 0, 1182, 125);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblHome = new JLabel("Home");
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setForeground(Color.WHITE);
		lblHome.setFont(new Font("Verdana", Font.BOLD, 24));
		lblHome.setIcon(new ImageIcon(HomeFrame.class.getResource("/main/images/home_48px_1.png")));
		lblHome.setBounds(136, -35, 227, 155);
		panel_1.add(lblHome);
		
		JLabel lblImportAssignmentSystem = new JLabel("Sale Order Management");
		lblImportAssignmentSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblImportAssignmentSystem.setForeground(Color.WHITE);
		lblImportAssignmentSystem.setFont(new Font("Verdana", Font.BOLD, 32));
		lblImportAssignmentSystem.setBounds(122, 64, 572, 56);
		panel_1.add(lblImportAssignmentSystem);
		
		
		java.net.URL imgUrl = getClass().getResource("/main/images/list_64px.png");
		ImageIcon icon = new ImageIcon(imgUrl);
		Image img = icon.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(img);		
		
		JLabel lblList = new JLabel("Create Save Order ");
		lblList.setBounds(37, 137, 269, 40);
		panel.add(lblList);
		lblList.setHorizontalAlignment(SwingConstants.CENTER);
		lblList.setForeground(UIManager.getColor("CheckBoxMenuItem.acceleratorForeground"));
		lblList.setFont(new Font("Verdana", Font.BOLD, 18));
		lblList.setIcon(newIcon);
		
		
		
		 DefaultTableModel dm = new DefaultTableModel();
		    dm.setColumnIdentifiers(
		    new Object[]{"Merchandise Code","Quantity Ordered","Unit", "Year", "Month" ,"Day"});

		    
		    JTable table = new JTable(dm) {
		      protected JTableHeader createDefaultTableHeader() {
		          return new GroupableTableHeader(columnModel);
		      }
		    };
		    table.setBackground(Color.WHITE);

		    TableColumnModel cm = table.getColumnModel();
		 

		    ColumnGroup g_lang = new ColumnGroup("Desired Delivery Date");
		    g_lang.add(cm.getColumn(3));
		    g_lang.add(cm.getColumn(4));
		    g_lang.add(cm.getColumn(5));

		    GroupableTableHeader header = (GroupableTableHeader)table.getTableHeader();
		    header.addColumnGroup(g_lang);
		    JScrollPane scroll = new JScrollPane( table );
		    scroll.setBounds(63, 300, 1087, 350);
		    panel.add(scroll);
		    
		    String MerchandiseCode[]={"India","Aus","U.S.A","England","Newzealand"};        
		    
		    JComboBox comboBox = new JComboBox(MerchandiseCode);
		    comboBox.setBackground(Color.WHITE);
		    comboBox.setBounds(63, 233, 135, 26);
		    panel.add(comboBox);
		    
		    JLabel lblNewLabel = new JLabel("Merchandise Code");
		    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		    lblNewLabel.setBounds(63, 193, 142, 28);
		    panel.add(lblNewLabel);
		    
		    JLabel lblNewLabel_1 = new JLabel("Quantity Ordered");
		    lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		    lblNewLabel_1.setBounds(257, 193, 142, 28);
		    panel.add(lblNewLabel_1);
		    
		    textField = new JTextField();
		    textField.setBounds(260, 233, 139, 28);
		    panel.add(textField);
		    textField.setColumns(10);
		    
		    String Unit[]={"Chiếc","Cái","Quyển","Hộp","Chịu"};        

		    JLabel lblNewLabel_2 = new JLabel("Unit");
		    lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		    lblNewLabel_2.setBounds(446, 193, 142, 28);
		    panel.add(lblNewLabel_2);
		    
		    JComboBox comboBox_1 = new JComboBox(Unit);
		    comboBox_1.setBackground(Color.WHITE);
		    comboBox_1.setBounds(453, 232, 135, 28);
		    panel.add(comboBox_1);
		    
		    JTextArea txtrFafafafafaf = new JTextArea();
		    txtrFafafafafaf.setText("fafafafafaf");
		    txtrFafafafafaf.setBounds(760, 251, 1, 15);
		    panel.add(txtrFafafafafaf);
		    
		    JLabel lblNewLabel_3 = new JLabel("Day");
		    lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		    lblNewLabel_3.setBounds(640, 193, 142, 28);
		    panel.add(lblNewLabel_3);
		    
		    String Day[]={"01", "02", "03", "04", "05", "06", "07", "08", "09", "10"
		    		, "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"
		    		, "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};        
		    JComboBox comboBox_2 = new JComboBox(Day);
		    comboBox_2.setBackground(Color.WHITE);
		    comboBox_2.setBounds(647, 232, 135, 28);
		    panel.add(comboBox_2);
		    
		    JLabel lblNewLabel_4 = new JLabel("Month");
		    lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		    lblNewLabel_4.setBounds(834, 195, 142, 24);
		    panel.add(lblNewLabel_4);
		    
		    String Month[]={"01", "02", "03", "04", "05", "06", "07", "08", "09", "10"
		    		, "11", "12",};
		    JComboBox comboBox_3 = new JComboBox(Month);
		    comboBox_3.setBackground(Color.WHITE);
		    comboBox_3.setBounds(841, 232, 135, 28);
		    panel.add(comboBox_3);
		    
		    JLabel lblNewLabel_5 = new JLabel("Year");
		    lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		    lblNewLabel_5.setBounds(1024, 193, 142, 28);
		    panel.add(lblNewLabel_5);
		    
		    textField_1 = new JTextField();
		    textField_1.setBounds(1024, 232, 126, 28);
		    panel.add(textField_1);
		    textField_1.setColumns(10);
		    
			Object[] row = new Object[6];

		    JButton btnNewButton = new JButton("Add");
		    btnNewButton.setFont(new Font("Dialog", Font.BOLD, 14));
		    btnNewButton.setBounds(81, 674, 117, 25);
		    btnNewButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(textField.getText() == null || textField.getText().trim().isEmpty()) {
						JOptionPane.showMessageDialog(frame, "Quantity can't be null!");
					}
					
					else if(textField_1.getText() == null || textField_1.getText().trim().isEmpty()) {
						JOptionPane.showMessageDialog(frame, "Year can't be null!");
					}
					
					else {
					row[0] = (String)comboBox.getSelectedItem();
					row[1] = textField.getText();
					row[2] = (String)comboBox_1.getSelectedItem();
					row[3] = (String)comboBox_2.getSelectedItem();
					row[4] = (String)comboBox_3.getSelectedItem();
					row[5] = textField_1.getText();
					dm.addRow(row);
					}
				}
			});
		    panel.add(btnNewButton);
		    
		    JButton btnNewButton_1 = new JButton("Update");
		    btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 14));
		    btnNewButton_1.setBounds(415, 674, 117, 25);
		    btnNewButton_1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int i = table.getSelectedRow();
					if(i >= 0) {
						dm.setValueAt((String)comboBox.getSelectedItem(), i, 0);
						dm.setValueAt(textField.getText(), i, 1);
						dm.setValueAt((String)comboBox_1.getSelectedItem(), i, 2);
						dm.setValueAt((String)comboBox_2.getSelectedItem(), i, 3);
						dm.setValueAt((String)comboBox_3.getSelectedItem(), i, 4);
						dm.setValueAt(textField_1.getText(), i, 5);
					}
					else {
						JOptionPane.showMessageDialog(frame, "Update Error!");
					}
				}
			});
		    panel.add(btnNewButton_1);
		    
		    JButton btnNewButton_2 = new JButton("Delete");
		    btnNewButton_2.setFont(new Font("Dialog", Font.BOLD, 14));
		    btnNewButton_2.setBounds(248, 674, 117, 25);
		    btnNewButton_2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int i = table.getSelectedRow();
					if(i >= 0) {
						dm.removeRow(i);
					}
					else {
						JOptionPane.showMessageDialog(frame, "No line to delete!");
					}
				}
			});
		    panel.add(btnNewButton_2);
		    
		    JButton btnNewButton_3 = new JButton("Save");
		    btnNewButton_3.setFont(new Font("Dialog", Font.BOLD, 14));
		    btnNewButton_3.setBounds(1033, 674, 117, 25);
		    btnNewButton_3.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
				    int rows = table.getRowCount();
				    if (rows > 0) {
					ListSaleOrder listOrder = new ListSaleOrder();
					panel.setVisible(false);
					listOrder.createListSaleOrder(frame);
				    }
				    else {
				    	JOptionPane.showMessageDialog(frame,"Please add goods to the list!");
				    }
				}
			});
		    panel.add(btnNewButton_3);

	}
}