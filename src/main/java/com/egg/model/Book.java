package com.egg.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "books")
public class Book extends Item {

    private String isbn;
    private String title;
    private String author;

    public String getBookDetails() {
        return "ISBN: " + isbn
                + ", Title: " + title
                + ", Author: " + author;
    }
}
