package skeleton.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.tai.recipeme.model.User;
import pl.edu.agh.tai.recipeme.web.UserCommand;
import pl.edu.agh.tai.recipeme.web.UserGrid;
import skeleton.dao.UserDao;
import skeleton.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired UserDao userDao;
	
	@Transactional(readOnly = true)
	public User get(Long id) {
		return userDao.get(id);
	}

	@Transactional
	public void delete(User user) {
		userDao.delete(user);
	}

	@Transactional(readOnly = true)
	public UserGrid findAll() {
		return new UserGrid(userDao.findAll());
	}

	@Transactional
	public void save(UserCommand userCommand) {
		userDao.save(userCommand.toUser());
	}

	@Transactional
	public void saveAll(UserGrid userGrid) {
		for (User user : userGrid.getUsers())
			userDao.save(user);
	}
	
	@Transactional(readOnly = true)
	public void updateWithAll(UserGrid userGrid) {
		UserGrid allUsers = findAll();
		allUsers.getUserMap().putAll(userGrid.getUserMap());
		userGrid.setUserMap(allUsers.getUserMap());
	}

	@Override
	public User getUserByUsername(String username) {
		return userDao.findByUserName(username);
	}
}
