package com.mjc.school.service.impl;

import com.mjc.school.repository.Repository;
import com.mjc.school.repository.entity.News;
import com.mjc.school.repository.impl.NewsRepository;
import com.mjc.school.service.NewsMapper;
import com.mjc.school.service.Service;
import com.mjc.school.service.dto.NewsDto;
import com.mjc.school.service.exception.ErrorNotification;
import com.mjc.school.service.exception.InvalidDataException;
import com.mjc.school.service.exception.NoSuchEntityException;
import com.mjc.school.service.validation.NewsValidation;

import java.util.List;

public class NewsService implements Service<NewsDto> {
    private final Repository<News> newsRepository;
    private final NewsValidation newsValidation;

    public NewsService(){
        newsRepository = new NewsRepository();
        newsValidation = new NewsValidation();
    }

    @Override
    public NewsDto create(NewsDto newsDto) {
        ErrorNotification errorNotification = newsValidation.validate(newsDto);
        if (errorNotification.hasErrors()){
            throw new InvalidDataException(errorNotification.getErrorList().toString());
        }
        News news = newsRepository.create(NewsMapper.newsMapper.news(newsDto));
        return NewsMapper.newsMapper.newsDto(news);
    }

    @Override
    public NewsDto update(NewsDto newsDto) {
        News news = newsRepository.getById(newsDto.getId());
        if (news == null){
            throw new NoSuchEntityException("This entity does not exist");
        }

        ErrorNotification errorNotification = newsValidation.validate(newsDto);
        if (errorNotification.hasErrors()){
            throw new InvalidDataException(errorNotification.getErrorList().toString());
        }
        newsDto.setCreateDate(news.getCreateDate());
        return NewsMapper.newsMapper.newsDto(newsRepository.update(NewsMapper.newsMapper.news(newsDto)));
    }

    @Override
    public NewsDto getById(Long id) {
        News byId = newsRepository.getById(id);
        if (byId == null){
            throw new NoSuchEntityException("This entity does not exist");
        }
        return NewsMapper.newsMapper.newsDto(byId);
    }

    @Override
    public List<NewsDto> getAll() {
        return NewsMapper.newsMapper.toListDto(newsRepository.getAll());
    }

    @Override
    public NewsDto delete(Long id) {
        News delete = newsRepository.delete(id);
        if (delete == null){
            throw new NoSuchEntityException("This entity does not exist");
        }
        return NewsMapper.newsMapper.newsDto(delete);
    }
}