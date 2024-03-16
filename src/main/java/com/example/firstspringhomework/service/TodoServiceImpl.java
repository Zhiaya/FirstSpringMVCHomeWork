package com.example.firstspringhomework.service;

import com.example.firstspringhomework.model.Todo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {
    private List<Todo> todos = new ArrayList<>();

    public TodoServiceImpl() {
        int nextId = 0;
        todos.add(new Todo(++nextId, "Learn Spring MVC", "Study Spring MVC framework","Yes", LocalDateTime.now()));
        todos.add(new Todo(++nextId, "Build a REST API", "Create a RESTful API using Spring Boot","No", LocalDateTime.now()));
        todos.add(new Todo(++nextId, "Deploy Application", "Deploy the application to a cloud provider","Yes", LocalDateTime.now()));
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
        // Find the highest id currently in use
        int maxId = todos.stream().mapToInt(Todo::getId).max().orElse(0);
        // Assign the next available id to the new todo
        todo.setId(maxId + 1);
        // Add the new todo to the list
        todos.add(todo);
    }


    //    Search for a todo by task
    @Override
    public List<Todo> searchTodoByTask(String task) {
        List<Todo> results = new ArrayList<>();
        for (Todo todo : todos) {
            if (todo.getTask().equalsIgnoreCase(task)) {
                results.add(todo);
            }
        }
        return results;
    }
//    Search for a todo by task and isDone
    @Override
    public List<Todo> searchTodoByIsDone(String isDone) {
        List<Todo> results = new ArrayList<>();
        for (Todo todo : todos) {
            if (todo.getIsDone().equalsIgnoreCase(isDone)) {
                results.add(todo);
            }
        }
        return results;
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




}
