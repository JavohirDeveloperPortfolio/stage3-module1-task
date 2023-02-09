package com.mjc.school.repository;

import java.util.List;

public interface Repository<T> {
    T create(T t);
    T update(T t);
    T readById(Long id);
    List<T> readAll();
    Boolean delete(Long id);
}
