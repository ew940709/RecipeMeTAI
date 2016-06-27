package pl.edu.agh.tai.recipeme.dao.generic;

import java.util.List;

import pl.edu.agh.tai.recipeme.model.Photo;

public interface PhotoDao extends GenericDao<Photo>{

	List<Photo> getPhotos(Long recipeId);
}
