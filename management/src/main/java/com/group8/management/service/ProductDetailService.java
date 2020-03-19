package com.group8.management.service;

import java.util.List;

import com.group8.management.entities.ProductDetail;

public interface ProductDetailService {
	List<ProductDetail> findAll();
	
	ProductDetail findOne(int id);
	
	int create(ProductDetail product);
	
	int update(ProductDetail product);
	
	int deleteOne(int id);
}
