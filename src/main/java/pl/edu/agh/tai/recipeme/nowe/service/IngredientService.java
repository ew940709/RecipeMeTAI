package pl.edu.agh.tai.recipeme.nowe.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.tai.hmm.IngredientGrid;
import pl.edu.agh.tai.recipeme.model.Ingredient;

public interface IngredientService {
	
	@Transactional
	Ingredient get(Long id);
	
	@Transactional
    Ingredient create(Ingredient ingredient);
	
	@Transactional
	void delete(Ingredient ingredient);
	
	@Transactional
	Ingredient update(Ingredient ingredient);
	
	@Transactional
	List<Ingredient> getAll();

	@Transactional
	void updateWithAll(IngredientGrid ingredientGrid);
	
	@Transactional
	IngredientGrid findAll();

}
