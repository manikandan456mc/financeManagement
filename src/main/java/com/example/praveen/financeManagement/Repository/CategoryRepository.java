package com.example.praveen.financeManagement.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.praveen.financeManagement.Model.Category;

public interface CategoryRepository extends MongoRepository<Category, String> {

}
