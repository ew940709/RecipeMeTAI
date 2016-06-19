package pl.edu.agh.tai.recipeme.nowe.service;

import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.tai.recipeme.model.Recipe;

public interface RecipeService {

	@Transactional
	Recipe get(Long id);
	
	@Transactional
    Recipe create(Recipe recipe);
	
	@Transactional
	void delete(Recipe recipe);
	
	@Transactional
	Recipe update(Recipe recipe);
}
