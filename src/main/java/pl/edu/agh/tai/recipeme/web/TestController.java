package pl.edu.agh.tai.recipeme.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.edu.agh.tai.recipeme.model.Category;
import pl.edu.agh.tai.recipeme.model.Ingredient;
import pl.edu.agh.tai.recipeme.model.UserSecured;
import pl.edu.agh.tai.recipeme.nowe.service.CategoryService;
import pl.edu.agh.tai.recipeme.nowe.service.IngredientService;
import pl.edu.agh.tai.recipeme.nowe.service.UserSecuredService;

@Controller
@RequestMapping("/testUsera")
public class TestController {

	@Autowired
	UserSecuredService userService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	IngredientService ingredientService;

	@RequestMapping(method = RequestMethod.GET, value = "/testuj")
	public @ResponseBody String get() {

		userService.create(new UserSecured("Ewa", "passwd", false));
		return "OK";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/dodaj")
	public @ResponseBody String persist(){
		
		Category category = new Category("przyprawy");
		category.setId(new Long(2));
		
		ingredientService.create(new Ingredient("oregano", category,true));
		
		return "OKK";
	}

}
