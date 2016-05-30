package pl.edu.agh.tai.recipeme.dao.generic.impl;

import org.springframework.stereotype.Component;

import pl.edu.agh.tai.recipeme.dao.generic.CommentDao;
import pl.edu.agh.tai.recipeme.model.Comment;

@Component("commentDao")
public class CommentDaoImpl extends GenericDaoImpl<Comment> implements CommentDao {

}
