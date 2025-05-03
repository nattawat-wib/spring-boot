package com.example.demo;

public class Todo {

    private long id;
    private String Name;

    public Todo() {

    }

    public Todo(long id, String name) {
        this.id = id;
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        Name = name;
    }
}
