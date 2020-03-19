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

import com.group8.management.Constants;
import com.group8.management.entities.ImportOrder;
import com.group8.management.entities.Product;
import com.group8.management.entities.ProductDetail;
import com.group8.management.entities.SaleOrder;
import com.group8.management.entities.Site;
import com.group8.management.entities.SiteProduct;
import com.group8.management.service.ImportOrderService;
import com.group8.management.service.ProductDetailService;
import com.group8.management.service.ProductService;
import com.group8.management.service.SaleOrderService;
import com.group8.management.service.SiteProductService;
import com.group8.management.service.SiteService;
import com.group8.management.service.impl.ImportOrderImpl;
import com.group8.management.service.impl.ProductDetailImpl;
import com.group8.management.service.impl.ProductImpl;
import com.group8.management.service.impl.SaleOrderImpl;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;


public class HandleSaleOrder {
	private SaleOrderService saleOrderService = new SaleOrderImpl();
	private ProductDetailService productDetailService = new ProductDetailImpl();
	private ProductService productService = new ProductImpl();
	private ImportOrderService importOrderService = new ImportOrderImpl();
	private JTable table;
	private JTable detailTable;
	private String orderID;
	private int productId;
	private int importId;
	
	public HandleSaleOrder() {
	}
	
	public HandleSaleOrder(String orderId) {
		this.orderID = orderId;
	}
	/**
	 * @wbp.parser.entryPoint
	 */
	public void createProductCreateUpdateFrame(final JFrame frame) {
		frame.getContentPane().removeAll();
		frame.setVisible(false);
		
		frame.getContentPane().setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1182, 853);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton button_1 = new JButton("Delete");
		button_1.setBounds(948, 668, 81, 25);
		panel.add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteActionPerformed(e);
			}
		});
		
		JButton button_3 = new JButton("Create");
		button_3.setBounds(840, 668, 82, 25);
		panel.add(button_3);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addActionPerformed(e,frame);
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1182, 55);
		panel_1.setBackground(new Color(51, 102, 255));
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
		lblNewLabel_3.setBounds(68, 67, 280, 55);
		lblNewLabel_3.setForeground(new Color(51, 0, 255));
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_3.setIcon(new ImageIcon(CreateProduct.class.getResource("/icon/home_48px.png")));

		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_3);
		
		//========================== Form list product ===========================

	
		table = new JTable();
	
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(87, 158, 1044, 248);
		panel.add(scrollPane_1);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				System.out.println("clickhereeeeeeeeeee");
				int selectedRow = table.getSelectedRow();
				int id = Integer.parseInt(table.getValueAt(selectedRow, 0).toString());
//				SaleOrder saleOrder = saleOrderService.findOne(id);
//				textId.setText(site.getSiteID());
//				textName.setText(site.getSiteName());
				productId = id ;
			}
		});
		scrollPane_1.setViewportView(table);
		loadDataOrder();
		
		detailTable = new JTable();

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = detailTable.getSelectedRow();
				int id = Integer.parseInt(detailTable.getValueAt(selectedRow, 0).toString());
				importId = id ;
			}
		});
		scrollPane.setBounds(87, 482, 1044, 174);
		panel.add(scrollPane);
	
		
		scrollPane.setViewportView(detailTable);
		
		JButton btnFindSite = new JButton("Find Site");
		btnFindSite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				findSiteActionPerformed(arg0,frame);
			}
		});
		btnFindSite.setBounds(989, 422, 142, 25);
		panel.add(btnFindSite);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				saveActionPerformed(arg0, frame);
			}
		});
		btnSave.setBounds(1052, 668, 79, 25);
		panel.add(btnSave);
		
		loadDataDetail();
		
		
		
		frame.setVisible(true);
	}
	private void loadDataOrder() {
		DefaultTableModel listProduct = new DefaultTableModel();
		listProduct.addColumn("ID");
		listProduct.addColumn("Product");
		listProduct.addColumn("Quantity");
		listProduct.addColumn("Status");
		SaleOrder saleOrder = saleOrderService.findOne(orderID);
		for (ProductDetail productDetail : saleOrder.getproducts()) {
			int quantity = productDetail.getProcessQuantity();
			String status;
			if(quantity==0) status=Constants.ENOUGH;
			else status = Constants.NOT_ENOUGH;
			listProduct.addRow(new Object[] { 
					productDetail.getId(), 
					productDetail.getProduct().getName(),
					productDetail.getQuantiy() ,
					status
			});
		}
		table.setModel(listProduct);
	}
	private void loadDataDetail() {
		DefaultTableModel listProductSite = new DefaultTableModel();
		listProductSite.addColumn("Product");
		listProductSite.addColumn("Site");
		listProductSite.addColumn("Quantity");
		listProductSite.addColumn("Delivery Transportation");
		listProductSite.addColumn("Delivery Days");
		listProductSite.addColumn("Status");
		
		
		if(orderID!=null) {
			List<ImportOrder> importOrders = importOrderService.findByOrder(orderID, null);
			
			for(ImportOrder importOrder: importOrders) {
				listProductSite.addRow(new Object[] {
						importOrder.getProduct().getName(),
						importOrder.getSite().getSiteName(),
						importOrder.getQuantity(),
						importOrder.getMean().getName(),
						importOrder.getMean().getDeliveryDays(),
						importOrder.getStatus()
				});
			}
		}
		
		detailTable.setModel(listProductSite);
	}
	public void addActionPerformed(ActionEvent e,JFrame frame) {
		try {
			
			
		} catch (Exception e2) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e2.getMessage());
		}
	}

	public void deleteActionPerformed(ActionEvent e) {
		try {
			int selectedRow = table.getSelectedRow();
			String status = table.getValueAt(selectedRow, 5).toString();
			if(status.equals(Constants.CREATED)) {
				int result = JOptionPane.showConfirmDialog(null, "Are you sure to delete this sale order", "Confirm", JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.YES_OPTION) {
					importOrderService.deleteOne(importId);
					loadDataDetail();
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Error. This order is handling now");
			}
			
		} catch (Exception e2) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e2.getMessage());
		}
	}
	public void findSiteActionPerformed(ActionEvent arg0, JFrame frame) {
		ProductDetail productDetail = productDetailService.findOne(productId);
		ChooseSite chooseSite = new ChooseSite(orderID,productId);
		chooseSite.createProductCreateUpdateFrame(frame);
	}
	public void saveActionPerformed(ActionEvent arg0,JFrame frame) {
		List<ImportOrder> importOrders = importOrderService.findByOrder(orderID, null);
		for(ImportOrder importOrder: importOrders) {
			importOrder.setStatus(Constants.PROCESSING);
			importOrderService.update(importOrder);
		}
		CreateSaleOrder createSaleOrder = new CreateSaleOrder();
        createSaleOrder.createProductCreateUpdateFrame(frame);

	}
}
