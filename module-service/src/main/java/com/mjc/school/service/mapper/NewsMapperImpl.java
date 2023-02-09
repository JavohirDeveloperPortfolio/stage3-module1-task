package com.mjc.school.service.mapper;

import com.mjc.school.repository.entity.News;
import com.mjc.school.service.NewsMapper;
import com.mjc.school.service.dto.NewsDto;

import java.util.ArrayList;
import java.util.List;

public class NewsMapperImpl implements NewsMapper {
    @Override
    public NewsDto newsDto(News news) {
        if ( news == null ) {
            return null;
        }

        NewsDto newsDto = new NewsDto();

        newsDto.setId( news.getId() );
        newsDto.setTitle( news.getTitle() );
        newsDto.setContent( news.getContent() );
        newsDto.setAuthorId( news.getAuthorId() );
        newsDto.setCreateDate( news.getCreateDate() );
        newsDto.setLastUpdateDate( news.getLastUpdateDate() );

        return newsDto;
    }

    @Override
    public News news(NewsDto newsDto) {
        if ( newsDto == null ) {
            return null;
        }

        News news = new News();

        news.setId( newsDto.getId() );
        news.setTitle( newsDto.getTitle() );
        news.setContent( newsDto.getContent() );
        news.setCreateDate( newsDto.getCreateDate() );
        news.setLastUpdateDate( newsDto.getLastUpdateDate() );
        news.setAuthorId( newsDto.getAuthorId() );

        return news;
    }

    @Override
    public List<NewsDto> toListDto(List<News> newsList) {
        if ( newsList == null ) {
            return null;
        }

        List<NewsDto> list = new ArrayList<NewsDto>( newsList.size() );
        for ( News news : newsList ) {
            list.add( newsDto( news ) );
        }

        return list;
    }
}
