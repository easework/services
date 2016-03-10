package com.ews.services.auth.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import com.ews.services.auth.domain.ApplicationUser;

@Component("applicationUserRepository")
public interface ApplicationUserRepository extends MongoRepository<ApplicationUser, String> {
	public ApplicationUser findByUsername(String username);

}
