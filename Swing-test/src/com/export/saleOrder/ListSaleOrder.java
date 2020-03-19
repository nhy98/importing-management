package com.export.saleOrder;

import java.awt.SystemColor;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionEvent;

import com.export.HomeFrame;


public class ListSaleOrder {

	/**
	 * Create the panel.
	 */
	private JTable j; 
	private JTextField textField;
	
	public ListSaleOrder() {

	}
	/**
	 * @wbp.parser.entryPoint
	 */
	public void createListSaleOrder(JFrame f) {
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBackground(new Color(255, 255, 255));

		// Frame Title 
		f.setTitle("Management Sytem"); 

		// Data to be displayed in the JTable 
		String[][] data = { 
			{ "1", "A123", "H1","10","10","Plane","Detail" }, 
			{ "2", "A123", "H1","20","12","Train","Detail" },
			{ "3", "A123", "H1","20","12","Train","Detail" },
			{ "4", "A123", "H1","20","12","Train","Detail" }, 
			{ "5", "A123", "H1","20","12","Train","Detail" }, 
			{ "6", "A123", "H1","20","12","Train","Detail" }, 
			{ "7", "A123", "H1","20","12","Train","Detail" }, 
			{ "8", "A123", "H1","20","12","Train","Detail" }, 
			{ "9", "A123", "H1","20","12","Train","Detail" }, 
			{ "10", "A123", "H1","20","12","Train","Detail" }, 
			{ "11", "A123", "H1","20","12","Train","Detail" }, 
			{ "12", "A123", "H1","20","12","Train","Detail" }, 
			{ "13", "A123", "H1","20","12","Train","Detail" }, 
			{ "14", "A123", "H1","20","12","Train","Detail" }, 
			{ "15", "A123", "H1","20","12","Train","Detail" }, 
			{ "16", "A123", "H1","20","12","Train","Detail" }, 
			{ "17", "A123", "H1","20","12","Train","Detail" }, 
			{ "18", "A123", "H1","20","12","Train","Detail" }, 
			{ "19", "A123", "H1","20","12","Train","Detail" }, 
			{ "20", "A123", "H1","20","12","Train","Detail" }, 
			{ "21", "A123", "H1","20","12","Train","Detail" }, 
			{ "22", "A123", "H1","20","12","Train","Detail" }, 
			{ "23", "A123", "H1","20","12","Train","Detail" }, 
			{ "24", "A123", "H1","20","12","Train","Detail" },
			{ "24", "A123", "H1","20","12","Train","Detail" },
			{ "24", "A123", "H1","20","12","Train","Detail" }, 
		}; 

		// Column Names 
		String[] columnNames = { "ID", "Site Code", "Merchandise Code","Quantity","Unit","Delivery","View" }; 
		f.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 12, 1182, 853);
		f.getContentPane().add(panel);
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
		lblHome.setIcon(new ImageIcon(HomeFrame.class.getResource("/main/images/home_48px_1.png")));
		lblHome.setBounds(45, 12, 227, 65);
		panel_1.add(lblHome);
		java.net.URL imgUrl = getClass().getResource("/main/images/list_64px.png");
		ImageIcon icon = new ImageIcon(imgUrl);
		Image img = icon.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(img);
		
		// Initializing the JTable 
		j = new JTable(data, columnNames); 
		j.setBorder(new LineBorder(new Color(0, 0, 0)));
		j.setBackground(Color.WHITE);
		j.setBounds(30, 40, 200, 300); 

		// adding it to JScrollPane 
		JScrollPane sp = new JScrollPane(j); 
		sp.setBounds(119, 230, 947, 428);
		panel.add(sp);
		
		textField = new JTextField();
		textField.setBounds(364, 162, 373, 34);
		panel.add(textField);
		textField.setColumns(10);
		
		Button button = new Button("Search");
		button.setBackground(UIManager.getColor("Button.light"));
		button.setBounds(777, 158, 111, 40);
		panel.add(button);
		
		JLabel lblList = new JLabel("Import Orders List");
		lblList.setBounds(84, 100, 269, 40);
		panel.add(lblList);
		lblList.setHorizontalAlignment(SwingConstants.CENTER);
		lblList.setForeground(UIManager.getColor("CheckBoxMenuItem.acceleratorForeground"));
		lblList.setFont(new Font("Verdana", Font.BOLD, 18));
		lblList.setIcon(newIcon);
		//f.getContentPane().add(sp); 
		java.net.URL imgUrl2 = getClass().getResource("/main/images/icons8-search-64.png");
		ImageIcon icon2 = new ImageIcon(imgUrl2);
		Image img2 = icon2.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon2 = new ImageIcon(img2);
		JLabel lblSearchJLabel = new JLabel("Search by ID");
		lblSearchJLabel.setBounds(213,158,133,40);
		lblSearchJLabel.setIcon(newIcon2);
		panel.add(lblSearchJLabel);

		// Frame Size 
		f.setSize(1200, 900); 
		// Frame Visible = true 
		f.setVisible(true); 
	}
}


