package com.example.todo.todos.model;

import javax.persistence.*;

@Entity
@Table(name="todo")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fullName;
    private String email;
    private String todoMessage;

    public Todo() {

    }

    public Todo(Integer id, String fullName, String email, String todoMessage) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.todoMessage = todoMessage;
    }

    public Todo(String fullName, String email, String todoMessage) {
        this.fullName = fullName;
        this.email = email;
        this.todoMessage = todoMessage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTodoMessage() {
        return todoMessage;
    }

    public void setTodoMessage(String todoMessage) {
        this.todoMessage = todoMessage;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", todoMessage='" + todoMessage + '\'' +
                '}';
    }
}