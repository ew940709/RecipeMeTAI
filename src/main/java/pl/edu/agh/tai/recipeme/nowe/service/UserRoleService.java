package pl.edu.agh.tai.recipeme.nowe.service;

import pl.edu.agh.tai.recipeme.model.UserRole;

public interface UserRoleService {

	UserRole get(Long id);

	UserRole create(UserRole userRole);

	void delete(UserRole userRole);

	UserRole update(UserRole userRole);
}
