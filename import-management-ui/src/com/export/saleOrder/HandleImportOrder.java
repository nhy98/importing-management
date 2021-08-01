package com.export.saleOrder;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import com.export.HomeFrame;

public class HandleImportOrder{

	/**
	 * Create the panel.
	 */
	public HandleImportOrder() {

	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public void createHandleOrder(JFrame frame) {
		frame.getContentPane().setLayout(null);
		JPanel panel = new JPanel();
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
		
		JLabel lblImportAssignmentSystem = new JLabel("View Order Management");
		lblImportAssignmentSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblImportAssignmentSystem.setForeground(Color.WHITE);
		lblImportAssignmentSystem.setFont(new Font("Verdana", Font.BOLD, 32));
		lblImportAssignmentSystem.setBounds(122, 64, 572, 56);
		panel_1.add(lblImportAssignmentSystem);
		
		
		java.net.URL imgUrl = getClass().getResource("/main/images/list_64px.png");
		ImageIcon icon = new ImageIcon(imgUrl);
		Image img = icon.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(img);		
		
		JLabel lblList = new JLabel("View Import Order ");
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

		    TableColumnModel cm = table.getColumnModel();
		 

		    ColumnGroup g_lang = new ColumnGroup("Desired Delivery Date");
		    g_lang.add(cm.getColumn(3));
		    g_lang.add(cm.getColumn(4));
		    g_lang.add(cm.getColumn(5));

		    GroupableTableHeader header = (GroupableTableHeader)table.getTableHeader();
		    header.addColumnGroup(g_lang);
		    JScrollPane scroll = new JScrollPane( table );
		    scroll.setBounds(50, 200, 1100, 420);
		    panel.add(scroll);
		    
		  
		    
		
	}
}
