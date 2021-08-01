package com.group8.management.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.group8.management.HibernateUtils;
import com.group8.management.entities.Product;
import com.group8.management.entities.ProductDetail;
import com.group8.management.service.ProductService;

public class ProductImpl implements ProductService {
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		List<Product> products = null;
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			//FROM query
			String queryStr = "from Product";
			Query query = (org.hibernate.Query) session.createQuery(queryStr);
			
			products = (List<Product>)query.list();
	
			session.getTransaction().commit();
			session.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return products;
	}

	public Product findOne(String id) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Product product = null;
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			//Get group
			product = (Product) session.get(Product.class, id);
			session.getTransaction().commit();
			session.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return product;
	}

	public int create(Product product) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Product productExist = null;
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			//Get group
			productExist = (Product) session.get(Product.class, product.getProductID());
			if(productExist == null) {
				session.save(product);
				session.getTransaction().commit();
				session.close();
				
				return 1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public int update(Product product) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Product productExist = null;
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			//Get group
			productExist = (Product) session.get(Product.class, product.getProductID());
			if(productExist != null) {
				productExist.setProductID(product.getProductID());
				productExist.setName(product.getName());
				productExist.setUnit(product.getUnit());
				productExist.setProductDetail(product.getProductDetail());
				productExist.setProducts(product.getProducts());
				session.save(productExist);
				session.getTransaction().commit();
				session.close();
				
				return 1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public int deleteOne(String id) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Product productExist = null;
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			//Get group
			productExist = (Product) session.get(Product.class, id);
			if(productExist != null) {
				session.delete(productExist);
				session.getTransaction().commit();
				session.close();
				
				return 1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
}
