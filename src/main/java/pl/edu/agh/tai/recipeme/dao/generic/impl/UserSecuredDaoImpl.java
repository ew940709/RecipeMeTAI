package pl.edu.agh.tai.recipeme.dao.generic.impl;

import org.springframework.stereotype.Component;

import pl.edu.agh.tai.recipeme.dao.generic.UserSecuredDao;
import pl.edu.agh.tai.recipeme.model.UserSecured;

@Component("userDao")
public class UserSecuredDaoImpl extends GenericDaoImpl<UserSecured> implements UserSecuredDao {

}