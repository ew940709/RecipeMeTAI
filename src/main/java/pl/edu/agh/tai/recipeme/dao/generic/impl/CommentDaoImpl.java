package pl.edu.agh.tai.recipeme.dao.generic.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import pl.edu.agh.tai.recipeme.dao.generic.CommentDao;
import pl.edu.agh.tai.recipeme.model.Comment;

@Component("commentDao")
public class CommentDaoImpl extends GenericDaoImpl<Comment> implements CommentDao {

	@Override
	public List<Comment> getComments(Long recipeId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Comment.class)
				.add(Restrictions.eq("recipeId", recipeId));
		
		@SuppressWarnings("unchecked")
		List<Comment> resultList = criteria.list();
		
		return resultList;
	}

}
