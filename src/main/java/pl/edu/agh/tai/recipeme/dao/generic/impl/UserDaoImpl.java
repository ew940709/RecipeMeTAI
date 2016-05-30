package pl.edu.agh.tai.recipeme.dao.generic.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;

import pl.edu.agh.tai.recipeme.dao.generic.UserDao;
import pl.edu.agh.tai.recipeme.model.User;

@Component("userDao")
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

}