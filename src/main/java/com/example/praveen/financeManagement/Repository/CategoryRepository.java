package com.example.praveen.financeManagement.Repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.example.praveen.financeManagement.Model.Category;

public interface CategoryRepository extends ReactiveMongoRepository<Category, String> {

}
