package com.csis3275.group4.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.csis3275.group4.entity.Service;

public interface ServiceRepository extends MongoRepository<Service, Integer>{

}
