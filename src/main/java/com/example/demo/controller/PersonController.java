package com.example.demo.controller;

import com.example.demo.model.ApiResponse;
import com.example.demo.model.Person;
import com.example.demo.repository.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    private final PersonDAO personDao;

    @Autowired
    public PersonController(PersonDAO personDao) {
        this.personDao = personDao;
    }

    @PostMapping("person")
    public ApiResponse InsertPerson(@RequestBody Person form) {
        Person newPerson = new Person(form.getFname(), form.getLname());
        personDao.save(newPerson);

        return new ApiResponse(201, "insert person successfully");
    }

    @DeleteMapping("person/{id}")
    public ApiResponse deletePerson(@PathVariable int id) {
        personDao.delete(id);

        return new ApiResponse(200, "delete person successfully");
    }

    @GetMapping("person")
    public ApiResponse getPerson(@RequestParam String id) {
        Person person = personDao.get(id);

        System.out.println(person);

        return new ApiResponse(200, "get user successfully", person);
    }

    @GetMapping("persons")
    public ApiResponse getAllPerson() {
        List<Person> allPerson = personDao.getAll();

        return new ApiResponse(200, "get user successfully", allPerson);
    }

    @PutMapping("person/{id}")
    public ApiResponse updatePerson(@PathVariable String id, @RequestBody Person person) {

        Person updatePerson = personDao.get(id);

        updatePerson.setFname(person.getFname());
        updatePerson.setLname(person.getLname());

        personDao.update(updatePerson);

        return new ApiResponse(200, "update person successfully");
    }
}
