package com.mjc.school.service;

import com.mjc.school.repository.entity.NewsModel;
import com.mjc.school.service.dto.NewsDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-09T16:04:39+0500",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.2.jar, environment: Java 17 (Oracle Corporation)"
)
public class NewsMapperImpl implements NewsMapper {

    @Override
    public NewsDto newsDto(NewsModel newsModel) {
        if ( newsModel == null ) {
            return null;
        }

        NewsDto newsDto = new NewsDto();

        newsDto.setId( newsModel.getId() );
        newsDto.setTitle( newsModel.getTitle() );
        newsDto.setContent( newsModel.getContent() );
        newsDto.setAuthorId( newsModel.getAuthorId() );
        newsDto.setCreateDate( newsModel.getCreateDate() );
        newsDto.setLastUpdateDate( newsModel.getLastUpdateDate() );

        return newsDto;
    }

    @Override
    public NewsModel news(NewsDto newsDto) {
        if ( newsDto == null ) {
            return null;
        }

        NewsModel newsModel = new NewsModel();

        newsModel.setId( newsDto.getId() );
        newsModel.setTitle( newsDto.getTitle() );
        newsModel.setContent( newsDto.getContent() );
        newsModel.setCreateDate( newsDto.getCreateDate() );
        newsModel.setLastUpdateDate( newsDto.getLastUpdateDate() );
        newsModel.setAuthorId( newsDto.getAuthorId() );

        return newsModel;
    }

    @Override
    public List<NewsDto> toListDto(List<NewsModel> newsModelModelList) {
        if ( newsModelModelList == null ) {
            return null;
        }

        List<NewsDto> list = new ArrayList<NewsDto>( newsModelModelList.size() );
        for ( NewsModel newsModel : newsModelModelList ) {
            list.add( newsDto( newsModel ) );
        }

        return list;
    }
}
