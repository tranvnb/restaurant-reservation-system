package com.csis3275.group4.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.csis3275.group4.entity.User;

public interface UserRepository extends MongoRepository<User, Integer>{

}
