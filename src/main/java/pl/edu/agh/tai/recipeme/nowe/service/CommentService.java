package pl.edu.agh.tai.recipeme.nowe.service;

import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.tai.recipeme.model.Comment;

public interface CommentService {
	
	@Transactional
	Comment get(Long id);
	
	@Transactional
    Comment create(Comment comment);
	
	@Transactional
	void delete(Comment category);
	
	@Transactional
	Comment update(Comment category);
}
