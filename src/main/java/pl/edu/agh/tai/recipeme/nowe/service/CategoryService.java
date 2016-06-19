package pl.edu.agh.tai.recipeme.nowe.service;

import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.tai.recipeme.model.Category;

public interface CategoryService {

	@Transactional
	Category get(Long id);
	
	@Transactional
    Category create(Category category);
	
	@Transactional
	void delete(Category category);
	
	@Transactional
	Category update(Category category);
}
