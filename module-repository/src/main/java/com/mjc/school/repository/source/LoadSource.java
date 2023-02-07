package com.mjc.school.repository.source;

import com.mjc.school.repository.entity.Author;
import com.mjc.school.repository.entity.News;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoadSource {

    private static final String AUTHOR_FILE_PATH = "resources/author.txt";
    private static final String NEWS_FILE_PATH = "resources/news.txt";
    private static final String CONTENT_FILE_PATH = "resources/content.txt";

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
        loader(authorList, AUTHOR_FILE_PATH);
        loader(newsList, NEWS_FILE_PATH);
        loader(contentList, CONTENT_FILE_PATH);

        for (int i = 0; i < 20; i++) {
            Author author = new Author(authorList.get(i));
            customDataSource.getAuthorMap().put(author.getId(), author);
            News news = new News(newsList.get(i),contentList.get(i),author.getId());
            customDataSource.getNewsMap().put(news.getId(), news);
        }
    }
}
