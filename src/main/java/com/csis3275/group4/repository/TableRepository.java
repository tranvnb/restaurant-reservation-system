package com.csis3275.group4.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.csis3275.group4.entity.Table;

public interface TableRepository extends MongoRepository<Table, String>{

}
