package com.group8.management.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.group8.management.HibernateUtils;
import com.group8.management.entities.User;
import com.group8.management.entities.User;
import com.group8.management.service.UserService;

public class UserServiceImpl implements UserService{

	public List<User> findAll() {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		List<User> users = null;
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			//FROM query
			String queryStr = "from adm_user";
			Query query = (org.hibernate.Query) session.createQuery(queryStr);
			
			users = (List<User>)query.list();
	
			session.getTransaction().commit();
			session.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return users;
	}

	public User findOne(String id) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		User user = null;
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			//Get group
			user = (User) session.get(User.class, id);
			session.getTransaction().commit();
			session.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return user;
	}

	public int create(User user) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		User userExist = null;
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			//Get group
			userExist = (User) session.get(User.class, user.getId());
			if(userExist == null) {
				session.save(user);
				session.getTransaction().commit();
				session.close();
				
				return 1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public int update(User user) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		User userExist = null;
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			//Get group
			userExist = (User) session.get(User.class, user.getId());
			if(userExist != null) {
				session.save(user);
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
		User userExist = null;
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			//Get group
			userExist = (User) session.get(User.class, id);
			if(userExist != null) {
				session.delete(userExist);
				session.getTransaction().commit();
				session.close();
				
				return 1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public int login(String username, String password) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		User userExist = null;
		List<User> users = null;
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			//FROM query
			String queryStr = "from adm_user where username = :username";
			Query query = (org.hibernate.Query) session.createQuery(queryStr);
			query.setParameter("username",username);
			users = (List<User>)query.list();
			if(users != null) {
				userExist = users.get(0);
				if(password.equals(userExist.getPassword())) {
					session.getTransaction().commit();
					session.close();
					return 1;
				}
			}
			session.getTransaction().commit();
			session.close();
		}catch(Exception e) {
			e.printStackTrace();
		}	
		return 0;
	}

	public int checkRole(String userRole, String role) {
		if(userRole.equals(role)) return 1;
		return 0;
	}

}
