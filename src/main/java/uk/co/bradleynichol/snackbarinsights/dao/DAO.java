package uk.co.bradleynichol.snackbarinsights.dao;

import java.util.List;

public interface DAO<T> {
    void create(T entity);
    T findById(String entityId);
    void update(T entity);
    void delete(String entityId);
    List<T> findAll();
}
