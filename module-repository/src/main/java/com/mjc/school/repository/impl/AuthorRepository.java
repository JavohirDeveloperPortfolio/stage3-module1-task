package com.mjc.school.repository.impl;

import com.mjc.school.repository.Repository;
import com.mjc.school.repository.entity.AuthorModel;
import com.mjc.school.repository.source.CustomDataSource;

import java.util.List;

public class AuthorRepository implements Repository<AuthorModel> {
    private final CustomDataSource dataSource;

    public AuthorRepository() {
        dataSource = CustomDataSource.getInstance();
    }

    @Override
    public AuthorModel create(AuthorModel authorModel) {
        return dataSource.getAuthorMap().putIfAbsent(authorModel.getId(), authorModel) == null ? authorModel : null;
    }

    @Override
    public AuthorModel update(AuthorModel authorModel) {
        return dataSource.getAuthorMap().computeIfPresent(authorModel.getId(), (aLong, authorModel1) -> authorModel);
    }

    @Override
    public AuthorModel readById(Long id) {
        return dataSource.getAuthorMap().get(id);
    }

    @Override
    public List<AuthorModel> readAll() {
        return List.copyOf(dataSource.getAuthorMap().values());
    }

    @Override
    public Boolean delete(Long id) {
        return dataSource.getAuthorMap().remove(id) != null;
    }
}
