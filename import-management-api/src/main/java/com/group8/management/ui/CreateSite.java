package com.group8.management.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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
import javax.swing.table.DefaultTableModel;

import com.group8.management.entities.Product;
import com.group8.management.entities.Site;
import com.group8.management.service.ProductService;
import com.group8.management.service.SiteService;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;


public class CreateSite{
	private JTextField textId;
	private JTextField textName;
	private SiteService siteService;
	private JTable table;

	public CreateSite() {
	}
	
	public CreateSite(SiteService siteService) {
		this.siteService = siteService;
	}
	/**
	 * @wbp.parser.entryPoint
	 */
	public void createProductCreateUpdateFrame(JFrame frame) {
		frame.getContentPane().removeAll();
		frame.setVisible(false);
		
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
		lblNewLabel.setIcon(new ImageIcon(CreateProduct.class.getResource("/icon/home_48px_1.png")));

		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(46, 0, 144, 52);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Site Information");
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
		
		JLabel lblNewLabel_3 = new JLabel("Create Site");
		lblNewLabel_3.setForeground(new Color(51, 0, 255));
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_3.setIcon(new ImageIcon(CreateProduct.class.getResource("/icon/home_48px.png")));

		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(68, 67, 280, 55);
		panel.add(lblNewLabel_3);
		
		//========================== Form list product ===========================

	
		table = new JTable();
	
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(87, 158, 1044, 269);
		panel.add(scrollPane_1);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("clickhereeeeeeeeeee");
				int selectedRow = table.getSelectedRow();
				String id = table.getValueAt(selectedRow, 0).toString();
				Site site = siteService.findOne(id);
				textId.setText(site.getSiteID());
				textName.setText(site.getSiteName());
			}
		});
		scrollPane_1.setViewportView(table);
		
		loadData();		
		
		
		//========================== Form create update delete product ===========================
				JPanel panel_3 = new JPanel();
				panel_3.setForeground(Color.WHITE);
				panel_3.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Product Information", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
				panel_3.setBounds(89, 460, 1042, 222);
				panel.add(panel_3);
		panel_3.setLayout(null);
			
		
		JLabel lblNewLabel_4 = new JLabel("Site Name");
		lblNewLabel_4.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(40, 98, 127, 19);
		panel_3.add(lblNewLabel_4);
		

		textName = new JTextField();
		textName.setHorizontalAlignment(SwingConstants.CENTER);
		textName.setBounds(210, 99, 377, 19);
		panel_3.add(textName);
		textName.setColumns(10);
		
		
	
		JLabel lblNewLabel_7 = new JLabel("Site ID");
		lblNewLabel_7.setForeground(Color.BLACK);
		lblNewLabel_7.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(40, 55, 96, 20);
		panel_3.add(lblNewLabel_7);
		
		textId = new JTextField();
		textId.setHorizontalAlignment(SwingConstants.CENTER);
		textId.setBounds(210, 57, 377, 19);
		panel_3.add(textId);
		textId.setColumns(10);
		
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Dialog", Font.BOLD, 12));
		btnAdd.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				addActionPerformed(e);
			}
		});
		btnAdd.setBounds(332, 183, 65, 27);
		panel_3.add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Dialog", Font.BOLD, 12));
        btnDelete.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				deleteActionPerformed(e);
			}
		});
		btnDelete.setBounds(562, 180, 85, 27);
		panel_3.add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(423, 180, 112, 27);
		panel_3.add(btnUpdate);
		btnUpdate.setFont(new Font("Dialog", Font.BOLD, 12));
		btnUpdate.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				updateActionPerformed(e);
			}
		});
		
		
		
		frame.setVisible(true);
	}
	private void loadData() {
		DefaultTableModel listSite = new DefaultTableModel();
		listSite.addColumn("Site ID");
		listSite.addColumn("Site Name");
		
		for(Site site: this.siteService.findAll()) {
			listSite.addRow(new Object[] {
					site.getSiteID(),
					site.getSiteName(),
			});
		}
		table.setModel(listSite);
	}
	public void addActionPerformed(ActionEvent e) {
		try {
			Site site = new Site();
			site.setSiteID(textId.getText());
			site.setSiteName(textName.getText());
			int res = siteService.create(site);
			if(res == 0) {
				JOptionPane.showMessageDialog(null, "Site existed");
			}
			loadData();
			
		} catch (Exception e2) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e2.getMessage());
		}
	}
	public void updateActionPerformed(ActionEvent e) {
		try {
			Site site = new Site();
			site.setSiteID(textId.getText());
			site.setSiteName(textName.getText());
			siteService.update(site);
			loadData();
			
		} catch (Exception e2) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e2.getMessage());
		}
	}

	public void deleteActionPerformed(ActionEvent e) {
		try {
			int result = JOptionPane.showConfirmDialog(null, "Are you sure to delete this product", "Confirm", JOptionPane.YES_NO_OPTION);
			if(result == JOptionPane.YES_OPTION) {
				String id = textId.getText();
				siteService.deleteOne(id);
				loadData();
			}
		} catch (Exception e2) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e2.getMessage());
		}
	}
}
