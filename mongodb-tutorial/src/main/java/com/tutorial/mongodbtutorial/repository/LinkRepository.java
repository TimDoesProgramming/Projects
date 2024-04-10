package com.tutorial.mongodbtutorial.repository;

import com.tutorial.mongodbtutorial.model.Link;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface LinkRepository extends MongoRepository<Link, String> {
        @Query("{'link': ?0}")
        Optional<Link> findByLink(String link);
}
