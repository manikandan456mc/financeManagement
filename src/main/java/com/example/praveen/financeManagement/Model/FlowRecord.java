package com.example.praveen.financeManagement.Model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import com.example.praveen.financeManagement.Payload.FlowRecordCreateReq;

import lombok.*;

@Getter
@Setter
@Document(collection = "record")

public class FlowRecord {

    public String id;
    public FundType type;
    public String CategoryId;
    public String notes;
    public Double amount;
    public Date DateTime;
    public Date created;
    public Date updated;

    public FlowRecord(FlowRecordCreateReq recordCreateReq) {
        this.id = recordCreateReq.id;
        this.type = recordCreateReq.Type;
        this.CategoryId = recordCreateReq.CategoryId;
        this.notes = recordCreateReq.notes;
        this.amount = recordCreateReq.amount;
        this.DateTime = recordCreateReq.DateTime;
        this.created = new Date();
        this.updated = new Date();
    }
}
