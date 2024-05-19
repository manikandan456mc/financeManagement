package com.example.praveen.financeManagement.Model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class DataResponse {
    public Object data;
    public Object error;
    public Object message;

}
