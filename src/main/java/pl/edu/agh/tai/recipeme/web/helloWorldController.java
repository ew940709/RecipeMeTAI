package pl.edu.agh.tai.recipeme.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class helloWorldController {
	
	@RequestMapping( value = "/helloWorld", method=RequestMethod.GET)
	public void secret(ModelMap model) {
		model.addAttribute("msg", "JCG Hello World!");
	}
	
	@RequestMapping( value = "/index")
	public void index() {
	}
	
	@RequestMapping( value = "/findRecipe")
	public void findRecipe() {
	}
}
