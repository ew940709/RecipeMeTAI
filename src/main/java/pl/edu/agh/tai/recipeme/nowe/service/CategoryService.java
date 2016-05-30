package pl.edu.agh.tai.recipeme.nowe.service;

import pl.edu.agh.tai.recipeme.model.Category;

public interface CategoryService {
	
	Category get(Long id);
	
    Category create(Category category);
	
	void delete(Category category);
	
	Category update(Category category);
}
