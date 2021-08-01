package com.group8.management.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.group8.management.HibernateUtils;
import com.group8.management.entities.ImportOrder;
import com.group8.management.service.ImportOrderService;

public class ImportOrderImpl implements ImportOrderService{
	public List<ImportOrder> findAll() {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		List<ImportOrder> orders = null;
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			//FROM query
			String queryStr = "from ImportOrder";
			Query query = (org.hibernate.Query) session.createQuery(queryStr);
			
			orders = (List<ImportOrder>)query.list();
	
			session.getTransaction().commit();
			session.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return orders;
	}
	
	public List<ImportOrder> findByOrder(String orderId, String productId) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		List<ImportOrder> orders = null;
		try {
			Session session = sessionFactory.openSession();
			
			//FROM query
			if(productId==null) {
				String queryStr = "select i from ImportOrder i where i.order.orderId=:orderId ";
				Query query = (org.hibernate.Query) session.createQuery(queryStr);
				query.setParameter("orderId", orderId);
				orders = (List<ImportOrder>)query.list();
			}
			else {
				String queryStr = "select i from ImportOrder i where i.order.orderId=:orderId and i.product.productID=:productId";
				Query query = (org.hibernate.Query) session.createQuery(queryStr);
				query.setParameter("orderId", orderId);
				query.setParameter("productId", productId);
				orders = (List<ImportOrder>)query.list();
			}
	
			session.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return orders;
	}

	public ImportOrder findOne(int id) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		ImportOrder order = null;
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			//Get group
			order = (ImportOrder) session.get(ImportOrder.class, id);
			session.getTransaction().commit();
			session.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return order;
	}

	public int create(ImportOrder order) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		ImportOrder orderExist = null;
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			//Get group
			orderExist = (ImportOrder) session.get(ImportOrder.class, order.getId());
			if(orderExist == null) {
				session.save(order);
				session.getTransaction().commit();
				session.close();
				
				return 1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public int update(ImportOrder order) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		ImportOrder orderExist = null;
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			//Get group
			orderExist = (ImportOrder) session.get(ImportOrder.class, order.getId());
			if(orderExist != null) {
				orderExist.setStatus(order.getStatus());
				session.save(orderExist);
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
		ImportOrder orderExist = null;
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			//Get group
			orderExist = (ImportOrder) session.get(ImportOrder.class, id);
			if(orderExist != null) {
				session.delete(orderExist);
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
