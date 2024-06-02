package com.example.praveen.financeManagement.Repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.example.praveen.financeManagement.Model.FlowRecord;

public interface FlowRecordRepository extends ReactiveMongoRepository<FlowRecord, String> {

}
