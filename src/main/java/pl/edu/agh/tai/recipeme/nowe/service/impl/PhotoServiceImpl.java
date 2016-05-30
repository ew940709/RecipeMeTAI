package pl.edu.agh.tai.recipeme.nowe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.edu.agh.tai.recipeme.dao.generic.PhotoDao;
import pl.edu.agh.tai.recipeme.model.Photo;
import pl.edu.agh.tai.recipeme.nowe.service.PhotoService;

@Service("photoService")
public class PhotoServiceImpl implements PhotoService{

	@Autowired
	PhotoDao photoDao;
	
	@Override
	public Photo get(Long id) {
		return photoDao.find(id);
	}

	@Override
	public Photo create(Photo photo) {
		return photoDao.create(photo);
	}

	@Override
	public void delete(Photo photo) {
		photoDao.delete(photo);
	}

	@Override
	public Photo update(Photo photo) {
		return photoDao.update(photo);
	}

}
