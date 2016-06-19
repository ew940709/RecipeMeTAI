package pl.edu.agh.tai.recipeme.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.edu.agh.tai.hmm.IngredientList;
import pl.edu.agh.tai.hmm.IngredientSelection;
import pl.edu.agh.tai.recipeme.model.Ingredient;
import pl.edu.agh.tai.recipeme.nowe.service.IngredientService;

@Controller
@RequestMapping(value="/findRecipe")
public class RecipeController {
	
	static final String URL = "/findRecipe";
	
	@Autowired
	IngredientService ingredientService;
	
	@RequestMapping(method=RequestMethod.GET)
	public void findRecipe(Map<String, Object> model) {
		List<Ingredient> ingredients = ingredientService.getAll();
		IngredientList ingredientList = new IngredientList();
		ingredientList.setIngredientList(ingredients);
		model.put("ingredients",ingredientList);

//		System.out.println("GET: inglist size: " + ingredientList.getIngredientList().size());
		
		for (IngredientSelection is: ingredientList.getIngredientList()){
			System.out.println("GET " + is);
		}
		
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public String post(@ModelAttribute("ingredients") IngredientList ingredientList, Map<String,Object> model) {

		System.out.println("POST: list size: " + ingredientList.getIngredientList().size());

		for (IngredientSelection is: ingredientList.getIngredientList()){
			System.out.println(is);
		}
		
		return "result";
		
	}

}

