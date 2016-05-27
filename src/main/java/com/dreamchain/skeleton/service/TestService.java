package com.dreamchain.skeleton.service;

import java.util.List;

import com.dreamchain.skeleton.model.Test;

public interface TestService {
	Test get(Long id);
	
	void save(Test test);
	
	void delete(Test user);
	
	List<Test> findAll();
	
	void saveAll(List<Test> testList);

}
