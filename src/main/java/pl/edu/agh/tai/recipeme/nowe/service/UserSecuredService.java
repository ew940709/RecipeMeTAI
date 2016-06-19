package pl.edu.agh.tai.recipeme.nowe.service;

import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.tai.recipeme.model.UserSecured;

public interface UserSecuredService {

	@Transactional
	UserSecured get(Long id);
	
	@Transactional
	UserSecured create(UserSecured userSecured);
	
	@Transactional
	void delete(UserSecured userSecured);
	
	@Transactional
	UserSecured update(UserSecured userSecured);
}
