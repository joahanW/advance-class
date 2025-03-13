package com.metrodata.advance_class.exception;

import lombok.Data;

@Data
public class CustomException extends RuntimeException{

    private int status;

    public CustomException(String message, int status) {
        super(message);
        this.status = status;
    }
}
