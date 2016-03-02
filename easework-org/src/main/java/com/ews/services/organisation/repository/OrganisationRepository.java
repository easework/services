package com.ews.services.organisation.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ews.services.organisation.domain.Organisation;

public interface OrganisationRepository extends MongoRepository<Organisation, String> {

}
