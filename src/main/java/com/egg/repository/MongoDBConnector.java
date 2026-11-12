package com.egg.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

/** Creates the MongoDB client used by Spring Data repositories. */
@Configuration
public class MongoDBConnector extends DatabaseConnector<MongoClient> {

    private final String connectionString;

    public MongoDBConnector(@Value("${spring.mongodb.uri}") String connectionString) {
        this.connectionString = connectionString;
    }

    @Override
    @Bean(destroyMethod = "close")
    public MongoClient createConnection() {
        return MongoClients.create(connectionString);
    }
}
