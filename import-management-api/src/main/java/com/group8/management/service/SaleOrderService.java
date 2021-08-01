package com.group8.management.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.group8.management.HibernateUtils;
import com.group8.management.entities.SaleOrder;

public interface SaleOrderService {
	List<SaleOrder> findAll();
	
	SaleOrder findOne(String id);
	
	int create(SaleOrder order);
	
	int update(SaleOrder order);
	
	int deleteOne(String id);
		    
}
