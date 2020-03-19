package edu.fa.service;

import java.util.List;

import edu.fa.model.Group;

public interface GroupService {
	List<Group> findAll();
	
	Group findOne(int id);
	
	int create(Group group);
	
	int update(Group group);
	
	int deleteOne(int id);
	
	int deleteAllBatch(int[] ids);
}
