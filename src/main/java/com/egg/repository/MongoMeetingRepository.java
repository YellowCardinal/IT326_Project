package com.egg.repository;

import com.egg.model.Meeting;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import static org.springframework.data.mongodb.core.query.Criteria.where;

/** MongoTemplate-backed implementation of {@link MeetingRepository} */
@Repository 
public class MongoMeetingRepository implements  MeetingRepository{
    
    private final MongoTemplate mongoTemplate;

    public MongoMeetingRepository(MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
    }

    @Override 
    public Meeting save(Meeting meeting){
        return mongoTemplate.save(meeting);
    }

    @Override
    public Optional<Meeting> findById(String id) {
        return Optional.ofNullable(mongoTemplate.findById(id, Meeting.class));
    }

    @Override
    public List<Meeting> findAll() {
        return mongoTemplate.findAll(Meeting.class);
    }

    @Override
    public void deleteById(String id) {
        mongoTemplate.remove(new Query(where("_id").is(id)), Meeting.class);
    }
}
