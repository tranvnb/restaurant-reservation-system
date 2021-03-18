package com.csis3275.group4.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.csis3275.group4.entity.Report;

public interface ReportRepository extends MongoRepository<Report, Integer> {

}
