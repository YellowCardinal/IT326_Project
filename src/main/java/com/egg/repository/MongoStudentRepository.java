package com.egg.repository;

import com.egg.model.Student;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.mongodb.core.query.Criteria.where;

/** MongoTemplate-backed implementation of {@link StudentRepository}. */
@Repository
public class MongoStudentRepository implements StudentRepository {

    private final MongoTemplate mongoTemplate;

    public MongoStudentRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Student save(Student student) {
        return mongoTemplate.save(student);
    }

    @Override
    public Optional<Student> findById(String id) {
        return Optional.ofNullable(mongoTemplate.findById(id, Student.class));
    }

    @Override
    public List<Student> findAll() {
        return mongoTemplate.findAll(Student.class);
    }

    @Override
    public void deleteById(String id) {
        mongoTemplate.remove(new Query(where("_id").is(id)), Student.class);
    }
}
