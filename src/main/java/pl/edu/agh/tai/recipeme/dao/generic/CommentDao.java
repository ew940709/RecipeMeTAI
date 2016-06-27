package pl.edu.agh.tai.recipeme.dao.generic;

import java.util.List;

import pl.edu.agh.tai.recipeme.model.Comment;

public interface CommentDao extends GenericDao<Comment>{

	List<Comment> getComments(Long recipeId);
}
