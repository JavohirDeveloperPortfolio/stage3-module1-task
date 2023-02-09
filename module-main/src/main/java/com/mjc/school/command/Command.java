package com.mjc.school.command;

public interface Command<T> {
    void execute(T controller);
}
