package com.group8.management.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.group8.management.HibernateUtils;
import com.group8.management.entities.Product;
import com.group8.management.entities.ProductDetail;
import com.group8.management.service.ProductDetailService;

public class ProductDetailImpl implements ProductDetailService {
	public List<ProductDetail> findAll() {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		List<ProductDetail> products = null;
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			//FROM query
			String queryStr = "from ProductDetail";
			Query query = (org.hibernate.Query) session.createQuery(queryStr);
			
			products = (List<ProductDetail>)query.list();
	
			session.getTransaction().commit();
			session.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return products;
	}

	public ProductDetail findOne(int id) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		ProductDetail product = null;
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			//Get group
			product = (ProductDetail) session.get(ProductDetail.class, id);
			session.getTransaction().commit();
			session.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return product;
	}

	public int create(ProductDetail product) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		ProductDetail productExist = null;
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			//Get group
			productExist = (ProductDetail) session.get(ProductDetail.class, product.getId());
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

	public int update(ProductDetail product) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		ProductDetail productExist = null;
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			//Get group
			productExist = (ProductDetail) session.get(ProductDetail.class, product.getId());
			if(productExist != null) {
				productExist.setQuantiy(product.getQuantiy());
				productExist.setProduct(product.getProduct());
				productExist.setProcessQuantity(product.getProcessQuantity());
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

	public int deleteOne(int id) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		ProductDetail productExist = null;
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			//Get group
			productExist = (ProductDetail) session.get(ProductDetail.class, id);
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
