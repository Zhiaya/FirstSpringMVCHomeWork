package com.example.firstspringhomework.service;

import com.example.firstspringhomework.model.Todo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public interface TodoService {
    List<Todo> getAllTodos();

    List<Todo> searchTodoByTask(String task);

    Todo getTodoById(int id);

    void addTodo(Todo todo);

    List<Todo> searchTodoByIsDone(String isDone);

    void updateTodo(int id, Todo todoDetails);

    void deleteTodoById(int id);


}
