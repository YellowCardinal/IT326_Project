package com.egg.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "books")
public class Book extends Item implements BookOperations {

    private String isbn;
    private String title;
    private String author;

    @Override
    public String getBookDetails() {
        return "ISBN: " + isbn
                + ", Title: " + title
                + ", Author: " + author;
    }

    public String getTitle() {
        return title;
    }
}
