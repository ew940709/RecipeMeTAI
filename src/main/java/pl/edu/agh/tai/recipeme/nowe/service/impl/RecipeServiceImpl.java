package pl.edu.agh.tai.recipeme.nowe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.edu.agh.tai.recipeme.dao.generic.RecipeDao;
import pl.edu.agh.tai.recipeme.model.Recipe;
import pl.edu.agh.tai.recipeme.nowe.service.RecipeService;

@Service("recipeService")
public class RecipeServiceImpl implements RecipeService {

	@Autowired
	RecipeDao recipeDao;
	
	@Override
	public Recipe get(Long id) {
		return recipeDao.find(id);
	}

	@Override
	public Recipe create(Recipe recipe) {
		return recipeDao.create(recipe);
	}

	@Override
	public void delete(Recipe recipe) {
		recipeDao.delete(recipe);
		
	}

	@Override
	public Recipe update(Recipe recipe) {
		return recipeDao.update(recipe);
	}

}
