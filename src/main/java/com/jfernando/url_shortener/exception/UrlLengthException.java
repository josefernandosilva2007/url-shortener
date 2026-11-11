package com.jfernando.url_shortener.exception;

public class UrlLengthException extends RuntimeException {
    public UrlLengthException(String message) {
        super(message);
    }
}
