package com.example.demo.domain.exception;

public class TaskIntegrityViolationException extends RuntimeException {

    public TaskIntegrityViolationException(String msg) {
        super(msg);
    }

}
