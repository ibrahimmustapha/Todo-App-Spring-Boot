package com.example.todo.todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/v1/todos")
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public @ResponseBody List<Todo> getTodos() {
        return todoService.getTodos();
    }

    @PostMapping
    public void addNewTodo(@RequestBody Todo todo) {
        todoService.addNewTodo(todo);
    }

    @PutMapping(path="/update")
    public Todo updateTodo(@RequestBody Todo todo) {
        return todoService.updateTodo(todo);
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteTodo(@PathVariable Integer id) {
        return todoService.deleteTodo(id);
    }
}
