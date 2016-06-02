package pl.edu.agh.tai.recipeme.nowe.service;

import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.tai.recipeme.model.Category;

public interface CategoryService {
	
	Category get(Long id);
	
	@Transactional
    Category create(Category category);
	
	void delete(Category category);
	
	Category update(Category category);
}
