package pl.edu.agh.tai.recipeme.nowe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.edu.agh.tai.recipeme.dao.generic.UserSecuredDao;
import pl.edu.agh.tai.recipeme.model.UserSecured;
import pl.edu.agh.tai.recipeme.nowe.service.UserSecuredService;

@Service("userService")
public class UserSecuredServiceImpl implements UserSecuredService {

	@Autowired
	private UserSecuredDao userDao;

	@Override
	public void createUser(String uname, String upwd, boolean isEnabled) {
		UserSecured u = new UserSecured(uname, upwd, isEnabled);

		userDao.create(u);
	}
}