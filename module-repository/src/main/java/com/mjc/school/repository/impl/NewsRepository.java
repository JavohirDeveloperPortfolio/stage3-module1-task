package com.mjc.school.repository.impl;

import com.mjc.school.repository.Repository;
import com.mjc.school.repository.entity.NewsModel;
import com.mjc.school.repository.source.CustomDataSource;

import java.util.List;

public class NewsRepository implements Repository<NewsModel> {
    private final CustomDataSource dataSource;

    public NewsRepository() {
        dataSource = CustomDataSource.getInstance();
    }

    @Override
    public NewsModel create(NewsModel newsModel) {
        return dataSource.getNewsMap().putIfAbsent(newsModel.getId(), newsModel);
    }

    @Override
    public NewsModel update(NewsModel newsModel) {
        return dataSource.getNewsMap().computeIfPresent(newsModel.getId(), (aLong, news1) -> newsModel);
    }

    @Override
    public NewsModel readById(Long id) {
        return dataSource.getNewsMap().get(id);
    }

    @Override
    public List<NewsModel> readAll() {
        return List.copyOf(dataSource.getNewsMap().values());
    }

    @Override
    public Boolean delete(Long id) {
        return dataSource.getNewsMap().remove(id) != null;
    }
}
