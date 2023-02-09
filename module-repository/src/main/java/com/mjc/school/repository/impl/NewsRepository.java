package com.mjc.school.repository.impl;

import com.mjc.school.repository.Repository;
import com.mjc.school.repository.entity.News;
import com.mjc.school.repository.source.CustomDataSource;

import java.util.List;

public class NewsRepository implements Repository<News> {
    private final CustomDataSource dataSource;

    public NewsRepository() {
        dataSource = CustomDataSource.getInstance();
    }

    @Override
    public News create(News news) {
        return dataSource.getNewsMap().putIfAbsent(news.getId(), news);
    }

    @Override
    public News update(News news) {
        return dataSource.getNewsMap().computeIfPresent(news.getId(), (aLong, news1) -> news);
    }

    @Override
    public News readById(Long id) {
        return dataSource.getNewsMap().get(id);
    }

    @Override
    public List<News> readAll() {
        return List.copyOf(dataSource.getNewsMap().values());
    }

    @Override
    public Boolean delete(Long id) {
        return (dataSource.getNewsMap().remove(id) != null)?true:false;
    }
}
