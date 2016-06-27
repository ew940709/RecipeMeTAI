package pl.edu.agh.tai.recipeme.nowe.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.tai.recipeme.model.Photo;

public interface PhotoService {
	
	@Transactional
	Photo get(Long id);
	
	@Transactional
    Photo create(Photo photo);
	
	@Transactional
	void delete(Photo photo);
	
	@Transactional
	Photo update(Photo photo);
	
	@Transactional
	List<Photo> getPhotos(Long recipeId);
}
