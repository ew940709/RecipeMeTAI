package pl.edu.agh.tai.recipeme.dao.generic.impl;

import org.springframework.stereotype.Component;

import pl.edu.agh.tai.recipeme.dao.generic.UserRoleDao;
import pl.edu.agh.tai.recipeme.model.UserRole;

@Component("userRoleDao")
public class UserRoleDaoImpl extends GenericDaoImpl<UserRole> implements UserRoleDao{

}
