package com.example.firstspringhomework.configuration;

import com.example.firstspringhomework.model.Todo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class TodoListDataSource {

    @Bean
    public List<Todo> todoList() {
        List<Todo> todos = new ArrayList<>();
        todos.add(new Todo(1, "Learn Spring MVC", "Study Spring MVC framework","Yes", LocalDateTime.now()));
        todos.add(new Todo(2, "Build a REST API", "Create a RESTful API using Spring Boot","No", LocalDateTime.now()));
        todos.add(new Todo(3, "Deploy Application", "Deploy the application to a cloud provider","Yes", LocalDateTime.now()));
        return todos;
    }
}
