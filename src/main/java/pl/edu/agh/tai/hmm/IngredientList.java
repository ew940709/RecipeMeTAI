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
	
	public void updateIngredients(List<Ingredient> ingredients){
		List<IngredientSelection> newList = new ArrayList<>();
		
		if (ingList.size() == ingredients.size()){
			for (int i = 0; i < ingList.size(); i++){
				IngredientSelection is = ingList.get(i);
				is.setId(ingredients.get(i).getId());
				is.setName(ingredients.get(i).getName());
				is.setCategory(ingredients.get(i).getCategory());
				is.setIsApproved(ingredients.get(i).getIsApproved());
				newList.add(is);
			}
			
			ingList = newList;
		}
		
	}
}
