package pl.edu.agh.tai.recipeme.web;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.edu.agh.tai.hmm.IngredientList;

@Controller
@RequestMapping(value="/addRecipe")
public class AddRecipeController {
	

	@RequestMapping(method=RequestMethod.GET)
	public void findRecipe(Map<String, Object> model) {
		
		
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public String post(@ModelAttribute("ingredients") IngredientList ingredientList, Map<String,Object> model) {
		
		return "OK";
		
	}

}
