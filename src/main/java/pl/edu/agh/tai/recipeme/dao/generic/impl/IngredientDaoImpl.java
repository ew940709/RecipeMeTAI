package pl.edu.agh.tai.recipeme.dao.generic.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Component;

import pl.edu.agh.tai.recipeme.dao.generic.IngredientDao;
import pl.edu.agh.tai.recipeme.model.Ingredient;

@Component("ingredientDao")
public class IngredientDaoImpl extends GenericDaoImpl<Ingredient> implements IngredientDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Ingredient> getAll() {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Ingredient.class);
		return criteria.list();
	}
}
