package uk.co.bradleynichol.snackbarinsights.service;


import java.util.List;

public interface GenericService<T> {
    boolean save(T entity);
    T getById(String brandId);
    void update(T entity);
    void delete(String brandId);
    List<T> getAll();
}


