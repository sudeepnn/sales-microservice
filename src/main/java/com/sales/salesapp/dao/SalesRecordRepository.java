package com.sales.salesapp.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sales.salesapp.entity.SalesRecord;

@Repository
public interface SalesRecordRepository extends MongoRepository<SalesRecord, Long> {

}
