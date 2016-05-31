package pl.edu.agh.tai.recipeme.nowe.service;

import java.util.List;

import pl.edu.agh.tai.recipeme.model.Ingredient;

public interface IngredientService {
	
	Ingredient get(Long id);
	
    Ingredient create(Ingredient ingredient);
	
	void delete(Ingredient ingredient);
	
	Ingredient update(Ingredient ingredient);
	
	List<Ingredient> getAll();

}
