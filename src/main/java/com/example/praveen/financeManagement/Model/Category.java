package com.example.praveen.financeManagement.Model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import com.example.praveen.financeManagement.Payload.CategoryCreateReq;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Document(collection = "category")

public class Category {
    public String id;
    public String name;
    public FundType type;
    public String description;
    public String iconName;
    public Date created;
    public Date Updated;

    public Category(CategoryCreateReq categoryCreateReq) {
        this.id = categoryCreateReq.id;
        this.name = categoryCreateReq.name;
        this.type = categoryCreateReq.type;
        this.description = categoryCreateReq.description;
        this.iconName = categoryCreateReq.iconName;
        this.created = new Date();
        this.Updated = new Date();
    }

}
