package com.egg.repository;

import com.egg.model.Dispute;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.mongodb.core.query.Criteria.where;

/** MongoTemplate-backed implementation of {@link DisputeRepository}. */
@Repository
public class MongoDisputeRepository implements DisputeRepository {

    private final MongoTemplate mongoTemplate;

    public MongoDisputeRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Dispute save(Dispute dispute) {
        return mongoTemplate.save(dispute);
    }

    @Override
    public Optional<Dispute> findById(String id) {
        return Optional.ofNullable(mongoTemplate.findById(id, Dispute.class));
    }

    @Override
    public List<Dispute> findAll() {
        return mongoTemplate.findAll(Dispute.class);
    }

    @Override
    public void deleteById(String id) {
        mongoTemplate.remove(new Query(where("_id").is(id)), Dispute.class);
    }
}