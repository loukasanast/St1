package io.anastasiou.services;

import io.anastasiou.models.Student;

import java.util.List;

public interface EntityService<T> {
    T findById(Integer id);
    List<T> find();
    void add(T entity);
    void edit(T entity);
    void remove(T entity);
}
