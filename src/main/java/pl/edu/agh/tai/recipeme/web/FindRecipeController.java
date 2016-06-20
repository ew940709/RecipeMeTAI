package pl.edu.agh.tai.recipeme.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.edu.agh.tai.hmm.IngredientGrid;
import pl.edu.agh.tai.hmm.IngredientList;
import pl.edu.agh.tai.hmm.IngredientSelection;
import pl.edu.agh.tai.recipeme.model.Ingredient;
import pl.edu.agh.tai.recipeme.nowe.service.IngredientService;

@Controller
@RequestMapping(value="/findRecipe")
public class FindRecipeController {
	
	static final String URL = "/findRecipe";
	
	@Autowired
	IngredientService ingredientService;
	
	@RequestMapping(method=RequestMethod.GET)
	public void findRecipe(Map<String, Object> model) {
		List<Ingredient> ingredients = ingredientService.getAll();
		IngredientGrid ingredientGrid = new IngredientGrid();
		ingredientGrid.setIngredientGrid(ingredients);
		model.put("ingredientGrid",ingredientGrid);

		for (Map.Entry<String, IngredientList> entry: ingredientGrid.getCategoryMap().entrySet()){
			System.out.println("CATEGORY: " + entry.getKey());
			for (IngredientSelection is: entry.getValue().getIngList()){
				System.out.println("GET " + is);
			}
		}
		
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public String post(@ModelAttribute("ingredientGrid") IngredientGrid ingredientGrid, Map<String,Object> model) {

		for (Map.Entry<String, IngredientList> entry: ingredientGrid.getCategoryMap().entrySet()){
			for (IngredientSelection is: entry.getValue().getIngList()){
				if(is.getSelected()){
					System.out.println("POST " + is);
				}
			}
		}
		
		return "result";
		
	}

}

