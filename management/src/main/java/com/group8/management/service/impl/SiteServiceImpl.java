package com.group8.management.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.group8.management.HibernateUtils;
import com.group8.management.entities.Site;
import com.group8.management.service.SiteService;

public class SiteServiceImpl implements SiteService{
	public List<Site> findAll() {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		List<Site> sites = null;
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			//FROM query
			String queryStr = "from Sites";
			Query query = (org.hibernate.Query) session.createQuery(queryStr);
			
			sites = (List<Site>)query.list();
	
			session.getTransaction().commit();
			session.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return sites;
	}

	public Site findOne(String id) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Site site = null;
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			//Get group
			site = (Site) session.get(Site.class, id);
			session.getTransaction().commit();
			session.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return site;
	}

	public int create(Site site) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Site siteExist = null;
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			//Get group
			siteExist = (Site) session.get(Site.class, site.getSiteID());
			if(siteExist == null) {
				session.save(site);
				session.getTransaction().commit();
				session.close();
				
				return 1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public int update(Site site) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Site siteExist = null;
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			//Get group
			siteExist = (Site) session.get(Site.class, site.getSiteID());
			if(siteExist != null) {
				siteExist.setSiteID(site.getSiteID());
				siteExist.setSiteName(site.getSiteName());
				session.save(siteExist);
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
		Site siteExist = null;
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			//Get group
			siteExist = (Site) session.get(Site.class, id);
			if(siteExist != null) {
				session.delete(siteExist);
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
