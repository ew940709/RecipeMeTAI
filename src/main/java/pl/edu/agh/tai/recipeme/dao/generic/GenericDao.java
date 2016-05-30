package pl.edu.agh.tai.recipeme.dao.generic;

import java.util.Map;

public interface GenericDao<T> {

    T create(T t);

    void delete(Object id);

    T find(Object id);

    T update(T t);
}
