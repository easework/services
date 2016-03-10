package com.ews.services.organisation.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ews.services.organisation.domain.Department;

public interface DepartmentRepository extends MongoRepository<Department, String> {

}
