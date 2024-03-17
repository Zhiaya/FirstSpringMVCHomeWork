package com.example.firstspringhomework.RestController;

import com.example.firstspringhomework.model.Todo;
import com.example.firstspringhomework.service.TodoService;
import com.example.firstspringhomework.service.TodoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Controller
public class TodoController {

    @Autowired
    private TodoService todoListService;
    @GetMapping("/")
    public String showTodoList(Model model) {
        List<Todo> todos = todoListService.getAllTodos();
        model.addAttribute("todos", todos);
        return "index";
    }

    @GetMapping("/todo/add-todo")
    public String addTodo() {
        return "add-todo";
    }

    @PostMapping("/todo/add-todo")
    public String addTodo(Todo todo) {
        todo.setCreatedAt(LocalDateTime.now());
        todoListService.addTodo(todo);
        return "redirect:/";
    }

    @GetMapping("/todo/edit/{id}")
    public String showEditTodoForm(@PathVariable("id") int id, Model model) {
        Todo todo = todoListService.getTodoById(id);
        model.addAttribute("todo", todo);
        return "edit-todo";
    }

    @PostMapping("/todo/edit/{id}")
    public String editTodo(@PathVariable("id") int id, Todo todoDetails) {
        todoListService.updateTodo(id, todoDetails);
        return "redirect:/";
    }

    @PostMapping("/todo/delete/{id}")
    public String deleteTodo(@PathVariable("id") int id) {
        todoListService.deleteTodoById(id);
        return "redirect:/";
    }

    @GetMapping("/todo/search")
    public String searchTodos(@RequestParam(required = false) String task,
                              @RequestParam(required = false) String isDone,
                              Model model) {
        List<Todo> todos;
        if (task != null && !task.isEmpty()) {
            todos = todoListService.searchTodoByTask(task);
        } else if (isDone != null && !isDone.isEmpty()) {
            todos = todoListService.searchTodoByIsDone(isDone);
        } else {
            todos = new ArrayList<>();
        }
        model.addAttribute("todos", todos);
        return "searchResults"; // Ensure this matches the name of your search results view
    }

}
