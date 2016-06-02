package skeleton.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.edu.agh.tai.recipeme.model.User;
import skeleton.dao.UserDao;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	public User get(Long id) {
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
	}

	public void delete(User user) {
		sessionFactory.getCurrentSession().delete(user);
	}

	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		return sessionFactory.getCurrentSession().createQuery(
				"FROM User ORDER BY id")
			.list();
	}

	public void save(User user) {
		User tmp = findByUserName(user.getName());
		System.out.println(tmp);
		if(tmp == null){
			sessionFactory.getCurrentSession().merge(user);
		} 
		
		
	}

	@Override
	public User findByUserName(String username) {
		return (User) sessionFactory.getCurrentSession().createQuery(
				"FROM User u WHERE u.name = :username ")
			.setString("username", username).uniqueResult();
	}
	
}
