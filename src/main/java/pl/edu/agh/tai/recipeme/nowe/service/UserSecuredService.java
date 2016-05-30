package pl.edu.agh.tai.recipeme.nowe.service;

import pl.edu.agh.tai.recipeme.model.UserSecured;

public interface UserSecuredService {
	
	UserSecured get(Long id);
	
	UserSecured create(UserSecured userSecured);
	
	void delete(UserSecured userSecured);
	
	UserSecured update(UserSecured userSecured);
}
