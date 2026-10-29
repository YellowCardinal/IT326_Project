package com.egg.repository;

import com.egg.model.Admin;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.mongodb.core.query.Criteria.where;

/** MongoTemplate-backed implementation of {@link AdminRepository}. */
@Repository
public class MongoAdminRepository implements AdminRepository {

    private final MongoTemplate mongoTemplate;

    public MongoAdminRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Admin save(Admin admin) {
        return mongoTemplate.save(admin);
    }

    @Override
    public Optional<Admin> findById(String id) {
        return Optional.ofNullable(mongoTemplate.findById(id, Admin.class));
    }

    @Override
    public List<Admin> findAll() {
        return mongoTemplate.findAll(Admin.class);
    }

    @Override
    public void deleteById(String id) {
        mongoTemplate.remove(new Query(where("_id").is(id)), Admin.class);
    }
}
