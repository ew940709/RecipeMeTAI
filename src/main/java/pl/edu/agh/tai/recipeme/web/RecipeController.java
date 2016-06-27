package pl.edu.agh.tai.recipeme.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.edu.agh.tai.recipeme.model.Recipe;
import pl.edu.agh.tai.recipeme.nowe.service.RecipeService;

@Controller
public class RecipeController {
	
	@Autowired
	RecipeService recipeService;
	

	@RequestMapping(value="/recipeDetails", method=RequestMethod.GET)
	public void listRequestedRecipes(@RequestParam(value="Id", required=true) Long Id, Map<String, Object> model) {
		
		
		Recipe recipe = recipeService.get(Id);
		System.out.println("LOGI " + recipe.getIngredientList().size());
		model.put("recipe", recipe);
	}

}
