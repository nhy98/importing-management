package com.group8.management.service;

import java.util.List;

import com.group8.management.entities.SiteProduct;

public interface SiteProductService {
	List<SiteProduct> findAll();
	
	SiteProduct findOne(int id);
	
	List<SiteProduct> findProductsById(String id);
	
	int create(SiteProduct product);
	
	int update(SiteProduct product);
	
	int deleteOne(int id);
}
