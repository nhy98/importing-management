package com.group8.management.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import com.group8.management.entities.Product;
import com.group8.management.entities.Site;
import com.group8.management.service.ProductService;
import com.group8.management.service.SiteService;

public class ListSite { 
	// frame 
	JFrame f; 
	// Table 
	private JTable j; 
	private JTextField textField;
	private SiteService siteService;
	public ListSite() {
		// TODO Auto-generated constructor stub
		
	}
	public ListSite( SiteService siteService) {
		this.siteService = siteService;
	}
	/**
	 * @wbp.parser.entryPoint
	 */

	// Constructor 
	public void createListFrame(final JFrame frame) 
	{ 
		// Frame initiallization 
		frame.getContentPane().removeAll();
		frame.setVisible(false);

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
//		lblHome.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//				 HomeFrame homeFrame = new HomeFrame();
//	             homeFrame.createHomeFrame(frame);
//			}
//		});
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setForeground(Color.WHITE);
		lblHome.setFont(new Font("Verdana", Font.BOLD, 24));
		lblHome.setIcon(new ImageIcon(ListProduct.class.getResource("/icon/home_48px_1.png")));
		lblHome.setBounds(45, 12, 227, 65);
		panel_1.add(lblHome);
		
		// Initializing the JTable 
		
		
//		j.setRowHeight(41);
//		j.setFont(new Font("Verdana", Font.PLAIN, 16));
//		j.setBorder(new LineBorder(new Color(0, 0, 0)));
//		j.setBackground(Color.WHITE);
//		j.setBounds(30, 40, 200, 300); 
//
//		Font f = new Font("Arial", Font.BOLD, 16);
//	    JTableHeader header = j.getTableHeader();
//	    header.setFont(f);
	    
//		// adding it to JScrollPane 
		j = new JTable();
		JScrollPane sp = new JScrollPane();
		sp.setBounds(116, 229, 947, 481);
		panel.add(sp);
		sp.setViewportView(j);
		
		loadData();
		
			    
		textField = new JTextField();
		textField.setBounds(364, 162, 373, 34);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblList = new JLabel("Product List");
		lblList.setBounds(84, 100, 269, 40);
		panel.add(lblList);
		lblList.setHorizontalAlignment(SwingConstants.CENTER);
		lblList.setForeground(UIManager.getColor("CheckBoxMenuItem.acceleratorForeground"));
		lblList.setFont(new Font("Verdana", Font.BOLD, 18));
		lblList.setIcon(new ImageIcon(ListProduct.class.getResource("/icon/list_64px.png")));
		//frame.getContentPane().add(sp); 
		JLabel lblSearchJLabel = new JLabel("Search by ID");
		lblSearchJLabel.setBounds(213,158,133,40);
		lblSearchJLabel.setIcon(new ImageIcon(ListProduct.class.getResource("/icon/search_20px_1.png")));
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
				searchActionPerformed(arg0);
			}
		});
		btnSearch.setFont(new Font("Verdana", Font.PLAIN, 18));
		btnSearch.setBounds(777, 162, 113, 34);
		panel.add(btnSearch);
		
		JButton btnAddNew = new JButton("Add New");
//		btnAddNew.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//				ProductCreateFrame productCreateFrame = new ProductCreateFrame();
//				productCreateFrame.createProductCreateUpdateFrame(frame);
//			}
//		});
		btnAddNew.setFont(new Font("Verdana", Font.PLAIN, 18));
		btnAddNew.setBounds(515, 749, 113, 40);
		panel.add(btnAddNew);

		// Frame Visible = true 
		frame.setVisible(true); 
	} 
	private void loadData() {
		DefaultTableModel listProduct = new DefaultTableModel();
		listProduct.addColumn("Site ID");
		listProduct.addColumn("Site Name");
		
		for(Site site: this.siteService.findAll()) {
			listProduct.addRow(new Object[] {
					site.getSiteID(),
					site.getSiteName()
			});
		}
		j.setModel(listProduct);
	}
	public void searchActionPerformed(ActionEvent arg0) {
		try {
			DefaultTableModel listProduct = new DefaultTableModel();
			listProduct.addColumn("Site ID");
			listProduct.addColumn("Site Name");
			Site site = siteService.findOne(textField.getText());
			listProduct.addRow(new Object[] {
					site.getSiteID(),
					site.getSiteName()
			});
			j.setModel(listProduct);
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
} 
