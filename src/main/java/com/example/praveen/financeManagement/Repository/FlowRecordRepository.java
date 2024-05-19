package com.example.praveen.financeManagement.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.praveen.financeManagement.Model.FlowRecord;

public interface FlowRecordRepository extends MongoRepository<FlowRecord, String> {

}
