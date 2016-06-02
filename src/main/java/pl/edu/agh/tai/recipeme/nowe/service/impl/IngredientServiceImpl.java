package pl.edu.agh.tai.recipeme.nowe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.tai.hmm.IngredientGrid;
import pl.edu.agh.tai.recipeme.dao.generic.IngredientDao;
import pl.edu.agh.tai.recipeme.model.Ingredient;
import pl.edu.agh.tai.recipeme.nowe.service.IngredientService;
import pl.edu.agh.tai.recipeme.web.UserGrid;

@Service("ingredientService")
public class IngredientServiceImpl implements IngredientService {

	@Autowired
	IngredientDao ingredientDao;

	@Override
	@Transactional
	public Ingredient get(Long id) {
		return ingredientDao.find(id);
	}

	@Override
	@Transactional
	public Ingredient create(Ingredient ingredient) {
		return ingredientDao.create(ingredient);
	}

	@Override
	@Transactional
	public void delete(Ingredient ingredient) {
		ingredientDao.delete(ingredient);

	}

	@Override
	@Transactional
	public Ingredient update(Ingredient ingredient) {
		return ingredientDao.update(ingredient);
	}

	@Override
	@Transactional
	public List<Ingredient> getAll() {
		return ingredientDao.getAll();
	}

	@Override
	@Transactional
	public void updateWithAll(IngredientGrid ingredientGrid) {
		IngredientGrid allCategories = findAll();
		allCategories.getCategoryMap().putAll(ingredientGrid.getCategoryMap());
		ingredientGrid.setCategoryMap(allCategories.getCategoryMap());
	}

	@Override
	@Transactional
	public IngredientGrid findAll() {
		IngredientGrid ig = new IngredientGrid(ingredientDao.getAll());
		return ig;
	}

}
