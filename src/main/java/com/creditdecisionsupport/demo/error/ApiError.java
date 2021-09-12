package com.creditdecisionsupport.demo.error;

import lombok.Data;

import java.util.Date;
import java.util.Map;

@Data
public class ApiError {

    private String message;
    private String path;
    private int status;

    public ApiError(String message, String path, int status) {
        this.message = message;
        this.path = path;
        this.status = status;
    }

    private Date errorDate = new Date(System.currentTimeMillis());
    private Map<String, String> validationErrors;
}
