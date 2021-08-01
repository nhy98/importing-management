package com.group8.management.service;

import java.util.List;

import com.group8.management.entities.ImportOrder;
import com.group8.management.entities.ProductDetail;

public interface ImportOrderService {
	List<ImportOrder> findAll();
	
	ImportOrder findOne(int id);
	
	List<ImportOrder> findByOrder(String orderId, String productId);
	
	int create(ImportOrder order);
	
	int update(ImportOrder order);
	
	int deleteOne(int id);
}
