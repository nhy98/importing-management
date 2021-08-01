package com.group8.management.service;

import java.util.List;

import com.group8.management.entities.Product;

public interface ProductService {
	List<Product> findAll();
	
	Product findOne(String id);
	
	int create(Product product);
	
	int update(Product product);
	
	int deleteOne(String id);
}
