package com.egg.repository;

import com.egg.model.Book;
import java.util.List;
import java.util.Optional;

/** Data access operations for book documents in the books collection. */
public interface BookRepository {

    Book save(Book book);

    Optional<Book> findById(String id);

    List<Book> findAll();

    void deleteById(String id);
}