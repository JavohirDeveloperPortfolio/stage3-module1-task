package com.mjc.school.repository.source;

import com.mjc.school.repository.entity.AuthorModel;
import com.mjc.school.repository.entity.NewsModel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CustomDataSource {
    private final Map<Long, AuthorModel> authorMap;
    private final Map<Long, NewsModel> newsMap;
    private static volatile CustomDataSource instance;

    private CustomDataSource(){
        authorMap = new ConcurrentHashMap<>();
        newsMap = new ConcurrentHashMap<>();
        LoadSource.loadData(this);
    }

    public static CustomDataSource getInstance(){
//        CustomDataSource result = instance;
//        if (result == null) {
//            synchronized (CustomDataSource.class) {
//                result = instance;
                if (instance == null) {
                    instance = new CustomDataSource();
                }
//            }
//        }
        return instance;
    }

    public Map<Long, AuthorModel> getAuthorMap(){
        return authorMap;
    }

    public Map<Long, NewsModel> getNewsMap(){
        return newsMap;
    }
}
