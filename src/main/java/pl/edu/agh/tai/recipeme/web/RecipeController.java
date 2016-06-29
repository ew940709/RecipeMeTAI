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
import pl.edu.agh.tai.recipeme.util.RatingForm;
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
		Comment commentForm = new Comment();
		
		List<Comment> comments = commentService.getComments(Id);
		
		Recipe recipe = recipeService.get(Id);
		RatingForm ratingForm = new RatingForm(recipe.getId());
		
		model.put("recipe", recipe);
		model.put("commentForm", commentForm);
		model.put("commentList", comments);
		model.put("ratingForm", ratingForm);
	}

	@RequestMapping(value="/addComment", method=RequestMethod.POST)
	public String addComment(@ModelAttribute("commentForm") Comment commentForm, Map<String, Object> model) {

		model.put("commentForm", commentForm);
		

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		User authenticatedUser = userService.getUserByUsername(username);
		commentForm.setAuthor(authenticatedUser);
		commentForm.setDate(new Date());
		commentForm.setRating(0);
		
		commentService.create(commentForm);
		
		
		return "redirect:" + URL + "?Id=" + commentForm.getRecipeId();

	}
	
	@RequestMapping(value="/addRating", method=RequestMethod.POST)
	public String addRating(@ModelAttribute("ratingForm") RatingForm ratingForm, Map<String, Object> model){
		
		
		return "redirect:" + URL + "?Id=" + ratingForm.getRecipeId();
	}
	

}
