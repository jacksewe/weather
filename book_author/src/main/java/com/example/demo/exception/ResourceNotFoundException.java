package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String resourceName, String fieldName,
            Object fieldValue) {
        super(String.format("%s not found with 5s : '%s'", resourceName,
                fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    private String resourceName;
    private String fieldName;
    private Object fieldValue;

    public String getResourceName() {
        return this.resourceName;
    }

    public String getFieldName() {
        return this.fieldName;
    }

    public Object getFieldValue() {
        return this.fieldValue;
    }

}
