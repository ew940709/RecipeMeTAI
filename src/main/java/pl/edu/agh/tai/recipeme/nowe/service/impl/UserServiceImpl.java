package pl.edu.agh.tai.recipeme.nowe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.edu.agh.tai.recipeme.dao.generic.UserDao;
import pl.edu.agh.tai.recipeme.model.UserSecured;
import pl.edu.agh.tai.recipeme.nowe.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public void createUser(String uname, String upwd, boolean isEnabled) {
		UserSecured u = new UserSecured(uname, upwd, isEnabled);

		userDao.create(u);
	}
}