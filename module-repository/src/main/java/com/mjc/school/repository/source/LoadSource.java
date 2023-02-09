package com.mjc.school.repository.source;

import com.mjc.school.repository.entity.AuthorModel;
import com.mjc.school.repository.entity.NewsModel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LoadSource {

    private static final String AUTHOR_FILE_PATH = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("author.txt")).getPath();;
    private static final String NEWS_FILE_PATH = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("title.txt")).getPath();
    private static final String CONTENT_FILE_PATH = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("content.txt")).getPath();

    private static final List<String> authorList = new ArrayList<>();
    private static final List<String> newsList = new ArrayList<>();
    private static final List<String> contentList = new ArrayList<>();

    private LoadSource(){}

    public static void loader(List<String> list, String filePath){
        try(
                BufferedReader reader = new BufferedReader(new FileReader(filePath))
        ){
            while(reader.ready()){
                list.add(reader.readLine());
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void loadData(CustomDataSource customDataSource) {

//        System.out.println(AUTHOR_FILE_PATH);

        loader(authorList, AUTHOR_FILE_PATH);
        loader(newsList, NEWS_FILE_PATH);
        loader(contentList, CONTENT_FILE_PATH);

        for (int i = 0; i < 20; i++) {
            AuthorModel authorModel = new AuthorModel(authorList.get(i));
            customDataSource.getAuthorMap().put(authorModel.getId(), authorModel);
            NewsModel newsModel = new NewsModel(newsList.get(i),contentList.get(i), authorModel.getId());
            customDataSource.getNewsMap().put(newsModel.getId(), newsModel);
        }
    }
}
