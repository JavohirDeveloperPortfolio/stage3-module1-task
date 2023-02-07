package com.mjc.school.repository.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

@Getter
@Setter
public class News {

    private static AtomicLong nextId = new AtomicLong();

    private Long id;
    private String title;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdateDate;
    private Long authorId;

    public News(){
        this.id = nextId.getAndIncrement();
    }

    public News(String title, String content, Long authorId){
        this.id = nextId.getAndIncrement();
        this.title = title;
        this.content = content;
        this.createDate = LocalDateTime.now();
        this.lastUpdateDate = LocalDateTime.now();
        this.authorId = authorId;
    }
}
