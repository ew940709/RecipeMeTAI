package pl.edu.agh.tai.recipeme.nowe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.edu.agh.tai.recipeme.dao.generic.RecipeDao;
import pl.edu.agh.tai.recipeme.model.Ingredient;
import pl.edu.agh.tai.recipeme.model.Recipe;
import pl.edu.agh.tai.recipeme.nowe.service.RecipeService;
import pl.edu.agh.tai.recipeme.util.RatingForm;

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
	
	@Override
	public List<Recipe> find(List<Ingredient> ingredients){
		return recipeDao.find(ingredients);
	}

	@Override
	public Recipe updateRating(RatingForm ratingForm) {
		return recipeDao.updateRating(ratingForm);
	}

}
