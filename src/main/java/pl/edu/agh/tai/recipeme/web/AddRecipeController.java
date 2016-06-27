package pl.edu.agh.tai.recipeme.web;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.edu.agh.tai.recipeme.model.Ingredient;
import pl.edu.agh.tai.recipeme.model.Recipe;
import pl.edu.agh.tai.recipeme.model.User;
import pl.edu.agh.tai.recipeme.nowe.service.IngredientService;
import pl.edu.agh.tai.recipeme.nowe.service.RecipeService;
import pl.edu.agh.tai.recipeme.util.IngredientList;
import pl.edu.agh.tai.recipeme.util.IngredientSelection;
import pl.edu.agh.tai.recipeme.util.RecipeForm;
import skeleton.service.UserService;

@Controller
@RequestMapping(value = "/addRecipe")
public class AddRecipeController {

	@Autowired
	IngredientService ingredientService;

	@Autowired
	RecipeService recipeService;

	@Autowired
	UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public void findRecipe(Map<String, Object> model) {
		
		List<Ingredient> ingredients = ingredientService.getAll();
		RecipeForm recipeForm = new RecipeForm();
		recipeForm.setIngredientList(ingredients);
		model.put("recipeForm", recipeForm);
		
	}

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody String post(@ModelAttribute("recipeForm") RecipeForm recipeForm, Map<String, Object> model) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		User authenticatedUser = userService.getUserByUsername(username);
		recipeForm.setAuthor(authenticatedUser);

		List<Ingredient> ingredients = new LinkedList<>();
		for (Entry<String, IngredientList> entry : recipeForm.getSelectedIngredients().entrySet()) {
			for (IngredientSelection is : entry.getValue().getIngredientList()) {
				if (is.getSelected()) {
					ingredients.add(ingredientService.get(is.getId()));
				}
			}
		}

		Recipe recipe = new Recipe(recipeForm);
		recipe.fillIngredientList(ingredients);
		Recipe createdRecipe = recipeService.create(recipe);
		
		return "OK";

	}

}
