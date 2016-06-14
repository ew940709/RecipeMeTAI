package pl.edu.agh.tai.hmm;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import pl.edu.agh.tai.recipeme.model.Category;
import pl.edu.agh.tai.recipeme.model.Ingredient;

public class IngredientGrid {
	
	@Valid
	private Map<Category, List<IngredientSelection>> categoryMap;
	
	public IngredientGrid(){
		categoryMap = new LinkedHashMap<>();
	}
	
	public IngredientGrid(List<Ingredient> ingredients){
		this();
		setIngredients(ingredients);
	}

	public Map<Category, List<IngredientSelection>> getCategoryMap() {
		return categoryMap;
	}

	public void setCategoryMap(Map<Category, List<IngredientSelection>> categoryMap) {
		this.categoryMap = categoryMap;
	}
	
	public List<Ingredient> getIngredients(){
		List<Ingredient> ingredients = new ArrayList<Ingredient>();
		
		for(Map.Entry<Category, List<IngredientSelection>> entry: categoryMap.entrySet()){

			for (IngredientSelection is: entry.getValue()){
				ingredients.add(is.toIngredient());

			}
		}
		return ingredients;
	}
	
	public void setIngredients(List<Ingredient> ingredients){
		List<IngredientSelection> iList = null;
		for (Ingredient ingredient: ingredients){
			IngredientSelection is = new IngredientSelection(ingredient);
			
			iList = null;
			if (categoryMap.containsKey(ingredient.getCategory())){
				iList = categoryMap.get(ingredient.getCategory());
			}else{
				iList = new ArrayList<IngredientSelection>();
				categoryMap.put(ingredient.getCategory(), iList);
			}
			iList.add(is);
		}
	}
	


}
