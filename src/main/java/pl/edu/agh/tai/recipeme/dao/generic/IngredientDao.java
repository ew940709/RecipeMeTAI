package pl.edu.agh.tai.recipeme.dao.generic;

import java.util.List;

import pl.edu.agh.tai.recipeme.model.Ingredient;

public interface IngredientDao extends GenericDao<Ingredient>{
	
	List<Ingredient> getAll();
}
