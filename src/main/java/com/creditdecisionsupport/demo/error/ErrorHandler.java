package com.creditdecisionsupport.demo.error;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.*;

@RestController
public class ErrorHandler implements ErrorController {

    @Autowired
    private ErrorAttributes errorAttributes;

    @RequestMapping("/error")
    ApiError handleError(WebRequest webRequest){

        Map<String,Object> attributes = this.errorAttributes.getErrorAttributes(webRequest,true);

        String message = (String) attributes.get("message");
        String path = (String) attributes.get("path");
        int status =(Integer) attributes.get("status");

        List<FieldError> fieldErrors =  (List<FieldError>) attributes.get("errors");

        Map<String,String> validationErrors = new HashMap<>();

        for(FieldError fieldError:fieldErrors){
            validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
        }

        ApiError error = new ApiError(message,path,status);
        error.setValidationErrors(validationErrors);

        return error;

    }

    @Override
    public String getErrorPath() {
        return null;
    }
}