package pl.edu.agh.tai.recipeme.nowe.service;

import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.tai.recipeme.model.UserRole;

public interface UserRoleService {

	@Transactional
	UserRole get(Long id);

	@Transactional
	UserRole create(UserRole userRole);

	@Transactional
	void delete(UserRole userRole);

	@Transactional
	UserRole update(UserRole userRole);
}
