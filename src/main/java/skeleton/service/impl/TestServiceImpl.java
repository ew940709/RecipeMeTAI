package skeleton.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.tai.recipeme.model.Test;
import skeleton.dao.TestDao;
import skeleton.service.TestService;

@Service("testService") 
public class TestServiceImpl implements TestService{
	@Autowired TestDao userDao;

	@Transactional(readOnly=true)
	public Test get(Long id) {
		return userDao.get(id);
	}

	@Transactional
	public void save(Test test) {
		userDao.save(test);		
	}

	@Transactional
	public void delete(Test user) {
		userDao.delete(user);
		
	}

	@Transactional
	public List<Test> findAll() {
		return userDao.findAll();
	}

	@Transactional
	public void saveAll(List<Test> testList) {
		for(Test test : testList){
			userDao.save(test);
		}
		
	}

	
	

}
