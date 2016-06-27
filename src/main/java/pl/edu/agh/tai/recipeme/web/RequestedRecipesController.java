package pl.edu.agh.tai.recipeme.web;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.edu.agh.tai.recipeme.model.Recipe;

@Controller
@RequestMapping(value="/requestedRecipes")
public class RequestedRecipesController {
	
	@RequestMapping(method=RequestMethod.GET)
	public void listRequestedRecipes(Map<String, Object> model, @ModelAttribute("foundRecipes") Object foundRecipes) {
		
		List<Recipe> listOfRecipes = (List<Recipe>) foundRecipes;
		System.out.println("foundRecipes " + (listOfRecipes).size());
		
		for(Recipe r : listOfRecipes){
			System.out.println(r.toString());
		}
		
		model.put("recipes", listOfRecipes);
		
	
	}

}
