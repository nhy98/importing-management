package com.group8.management.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

public class CreateProductDetail extends JFrame {
	private ProductDetailService productDetailService = new ProductDetailImpl();
	private SaleOrderService saleOrderService = new SaleOrderImpl();
	private ProductService productService = new ProductImpl();
	private ImportOrderService importOrderService = new ImportOrderImpl();
	private JTable table;
	private JComboBox comboBox;
	private JTextField quantity;
	private JTextField desiredDate;
	private String orderid;
	private int selectedId;
	private List<String> products;
	private List<Product> listProducts;

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					System.out.println("vaoday khong");
//					CreateProductDetail frame2 = new CreateProductDetail();
//					frame2.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	public CreateProductDetail() {
	}

	public CreateProductDetail(String orderid) {
		this.orderid = orderid;
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

		// ========================== Form list product ===========================

		table = new JTable();

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(87, 158, 1044, 269);
		panel.add(scrollPane_1);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("clickhereeeeeeeeeee");
				int selectedRow = table.getSelectedRow();
				int id = Integer.parseInt(table.getValueAt(selectedRow, 0).toString());
				selectedId = id;
				ProductDetail productDetail = productDetailService.findOne(id);
				orderid = productDetail.getorder().getOrderId();
				quantity.setText(String.valueOf(productDetail.getQuantiy()));
				comboBox.setSelectedItem(productDetail.getProduct());
			}
		});
		scrollPane_1.setViewportView(table);

		loadData();

		// ========================== Form create update delete product
		// ===========================
		JPanel panel_3 = new JPanel();
		panel_3.setForeground(Color.WHITE);
		panel_3.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Product Information",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel_3.setBounds(89, 454, 1042, 222);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("Quantity");
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(46, 99, 127, 19);
		panel_3.add(lblNewLabel_4);

		quantity = new JTextField();
		quantity.setHorizontalAlignment(SwingConstants.CENTER);
		quantity.setBounds(210, 99, 377, 19);
		panel_3.add(quantity);
		quantity.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Product");
		lblNewLabel_7.setForeground(Color.BLACK);
		lblNewLabel_7.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(60, 56, 96, 20);
		panel_3.add(lblNewLabel_7);

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
		btnDelete.setBounds(560, 180, 87, 27);
		panel_3.add(btnDelete);

		JButton btnUpdate = new JButton("Edit");
		btnUpdate.setBounds(440, 180, 79, 27);
		panel_3.add(btnUpdate);
		btnUpdate.setFont(new Font("Dialog", Font.BOLD, 12));

		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateActionPerformed(e);
			}
		});
		products = new ArrayList<String>();
		listProducts = new ArrayList<Product>();
		loadProduct();

		comboBox = new JComboBox(products.toArray());
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(210, 53, 377, 27);
		panel_3.add(comboBox);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				saveActionPerformed(arg0, frame);
			}
		});
		btnSave.setBounds(691, 181, 79, 25);
		panel_3.add(btnSave);

		JLabel lblNewLabel_5 = new JLabel("Desired Date");
		lblNewLabel_5.setForeground(Color.BLACK);
		lblNewLabel_5.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(690, 53, 135, 27);
		panel_3.add(lblNewLabel_5);

		desiredDate = new JTextField();
		desiredDate.setBounds(835, 54, 178, 27);
		panel_3.add(desiredDate);

		frame.setVisible(true);
	}

	private void loadProduct() {
		for (Product product : productService.findAll()) {
			listProducts.add(product);
			products.add(product.getName() + " - " + product.getUnit());
		}
	}

	private void loadData() {
		DefaultTableModel listSite = new DefaultTableModel();
		listSite.addColumn("ID");
		listSite.addColumn("Product");
		listSite.addColumn("Quantity");
		SaleOrder saleOrder = saleOrderService.findOne(orderid);
		for (ProductDetail productDetail : saleOrder.getproducts()) {
			listSite.addRow(new Object[] { productDetail.getId(), productDetail.getProduct().getName(),
					productDetail.getQuantiy() });
		}
		table.setModel(listSite);
	}

	public void addActionPerformed(ActionEvent e) {
		try {
			ProductDetail productDetail = new ProductDetail();
			productDetail.setorder(saleOrderService.findOne(orderid));
			productDetail.setQuantiy(Integer.parseInt(quantity.getText()));
			int index = comboBox.getSelectedIndex();
			Product product = listProducts.get(index);
			productDetail.setProduct(product);
			int res = productDetailService.create(productDetail);
			if (res == 0) {
				JOptionPane.showMessageDialog(null, "Product existed, please update if you want");
			}
			loadData();

		} catch (Exception e2) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e2.getMessage());
		}
	}

	public void updateActionPerformed(ActionEvent e) {
		try {
			ProductDetail productDetail = productDetailService.findOne(selectedId);
			productDetail.setorder(saleOrderService.findOne(orderid));
			productDetail.setQuantiy(Integer.parseInt(quantity.getText()));
			int index = comboBox.getSelectedIndex();
			Product product = listProducts.get(index);
			productDetail.setProduct(product);
			productDetailService.update(productDetail);
			loadData();

		} catch (Exception e2) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e2.getMessage());
		}
	}

	public void deleteActionPerformed(ActionEvent e) {
		try {
			int result = JOptionPane.showConfirmDialog(null, "Are you sure to delete this product", "Confirm",
					JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				productDetailService.deleteOne(selectedId);
				loadData();
			}
		} catch (Exception e2) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e2.getMessage());
		}
	}

	public void saveActionPerformed(ActionEvent arg0, JFrame frame) {
		Date date = null;

		try {

			date = new SimpleDateFormat("dd/MM/yyyy").parse(desiredDate.getText());
			SaleOrder order = saleOrderService.findOne(orderid);
			order.setDesiredDate(date);
			saleOrderService.update(order);

		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
		CreateSaleOrder createSaleOrder = new CreateSaleOrder();
		createSaleOrder.createProductCreateUpdateFrame(frame);
	}
}
