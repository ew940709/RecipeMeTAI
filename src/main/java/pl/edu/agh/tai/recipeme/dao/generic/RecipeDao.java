package pl.edu.agh.tai.recipeme.dao.generic;

import java.util.List;

import pl.edu.agh.tai.recipeme.model.Ingredient;
import pl.edu.agh.tai.recipeme.model.Recipe;
import pl.edu.agh.tai.recipeme.util.RatingForm;

public interface RecipeDao extends GenericDao<Recipe>{

	List<Recipe> find(List<Ingredient> ingredients);
	
	Recipe updateRating(RatingForm ratingForm);
}
