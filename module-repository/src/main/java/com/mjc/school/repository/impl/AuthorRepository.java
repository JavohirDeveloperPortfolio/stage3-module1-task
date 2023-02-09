package com.mjc.school.repository.impl;

import com.mjc.school.repository.Repository;
import com.mjc.school.repository.entity.Author;
import com.mjc.school.repository.source.CustomDataSource;

import java.util.List;

public class AuthorRepository implements Repository<Author> {
    private final CustomDataSource dataSource;

    public AuthorRepository() {
        dataSource = CustomDataSource.getInstance();
    }

    @Override
    public Author create(Author author) {
        return dataSource.getAuthorMap().putIfAbsent(author.getId(), author) == null ? author : null;
    }

    @Override
    public Author update(Author author) {
        return dataSource.getAuthorMap().computeIfPresent(author.getId(), (aLong, author1) -> author);
    }

    @Override
    public Author readById(Long id) {
        return dataSource.getAuthorMap().get(id);
    }

    @Override
    public List<Author> readAll() {
        return List.copyOf(dataSource.getAuthorMap().values());
    }

    @Override
    public Boolean delete(Long id) {
        return (dataSource.getAuthorMap().remove(id) != null)?true:false;
    }
}
