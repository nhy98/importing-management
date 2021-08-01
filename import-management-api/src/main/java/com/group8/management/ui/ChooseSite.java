package com.group8.management.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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

import org.hibernate.Hibernate;

import com.group8.management.Constants;
import com.group8.management.entities.ImportOrder;
import com.group8.management.entities.Product;
import com.group8.management.entities.ProductDetail;
import com.group8.management.entities.SaleOrder;
import com.group8.management.entities.Site;
import com.group8.management.entities.SiteProduct;
import com.group8.management.entities.Transportation;
import com.group8.management.service.ImportOrderService;
import com.group8.management.service.ProductDetailService;
import com.group8.management.service.ProductService;
import com.group8.management.service.SaleOrderService;
import com.group8.management.service.SiteProductService;
import com.group8.management.service.SiteService;
import com.group8.management.service.TransportationService;
import com.group8.management.service.impl.ImportOrderImpl;
import com.group8.management.service.impl.SiteProductImpl;
import com.group8.management.service.impl.TransportationImpl;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;


public class ChooseSite {
	private SaleOrderService saleOrderService;
	private ProductDetailService productDetailService;
	private ProductService productService;
	private SiteProductService siteProductService = new SiteProductImpl();
	private TransportationService transportationService;
	private ImportOrderService importOrderService = new ImportOrderImpl();
	private JTable table;
	private JTable detailTable;
	private String orderID;
	private int importId;
	private int productId;
	private int productSiteId;
	private List<String> transports;
	private List<Transportation> listTransportations;
	private JComboBox comboBox;
	
	public ChooseSite() {
	}
	
	public ChooseSite(String orderID,int productId) {
		this.productId = productId;
		this.orderID = orderID;
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
		button_1.setBounds(1050, 668, 81, 25);
		panel.add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteActionPerformed(e);
			}
		});
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(945, 668, 82, 25);
		panel.add(btnSave);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveActionPerformed(e,frame);
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
				int selectedRow = table.getSelectedRow();
				int id = Integer.parseInt(table.getValueAt(selectedRow, 0).toString());
//				SaleOrder saleOrder = saleOrderService.findOne(id);
//				textId.setText(site.getSiteID());
//				textName.setText(site.getSiteName());
				productSiteId = id ;
				loadTransport(productSiteId);

			}
		});
		scrollPane_1.setViewportView(table);
		loadDataDetail();
		
		detailTable = new JTable();

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(87, 482, 1044, 174);
		panel.add(scrollPane);
	
		detailTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = detailTable.getSelectedRow();
				int id = Integer.parseInt(detailTable.getValueAt(selectedRow, 0).toString());
//				SaleOrder saleOrder = saleOrderService.findOne(id);
//				textId.setText(site.getSiteID());
//				textName.setText(site.getSiteName());
				importId = id ;
			}
		});
		scrollPane.setViewportView(detailTable);
		loadDataOrder();
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addActionPerformed(arg0);
			}
		});
		btnAdd.setBounds(989, 422, 142, 25);
		panel.add(btnAdd);
		
		JLabel lblTransportation = new JLabel("Transportation");
		lblTransportation.setBounds(475, 427, 107, 15);
		panel.add(lblTransportation);
		
		transportationService = new TransportationImpl();
		transports = new ArrayList<String>();
		listTransportations = new ArrayList<Transportation>();
		
		comboBox = new JComboBox();
		comboBox.setBounds(600, 422, 194, 24);
		panel.add(comboBox);
		loadTransport(productSiteId);
//		loadDataOrder();
		
		
		
		frame.setVisible(true);
	}
	private void loadTransport(int productSiteId) {
		DefaultComboBoxModel listTransport = new DefaultComboBoxModel();
		siteProductService = new SiteProductImpl();
		if(productSiteId!=0) {
			SiteProduct siteProduct = siteProductService.findOne(productSiteId);
			List<Transportation> transportations = transportationService.findBySiteId(siteProduct.getSite().getSiteID());
			for (Transportation transportation : transportations) {
				listTransport.addElement(transportation.getName()+" - "+transportation.getDeliveryDays()+" days");
				listTransportations.add(transportation);
				transports.add(transportation.getName() + " - " + transportation.getDeliveryDays());
			}
		}
		comboBox.setModel(listTransport);
	}
	private void loadDataOrder() {
		DefaultTableModel listProductSite = new DefaultTableModel();
		listProductSite.addColumn("ID");
		listProductSite.addColumn("Site Name");
		listProductSite.addColumn("Quantity");
		listProductSite.addColumn("Delivery Transportation");
		listProductSite.addColumn("Delivery Days");

		
		ProductDetail product = productDetailService.findOne(productId);
		List<ImportOrder> importOrders = importOrderService.findByOrder(product.getorder().getOrderId(), product.getProduct().getProductID());
		
		for(ImportOrder importOrder: importOrders) {
			listProductSite.addRow(new Object[] {
					importOrder.getId(),
					importOrder.getSite().getSiteName(),
					importOrder.getQuantity(),
					importOrder.getMean().getName(),
					importOrder.getMean().getDeliveryDays()
			});
		}
		
		detailTable.setModel(listProductSite);
	}
	private void loadDataDetail() {
		DefaultTableModel listProductSite = new DefaultTableModel();
		listProductSite.addColumn("ID");
		listProductSite.addColumn("Site Name");
		listProductSite.addColumn("Quantity");
		
		
		if(productId!=0) {
			ProductDetail productDetail = productDetailService.findOne(productId);
			Product product = productDetail.getProduct();
//			List<SiteProduct> siteProducts = product.getProducts();
//			System.out.println(siteProducts.size() + "sizde");
			 List<SiteProduct> siteProducts = siteProductService.findProductsById(product.getProductID());
			 
			for(SiteProduct siteProduct: siteProducts) {
				listProductSite.addRow(new Object[] {
						siteProduct.getId(),
						siteProduct.getSite().getSiteName(),
						siteProduct.getQuantity()
				});
			}
		}
		
		table.setModel(listProductSite);
	}
	public void addActionPerformed(ActionEvent e) {
		try {
				ProductDetail productDetail = productDetailService.findOne(productId);
				int quantity = productDetail.getQuantiy();
				if(quantity>0) {
					ImportOrder importOrder = new ImportOrder();
					int index = comboBox.getSelectedIndex();
					Transportation transportation = listTransportations.get(index);
					importOrder.setMean(transportation);
					Product product = siteProductService.findOne(productSiteId).getProduct();
					importOrder.setProduct(product);
					importOrder.setStatus("created");
					importOrder.setOrder(productDetailService.findOne(productId).getorder());
					importOrder.setSite(siteProductService.findOne(productSiteId).getSite());
					//int quantity = productDetailService.findOne(productId).getQuantiy();
					int selectedRow = table.getSelectedRow();
					int siteQuantity = Integer.parseInt(table.getValueAt(selectedRow, 2).toString());
					
					
					if(quantity<= siteQuantity) {
						importOrder.setQuantity(quantity);
						siteQuantity-=quantity;
						quantity=0;
					}
					else {
						importOrder.setQuantity(siteQuantity);
						siteQuantity=0;
						quantity-=siteQuantity;
					}
					productDetail.setProcessQuantity(quantity);
					productDetailService.update(productDetail);
					SiteProduct siteProduct = siteProductService.findOne(productSiteId);
					siteProduct.setQuantity(siteQuantity);
					siteProductService.update(siteProduct);
					importOrderService.create(importOrder);
					loadDataOrder();
					loadDataDetail();
				}
				else {
					JOptionPane.showMessageDialog(null, "Error. This order detail had already done or out of quantity");
				}

		} catch (Exception e2) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e2.getMessage());
		}
	}

	public void deleteActionPerformed(ActionEvent e) {
		try {
			ImportOrder importOrder = importOrderService.findOne(importId);
			if(importOrder.getStatus().equals(Constants.PROCESSING)) {
				JOptionPane.showMessageDialog(null, "This order is now processing");
			}
			else {
				int result = JOptionPane.showConfirmDialog(null, "Are you sure to delete this sale order", "Confirm", JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.YES_OPTION) {
					int quantity = importOrder.getQuantity();
					ProductDetail productDetail = productDetailService.findOne(productId);
					productDetail.setQuantiy(productDetail.getQuantiy()+quantity);
					importOrderService.deleteOne(importId);
					loadDataOrder();
				}	
			}
		} catch (Exception e2) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e2.getMessage());
		}
	}
	public void saveActionPerformed(ActionEvent e, JFrame frame) {
		HandleSaleOrder handleSaleOrder = new HandleSaleOrder(orderID);
		handleSaleOrder.createProductCreateUpdateFrame(frame);
	}

}
