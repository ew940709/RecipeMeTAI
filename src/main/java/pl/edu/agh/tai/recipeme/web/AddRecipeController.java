package pl.edu.agh.tai.recipeme.web;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.edu.agh.tai.hmm.IngredientSelection;
import pl.edu.agh.tai.hmm.RecipeForm;
import pl.edu.agh.tai.recipeme.model.Ingredient;
import pl.edu.agh.tai.recipeme.model.Recipe;
import pl.edu.agh.tai.recipeme.model.User;
import pl.edu.agh.tai.recipeme.nowe.service.IngredientService;
import pl.edu.agh.tai.recipeme.nowe.service.RecipeService;
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
		model.put("recipeForm",recipeForm);

//		System.out.println("GET: inglist size: " + ingredientList.getIngredientList().size());
//		for (IngredientSelection is: recipeForm.getSelectedIngredients()){
//			System.out.println("GET " + is);
//		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody String post(@ModelAttribute("recipeForm") RecipeForm recipeForm, Map<String, Object> model) {
		
		System.out.println("DUPA 1");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName(); 
		System.out.println(name);

	    User authenticatedUser = userService.getUserByUsername(name);
		System.out.println(authenticatedUser.getName() + " " + authenticatedUser.getId());

	    recipeForm.setAuthor(authenticatedUser);

	    List<Ingredient> ingredients = new LinkedList<>();
	    
	    for(IngredientSelection is: recipeForm.getSelectedIngredients()){
	    	if (is.getSelected()){
	    		ingredients.add(ingredientService.get(is.getId()));
	    	}
	    }

	    Recipe recipe = new Recipe(recipeForm);
	    recipe.fillIngredientList(ingredients);
	    Recipe createdRecipe = recipeService.create(recipe);
	    
	    System.out.println(createdRecipe);
	
		return "OK";

	}

}
