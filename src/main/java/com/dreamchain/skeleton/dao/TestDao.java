package com.dreamchain.skeleton.dao;

import java.util.List;

import com.dreamchain.skeleton.model.Test;

public interface TestDao {
	Test get(Long id);
	void save(Test user);
	void delete(Test user);
	List<Test> findAll();

}
