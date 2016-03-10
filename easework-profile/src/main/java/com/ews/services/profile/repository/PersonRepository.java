package com.ews.services.profile.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ews.services.profile.domain.Person;

public interface PersonRepository extends MongoRepository<Person, String> {

}
