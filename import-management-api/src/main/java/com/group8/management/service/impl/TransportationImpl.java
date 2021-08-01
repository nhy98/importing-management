package com.group8.management.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.group8.management.HibernateUtils;
import com.group8.management.entities.Transportation;
import com.group8.management.service.TransportationService;

public class TransportationImpl implements TransportationService {
	public List<Transportation> findAll() {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		List<Transportation> transports = null;
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			//FROM query
			String queryStr = "from Transportation";
			Query query = (org.hibernate.Query) session.createQuery(queryStr);
			
			transports = (List<Transportation>)query.list();
	
			session.getTransaction().commit();
			session.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return transports;
	}

	public List<Transportation> findBySiteId(String siteId) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		List<Transportation> transports = null;
		try {
			Session session = sessionFactory.openSession();
			
			//FROM query
			String queryStr = "select t from Transportation t where t.Site.siteID=:siteId";
			Query query = (org.hibernate.Query) session.createQuery(queryStr);
			query.setParameter("siteId", siteId);
			transports = (List<Transportation>)query.list();
	
			session.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return transports;
	}
	
	public Transportation findOne(String id) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Transportation transport = null;
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			//Get group
			transport = (Transportation) session.get(Transportation.class, id);
			session.getTransaction().commit();
			session.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return transport;
	}

	public int create(Transportation transport) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Transportation transportExist = null;
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			//Get group
			transportExist = (Transportation) session.get(Transportation.class, transport.getMeansID());
			if(transportExist == null) {
				session.save(transport);
				session.getTransaction().commit();
				session.close();
				
				return 1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public int update(Transportation transport) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Transportation transportExist = null;
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();   
			//Get group
			transportExist = (Transportation) session.get(Transportation.class, transport.getMeansID());
			if(transportExist != null) {
				session.save(transport);
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
		Transportation transportExist = null;
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			//Get group
			transportExist = (Transportation) session.get(Transportation.class, id);
			if(transportExist != null) {
				session.delete(transportExist);
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
