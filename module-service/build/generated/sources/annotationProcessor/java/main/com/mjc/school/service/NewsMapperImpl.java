package com.mjc.school.service;

import com.mjc.school.repository.entity.News;
import com.mjc.school.service.dto.NewsDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-09T15:31:51+0500",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.2.jar, environment: Java 17 (Oracle Corporation)"
)
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
    public List<NewsDto> toListDto(List<News> newsModelList) {
        if ( newsModelList == null ) {
            return null;
        }

        List<NewsDto> list = new ArrayList<NewsDto>( newsModelList.size() );
        for ( News news : newsModelList ) {
            list.add( newsDto( news ) );
        }

        return list;
    }
}
