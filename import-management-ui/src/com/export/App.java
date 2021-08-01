package com.export;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import com.export.saleOrder.SaleOrder;
import com.export.saleOrder.HandleImportOrder;
import com.export.saleOrder.ListSaleOrder;


public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                JFrame frame = new JFrame();
	                frame.setSize(1200, 900);
	                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                frame.setVisible(true);
//	                HandleImportOrder order = new HandleImportOrder();
//	                order.createHandleOrder(frame);
	                
	                ListSaleOrder sale = new ListSaleOrder();
	                sale.createListSaleOrder(frame);
	                
//	                HomeFrame homeFrame = new HomeFrame();
//	                homeFrame.createHomeFrame(frame);
	            }
	        });
	}

}
