package com.example.firstspringhomework.configuration;
import com.example.firstspringhomework.model.Todo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
@Configuration
public class TodoListDataSource {
    @Bean
    public List<Todo> todoList() {
        return new ArrayList<>();
    }
}


