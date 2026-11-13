
package com.egg.service;

import com.egg.model.Book;
import com.egg.repository.BookRepository;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findBooksByTitle(String title) {
        return bookRepository.findAll().stream()
                .filter(book -> book.getTitle() != null
                        && book.getTitle().toLowerCase()
                                .contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }
}
