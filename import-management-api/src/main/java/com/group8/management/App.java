package com.group8.management;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.print.attribute.standard.Sides;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

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
import com.group8.management.service.UserService;
import com.group8.management.service.impl.ImportOrderImpl;
import com.group8.management.service.impl.ProductDetailImpl;
import com.group8.management.service.impl.ProductImpl;
import com.group8.management.service.impl.SaleOrderImpl;
import com.group8.management.service.impl.SiteProductImpl;
import com.group8.management.service.impl.SiteServiceImpl;
import com.group8.management.service.impl.TransportationImpl;
import com.group8.management.service.impl.UserServiceImpl;
import com.group8.management.ui.CreateProduct;
import com.group8.management.ui.CreateSaleOrder;
import com.group8.management.ui.CreateSite;
import com.group8.management.ui.ListProduct;
import com.group8.management.ui.ListSite;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//    	SaleOrderService orderService = new SaleOrderImpl();
//    	ProductDetailService productDetailService = new ProductDetailImpl();
    	SiteService siteService = new SiteServiceImpl();
//    	SiteProductService siteProductService = new SiteProductImpl();
//    	TransportationService transportationService = new TransportationImpl();
//    	 
////    	Site shopee = new Site("s1","shopee");
////    	Product pen = new Product("pen1","pen","pcs");
////    	Transportation transport = new Transportation("p1",shopee,"plane",3,"very fast");
////    	SiteProduct siteProduct = new SiteProduct(shopee,pen,1000);
////    	siteService.create(shopee);
////    	transportationService.create(transport);
////    	productService.create(pen);
////    	siteProductService.create(siteProduct);
    	
		  SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                final JFrame frame = new JFrame();
	                frame.setSize(1200, 900);
	                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                frame.setVisible(true);
//	        ============ list product ===========================
	           	 	ProductService productService = new ProductImpl();
	           	 	SaleOrderService saleOrderService = new SaleOrderImpl();
	           	 	ProductDetailService productDetailService = new ProductDetailImpl();
	           	 	ImportOrderService importOrderService = new ImportOrderImpl();
	       


//
//	                ListProduct product = new ListProduct(productService);
//	                product.createListFrame(frame);
//	                
//	        ============ create product ===========================
//	                CreateProduct createProduct = new CreateProduct(productService);
//	                createProduct.createProductCreateUpdateFrame(frame);
//			        ============ list product ===========================
	           	 	SiteService siteService = new SiteServiceImpl();

//	    	        ============ list site ===========================
//	                ListSite site = new ListSite(siteService);
//	                site.createListFrame(frame);
	                
////	    	        ============ create site ===========================
//	                CreateSite createSite = new CreateSite(siteService);
//	                createSite.createProductCreateUpdateFrame(frame);
	                
//	    	        ============ create sale order ===========================
	                CreateSaleOrder createSaleOrder = new CreateSaleOrder();
	                createSaleOrder.createProductCreateUpdateFrame(frame);
	            }
	     
		  
		  });
    	
    }
}
