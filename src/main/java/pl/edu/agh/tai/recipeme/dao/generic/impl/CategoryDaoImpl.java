package pl.edu.agh.tai.recipeme.dao.generic.impl;

import org.springframework.stereotype.Component;

import pl.edu.agh.tai.recipeme.dao.generic.CategoryDao;
import pl.edu.agh.tai.recipeme.model.Category;

@Component("categoryDao")
public class CategoryDaoImpl extends GenericDaoImpl<Category> implements CategoryDao {
	
}
