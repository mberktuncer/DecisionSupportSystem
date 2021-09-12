package com.creditdecisionsupport.demo.response;

import lombok.Data;

@Data
public class DeleteCustomerResponse {
    private String identityNumber;
    private String message;
    private int code;
}
