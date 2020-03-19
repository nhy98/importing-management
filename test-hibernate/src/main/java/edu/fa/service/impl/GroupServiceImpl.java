package edu.fa.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import edu.fa.ConnectionUtil;
import edu.fa.model.Group;
import edu.fa.service.GroupService;

public class GroupServiceImpl implements GroupService{

	public List<Group> findAll() {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = ConnectionUtil.getSessionFactory();
		List<Group> groups = null;
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			//FROM query
			String queryStr = "from Group";
			Query query = (org.hibernate.Query) session.createQuery(queryStr);
			
			groups = (List<Group>)query.list();
	
			session.getTransaction().commit();
			session.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return groups;
	}

	public Group findOne(int id) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = ConnectionUtil.getSessionFactory();
		Group group = null;
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			//Get group
			group = (Group) session.get(Group.class, id);
			session.getTransaction().commit();
			session.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return group;
	}

	public int create(Group group) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = ConnectionUtil.getSessionFactory();
		Group groupExist = null;
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			//Get group
			groupExist = (Group) session.get(Group.class, group.getId());
			if(groupExist == null) {
				session.save(group);
				session.getTransaction().commit();
				session.close();
				
				return 1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public int update(Group group) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = ConnectionUtil.getSessionFactory();
		Group groupExist = null;
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			//Get group
			groupExist = (Group) session.get(Group.class, group.getId());
			if(groupExist != null) {
				groupExist.setName(group.getName());
				session.save(groupExist);
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
		SessionFactory sessionFactory = ConnectionUtil.getSessionFactory();
		Group groupExist = null;
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			//Get group
			groupExist = (Group) session.get(Group.class, id);
			if(groupExist != null) {
				session.delete(groupExist);
				session.getTransaction().commit();
				session.close();
				
				return 1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public int deleteAllBatch(int[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

}
