package com.test.exception;

public class PasswordNullException extends RuntimeException {
    public PasswordNullException(String msg) {
        super(msg);
    }
}
