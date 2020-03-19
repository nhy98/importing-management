package com.group8.management.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jboss.jandex.Main;

import com.group8.management.HibernateUtils;
import com.group8.management.entities.SaleOrder;
import com.group8.management.service.SaleOrderService;


public class SaleOrderImpl implements SaleOrderService{
	public List<SaleOrder> findAll() {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		List<SaleOrder> orders = null;
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			//FROM query
			String queryStr = "from SaleOrder";
			Query query = (org.hibernate.Query) session.createQuery(queryStr);
			
			orders = (List<SaleOrder>)query.list();
	
			session.getTransaction().commit();
			session.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return orders;
	}

	public SaleOrder findOne(String id) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		SaleOrder order = null;
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			//Get group
			order = (SaleOrder) session.get(SaleOrder.class, id);
			session.getTransaction().commit();
			//session.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return order;
	}

	public int create(SaleOrder order) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		SaleOrder orderExist = null;
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			//Get group
			orderExist = (SaleOrder) session.get(SaleOrder.class, order.getOrderId());
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

	public int update(SaleOrder order) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		SaleOrder orderExist = null;
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			//Get group
			orderExist = (SaleOrder) session.get(SaleOrder.class, order.getOrderId());
			if(orderExist != null) {
				orderExist.setDesiredDate(order.getDesiredDate());
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

	public int deleteOne(String id) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		SaleOrder orderExist = null;
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			//Get group
			orderExist = (SaleOrder) session.get(SaleOrder.class, id);
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
