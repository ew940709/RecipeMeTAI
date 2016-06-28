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
		for(Ingredient requestedIngredient: requestedIngredients){
			for(Ingredient recipeIngredient: getIngredientList()){
				IngredientMatch ingredientMatch = new IngredientMatch(recipeIngredient.getName(),requestedIngredient.getId() == recipeIngredient.getId());
				ingredientMatches.add(ingredientMatch);
			}
		}
		
	}

	public List<IngredientMatch> getIngredientMatches() {
		return ingredientMatches;
	}

	public void setIngredientMatches(List<IngredientMatch> ingredientMatches) {
		this.ingredientMatches = ingredientMatches;
	}
	
	
}
