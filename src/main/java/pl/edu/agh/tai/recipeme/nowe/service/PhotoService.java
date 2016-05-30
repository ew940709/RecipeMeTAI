package pl.edu.agh.tai.recipeme.nowe.service;

import pl.edu.agh.tai.recipeme.model.Photo;

public interface PhotoService {
	
	Photo get(Long id);
	
    Photo create(Photo photo);
	
	void delete(Photo photo);
	
	Photo update(Photo photo);
}
