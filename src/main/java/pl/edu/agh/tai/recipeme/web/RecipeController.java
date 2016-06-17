package pl.edu.agh.tai.recipeme.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.edu.agh.tai.hmm.IngredientList;
import pl.edu.agh.tai.hmm.IngredientSelection;
import pl.edu.agh.tai.recipeme.model.Ingredient;
import pl.edu.agh.tai.recipeme.nowe.service.IngredientService;

@Controller
public class RecipeController {
	
	static final String URL = "/findRecipe";
	
	@Autowired
	IngredientService ingredientService;
	
	@RequestMapping(value="/findRecipe", method=RequestMethod.GET)
	public void findRecipe(ModelMap model) {
		List<Ingredient> ingredients = ingredientService.getAll();
		IngredientList ingredientList = new IngredientList();
		ingredientList.setIngredientList(ingredients);
		model.addAttribute("ingredients",ingredientList);

//		System.out.println("GET: inglist size: " + ingredientList.getIngredientList().size());
		
		for (IngredientSelection is: ingredientList.getIngredientList()){
			System.out.println("GET " + is);
		}
		
	}
	
	
	@RequestMapping(value="/findRecipe", method = RequestMethod.POST)
	public String post(Model model, @ModelAttribute("ingredients") IngredientList ingredientList, BindingResult result) {
		if (result.hasErrors()) {
		}
		System.out.println("POST: list size: " + ingredientList.getIngredientList().size());
		List<Ingredient> ingredients = ingredientService.getAll();
		ingredientList.updateIngredients(ingredients);
		
		for (IngredientSelection is: ingredientList.getIngredientList()){
			System.out.println(is);
		}
		
		return "result";
		
	}

}

