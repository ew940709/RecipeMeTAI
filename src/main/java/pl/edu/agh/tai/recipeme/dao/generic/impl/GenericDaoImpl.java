package pl.edu.agh.tai.recipeme.dao.generic.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import pl.edu.agh.tai.recipeme.dao.generic.GenericDao;

public abstract class GenericDaoImpl<T> implements GenericDao<T> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
    private Class<T> type;

    @SuppressWarnings("unchecked")
	public GenericDaoImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }

    @Override
    public T create(final T t) {
    	sessionFactory.getCurrentSession().merge(t);
    	return t;
    }

    @Override
    public void delete(final T t) {
    	sessionFactory.getCurrentSession().delete(t);
    }

    @Override
    public T find(final Object id) {
    	return (T) sessionFactory.getCurrentSession().get(type, (Serializable) id);
    }

    @Override
    public T update(final T t) {
        return (T) this.sessionFactory.getCurrentSession().merge(t); 
    }

}
