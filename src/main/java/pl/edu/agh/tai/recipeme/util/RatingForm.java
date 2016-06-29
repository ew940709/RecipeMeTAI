package pl.edu.agh.tai.recipeme.util;

public class RatingForm {

	private int rating;
	private Long recipeId;
	
	
	public RatingForm(){
		
	}
	public RatingForm(Long recipeId) {
		this.recipeId = recipeId;
	}


	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}


	public Long getRecipeId() {
		return recipeId;
	}


	public void setRecipeId(Long recipeId) {
		this.recipeId = recipeId;
	}
	
	
	
	
}
