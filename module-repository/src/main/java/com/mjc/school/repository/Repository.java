package com.mjc.school.repository;

import java.util.List;

public interface Repository<T> {
    T create(T t);
    T update(T t);
    T getById(Long id);
    List<T> getAll();
    T delete(Long id);
}
