package com.example.firstspringhomework.service;

import com.example.firstspringhomework.model.Todo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public interface TodoService {
    List<Todo> getAllTodos();

//    List<Todo> searchTodoByTask(String task);

//    List<Todo> searchTodoByTaskAndIsDone(String task, String isDone);

    Todo getTodoById(int id);

    void addTodo(Todo todo);

    //    Search for a todo by task and isDone
    List<Todo> searchTodoByTask(String task);

    List<Todo> searchTodoByIsDone(String isDone);

    void updateTodo(int id, Todo todoDetails);

    void deleteTodoById(int id);
}
