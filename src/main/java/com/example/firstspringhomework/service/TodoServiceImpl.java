package com.example.firstspringhomework.service;

import com.example.firstspringhomework.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {
    private List<Todo> todos = new ArrayList<>();

    @Override
    public List<Todo> getAllTodos() {
        return todos;
    }

    @Override
    public Todo getTodoById(int id) {
        return todos.stream().filter(todo -> todo.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void addTodo(Todo todo) {
        todos.add(todo);
    }

    @Override
    public void updateTodo(int id, Todo todoDetails) {
        Optional<Todo> optionalTodo = todos.stream().filter(todo -> todo.getId() == id).findFirst();
        if (optionalTodo.isPresent()) {
            Todo todo = optionalTodo.get();
            todo.setTask(todoDetails.getTask());
            todo.setDescription(todoDetails.getDescription());
            todo.setIsDone(todoDetails.isDone());
        }
    }

    @Override
    public void deleteTodoById(int id) {
        todos.removeIf(todo -> todo.getId() == id);
    }
}
