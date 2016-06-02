package pl.edu.agh.tai.hmm;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import pl.edu.agh.tai.recipeme.model.Category;
import pl.edu.agh.tai.recipeme.model.Ingredient;

public class IngredientGrid {
	
	@Valid
	private Map<Category, Set<IngredientSelection>> categoryMap;
	
	public IngredientGrid(){
	}
	
	public IngredientGrid(List<Ingredient> ingredients){
		categoryMap = new LinkedHashMap<>();
		for (Ingredient ingredient: ingredients){
			IngredientSelection is = new IngredientSelection(ingredient);
			
			if (categoryMap.containsKey(ingredient.getCategory())){
				Set<IngredientSelection> iSet = categoryMap.get(ingredient.getCategory());
				
				iSet.add(is);
				
			}else{
				categoryMap.put(ingredient.getCategory(), new HashSet<IngredientSelection>());
			}
		}
	}

	public Map<Category, Set<IngredientSelection>> getCategoryMap() {
		return categoryMap;
	}

	public void setCategoryMap(Map<Category, Set<IngredientSelection>> categoryMap) {
		this.categoryMap = categoryMap;
	}
	
	public Set<Ingredient> getIngredients(){
		Set<Ingredient> ingredients = new HashSet<Ingredient>();
		
		for(Map.Entry<Category, Set<IngredientSelection>> entry: categoryMap.entrySet()){

			for (IngredientSelection is: entry.getValue()){
				ingredients.add(is.toIngredient());
			}
		}
		return ingredients;
	}

}
