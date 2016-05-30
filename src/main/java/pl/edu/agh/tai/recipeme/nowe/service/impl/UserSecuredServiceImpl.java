package pl.edu.agh.tai.recipeme.nowe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.edu.agh.tai.recipeme.dao.generic.UserSecuredDao;
import pl.edu.agh.tai.recipeme.model.UserSecured;
import pl.edu.agh.tai.recipeme.nowe.service.UserSecuredService;

@Service("userSecuredService")
public class UserSecuredServiceImpl implements UserSecuredService {

	@Autowired
	private UserSecuredDao userDao;

	@Override
	public UserSecured get(Long id) {
		UserSecured userSecured = userDao.find(id);
		return userSecured;
	}

	@Override
	public UserSecured create(UserSecured userSecured) {
		userDao.create(userSecured);
		return userSecured;
	}

	@Override
	public void delete(UserSecured userSecured) {
		userDao.delete(userSecured);
		
	}

	@Override
	public UserSecured update(UserSecured userSecured) {
		return userDao.update(userSecured);
	}

	
}