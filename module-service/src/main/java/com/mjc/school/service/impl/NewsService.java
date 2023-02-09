package com.mjc.school.service.impl;

import com.mjc.school.repository.Repository;
import com.mjc.school.repository.entity.NewsModel;
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
    private final Repository<NewsModel> newsRepository;
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
        NewsModel newsModel = newsRepository.create(NewsMapper.newsMapper.news(newsDto));
        return NewsMapper.newsMapper.newsDto(newsModel);
    }

    @Override
    public NewsDto update(NewsDto newsDto) {
        NewsModel newsModel = newsRepository.readById(newsDto.getId());
        if (newsModel == null){
            throw new NoSuchEntityException("This entity does not exist");
        }

        ErrorNotification errorNotification = newsValidation.validate(newsDto);
        if (errorNotification.hasErrors()){
            throw new InvalidDataException(errorNotification.getErrorList().toString());
        }
        newsDto.setCreateDate(newsModel.getCreateDate());
        return NewsMapper.newsMapper.newsDto(newsRepository.update(NewsMapper.newsMapper.news(newsDto)));
    }

    @Override
    public NewsDto readById(Long id) {
        NewsModel byId = newsRepository.readById(id);
        if (byId == null){
            throw new NoSuchEntityException("This entity does not exist");
        }
        return NewsMapper.newsMapper.newsDto(byId);
    }

    @Override
    public List<NewsDto> readAll() {
        return NewsMapper.newsMapper.toListDto(newsRepository.readAll());
    }

    @Override
    public Boolean delete(Long id) {
        if (!newsRepository.delete(id)){
            throw new NoSuchEntityException("This entity does not exist");
        }
        return true;
    }
}
