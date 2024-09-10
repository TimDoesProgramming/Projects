package com.portfolio.website.repository;

import com.portfolio.website.model.Link;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LinkRepository extends MongoRepository<Link, String> {
        @Query("{'link': ?0}")
        Optional<Link> findByLink(String link);
        @Query("{'referenceId': ?0}")
        Optional<List<Link>> findByReferenceId(String referenceId);
}
