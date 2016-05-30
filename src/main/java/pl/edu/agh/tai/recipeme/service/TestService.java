package pl.edu.agh.tai.recipeme.service;

import java.util.List;

import pl.edu.agh.tai.recipeme.model.Test;

public interface TestService {
	Test get(Long id);
	
	void save(Test test);
	
	void delete(Test user);
	
	List<Test> findAll();
	
	void saveAll(List<Test> testList);

}
