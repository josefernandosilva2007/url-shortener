package com.jfernando.url_shortener.exception;

public class InvalidSlugException extends RuntimeException {
    public InvalidSlugException(String message) {
        super(message);
    }
}
