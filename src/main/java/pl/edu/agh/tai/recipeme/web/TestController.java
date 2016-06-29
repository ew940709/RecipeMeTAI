package pl.edu.agh.tai.recipeme.web;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.edu.agh.tai.recipeme.model.Category;
import pl.edu.agh.tai.recipeme.model.Ingredient;
import pl.edu.agh.tai.recipeme.nowe.service.CategoryService;
import pl.edu.agh.tai.recipeme.nowe.service.IngredientService;
import skeleton.service.UserService;

@Controller
@RequestMapping("/test")
public class TestController {

	@Autowired
	UserService userService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	IngredientService ingredientService;
	
	private boolean initialized = false;

	public String initRoot() {

		UserCommand root = new UserCommand();
		root.setName("root");
		PasswordEncoder passwordEncoder = new StandardPasswordEncoder();
		root.setPassword(passwordEncoder.encode("root"));
		root.setAddress("root@localhost");
		root.setEmail("root@localhost");
		
		userService.save(root);
		return "OK";
	}
	
	private String initCategories(){
		
		Category c1 = new Category("spices");		
		Category c2 = new Category("vegetables");		
		Category c3 = new Category("fruits");		
		Category c4 = new Category("meat");		
		Category c5 = new Category("fish");		
		Category c6 = new Category("dairy");		
		Category c7 = new Category("sweets");
		
		categoryService.create(c1);
		categoryService.create(c2);
		categoryService.create(c3);
		categoryService.create(c4);
		categoryService.create(c5);
		categoryService.create(c6);
		categoryService.create(c7);

		return "OKK";
	}
	

	private String initIngredients(){
		List<Ingredient> ingredients = new LinkedList<>();
		
		Category c1 = categoryService.get(new Long(1));		
		Category c2 = categoryService.get(new Long(2));		
		Category c3 = categoryService.get(new Long(3));		
		Category c4 = categoryService.get(new Long(4));		
		Category c5 = categoryService.get(new Long(5));		
		Category c6 = categoryService.get(new Long(6));		
		Category c7 = categoryService.get(new Long(7));		
		
		ingredients.add(new Ingredient("oregano", c1, true));
		ingredients.add(new Ingredient("salt", c1, true));
		ingredients.add(new Ingredient("pepper", c1, true));
		ingredients.add(new Ingredient("tomato", c2, true));
		ingredients.add(new Ingredient("potato", c2, true));
		ingredients.add(new Ingredient("cucamber", c2, true));
		ingredients.add(new Ingredient("apple", c3, true));
		ingredients.add(new Ingredient("pear", c3, true));
		ingredients.add(new Ingredient("strawberry", c3, true));
		ingredients.add(new Ingredient("chicken", c4, true));
		ingredients.add(new Ingredient("pork", c4, true));
		ingredients.add(new Ingredient("beef", c4, true));
		ingredients.add(new Ingredient("salmon", c5, true));
		ingredients.add(new Ingredient("tuna", c5, true));
		ingredients.add(new Ingredient("octopus", c5, true));
		ingredients.add(new Ingredient("yoghurt", c6, true));
		ingredients.add(new Ingredient("milk", c6, true));
		ingredients.add(new Ingredient("cheese", c6, true));
		ingredients.add(new Ingredient("ice cream", c7, true));
		ingredients.add(new Ingredient("chocolate", c7, true));
		ingredients.add(new Ingredient("honey", c7, true));
		
		for (Ingredient i: ingredients){
			ingredientService.create(i);
		}
		
		
		return "OKK";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/init")
	public @ResponseBody String initDatabase(){
		System.out.println("------------Wywolanie test/init");
		if (!initialized){
			initCategories();
			initIngredients();
			initRoot();
			initialized = true;
		}
		return "OKK";
	}

}
