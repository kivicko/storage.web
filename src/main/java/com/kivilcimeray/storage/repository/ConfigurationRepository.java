package com.kivilcimeray.storage.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.kivilcimeray.storage.model.Configuration;

@Repository
public interface ConfigurationRepository extends MongoRepository<Configuration, String> {

	List<Configuration> findByNameLike(String name);
	
}
