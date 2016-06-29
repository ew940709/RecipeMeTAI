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

	private String initCategories() {
		List<Category> categoryList = new LinkedList<>();

		categoryList.add(new Category("spices"));
		categoryList.add(new Category("vegetables"));
		categoryList.add(new Category("fruit"));
		categoryList.add(new Category("meats"));
		categoryList.add(new Category("fish"));
		categoryList.add(new Category("dairy"));
		categoryList.add(new Category("sweets"));
		categoryList.add(new Category("vegan"));
		categoryList.add(new Category("other"));
		categoryList.add(new Category("lipids"));
		categoryList.add(new Category("liquids"));
		categoryList.add(new Category("grain products"));

		for (Category category : categoryList) {
			categoryService.create(category);
		}

		return "OKK";
	}

	private String initIngredients() {
		List<Ingredient> ingredients = new LinkedList<>();

		Category spices = categoryService.get(new Long(1));
		Category vegetables = categoryService.get(new Long(2));
		Category fruit = categoryService.get(new Long(3));
		Category meat = categoryService.get(new Long(4));
		Category fish = categoryService.get(new Long(5));
		Category dairy = categoryService.get(new Long(6));
		Category sweets = categoryService.get(new Long(7));
		Category vegan = categoryService.get(new Long(8));
		Category other = categoryService.get(new Long(9));
		Category lipids = categoryService.get(new Long(10));
		Category liquids = categoryService.get(new Long(11));
		Category grain = categoryService.get(new Long(12));

		ingredients.add(new Ingredient("oregano", spices, true));
		ingredients.add(new Ingredient("salt", spices, true));
		ingredients.add(new Ingredient("pepper", spices, true));
		ingredients.add(new Ingredient("basil", spices, true));
		ingredients.add(new Ingredient("curry", spices, true));
		ingredients.add(new Ingredient("chili", spices, true));
		ingredients.add(new Ingredient("sweet pepper", spices, true));
		ingredients.add(new Ingredient("cumin", spices, true));
		ingredients.add(new Ingredient("marjoram", spices, true));

		ingredients.add(new Ingredient("tomato", vegetables, true));
		ingredients.add(new Ingredient("potato", vegetables, true));
		ingredients.add(new Ingredient("cucamber", vegetables, true));
		ingredients.add(new Ingredient("courgette", vegetables, true));
		ingredients.add(new Ingredient("onion", vegetables, true));
		ingredients.add(new Ingredient("garlic", vegetables, true));
		ingredients.add(new Ingredient("paprika", vegetables, true));
		ingredients.add(new Ingredient("letuce", vegetables, true));
		ingredients.add(new Ingredient("cabbage", vegetables, true));
		ingredients.add(new Ingredient("leek", vegetables, true));
		ingredients.add(new Ingredient("radish", vegetables, true));
		ingredients.add(new Ingredient("chive", vegetables, true));
		ingredients.add(new Ingredient("carrot", vegetables, true));
		ingredients.add(new Ingredient("parsley", fruit, true));

		ingredients.add(new Ingredient("apple", fruit, true));
		ingredients.add(new Ingredient("pear", fruit, true));
		ingredients.add(new Ingredient("strawberry", fruit, true));
		ingredients.add(new Ingredient("raspberry", fruit, true));
		ingredients.add(new Ingredient("blueberry", fruit, true));
		ingredients.add(new Ingredient("plum", fruit, true));
		ingredients.add(new Ingredient("banana", fruit, true));
		ingredients.add(new Ingredient("pineapple", fruit, true));
		ingredients.add(new Ingredient("pomegranate", fruit, true));
		ingredients.add(new Ingredient("avocado", fruit, true));
		ingredients.add(new Ingredient("orange", fruit, true));
		ingredients.add(new Ingredient("mandarin", fruit, true));
		ingredients.add(new Ingredient("lemon", fruit, true));
		ingredients.add(new Ingredient("peach", fruit, true));

		ingredients.add(new Ingredient("poultry", meat, true));
		ingredients.add(new Ingredient("pork", meat, true));
		ingredients.add(new Ingredient("beef", meat, true));
		ingredients.add(new Ingredient("lamb", meat, true));
		ingredients.add(new Ingredient("veal", meat, true));
		ingredients.add(new Ingredient("game", meat, true));

		ingredients.add(new Ingredient("salmon", fish, true));
		ingredients.add(new Ingredient("tuna", fish, true));
		ingredients.add(new Ingredient("octopus", fish, true));
		ingredients.add(new Ingredient("shrimp", fish, true));
		ingredients.add(new Ingredient("panga", fish, true));
		ingredients.add(new Ingredient("eel", fish, true));
		ingredients.add(new Ingredient("carp", fish, true));
		ingredients.add(new Ingredient("frog", fish, true));

		ingredients.add(new Ingredient("yoghurt", dairy, true));
		ingredients.add(new Ingredient("milk", dairy, true));
		ingredients.add(new Ingredient("cheese", dairy, true));
		ingredients.add(new Ingredient("cream", dairy, true));
		ingredients.add(new Ingredient("kephir", dairy, true));
		ingredients.add(new Ingredient("buttermilk", dairy, true));

		ingredients.add(new Ingredient("ice cream", sweets, true));
		ingredients.add(new Ingredient("chocolate", sweets, true));
		ingredients.add(new Ingredient("honey", sweets, true));
		ingredients.add(new Ingredient("frosting", sweets, true));
		ingredients.add(new Ingredient("whipped cream", sweets, true));

		ingredients.add(new Ingredient("tofu", vegan, true));
		ingredients.add(new Ingredient("soy milk", vegan, true));
		ingredients.add(new Ingredient("soy", vegan, true));

		ingredients.add(new Ingredient("sugar", other, true));
		ingredients.add(new Ingredient("eggs", other, true));
		ingredients.add(new Ingredient("pasta", other, true));

		ingredients.add(new Ingredient("oil", lipids, true));
		ingredients.add(new Ingredient("olive", lipids, true));
		ingredients.add(new Ingredient("butter", lipids, true));
		ingredients.add(new Ingredient("margarine", lipids, true));

		ingredients.add(new Ingredient("water", liquids, true));
		ingredients.add(new Ingredient("wine", liquids, true));
		ingredients.add(new Ingredient("vodka", liquids, true));

		ingredients.add(new Ingredient("flour", grain, true));
		ingredients.add(new Ingredient("rice", grain, true));
		ingredients.add(new Ingredient("buckwheat", grain, true));
		ingredients.add(new Ingredient("barley", grain, true));
		ingredients.add(new Ingredient("semolina", grain, true));

		for (Ingredient i : ingredients) {
			ingredientService.create(i);
		}

		return "OKK";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/init")
	public @ResponseBody String initDatabase() {
		
		initCategories();
		initIngredients();
		initRoot();

		return "OKK";
	}

}
