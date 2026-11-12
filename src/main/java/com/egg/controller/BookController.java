package com.egg.controller;

import com.egg.model.Book;
import com.egg.service.BookService;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books/search")
    public List<Book> searchBook(@RequestParam String title) {
        return bookService.findBooksByTitle(title);
    }
}

