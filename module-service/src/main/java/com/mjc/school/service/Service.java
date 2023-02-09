package com.mjc.school.service;

import java.util.List;

public interface Service<T> {
    T create(T t);
    T update(T t);
    T readById(Long id);
    List<T> readAll();
    Boolean delete(Long id);
}
