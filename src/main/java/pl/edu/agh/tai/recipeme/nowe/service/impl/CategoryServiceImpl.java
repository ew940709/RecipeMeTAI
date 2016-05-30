package pl.edu.agh.tai.recipeme.nowe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.edu.agh.tai.recipeme.dao.generic.CategoryDao;
import pl.edu.agh.tai.recipeme.model.Category;
import pl.edu.agh.tai.recipeme.nowe.service.CategoryService;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService{

	@Autowired CategoryDao categoryDao;
	
	@Override
	public Category get(Long id) {
		Category category = categoryDao.find(id);
		return category;
	}

	@Override
	public Category createCategory(String name) {
		Category cat = new Category(name);
		categoryDao.create(cat);
		return cat;
	}


	@Override
	public void delete(Category category) {
		categoryDao.delete(category);
		
	}

	@Override
	public Category update(Category category) {
		return categoryDao.update(category);
	}


}
