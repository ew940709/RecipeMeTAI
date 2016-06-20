
package pl.edu.agh.tai.hmm;

import pl.edu.agh.tai.recipeme.model.Ingredient;

public class IngredientSelection extends Ingredient{

	private boolean selected = false;
	
	public IngredientSelection(){
		
	}
	
	public IngredientSelection(Ingredient ingredient){
		setCategory(ingredient.getCategory());
		setIsApproved(ingredient.getIsApproved());
		setName(ingredient.getName());
		setId(ingredient.getId());
	}

	public Ingredient toIngredient(){
		Ingredient ingredient = new Ingredient();
		ingredient.setCategory(getCategory());
		ingredient.setIsApproved(getIsApproved());
		ingredient.setName(getName());
		ingredient.getId();
		return ingredient;
		
	}
	
	public boolean getSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	@Override
	public String toString(){
		return getId() + "-" + getCategory().getName() + "-" + getName() + "-" + getSelected();
	}
}

