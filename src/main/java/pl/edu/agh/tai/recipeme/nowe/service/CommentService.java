package pl.edu.agh.tai.recipeme.nowe.service;

import pl.edu.agh.tai.recipeme.model.Comment;

public interface CommentService {
	
	Comment get(Long id);
	
    Comment create(Comment comment);
	
	void delete(Comment category);
	
	Comment update(Comment category);
}
