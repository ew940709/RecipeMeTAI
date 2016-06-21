package pl.edu.agh.tai.recipeme.dao.generic;

import java.util.List;

import pl.edu.agh.tai.recipeme.model.Ingredient;
import pl.edu.agh.tai.recipeme.model.Recipe;

public interface RecipeDao extends GenericDao<Recipe>{

	List<Recipe> find(List<Ingredient> ingredients);
}
