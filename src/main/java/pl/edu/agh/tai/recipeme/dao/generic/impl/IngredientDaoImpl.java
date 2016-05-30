package pl.edu.agh.tai.recipeme.dao.generic.impl;

import org.springframework.stereotype.Component;

import pl.edu.agh.tai.recipeme.dao.generic.IngredientDao;
import pl.edu.agh.tai.recipeme.model.Ingredient;

@Component("ingredientDao")
public class IngredientDaoImpl extends GenericDaoImpl<Ingredient> implements IngredientDao{

}
