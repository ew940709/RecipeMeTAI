package pl.edu.agh.tai.recipeme.nowe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.edu.agh.tai.recipeme.dao.generic.UserDao;
import pl.edu.agh.tai.recipeme.model.User;
import pl.edu.agh.tai.recipeme.nowe.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;

	@Override
	public void createUser(String uname, String upwd) {
		User u = new User();
		u.setName(uname);
		u.setPassword(upwd);
		dao.create(u);
	}
}