package pl.edu.agh.tai.recipeme.dao.generic.impl;

import org.springframework.stereotype.Component;

import pl.edu.agh.tai.recipeme.dao.generic.RecipeDao;
import pl.edu.agh.tai.recipeme.model.Recipe;

@Component("recipeDao")
public class RecipeDaoImpl extends GenericDaoImpl<Recipe> implements RecipeDao{

}
