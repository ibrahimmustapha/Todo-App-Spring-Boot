package com.example.todo.todos.dao;

import com.example.todo.todos.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TodoRepository extends JpaRepository <Todo, Integer> {
    Optional<Todo> findTodoByEmail(String email);
}
