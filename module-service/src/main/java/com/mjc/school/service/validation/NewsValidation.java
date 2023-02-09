package com.mjc.school.service.validation;

import com.mjc.school.repository.impl.AuthorRepository;
import com.mjc.school.service.dto.NewsDto;
import com.mjc.school.service.exception.ErrorNotification;

public class NewsValidation {
    private final String VALIDATION_TITLE = "News title field should have length of value from 5 to 30.";
    private final String VALIDATION_CONTENT = "News content field should have length of value from 5 to 255.";
    private final String VALIDATION_AUTHOR = "Author with id does not exist.";
    private final AuthorRepository authorRepository;

    public NewsValidation() {
        this.authorRepository = new AuthorRepository();
    }

    public ErrorNotification validate (NewsDto news) {
        ErrorNotification errorNotification = new ErrorNotification();

        String title = news.getTitle();
        String content = news.getContent();
        Long authorId = news.getAuthorId();

        if (title.length() < 5 || title.length() > 30)
            errorNotification.addError(VALIDATION_TITLE + " Title length is " + title.length() + ".");

        if (content.length() < 5 || content.length() > 255)
            errorNotification.addError(VALIDATION_CONTENT + " Content length is " + content.length() + ".");

        if (authorRepository.readById(authorId) == null) {
            errorNotification.addError(String.format(VALIDATION_AUTHOR, authorId));
        }

        return errorNotification;
    }
}
