package pl.edu.agh.tai.recipeme.service;

import pl.edu.agh.tai.recipeme.model.User;
import pl.edu.agh.tai.recipeme.web.UserCommand;
import pl.edu.agh.tai.recipeme.web.UserGrid;

public interface UserService {
	
	User get(Long id);
	
	void save(UserCommand userCommand);
	
	void delete(User user);
	
	UserGrid findAll();
	
	void saveAll(UserGrid userGrid);

	void updateWithAll(UserGrid userGrid);
	
}
