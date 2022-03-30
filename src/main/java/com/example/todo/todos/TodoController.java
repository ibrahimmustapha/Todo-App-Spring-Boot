package com.example.todo.todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping // returns all todos
    public @ResponseBody List<Todo> getTodos() {
        return todoService.getTodos();
    }

    @GetMapping(path="/todo/{id}") // returns a single todo based on id
    @ResponseStatus(value = HttpStatus.OK)
    public Todo getTodo(@PathVariable("id") Integer todoId) {
        return todoService.getTodo(todoId);
    }

    @PostMapping // adds new todo to the database
    public void addNewTodo(@RequestBody Todo todo) {
        todoService.addNewTodo(todo);
    }

    @PutMapping(path="/update/{id}", consumes={"application/json"}) // updates an existing todo
    public Todo updateTodo(@PathVariable("id") Integer todoId, @RequestBody Todo todo) {
        return todoService.updateTodo(todo, todoId);
    }

    @DeleteMapping(path = "/delete/{id}") // delete a todo
    public String deleteTodo(@PathVariable Integer id) {
        return todoService.deleteTodo(id);
    }

    @DeleteMapping(path = "/delete-all-todos")
    public void deleteAllTodos(Todo todo) {
        todoService.deleteAllTodos(todo);
    }
}
