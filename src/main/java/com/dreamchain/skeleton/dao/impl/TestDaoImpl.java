package com.dreamchain.skeleton.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dreamchain.skeleton.dao.TestDao;
import com.dreamchain.skeleton.model.Test;

@Repository
public class TestDaoImpl implements TestDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Test get(Long id) {
		// TODO Auto-generated method stub
		return (Test) sessionFactory.getCurrentSession().get(Test.class, id);
	}

	
	public void save(Test test) {
		sessionFactory.getCurrentSession().merge(test);
		
	}

	public void delete(Test test) {
		sessionFactory.getCurrentSession().delete(test);
	}

	public List<Test> findAll() {
		return sessionFactory.getCurrentSession().createQuery(
				"FROM User ORDER BY id")
			.list();
	}


}
