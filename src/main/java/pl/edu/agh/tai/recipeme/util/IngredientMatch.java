package pl.edu.agh.tai.recipeme.util;

public class IngredientMatch {
	
	private String ingredientName;
	private boolean matching;
	
	public IngredientMatch(String ingredientName, boolean matching) {
		super();
		this.ingredientName = ingredientName;
		this.matching = matching;
	}

	public String getIngredientName() {
		return ingredientName;
	}

	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}

	public boolean getMatching() {
		return matching;
	}

	public void setMatching(boolean matching) {
		this.matching = matching;
	}
	
	
}
