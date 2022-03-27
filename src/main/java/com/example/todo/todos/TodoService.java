package com.example.todo.todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }

    public void addNewTodo(Todo todo) {
        Optional<Todo> studentOptional = todoRepository.findTodoByEmail(todo.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
            todoRepository.save(todo);
    }

    public Todo updateTodo(Todo todo) {
        Todo existingTodo = todoRepository.findById(todo.getId()).orElse(null);
        existingTodo.setFullName(todo.getFullName());
        existingTodo.setEmail(todo.getEmail());
        existingTodo.setTodoMessage(todo.getTodoMessage());
        return todoRepository.save(existingTodo);
    }

    public String deleteTodo(Integer id) {
        todoRepository.deleteById(id);
        return "Todo deleted successfully " + id;
    }
}

// Belinda Malm - 10283690
