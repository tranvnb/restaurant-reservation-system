package com.csis3275.group4.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.csis3275.group4.entity.Table;

import java.util.List;

public interface TableRepository extends MongoRepository<Table, String>{
    List<Table> findByisAvailableIsTrue(boolean isAvailable);
}
