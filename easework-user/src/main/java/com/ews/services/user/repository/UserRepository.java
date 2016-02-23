package com.ews.services.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ews.services.user.domain.User;

public interface UserRepository extends MongoRepository<User, String> {

}
