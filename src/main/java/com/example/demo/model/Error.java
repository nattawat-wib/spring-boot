package com.example.demo.model;

public class Error extends RuntimeException{
    public Error(String errorMessage) {
        super(errorMessage);
    }
}
