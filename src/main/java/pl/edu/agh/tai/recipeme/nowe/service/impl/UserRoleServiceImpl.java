package pl.edu.agh.tai.recipeme.nowe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.edu.agh.tai.recipeme.dao.generic.UserRoleDao;
import pl.edu.agh.tai.recipeme.model.UserRole;
import pl.edu.agh.tai.recipeme.nowe.service.UserRoleService;

@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	UserRoleDao userRoleDao;
	
	@Override
	public UserRole get(Long id) {
		UserRole userRole = userRoleDao.find(id);
		return userRole;
	}

	@Override
	public UserRole create(UserRole userRole) {
		userRoleDao.create(userRole);
		return userRole;
	}

	@Override
	public void delete(UserRole userRole) {
		userRoleDao.delete(userRole);
		
	}

	@Override
	public UserRole update(UserRole userRole) {
		return userRoleDao.update(userRole);
	}

}
