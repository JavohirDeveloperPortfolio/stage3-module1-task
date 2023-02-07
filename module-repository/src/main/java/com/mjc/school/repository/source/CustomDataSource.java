package com.mjc.school.repository.source;

import com.mjc.school.repository.entity.Author;
import com.mjc.school.repository.entity.News;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CustomDataSource {
    private final Map<Long, Author> authorMap;
    private final Map<Long, News> newsMap;
    private static CustomDataSource instance;

    private CustomDataSource(){
        authorMap = new ConcurrentHashMap<>();
        newsMap = new ConcurrentHashMap<>();
        LoadSource.loadData(this);
    }

    public static CustomDataSource getInstance(){
        if (instance == null){
            instance = new CustomDataSource();
        }
        return instance;
    }

    public Map<Long, Author> getAuthorMap(){
        return authorMap;
    }

    public Map<Long, News> getNewsMap(){
        return newsMap;
    }
}
