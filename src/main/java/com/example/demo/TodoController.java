package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class TodoController {

    private List<Todo> todoList = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    public TodoController() {
//        todoList.add(new Todo(1, "learn java"));
//        todoList.add(new Todo(2, "learn nodejs"));
//        todoList.add(new Todo(3, "learn python"));
    }

    @GetMapping("todo")
    public List<Todo> getTodo() {
        return todoList;
    }

    @GetMapping("todo/{id}")
    public Todo getTodoById(@PathVariable long id) {
        Todo todoById = todoList.stream().filter(todo -> todo.getId() == id).findFirst().orElseGet(() -> null);
        return todoById;
    }

    @GetMapping("todo/search")
    public String getTodyByName(@RequestParam(defaultValue = "test") String name) {
        return "search with name: " + name;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("todo")
    public String insertTodo(@RequestBody Todo todo) {
        todoList.add(new Todo(counter.getAndIncrement() + 1, todo.getName()));

        return "insert success";
    }

    @PutMapping("todo/{id}")
    public String updateTodo(@RequestBody Todo form, @PathVariable long id) {
        todoList
                .stream()
                .filter(todo -> todo.getId() == id)
                .findFirst()
                .ifPresentOrElse(
                        todo -> todo.setName(form.getName()),
                        () -> {}
                );

        return "Update todo id: " + id + " successfully";
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("todo/{id}")
    public String deleteTodo(@PathVariable long id) {
        todoList
                .stream()
                .filter(todo -> todo.getId() == id)
                .findFirst()
                .ifPresentOrElse(
                        todo -> todoList.remove(todo),
                        () -> { }
                );
        return "";
    }
}