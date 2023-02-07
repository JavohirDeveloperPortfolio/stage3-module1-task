package com.mjc.school.repository.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicLong;

@Getter
@Setter
public class Author {
    private static AtomicLong nextId = new AtomicLong();

    private Long id;
    private String name;

    public Author(){
        this.id = nextId.getAndIncrement();
    }

    public Author(String name){
        this.id = nextId.getAndIncrement();
        this.name = name;
    }
}
