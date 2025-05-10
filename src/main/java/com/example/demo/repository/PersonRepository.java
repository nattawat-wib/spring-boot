package com.example.demo.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Person;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class PersonRepository implements PersonDAO {
    private final EntityManager entityManager;

    @Autowired
    public PersonRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Person person) {
        entityManager.persist(person);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Person person = entityManager.find(Person.class, id);
        entityManager.remove(person);
    }

    @Override
    public Person get(String id) {
        return entityManager.find(Person.class, id);
    }

    @Override
    public List<Person> getAll() {
        TypedQuery<Person> query = entityManager.createQuery("FROM Person", Person.class);

        System.out.println(query);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Person person) {
        entityManager.merge(person);
    }
}
