package com.mjc.school.controller.impl;

import com.mjc.school.controller.Controller;
import com.mjc.school.service.Service;
import com.mjc.school.service.dto.NewsDto;

import java.util.List;

public class NewsController implements Controller<NewsDto> {
    private final Service<NewsDto> newsService;
    public NewsController(Service<NewsDto> newsService) {
        this.newsService = newsService;
    }

    @Override
    public NewsDto create(NewsDto newsDto) {
        return newsService.create(newsDto);
    }

    @Override
    public NewsDto update(NewsDto newsDto) {
        return newsService.update(newsDto);
    }

    @Override
    public NewsDto readById(Long id) {
        return newsService.readById(id);
    }

    @Override
    public List<NewsDto> readAll() {
        return newsService.readAll();
    }

    @Override
    public Boolean delete(Long id) {
        return newsService.delete(id);
    }
}
