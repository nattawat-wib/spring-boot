package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse {
    private int status ;
    private String message ;
    private Person person;
    private List<Person> allPerson;

    public ApiResponse(int status, String message, Person person) {
        this.status = status;
        this.message = message;
        this.person = person;
    }

    public ApiResponse(int status, String message, List<Person> allPerson) {
        this.status = status;
        this.message = message;
        this.allPerson = allPerson;
    }

    public ApiResponse(int status, String message) {
        this.status = status;
        this.message = message;
        this.person = null;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Person> getAllPerson() {
        return allPerson;
    }

    public void setAllPerson(List<Person> allPerson) {
        this.allPerson = allPerson;
    }
}
