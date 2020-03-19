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
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.table.JTableHeader;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent; 

public class OtherList { 
	// frame 
	JFrame f; 
	// Table 
	JTable j; 
	private JTextField textField;
	public OtherList() {
		// TODO Auto-generated constructor stub

	}
	/**
	 * @wbp.parser.entryPoint
	 */

	// Constructor 
	void createListFrame(final JFrame frame) 
	{ 
		// Frame initiallization 
		frame.getContentPane().removeAll();
		frame.setVisible(false);

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
		lblHome.setIcon(new ImageIcon(OtherList.class.getResource("/icon/home_48px_1.png")));
		lblHome.setBounds(45, 12, 227, 65);
		panel_1.add(lblHome);
		
		// Initializing the JTable 
		j = new JTable(data, columnNames);
		j.setRowHeight(41);
		j.setFont(new Font("Verdana", Font.PLAIN, 16));
		j.setBorder(new LineBorder(new Color(0, 0, 0)));
		j.setBackground(Color.WHITE);
		j.setBounds(30, 40, 200, 300); 

		Font f = new Font("Arial", Font.BOLD, 16);
	    JTableHeader header = j.getTableHeader();
	    header.setFont(f);
	    
		// adding it to JScrollPane 
		JScrollPane sp = new JScrollPane(j);
		sp.setBounds(116, 229, 947, 481);
		panel.add(sp);
		
		
	    
		textField = new JTextField();
		textField.setBounds(364, 162, 373, 34);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblList = new JLabel("Import Orders List");
		lblList.setBounds(84, 100, 269, 40);
		panel.add(lblList);
		lblList.setHorizontalAlignment(SwingConstants.CENTER);
		lblList.setForeground(UIManager.getColor("CheckBoxMenuItem.acceleratorForeground"));
		lblList.setFont(new Font("Verdana", Font.BOLD, 18));
		lblList.setIcon(new ImageIcon(OtherList.class.getResource("/icon/list_64px.png")));
		//frame.getContentPane().add(sp); 
		JLabel lblSearchJLabel = new JLabel("Search by ID");
		lblSearchJLabel.setBounds(213,158,133,40);
		lblSearchJLabel.setIcon(new ImageIcon(OtherList.class.getResource("/icon/search_20px_1.png")));
		panel.add(lblSearchJLabel);
		
		JButton btnDetail = new JButton("Detail");
		btnDetail.setFont(new Font("Verdana", Font.PLAIN, 18));
		btnDetail.setBounds(663, 749, 113, 40);
		panel.add(btnDetail);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setFont(new Font("Verdana", Font.PLAIN, 18));
		btnEdit.setBounds(808, 749, 113, 40);
		panel.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Verdana", Font.PLAIN, 18));
		btnDelete.setBounds(950, 749, 113, 40);
		panel.add(btnDelete);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSearch.setFont(new Font("Verdana", Font.PLAIN, 18));
		btnSearch.setBounds(777, 162, 113, 34);
		panel.add(btnSearch);
		
		JButton btnAddNew = new JButton("Add New");
		btnAddNew.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ProductCreateFrame productCreateFrame = new ProductCreateFrame();
				productCreateFrame.createProductCreateUpdateFrame(frame);
			}
		});
		btnAddNew.setFont(new Font("Verdana", Font.PLAIN, 18));
		btnAddNew.setBounds(515, 749, 113, 40);
		panel.add(btnAddNew);

		// Frame Visible = true 
		frame.setVisible(true); 
	} 
} 
