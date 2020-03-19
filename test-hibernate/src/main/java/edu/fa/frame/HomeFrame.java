package edu.fa.frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HomeFrame{
	
	public HomeFrame() {
	}
	/**
	 * @wbp.parser.entryPoint
	 */
	public void createHomeFrame(final JFrame frame) {
		frame.getContentPane().removeAll();
		frame.setVisible(false);
		frame.getContentPane().setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1182, 853);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_Home = new JPanel();
		panel_Home.setBackground(SystemColor.textHighlight);
		panel_Home.setBounds(0, 0, 1182, 322);
		panel.add(panel_Home);
		panel_Home.setLayout(null);
		
		JLabel lblHome = new JLabel("Home");
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setForeground(Color.WHITE);
		lblHome.setFont(new Font("Verdana", Font.BOLD, 24));
		lblHome.setIcon(new ImageIcon(HomeFrame.class.getResource("/icon/home_48px_1.png")));
		lblHome.setBounds(177, 57, 227, 155);
		panel_Home.add(lblHome);
		
		JLabel lblImportAssignmentSystem = new JLabel("Import Assignment System");
		lblImportAssignmentSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblImportAssignmentSystem.setForeground(Color.WHITE);
		lblImportAssignmentSystem.setFont(new Font("Verdana", Font.BOLD, 32));
		lblImportAssignmentSystem.setBounds(192, 169, 572, 56);
		panel_Home.add(lblImportAssignmentSystem);
		
		JLabel lblNewLabel = new JLabel("Hi, H\u00E0 L\u00EA Th\u1ECBnh");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel.setBounds(672, 33, 398, 30);
		panel_Home.add(lblNewLabel);
		
		JPanel panel_logout = new JPanel();
		panel_logout.setBounds(1082, 34, 88, 29);
		panel_Home.add(panel_logout);
		panel_logout.setBackground(SystemColor.menu);
		
		JLabel lblNewLabel_1 = new JLabel("Log out");
		panel_logout.add(lblNewLabel_1);
		lblNewLabel_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JPanel panel_btn1 = new JPanel();
		panel_btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("panel_2 clicked");
			
			}
		});
		panel_btn1.setBackground(SystemColor.inactiveCaption);
		panel_btn1.setBounds(180, 426, 120, 120);
		panel.add(panel_btn1);
		panel_btn1.setLayout(null);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(HomeFrame.class.getResource("/icon/icons8-list-64.png")));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.BLUE);
		label_2.setFont(new Font("Verdana", Font.BOLD, 12));
		label_2.setBounds(0, 26, 120, 52);
		panel_btn1.add(label_2);
		
		JLabel lblSaleOrder = new JLabel("Sale Order");
		lblSaleOrder.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaleOrder.setForeground(Color.BLUE);
		lblSaleOrder.setFont(new Font("Verdana", Font.BOLD, 12));
		lblSaleOrder.setBounds(0, 68, 120, 52);
		panel_btn1.add(lblSaleOrder);
		
		JPanel panel_btn2 = new JPanel();
		panel_btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
		
			}
		});
		panel_btn2.setBackground(SystemColor.inactiveCaption);
		panel_btn2.setBounds(417, 426, 120, 120);
		panel.add(panel_btn2);
		panel_btn2.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(60, 5, 0, 0);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLUE);
		label.setFont(new Font("Verdana", Font.BOLD, 12));
		panel_btn2.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(HomeFrame.class.getResource("/icon/icons8-purchase-order-64.png")));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.BLUE);
		label_1.setFont(new Font("Verdana", Font.BOLD, 12));
		label_1.setBounds(0, 27, 120, 52);
		panel_btn2.add(label_1);
		
		JLabel lblImportOrder = new JLabel("Import Order");
		lblImportOrder.setHorizontalAlignment(SwingConstants.CENTER);
		lblImportOrder.setForeground(Color.BLUE);
		lblImportOrder.setFont(new Font("Verdana", Font.BOLD, 12));
		lblImportOrder.setBounds(0, 68, 120, 52);
		panel_btn2.add(lblImportOrder);
		
		JPanel panel_btn3 = new JPanel();
		panel_btn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("panel_3 clicked");
			}
		});
		panel_btn3.setBackground(SystemColor.inactiveCaption);
		panel_btn3.setBounds(652, 426, 120, 120);
		panel.add(panel_btn3);
		panel_btn3.setLayout(null);
		
		JLabel lblUser_1 = new JLabel("User");
		lblUser_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser_1.setForeground(Color.BLUE);
		lblUser_1.setFont(new Font("Verdana", Font.BOLD, 12));
		lblUser_1.setBounds(0, 68, 120, 52);
		panel_btn3.add(lblUser_1);
		
		JLabel lblUser = new JLabel("");
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setBounds(0, 26, 120, 52);
		lblUser.setIcon(new ImageIcon(HomeFrame.class.getResource("/icon/icons8-user-account-64.png")));
		lblUser.setForeground(Color.BLUE);
		lblUser.setFont(new Font("Verdana", Font.BOLD, 12));
		panel_btn3.add(lblUser);
		
		JPanel panel_btn4 = new JPanel();
		panel_btn4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TransportationListFrame transportationListFrame = new TransportationListFrame();
				transportationListFrame.createListFrame(frame);
			}
		});
		panel_btn4.setBackground(SystemColor.inactiveCaption);
		panel_btn4.setBounds(180, 616, 120, 120);
		panel.add(panel_btn4);
		panel_btn4.setLayout(null);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(HomeFrame.class.getResource("/icon/icons8-shipped-64.png")));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.BLUE);
		label_3.setFont(new Font("Verdana", Font.BOLD, 12));
		label_3.setBounds(0, 26, 120, 52);
		panel_btn4.add(label_3);
		
		JLabel lblTransportation = new JLabel("Transportation");
		lblTransportation.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransportation.setForeground(Color.BLUE);
		lblTransportation.setFont(new Font("Verdana", Font.BOLD, 12));
		lblTransportation.setBounds(0, 68, 120, 52);
		panel_btn4.add(lblTransportation);
		
		JPanel panel_btn5 = new JPanel();
		panel_btn5.setBackground(SystemColor.inactiveCaption);
		panel_btn5.setBounds(417, 616, 120, 120);
		panel.add(panel_btn5);
		panel_btn5.setLayout(null);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(HomeFrame.class.getResource("/icon/icons8-male-user-64 (1).png")));
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(Color.BLUE);
		label_5.setFont(new Font("Verdana", Font.BOLD, 12));
		label_5.setBounds(0, 26, 120, 52);
		panel_btn5.add(label_5);
		
		JLabel lblProfile = new JLabel("Profile");
		lblProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfile.setForeground(Color.BLUE);
		lblProfile.setFont(new Font("Verdana", Font.BOLD, 12));
		lblProfile.setBounds(0, 68, 120, 52);
		panel_btn5.add(lblProfile);
		
		JPanel panel_btn6 = new JPanel();
		panel_btn6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(frame, "You just opened a dialog.", "Warning Dialog", JOptionPane.ERROR_MESSAGE);
			
			}
		});
		panel_btn6.setBackground(SystemColor.inactiveCaption);
		panel_btn6.setBounds(652, 616, 120, 120);
		panel.add(panel_btn6);
		panel_btn6.setLayout(null);
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(HomeFrame.class.getResource("/icon/icons8-internet-connection-64.png")));
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setForeground(Color.BLUE);
		label_7.setFont(new Font("Verdana", Font.BOLD, 12));
		label_7.setBounds(0, 26, 120, 52);
		panel_btn6.add(label_7);
		
		JLabel lblSite = new JLabel("Site");
		lblSite.setHorizontalAlignment(SwingConstants.CENTER);
		lblSite.setForeground(Color.BLUE);
		lblSite.setFont(new Font("Verdana", Font.BOLD, 12));
		lblSite.setBounds(0, 68, 120, 52);
		panel_btn6.add(lblSite);
		
		JPanel panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ProductListFrame productListFrame = new ProductListFrame();
				productListFrame.createListFrame(frame);
			}
		});
		panel_1.setLayout(null);
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setBounds(883, 426, 120, 120);
		panel.add(panel_1);
		
		JLabel lblProduct = new JLabel("Product");
		lblProduct.setHorizontalAlignment(SwingConstants.CENTER);
		lblProduct.setForeground(Color.BLUE);
		lblProduct.setFont(new Font("Verdana", Font.BOLD, 12));
		lblProduct.setBounds(0, 68, 120, 52);
		panel_1.add(lblProduct);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(HomeFrame.class.getResource("/icon/icons8-new-product-64.png")));
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setForeground(Color.BLUE);
		label_6.setFont(new Font("Verdana", Font.BOLD, 12));
		label_6.setBounds(0, 26, 120, 52);
		panel_1.add(label_6);
		
		JPanel panel_2 = new JPanel();
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SiteProductListFrame siteProductListFrame = new SiteProductListFrame();
				siteProductListFrame.createListFrame(frame);
			}
		});
		panel_2.setLayout(null);
		panel_2.setBackground(SystemColor.inactiveCaption);
		panel_2.setBounds(883, 616, 120, 120);
		panel.add(panel_2);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(HomeFrame.class.getResource("/icon/icons8-box-64.png")));
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.BLUE);
		label_4.setFont(new Font("Verdana", Font.BOLD, 12));
		label_4.setBounds(0, 26, 120, 52);
		panel_2.add(label_4);
		
		JLabel lblSiteProduct = new JLabel("Site Product");
		lblSiteProduct.setHorizontalAlignment(SwingConstants.CENTER);
		lblSiteProduct.setForeground(Color.BLUE);
		lblSiteProduct.setFont(new Font("Verdana", Font.BOLD, 12));
		lblSiteProduct.setBounds(0, 68, 120, 52);
		panel_2.add(lblSiteProduct);
		
		frame.setVisible(true);
	}
	
}
