package pl.edu.agh.tai.recipeme.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import pl.edu.agh.tai.recipeme.model.Ingredient;
import pl.edu.agh.tai.recipeme.model.Recipe;

public class RecipeForm extends Recipe{
	
	@Valid
	private Map<String, IngredientList> selectedIngredients;
	
	private byte[] photo;
	
	public RecipeForm(){
		selectedIngredients = new HashMap<>();
	}

	public Map<String, IngredientList> getSelectedIngredients() {
		return selectedIngredients;
	}

	public void setSelectedIngredients(Map<String, IngredientList> ingredientMap) {
		this.selectedIngredients = ingredientMap;
	}
		
	public void setIngredientList(List<Ingredient> ingredientList) {
		this.setIngredients(ingredientList);
	}
	
	
	public void setIngredients(List<Ingredient> ingredients){

		IngredientList iList;
		for (Ingredient ingredient: ingredients){
			if (selectedIngredients.containsKey(ingredient.getCategory().getName())){
				iList = selectedIngredients.get(ingredient.getCategory().getName());
				
			}else{
				iList = new IngredientList();
				selectedIngredients.put(ingredient.getCategory().getName(), iList);
			}
			
			iList.getIngList().add(new IngredientSelection(ingredient));
		}
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	
	

}
