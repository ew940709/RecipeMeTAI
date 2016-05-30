package pl.edu.agh.tai.recipeme.nowe.service;

import pl.edu.agh.tai.recipeme.model.Recipe;

public interface RecipeService {

	Recipe get(Long id);
	
    Recipe create(Recipe recipe);
	
	void delete(Recipe recipe);
	
	Recipe update(Recipe recipe);
}
