package pl.edu.agh.tai.recipeme.dao.generic.impl;

import org.springframework.stereotype.Component;

import pl.edu.agh.tai.recipeme.dao.generic.PhotoDao;
import pl.edu.agh.tai.recipeme.model.Photo;

@Component("photoDao")
public class PhotoDaoImpl extends GenericDaoImpl<Photo> implements PhotoDao{

}
