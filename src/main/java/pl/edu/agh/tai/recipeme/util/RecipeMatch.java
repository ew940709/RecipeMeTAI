package pl.edu.agh.tai.recipeme.util;

import java.util.LinkedList;
import java.util.List;

import pl.edu.agh.tai.recipeme.model.Ingredient;
import pl.edu.agh.tai.recipeme.model.Recipe;

public class RecipeMatch extends Recipe {

	//'matching' flag in IngredientMatch set to true means this ingredient matches
	//ingredient that was chosen by user in his request
	private List<IngredientMatch> ingredientMatches;
	
	public RecipeMatch(Recipe recipe, List<Ingredient> requestedIngredients){
		this.setId(recipe.getId());
		this.setAuthor(recipe.getAuthor());
		this.setAverageRating(recipe.getAverageRating());
		this.setDescription(recipe.getDescription());
		this.setTitle(recipe.getTitle());
		this.setIngredientList(recipe.getIngredientList());
		ingredientMatches = new LinkedList<>();
		this.fillIngredientMatches(requestedIngredients);
	}

	private void fillIngredientMatches(List<Ingredient> requestedIngredients) {
		IngredientMatch ingredientMatch;
		boolean foundMatch;
		
		for(Ingredient recipeIngredient: getIngredientList()){
			
			foundMatch = false;
			for(Ingredient requestedIngredient: requestedIngredients){
			
				if(requestedIngredient.getId() == recipeIngredient.getId()){
					foundMatch = true;
				}
			}
			ingredientMatch = new IngredientMatch(recipeIngredient.getName(),foundMatch);
			ingredientMatches.add(ingredientMatch);
		}
		System.out.println("filled ingredientMatches for " + this.getTitle() + " size(): " + ingredientMatches.size());
	}

	public List<IngredientMatch> getIngredientMatches() {
		return ingredientMatches;
	}

	public void setIngredientMatches(List<IngredientMatch> ingredientMatches) {
		this.ingredientMatches = ingredientMatches;
	}
	
	
}
