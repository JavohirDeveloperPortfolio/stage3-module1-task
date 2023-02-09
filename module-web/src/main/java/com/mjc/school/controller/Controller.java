package com.mjc.school.controller;

import java.util.List;

public interface Controller<T> {
    T create(T t);
    T update(T t);
    T getById(Long id);
    List<T> getAll();
    T delete(Long id);
}
