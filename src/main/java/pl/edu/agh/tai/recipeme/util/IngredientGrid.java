package pl.edu.agh.tai.recipeme.util;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import pl.edu.agh.tai.recipeme.model.Ingredient;

public class IngredientGrid {
	
	@Valid
	private Map<String, IngredientList> categoryMap;
	
	public IngredientGrid(){
		categoryMap = new LinkedHashMap<>();
	}
	
	public IngredientGrid(List<Ingredient> ingredients){
		this();
		setIngredients(ingredients);
	}

	public Map<String, IngredientList> getCategoryMap() {
		return categoryMap;
	}

	public void setCategoryMap(Map<String, IngredientList> categoryMap) {
		this.categoryMap.putAll(categoryMap);
	}

	public Map<String, IngredientList> getIngredientGrid() {
		return getCategoryMap();
	}

	public void setIngredientGrid(List<Ingredient> ingredients) {
		this.setIngredients(ingredients);
	}

	public List<Ingredient> getIngredients(){
		List<Ingredient> ingredients = new ArrayList<Ingredient>();
		
		for(Map.Entry<String, IngredientList> entry: categoryMap.entrySet()){

			for (IngredientSelection is: entry.getValue().getIngList()){
				ingredients.add(is.toIngredient());

			}
		}
		return ingredients;
	}
	
	public void setIngredients(List<Ingredient> ingredients){
		IngredientList iList;
		for (Ingredient ingredient: ingredients){
			if (categoryMap.containsKey(ingredient.getCategory().getName())){
				iList = categoryMap.get(ingredient.getCategory().getName());
				
			}else{
				iList = new IngredientList();
				categoryMap.put(ingredient.getCategory().getName(), iList);
			}
			
			iList.getIngList().add(new IngredientSelection(ingredient));
		}
	}
	


}
