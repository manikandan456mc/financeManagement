package com.example.praveen.financeManagement.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.example.praveen.financeManagement.Model.Category;
import com.example.praveen.financeManagement.Model.FlowRecord;
import com.example.praveen.financeManagement.Model.FundType;
import com.example.praveen.financeManagement.Payload.CategoryCreateReq;
import com.example.praveen.financeManagement.Payload.FlowRecordCreateReq;
import com.example.praveen.financeManagement.Repository.CategoryRepository;
import com.example.praveen.financeManagement.Repository.FlowRecordRepository;

public class FinanceServices {

    public CategoryRepository categoryRepository;
    public FlowRecordRepository flowRecordRepository;
    public ReactiveMongoTemplate reactiveMongoTemplate;

    public FinanceServices(CategoryRepository categoryRepository,
            FlowRecordRepository flowRecordRepository, ReactiveMongoTemplate reactiveMongoTemplate) {
        this.categoryRepository = categoryRepository;
        this.flowRecordRepository = flowRecordRepository;
        this.reactiveMongoTemplate = reactiveMongoTemplate;
    }

    public String CategoryCreate(CategoryCreateReq categoryCreateReq) {
        Category category = new Category(categoryCreateReq);
        categoryRepository.save(category).subscribe();
        return category.id;
    }

    public String RecordCreate(FlowRecordCreateReq recordCreateReq) {
        FlowRecord flowRecord = new FlowRecord(recordCreateReq);
        flowRecordRepository.save(flowRecord).subscribe();
        return flowRecord.id;
    }

    public List<Category> getCategoryByType(FundType type) {
        List<Category> categoryList = new ArrayList<>();
        if (type != null) {
            Criteria filterCriteria = new Criteria().andOperator(Criteria.where("type").is(type));
            Query query = new Query();
            query.addCriteria(filterCriteria);
            categoryList = reactiveMongoTemplate.find(query, Category.class).collectList().blockOptional()
                    .orElse(null);
        } else {
            categoryList = reactiveMongoTemplate.findAll(Category.class).collectList().blockOptional()
                    .orElse(null);
        }
        return categoryList;
    }

    public List<FlowRecord> GetRecordByFundType(FundType type) {
        List<FlowRecord> record = new ArrayList<>();
        if (type != null) {
            Criteria filterCriteria = new Criteria().andOperator(Criteria.where("type").is(type));
            Query query = new Query();
            query.addCriteria(filterCriteria);
            record = reactiveMongoTemplate.find(query, FlowRecord.class).collectList().blockOptional()
                    .orElse(null);
        } else {
            record = reactiveMongoTemplate.findAll(FlowRecord.class).collectList().blockOptional().orElse(null);
        }
        return record;
    }

}
