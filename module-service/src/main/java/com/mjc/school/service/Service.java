package com.mjc.school.service;

import java.util.List;

public interface Service<T> {
    T create(T t);
    T update(T t);
    T getById(Long id);
    List<T> getAll();
    T delete(Long id);
}
