package com.example.demo.repository;

import com.example.demo.model.Person;

import java.util.List;

public interface PersonDAO {
    void save(Person person);
    void delete(int id);
    Person get(String id);
    List<Person> getAll();
    void update(Person person);
}
