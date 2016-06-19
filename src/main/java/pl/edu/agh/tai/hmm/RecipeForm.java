package pl.edu.agh.tai.hmm;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import pl.edu.agh.tai.recipeme.model.Ingredient;
import pl.edu.agh.tai.recipeme.model.Recipe;

public class RecipeForm extends Recipe{
	
	@Valid
	private List<IngredientSelection> selectedIngredients;
	
	public RecipeForm(){
		selectedIngredients = new ArrayList<>();
	}

	public List<IngredientSelection> getSelectedIngredients() {
		return selectedIngredients;
	}

	public void setSelectedIngredients(List<Ingredient> ingredientList) {
		this.setIngredients(ingredientList);
	}
		
	public void setIngredientList(List<Ingredient> ingredientList) {
		this.setSelectedIngredients(ingredientList);
	}
	
	
	public void setIngredients(List<Ingredient> ingredients){

		for (Ingredient ingredient: ingredients){
			IngredientSelection is = new IngredientSelection(ingredient);
			
			if(!selectedIngredients.contains(is)){
				selectedIngredients.add(is);				
			}
		}
	}

}
