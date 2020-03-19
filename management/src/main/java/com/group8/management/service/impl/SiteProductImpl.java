package com.group8.management.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.group8.management.HibernateUtils;
import com.group8.management.entities.SiteProduct;
import com.group8.management.service.SiteProductService;

public class SiteProductImpl implements SiteProductService {
	public List<SiteProduct> findAll() {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		List<SiteProduct> products = null;
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			//FROM query
			String queryStr = "from SiteProduct";
			Query query = (org.hibernate.Query) session.createQuery(queryStr);
			
			products = (List<SiteProduct>)query.list();
	
			session.getTransaction().commit();
			session.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return products;
	}
	
	public List<SiteProduct> findProductsById(String id) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		List<SiteProduct> products = null;
		try {
			Session session = sessionFactory.openSession();
			
			//FROM query
			String queryStr = "Select s from SiteProduct s where s.product.productID=:productid" ;
			Query query = (org.hibernate.Query) session.createQuery(queryStr);
			query.setParameter("productid", id);
			products = (List<SiteProduct>)query.list();
	
			session.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return products;
	}

	public SiteProduct findOne(int id) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		SiteProduct product = null;
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			//Get group
			product = (SiteProduct) session.get(SiteProduct.class, id);
			session.getTransaction().commit();
			session.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return product;
	}

	public int create(SiteProduct product) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		SiteProduct productExist = null;
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			//Get group
			productExist = (SiteProduct) session.get(SiteProduct.class, product.getId());
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

	public int update(SiteProduct product) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		SiteProduct productExist = null;
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			//Get group
			productExist = (SiteProduct) session.get(SiteProduct.class, product.getId());
			if(productExist != null) {
				productExist.setQuantity(product.getQuantity());
				productExist.setProduct(product.getProduct());
				productExist.setSite(product.getSite());
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
		SiteProduct productExist = null;
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			//Get group
			productExist = (SiteProduct) session.get(SiteProduct.class, id);
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
