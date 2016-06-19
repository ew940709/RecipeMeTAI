package pl.edu.agh.tai.hmm;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import pl.edu.agh.tai.recipeme.model.Ingredient;

public class IngredientList {

	@Valid
	private List<IngredientSelection> ingList;
	
	public IngredientList(){
		ingList = new ArrayList<>();
	}

	public List<IngredientSelection> getIngList() {
		return ingList;
	}

	public void setIngList(List<Ingredient> ingredientList) {
		this.setIngredients(ingredientList);
	}
		
	public List<IngredientSelection> getIngredientList() {
		return getIngList();
	}

	public void setIngredientList(List<Ingredient> ingredientList) {
		this.setIngList(ingredientList);
	}
	
	
	public void setIngredients(List<Ingredient> ingredients){

		for (Ingredient ingredient: ingredients){
			IngredientSelection is = new IngredientSelection(ingredient);
			
			if(!ingList.contains(is)){
				ingList.add(is);				
			}
		}
	}
	
}
