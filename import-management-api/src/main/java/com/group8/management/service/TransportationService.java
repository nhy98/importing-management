package com.group8.management.service;

import java.util.List;

import com.group8.management.entities.Transportation;

public interface TransportationService {
	List<Transportation> findAll();
	
	Transportation findOne(String id);
	
	List<Transportation> findBySiteId(String siteId);
	
	int create(Transportation transport);
	
	int update(Transportation transport);
	
	int deleteOne(String id);
}
