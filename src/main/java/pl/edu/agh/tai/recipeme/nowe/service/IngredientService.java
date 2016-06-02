package pl.edu.agh.tai.recipeme.nowe.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.tai.hmm.IngredientGrid;
import pl.edu.agh.tai.recipeme.model.Ingredient;

public interface IngredientService {
	
	Ingredient get(Long id);
	
	@Transactional
    Ingredient create(Ingredient ingredient);
	
	void delete(Ingredient ingredient);
	
	Ingredient update(Ingredient ingredient);
	
	List<Ingredient> getAll();

	void updateWithAll(IngredientGrid ingredientGrid);
	
	IngredientGrid findAll();

}
