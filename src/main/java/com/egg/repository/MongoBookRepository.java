package com.egg.repository;

import com.egg.model.Book;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.mongodb.core.query.Criteria.where;

/** MongoTemplate-backed implementation of BookRepository. */
@Repository
public class MongoBookRepository implements BookRepository {

    private final MongoTemplate mongoTemplate;

    public MongoBookRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Book save(Book book) {
        return mongoTemplate.save(book);
    }

    @Override
    public Optional<Book> findById(String id) {
        return Optional.ofNullable(mongoTemplate.findById(id, Book.class));
    }

    @Override
    public List<Book> findAll() {
        return mongoTemplate.findAll(Book.class);
    }

    @Override
    public void deleteById(String id) {
        mongoTemplate.remove(new Query(where("_id").is(id)), Book.class);
    }
}
