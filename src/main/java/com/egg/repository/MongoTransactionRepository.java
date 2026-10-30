
package com.egg.repository;

import com.egg.model.Transaction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Repository
public class MongoTransactionRepository implements TransactionRepository {

    private final MongoTemplate mongoTemplate;

    public MongoTransactionRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Transaction save(Transaction transaction) {
        return mongoTemplate.save(transaction);
    }

    @Override
    public Optional<Transaction> findById(String id) {
        return Optional.ofNullable(
            mongoTemplate.findById(id, Transaction.class)
        );
    }

    @Override
    public List<Transaction> findAll() {
        return mongoTemplate.findAll(Transaction.class);
    }

    @Override
    public void deleteById(String id) {
        mongoTemplate.remove(
            new Query(where("_id").is(id)),
            Transaction.class
        );
    }
}
