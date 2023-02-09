package com.mjc.school.repository.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

@Getter
@Setter
public class NewsModel {

    private static AtomicLong nextId = new AtomicLong();

    private Long id;
    private String title;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdateDate;
    private Long authorId;

    public NewsModel(){
        this.id = nextId.getAndIncrement();
    }

    public NewsModel(String title, String content, Long authorId){
        this.id = nextId.getAndIncrement();
        this.title = title;
        this.content = content;
        this.createDate = LocalDateTime.now();
        this.lastUpdateDate = LocalDateTime.now();
        this.authorId = authorId;
    }
}
