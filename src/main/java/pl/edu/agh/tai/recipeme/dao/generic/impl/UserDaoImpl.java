package pl.edu.agh.tai.recipeme.dao.generic.impl;

import org.springframework.stereotype.Component;

import pl.edu.agh.tai.recipeme.dao.generic.UserDao;
import pl.edu.agh.tai.recipeme.model.UserSecured;

@Component("userDao")
public class UserDaoImpl extends GenericDaoImpl<UserSecured> implements UserDao {

}