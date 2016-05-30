package pl.edu.agh.tai.recipeme.nowe.service;

import org.springframework.transaction.annotation.Transactional;

public interface UserService {

	@Transactional
    void createUser(String uname, String upwd);
}
