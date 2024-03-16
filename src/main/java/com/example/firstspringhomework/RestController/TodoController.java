package com.example.firstspringhomework.RestController;

import com.example.firstspringhomework.model.Todo;
import com.example.firstspringhomework.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TodoController {
//    @Autowired
//    private List<Todo> todoList;
//
//    @GetMapping("/index")
//    public String showTodoList(Model model) {
//        model.addAttribute("todos", todoList);
//        return "index";
//    }
@Autowired
private TodoService todoListService;

    @GetMapping("/")
    public String showTodoList(Model model) {
        List<Todo> todos = todoListService.getAllTodos();
        model.addAttribute("todos", todos);
        return "index";
    }

//    @GetMapping("/todo/new")
//    public String showAddTodoForm(Model model) {
//        model.addAttribute("todo", new Todo());
//        return "add-todo";
//    }

    @PostMapping("/todo/add")
    public String addTodo(Todo todo) {
        todoListService.addTodo(todo);
        return "redirect:/todo";
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
        return "redirect:/todo";
    }

    @GetMapping("/todo/delete/{id}")
    public String deleteTodo(@PathVariable("id") int id) {
        todoListService.deleteTodoById(id);
        return "redirect:/todo";
    }

//    @GetMapping("/todo/search")
//    public String searchTodo(@RequestParam("task") String task, @RequestParam("isDone") boolean isDone, Model model) {
//        List<Todo> todos = todoListService.searchTodoByTaskAndIsDone(task, String.valueOf(isDone));
//        model.addAttribute("todos", todos);
//        return "todo";
//    }


}
