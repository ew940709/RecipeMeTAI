package pl.edu.agh.tai.recipeme.util;

import java.util.LinkedList;
import java.util.List;

public class RecipeMapping {
	
	private List<IngredientSelection> ingredientSelection;
	
	
	public RecipeMapping(){
		ingredientSelection = new LinkedList<IngredientSelection>();
	}
	
	public RecipeMapping(List<IngredientSelection> ingredientSelection){
		this.ingredientSelection  = ingredientSelection;
	}

	public List<IngredientSelection> getIngredientSelection() {
		return ingredientSelection;
	}


	public void setIngredientSelection(List<IngredientSelection> ingredientSelection) {
		this.ingredientSelection = ingredientSelection;
	}
	
	
	public void addIngredient(IngredientSelection is){
		this.ingredientSelection.add(is);
	}
	

}
