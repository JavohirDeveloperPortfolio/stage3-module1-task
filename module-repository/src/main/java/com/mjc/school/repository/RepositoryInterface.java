package com.mjc.school.repository;

import java.util.List;

public interface RepositoryInterface<T> {
    T create(T t);
    T update(T t);
    T getById(Long id);
    List<T> getAll();
    T delete(Long id);
}
