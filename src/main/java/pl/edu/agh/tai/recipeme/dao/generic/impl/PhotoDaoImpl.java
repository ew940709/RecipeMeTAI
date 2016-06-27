package pl.edu.agh.tai.recipeme.dao.generic.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import pl.edu.agh.tai.recipeme.dao.generic.PhotoDao;
import pl.edu.agh.tai.recipeme.model.Photo;

@Component("photoDao")
public class PhotoDaoImpl extends GenericDaoImpl<Photo> implements PhotoDao{

	@Override
	public List<Photo> getPhotos(Long recipeId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Photo.class)
				.add(Restrictions.eq("recipeId", recipeId));
		
		@SuppressWarnings("unchecked")
		List<Photo> resultList = criteria.list();
		
		return resultList;
	}

}
