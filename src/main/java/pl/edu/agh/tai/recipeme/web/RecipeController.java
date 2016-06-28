package pl.edu.agh.tai.recipeme.web;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.edu.agh.tai.recipeme.model.Comment;
import pl.edu.agh.tai.recipeme.model.Recipe;
import pl.edu.agh.tai.recipeme.model.User;
import pl.edu.agh.tai.recipeme.nowe.service.CommentService;
import pl.edu.agh.tai.recipeme.nowe.service.RecipeService;
import pl.edu.agh.tai.recipeme.util.CommentForm;
import skeleton.service.UserService;

@Controller
public class RecipeController {
	
	@Autowired
	RecipeService recipeService;
	
	@Autowired
	UserService userService;

	@Autowired
	CommentService commentService;
	
	private static final String URL = "recipeDetails";
	
	@RequestMapping(value="/recipeDetails", method=RequestMethod.GET)
	public void listRequestedRecipes(@RequestParam(value="Id", required=true) Long Id, Map<String, Object> model) {
		CommentForm commentForm = new CommentForm();
		
		List<Comment> comments = commentService.getComments(Id);
		
		Recipe recipe = recipeService.get(Id);
		System.out.println("LOGI " + recipe.getIngredientList().size());
		model.put("recipe", recipe);
		model.put("commentForm", commentForm);
		model.put("commentList", comments);
	}

	@RequestMapping(value="/addComment", method=RequestMethod.POST)
	public String addComment(@ModelAttribute("commentForm") CommentForm commentForm, Map<String, Object> model) {

		model.put("commentForm", commentForm);
		

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		User authenticatedUser = userService.getUserByUsername(username);
		commentForm.setAuthor(authenticatedUser);
		commentForm.setDate(new Date());
		commentForm.setRating(0);
		
		Comment comment = commentForm.toComment();
		commentService.create(comment);
		
		
		return "redirect:" + URL + "?Id=" + commentForm.getRecipeId();

	}

}