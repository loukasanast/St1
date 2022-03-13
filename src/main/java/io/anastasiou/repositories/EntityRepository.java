package io.anastasiou.repositories;

import java.util.List;

public interface EntityRepository<T> {
    T getById(Integer id);
    List<T> getAll();
    void create(T entity);
    void update(T entity);
    void delete(T entity);
}
