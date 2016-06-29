package pl.edu.agh.tai.recipeme.nowe.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.tai.recipeme.model.Ingredient;
import pl.edu.agh.tai.recipeme.model.Recipe;
import pl.edu.agh.tai.recipeme.util.RatingForm;

public interface RecipeService {

	@Transactional
	Recipe get(Long id);
	
	@Transactional
    Recipe create(Recipe recipe);
	
	@Transactional
	void delete(Recipe recipe);
	
	@Transactional
	Recipe update(Recipe recipe);
	
	@Transactional
	List<Recipe> find (List<Ingredient> ingredients);
	
	@Transactional
	Recipe updateRating(RatingForm ratingForm);
}
