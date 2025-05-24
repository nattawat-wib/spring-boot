package com.example.demo.controller;

import com.example.demo.model.ApiResponse;
import com.example.demo.model.Person;
import com.example.demo.repository.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("person")
public class PersonController {

    private final PersonDAO personDao;

    @Autowired
    public PersonController(PersonDAO personDao) {
        this.personDao = personDao;
    }

    @PostMapping("")
    public ApiResponse InsertPerson(@RequestBody Person form) {
        Person newPerson = new Person(form.getFname(), form.getLname());
        personDao.save(newPerson);

        return new ApiResponse(201, "insert person successfully");
    }

    @DeleteMapping("{id}")
    public ApiResponse deletePerson(@PathVariable int id) {
        personDao.delete(id);

        return new ApiResponse(200, "delete person successfully");
    }

    @GetMapping("")
    public ApiResponse getPerson(@RequestParam(required = false) String id) {
        if(id != null && !id.isEmpty()) {
            Person person = personDao.get(id);
            return new ApiResponse(200, "get user successfully", person);
        } else {
            List<Person> personList = personDao.getAll();
            return new ApiResponse(200, "get user successfully", personList);
        }
    }

    @GetMapping("{id}")
    public ApiResponse getAllPerson() {
        List<Person> allPerson = personDao.getAll();

        return new ApiResponse(200, "get user successfully", allPerson);
    }

    @PutMapping("{id}")
    public ApiResponse updatePerson(@PathVariable String id, @RequestBody Person person) {

        Person updatePerson = personDao.get(id);

        updatePerson.setFname(person.getFname());
        updatePerson.setLname(person.getLname());

        personDao.update(updatePerson);

        return new ApiResponse(200, "update person successfully");
    }
}
