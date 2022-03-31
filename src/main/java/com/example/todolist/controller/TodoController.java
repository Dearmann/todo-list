package com.example.todolist.controller;

import com.example.todolist.model.Task;
import com.example.todolist.service.TodoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/todo")
public class TodoController {

    @Autowired
    private final TodoServiceImpl todoService;

    public TodoController(TodoServiceImpl todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<Task> findAll() {
        return todoService.findAll();
    }

    @GetMapping("/{id}")
    public Task findOne(@PathVariable Long id) {
        return todoService.findOne(id);
    }

    @PostMapping("/user/{userId}")
    public Task save(@RequestBody Task task, @PathVariable Long userId) {
        return todoService.save(task, userId);
    }

    @PostMapping("/{taskId}")
    public void toggleTaskCompletion(@PathVariable Long taskId) {
        todoService.toggleTaskCompletion(taskId);
    }

    @PutMapping("/{id}")
    public Task update(@RequestBody Task newTask, @PathVariable Long id) {
       return todoService.update(newTask, id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        todoService.delete(id);
    }
}
