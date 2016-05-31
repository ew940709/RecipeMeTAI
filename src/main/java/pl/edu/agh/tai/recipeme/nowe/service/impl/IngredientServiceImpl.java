package pl.edu.agh.tai.recipeme.nowe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.tai.recipeme.dao.generic.IngredientDao;
import pl.edu.agh.tai.recipeme.model.Ingredient;
import pl.edu.agh.tai.recipeme.nowe.service.IngredientService;

@Service("ingredientService")
public class IngredientServiceImpl implements IngredientService {

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

	@Override
	@Transactional
	public List<Ingredient> getAll() {
		return ingredientDao.getAll();
	}

}
