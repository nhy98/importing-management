package com.group8.management.service;

import java.util.List;
import com.group8.management.entities.Site;

public interface SiteService {
	List<Site> findAll();
	
	Site findOne(String id);
	
	int create(Site site);
	
	int update(Site site);
	
	int deleteOne(String id);
}
