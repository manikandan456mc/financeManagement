package com.example.praveen.financeManagement.Payload;

import java.util.Date;

import com.example.praveen.financeManagement.Model.FundType;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class FlowRecordCreateReq {
    public String id;
    public FundType Type;
    public String CategoryId;
    public String notes;
    public Double amount;
    public Date DateTime;

}
