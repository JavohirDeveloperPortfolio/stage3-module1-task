package com.mjc.school.repository.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicLong;

@Getter
@Setter
public class AuthorModel {
    private static AtomicLong nextId = new AtomicLong();

    private Long id;
    private String name;

    public AuthorModel(){
        this.id = nextId.getAndIncrement();
    }

    public AuthorModel(String name){
        this.id = nextId.getAndIncrement();
        this.name = name;
    }
}
