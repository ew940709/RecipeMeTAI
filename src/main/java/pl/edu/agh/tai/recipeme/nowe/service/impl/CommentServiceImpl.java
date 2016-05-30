package pl.edu.agh.tai.recipeme.nowe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.edu.agh.tai.recipeme.dao.generic.CommentDao;
import pl.edu.agh.tai.recipeme.model.Comment;
import pl.edu.agh.tai.recipeme.nowe.service.CommentService;

@Service("commentService")
public class CommentServiceImpl implements CommentService{

	@Autowired
	CommentDao commentDao;
	
	@Override
	public Comment get(Long id) {
		return commentDao.find(id);
	}

	@Override
	public Comment create(Comment comment) {
		return commentDao.create(comment);
	}

	@Override
	public void delete(Comment comment) {
		commentDao.delete(comment);
		
	}

	@Override
	public Comment update(Comment comment) {
		return commentDao.update(comment);
	}

}
