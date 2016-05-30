package pl.edu.agh.tai.recipeme.nowe.service;

import pl.edu.agh.tai.recipeme.model.Ingredient;

public interface IngedientService {
	
	Ingredient get(Long id);
	
    Ingredient create(Ingredient ingredient);
	
	void delete(Ingredient ingredient);
	
	Ingredient update(Ingredient ingredient);
}
