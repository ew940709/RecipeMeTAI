package skeleton.service;

import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.tai.recipeme.model.User;
import pl.edu.agh.tai.recipeme.web.UserCommand;
import pl.edu.agh.tai.recipeme.web.UserGrid;

public interface UserService {
	
	@Transactional
	User get(Long id);

	@Transactional
	void save(UserCommand userCommand);
	
	@Transactional
	void delete(User user);
	
	@Transactional
	UserGrid findAll();
	
	@Transactional
	void saveAll(UserGrid userGrid);

	@Transactional
	void updateWithAll(UserGrid userGrid);
	
	@Transactional
	User getUserByUsername(String username);
	
}
