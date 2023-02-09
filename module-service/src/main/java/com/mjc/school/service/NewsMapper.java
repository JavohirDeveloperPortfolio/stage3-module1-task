package com.mjc.school.service;

import com.mjc.school.repository.entity.News;
import com.mjc.school.service.dto.NewsDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface NewsMapper {
    NewsMapper newsMapper = Mappers.getMapper(NewsMapper.class);
    NewsDto newsDto(News news);
    News news(NewsDto newsDto);
    List<NewsDto> toListDto (List<News> newsModelList);
}
