package pl.edu.agh.tai.recipeme.dao.generic;

public interface GenericDao<T> {

    T create(T t);

    void delete(T id);

    T find(Object id);

    T update(T t);
}
