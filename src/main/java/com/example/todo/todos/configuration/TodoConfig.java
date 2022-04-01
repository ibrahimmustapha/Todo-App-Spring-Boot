package com.example.todo.todos.configuration;

import com.example.todo.todos.dao.TodoRepository;
import com.example.todo.todos.model.Todo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TodoConfig {

    @Bean
    CommandLineRunner commandLineRunner (TodoRepository todoRepository) {
        return args -> {
            Todo steven = new Todo(
                "Steven Foli",
                "stevenfoli1@gmail.com",
                "I will travel to the volta region"
            );

            Todo abubakar = new Todo(
                    "Abubakar Sadiq",
                    "abubakarsadiq@gmail.com",
                    "I will go the mosque on friday."
            );

            Todo derrick = new Todo(
                    "Derrick Blackson",
                    "derrick@gmail.com",
                    "I will go the mosque on friday."
            );
            todoRepository.saveAll(List.of(steven, abubakar, derrick));
        };
    }
}
