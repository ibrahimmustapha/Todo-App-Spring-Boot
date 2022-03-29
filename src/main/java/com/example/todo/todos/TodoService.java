package com.example.todo.todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    public Todo updateTodo(Todo todo, Integer todoId) {
        Todo existingTodo = todoRepository.findById(todoId)
                        .orElseThrow(() -> new IllegalStateException("Employer not found for the id::" + todoId));
        existingTodo.setFullName(todo.getFullName());
        existingTodo.setEmail(todo.getEmail());
        existingTodo.setTodoMessage(todo.getTodoMessage());
        Todo updatedTodo = todoRepository.save(existingTodo);
        return updatedTodo;
    }

    public String deleteTodo(Integer id) {
        todoRepository.deleteById(id);
        return "Todo deleted successfully " + id;
    }
}