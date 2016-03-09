package com.ews.services.activity.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ews.services.activity.domain.Activity;

public interface ActivityRepository extends MongoRepository<Activity, String> {

}
