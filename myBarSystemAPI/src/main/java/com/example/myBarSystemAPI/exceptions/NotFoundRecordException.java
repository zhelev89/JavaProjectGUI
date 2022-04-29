package com.example.myBarSystemAPI.exceptions;

public class NotFoundRecordException extends RuntimeException {
    public NotFoundRecordException(String message) {
        super(message);
    }
}
