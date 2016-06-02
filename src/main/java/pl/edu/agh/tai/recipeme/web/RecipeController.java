package pl.edu.agh.tai.recipeme.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.edu.agh.tai.recipeme.model.Ingredient;
import pl.edu.agh.tai.recipeme.nowe.service.IngredientService;

@Controller
public class RecipeController {
	
	@Autowired
	IngredientService ingredientService;
	
	@RequestMapping(value="/findRecipe", method=RequestMethod.GET)
	public void findRecipe(ModelMap model) {
		List<Ingredient> ingredients = ingredientService.getAll();
		System.out.println(ingredients.size());
		System.out.println("name "+ingredients.get(0).getName());
		model.addAttribute("ingredients", ingredients);
	}

}
