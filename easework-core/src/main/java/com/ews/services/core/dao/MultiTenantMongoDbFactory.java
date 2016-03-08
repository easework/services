package com.ews.services.core.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;

public class MultiTenantMongoDbFactory extends SimpleMongoDbFactory {

	@Autowired
	public MultiTenantMongoDbFactory(MongoClient mongoClient, String databaseName) {
		super(mongoClient, databaseName);
	}
	
	

}
