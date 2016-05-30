package pl.edu.agh.tai.recipeme.nowe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.edu.agh.tai.recipeme.dao.generic.IngredientDao;
import pl.edu.agh.tai.recipeme.model.Ingredient;
import pl.edu.agh.tai.recipeme.nowe.service.IngedientService;

@Service("ingredientService")
public class IngredientServiceImpl implements IngedientService {

	@Autowired
	IngredientDao ingredientDao;
	@Override
	public Ingredient get(Long id) {
		return ingredientDao.find(id);
	}

	@Override
	public Ingredient create(Ingredient ingredient) {
		return ingredientDao.create(ingredient);
	}

	@Override
	public void delete(Ingredient ingredient) {
		ingredientDao.delete(ingredient);
		
	}

	@Override
	public Ingredient update(Ingredient ingredient) {
		return ingredientDao.update(ingredient);
	}

}
