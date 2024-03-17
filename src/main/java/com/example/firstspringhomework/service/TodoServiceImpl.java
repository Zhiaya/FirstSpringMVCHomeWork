package com.example.firstspringhomework.service;

import com.example.firstspringhomework.model.Todo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class TodoServiceImpl implements TodoService {
    private List<Todo> todos = new ArrayList<>();
    TodoService todoService;

    public TodoServiceImpl() {
        todos.add(new Todo(1, "Learn Spring MVC", "Study Spring MVC framework","Yes", LocalDateTime.now()));
        todos.add(new Todo(2, "Build a REST API", "Create a RESTful API using Spring Boot","No", LocalDateTime.now()));
        todos.add(new Todo(3, "Deploy Application", "Deploy the application to a cloud provider","Yes", LocalDateTime.now()));
    }

    @Override
    public List<Todo> getAllTodos() {
        return todos;
    }

    @Override
    public Todo getTodoById(int id) {
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }
    @Override
    public void addTodo(Todo todo) {
        int maxId = todos.stream().mapToInt(Todo::getId).max().orElse(0);
        todo.setId(maxId + 1);
        todos.add(todo);
    }
    @Override
    public void updateTodo(int id, Todo todoDetails) {
        for (int i = 0; i < todos.size(); i++) {
            Todo todo = todos.get(i);
            if (todo.getId() == id) {
                todos.set(i, todoDetails);
                break;
            }
        }
    }

    @Override
    public void deleteTodoById(int id) {
        todos.removeIf(todo -> todo.getId() == id);
    }
    @Override
    public List<Todo> searchTodoByTask(String task) {
        //ignore Upper and lower case
        return getAllTodos().stream()
                .filter(todo -> todo.getTask().toLowerCase(Locale.ROOT).contains(task.toLowerCase(Locale.ROOT)))
                .toList();

    }
    @Override
    public List<Todo> searchTodoByIsDone(String isDone) {
        return getAllTodos().stream()
                .filter(todo -> todo.getIsDone().toLowerCase(Locale.ROOT).contains(isDone.toLowerCase(Locale.ROOT)))
                .toList();
    }

}
