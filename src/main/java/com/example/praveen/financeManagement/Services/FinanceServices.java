package com.example.praveen.financeManagement.Services;

import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

import com.example.praveen.financeManagement.Model.Category;
import com.example.praveen.financeManagement.Model.FlowRecord;
import com.example.praveen.financeManagement.Payload.CategoryCreateReq;
import com.example.praveen.financeManagement.Payload.FlowRecordCreateReq;
import com.example.praveen.financeManagement.Repository.CategoryRepository;
import com.example.praveen.financeManagement.Repository.FlowRecordRepository;

public class FinanceServices {

    public CategoryRepository categoryRepository;
    public FlowRecordRepository flowRecordRepository;

    public FinanceServices(CategoryRepository categoryRepository,
            FlowRecordRepository flowRecordRepository) {
        this.categoryRepository = categoryRepository;
        this.flowRecordRepository = flowRecordRepository;
    }

    public String CategoryCreate(CategoryCreateReq categoryCreateReq) {
        Category category = new Category(categoryCreateReq);
        categoryRepository.save(category);
        return category.id;
    }

    public String RecordCreate(FlowRecordCreateReq recordCreateReq) {
        FlowRecord flowRecord = new FlowRecord(recordCreateReq);
        flowRecordRepository.save(flowRecord);
        return flowRecord.id;
    }

}
