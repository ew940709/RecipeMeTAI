package pl.edu.agh.tai.recipeme.util;

import pl.edu.agh.tai.recipeme.model.Comment;

public class CommentForm extends Comment{

	public Comment toComment(){
		Comment comment = new Comment();
		
		comment.setAuthor(getAuthor());
		comment.setContent(getContent());
		comment.setDate(getDate());
		comment.setRating(getRating());
		comment.setId(getId());
		comment.setRecipeId(getRecipeId());
		
		return comment;
	}
	
	
}
