package pl.edu.agh.tai.recipeme.nowe.service;

import org.springframework.transaction.annotation.Transactional;

public interface CategoryService {
	
	@Transactional
    void createCategory();
}
