package com.example.todo.todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    // get all todos
    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }

    // get a todo
    public Todo getTodo(Integer todoId) {
        return todoRepository.findById(todoId)
                .orElseThrow(() ->
                    new IllegalStateException("Todo not found with id::" + todoId));
    }

    // add new todo to the database
    public void addNewTodo(Todo todo) {
        Optional<Todo> studentOptional = todoRepository.findTodoByEmail(todo.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
            todoRepository.save(todo);
    }

    // update or edit existing todo
    public Todo updateTodo(Todo todo, Integer todoId) {
        Todo existingTodo = todoRepository.findById(todoId)
                        .orElseThrow(() -> new IllegalStateException("Todo not found for the id::" + todoId));
        existingTodo.setFullName(todo.getFullName());
        existingTodo.setEmail(todo.getEmail());
        existingTodo.setTodoMessage(todo.getTodoMessage());
        return todoRepository.save(existingTodo);
    }

    // delete a todo
    public String deleteTodo(Integer id) {
        todoRepository.deleteById(id);
        return "Todo deleted successfully " + id;
    }

    // delete all todos in the database
    public void deleteAllTodos(Todo todo) {
        todoRepository.deleteAll();
    }
}