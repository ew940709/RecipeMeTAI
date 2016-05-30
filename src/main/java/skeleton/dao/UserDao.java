package skeleton.dao;

import java.util.List;

import pl.edu.agh.tai.recipeme.model.User;

public interface UserDao {

	User get(Long id);
	void save(User user);
	void delete(User user);
	List<User> findAll();
	User findByUserName(String username);

}
