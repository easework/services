package com.ews.services.auth.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import com.ews.services.auth.domain.MongoUser;

@Component("applicationUserRepository")
public interface MongoUserRepository extends MongoRepository<MongoUser, String> {
	public MongoUser findByUsername(String username);

}
