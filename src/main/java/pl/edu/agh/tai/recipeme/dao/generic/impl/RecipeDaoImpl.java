package pl.edu.agh.tai.recipeme.dao.generic.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import pl.edu.agh.tai.recipeme.dao.generic.RecipeDao;
import pl.edu.agh.tai.recipeme.model.Ingredient;
import pl.edu.agh.tai.recipeme.model.Recipe;
import pl.edu.agh.tai.recipeme.util.RatingForm;

@Component("recipeDao")
public class RecipeDaoImpl extends GenericDaoImpl<Recipe> implements RecipeDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Recipe> find(List<Ingredient> ingredients) {

		List<Recipe> resultList = new LinkedList<>();
		List<Long> ids = new LinkedList<>();
		for (Ingredient i: ingredients){
			ids.add(i.getId());
		}
		
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Recipe.class, "recipe")
				.createCriteria("ingredientList", "ingredients")
				.add(Restrictions.in("Id", ids));
		
		criteria.setMaxResults(10);
		
		resultList = criteria.list();
		
		Map<Recipe, Integer> map = new HashMap<>();
		for (Recipe recipe: resultList){
			if (!map.containsKey(recipe)){
				map.put(recipe, 0);
			}
			else{
				Integer count = map.get(recipe);
				count++;
				map.put(recipe, count);
			}
		}
		resultList.clear();
		resultList.addAll(map.keySet());
		
		return resultList;
	}
	
	@Override
	public Recipe updateRating(RatingForm ratingForm){
		Recipe recipe = this.find(ratingForm.getRecipeId());
		recipe.incrementVotesCount();
		Double newAverageRating = (recipe.getAverageRating() + new Double(ratingForm.getRating())) / new Double(recipe.getVotesCount());
		recipe.setAverageRating(newAverageRating);
		return this.update(recipe);
	}

}
