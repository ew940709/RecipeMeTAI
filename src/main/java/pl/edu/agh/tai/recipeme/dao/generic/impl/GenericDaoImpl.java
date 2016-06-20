package pl.edu.agh.tai.recipeme.dao.generic.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import pl.edu.agh.tai.recipeme.dao.generic.GenericDao;

public abstract class GenericDaoImpl<T> implements GenericDao<T> {
	
	@Autowired
	protected SessionFactory sessionFactory;
	
    private Class<T> type;

    @SuppressWarnings("unchecked")
	public GenericDaoImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class<T>) pt.getActualTypeArguments()[0];
    }

    @Override
    public T create(final T t) {
    	return (T)sessionFactory.getCurrentSession().merge(t);
    }

    @Override
    public void delete(final T t) {
    	sessionFactory.getCurrentSession().delete(t);
    }

    @SuppressWarnings("unchecked")
	@Override
    public T find(final Object id) {
    	return (T) sessionFactory.getCurrentSession().get(type, (Serializable) id);
    }

    @SuppressWarnings("unchecked")
	@Override
    public T update(final T t) {
        return (T) this.sessionFactory.getCurrentSession().merge(t); 
    }

}
