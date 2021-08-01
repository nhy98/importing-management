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
import com.group8.management.service.ImportOrderService;
import com.group8.management.service.ProductDetailService;
import com.group8.management.service.ProductService;
import com.group8.management.service.SaleOrderService;
import com.group8.management.service.SiteService;
import com.group8.management.service.impl.ImportOrderImpl;
import com.group8.management.service.impl.ProductDetailImpl;
import com.group8.management.service.impl.ProductImpl;
import com.group8.management.service.impl.SaleOrderImpl;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;

import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;


public class CreateSaleOrder{
	private SaleOrderService saleOrderService = new SaleOrderImpl();
	private ProductDetailService productDetailService = new ProductDetailImpl();
	private ProductService productService = new ProductImpl();
	private ImportOrderService importOrderService = new ImportOrderImpl();
	private JTable table;
	private JTable detailTable;
	private String orderID;
	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	public static String randomAlphaNumeric(int count) {

		StringBuilder builder = new StringBuilder();

		while (count-- != 0) {
			int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}	
		return builder.toString();
	}
	public CreateSaleOrder() {
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
		
		JButton button = new JButton("Update");
		button.setBounds(812, 418, 86, 25);
		panel.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateActionPerformed(e,frame);
			}
		});
		
		JButton button_1 = new JButton("Delete");
		button_1.setBounds(925, 418, 81, 25);
		panel.add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteActionPerformed(e);
			}
		});
		
		JButton button_3 = new JButton("Create");
		button_3.setBounds(705, 418, 82, 25);
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
				String id = table.getValueAt(selectedRow, 0).toString();
//				SaleOrder saleOrder = saleOrderService.findOne(id);
//				textId.setText(site.getSiteID());
//				textName.setText(site.getSiteName());
				orderID = id ;
			}
		});
		scrollPane_1.setViewportView(table);
		loadDataOrder();
		
		detailTable = new JTable();

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(87, 497, 1044, 174);
		panel.add(scrollPane);
	
		
		scrollPane.setViewportView(detailTable);
		
		JButton btnNewButton = new JButton("Detail");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				detailActionPerformed(arg0);
			}
		});
		btnNewButton.setBounds(1035, 418, 86, 25);
		panel.add(btnNewButton);
		
		JButton btnHandle = new JButton("Handle");
		btnHandle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				handleActionPerformed(arg0,frame);
			}
		});
		btnHandle.setBounds(597, 418, 86, 25);
		panel.add(btnHandle);
		
		loadDataDetail();
		
		
		
		frame.setVisible(true);
	}
	private void loadDataOrder() {
		DefaultTableModel listSaleOrder = new DefaultTableModel();
		listSaleOrder.addColumn("Order ID");
		listSaleOrder.addColumn("Desired Date");
		listSaleOrder.addColumn("Status");
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		for(SaleOrder saleOrder: this.saleOrderService.findAll()) {
			listSaleOrder.addRow(new Object[] {
					saleOrder.getOrderId(),
					dateFormat.format(saleOrder.getDesiredDate()),
					saleOrder.getStatus()
			});
		}
		table.setModel(listSaleOrder);
	}
	private void loadDataDetail() {
		DefaultTableModel listSaleOrder = new DefaultTableModel();
		listSaleOrder.addColumn("Product ID");
		listSaleOrder.addColumn("Product Name");
		listSaleOrder.addColumn("Unit");
		listSaleOrder.addColumn("Quantity");
		
		if(orderID!=null) {
			SaleOrder saleOrder = saleOrderService.findOne(orderID);
			
			for(ProductDetail productDetail: saleOrder.getproducts()) {
				Product product = productDetail.getProduct();
				listSaleOrder.addRow(new Object[] {
						product.getProductID(),
						product.getName(),
						product.getUnit(),
						productDetail.getQuantiy()
				});
			}
		}
//		else {
//			SaleOrder saleOrder = saleOrderService.findOne("o1");
//			for(ProductDetail productDetail: saleOrder.getproducts()) {
//				Product product = productDetail.getProduct();
//				listSaleOrder.addRow(new Object[] {
//						product.getProductID(),
//						product.getName(),
//						product.getUnit(),
//						productDetail.getQuantiy()
//				});
//			}
//			
//		}
		
		detailTable.setModel(listSaleOrder);
	}
	public void addActionPerformed(ActionEvent e,JFrame frame) {
		try {
			SaleOrder saleOrder = new SaleOrder();
			String orderid = randomAlphaNumeric(6);
			saleOrder.setOrderId(orderid);
			saleOrder.setStatus(Constants.CREATED);
			int res = saleOrderService.create(saleOrder);
			if(res == 0) {
				JOptionPane.showMessageDialog(null, "Order existed");
			}
			CreateProductDetail createProductDetail = new CreateProductDetail(orderid);
			//CreateSaleOrder createSaleOrder = new CreateSaleOrder();
			createProductDetail.createProductCreateUpdateFrame(frame);
			//CreateProductDetail frame2 = new CreateProductDetail();
//			createProductDetail.setVisible(true);
//			createProductDetail.setSize(1200,900);
			//loadData();
			
		} catch (Exception e2) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e2.getMessage());
		}
	}
	public void updateActionPerformed(ActionEvent e,JFrame frame) {
		try {
			CreateProductDetail createProductDetail = new CreateProductDetail(orderID);
			//CreateSaleOrder createSaleOrder = new CreateSaleOrder();
			createProductDetail.createProductCreateUpdateFrame(frame);
			
		} catch (Exception e2) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e2.getMessage());
		}
	}

	public void deleteActionPerformed(ActionEvent e) {
		try {
			int selectedRow = table.getSelectedRow();
			String status = table.getValueAt(selectedRow, 2).toString();
			if(status.equals(Constants.CREATED)) {
				int result = JOptionPane.showConfirmDialog(null, "Are you sure to delete this sale order", "Confirm", JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.YES_OPTION) {
					String id = table.getValueAt(selectedRow, 0).toString();
					SaleOrder saleOrder = saleOrderService.findOne(id);
					for(ProductDetail productDetail : saleOrder.getproducts()) {
						productDetailService.deleteOne(productDetail.getId());
					}
					saleOrderService.deleteOne(id);
					loadDataOrder();
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
	public void detailActionPerformed(ActionEvent arg0) {
		loadDataDetail();
	}
	public void handleActionPerformed(ActionEvent arg0, JFrame frame) {
		int selectedRow = table.getSelectedRow();
		String status = table.getValueAt(selectedRow, 2).toString();
		if(status.equals(Constants.CREATED)){
			status = "processing";
			SaleOrder saleOrder = saleOrderService.findOne(orderID);
			saleOrder.setStatus(status);
			saleOrderService.update(saleOrder);
			HandleSaleOrder handleSaleOrder = new HandleSaleOrder(orderID);
			//CreateSaleOrder createSaleOrder = new CreateSaleOrder();
			handleSaleOrder.createProductCreateUpdateFrame(frame);
		}
		HandleSaleOrder handleSaleOrder = new HandleSaleOrder(orderID);
		//CreateSaleOrder createSaleOrder = new CreateSaleOrder();
		handleSaleOrder.createProductCreateUpdateFrame(frame);
	}
}
