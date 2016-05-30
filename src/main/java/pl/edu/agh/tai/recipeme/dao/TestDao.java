package pl.edu.agh.tai.recipeme.dao;

import java.util.List;

import pl.edu.agh.tai.recipeme.model.Test;

public interface TestDao {
	Test get(Long id);
	void save(Test user);
	void delete(Test user);
	List<Test> findAll();

}
