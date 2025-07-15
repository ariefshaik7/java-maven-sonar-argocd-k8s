package org.example.springbootapp.controller;

import org.example.springbootapp.model.Todo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoController {

    private final List<Todo> tasks = new ArrayList<>();

    @GetMapping("/tasks")
    public List<Todo> getTasks() {
        return tasks;
    }

    @PostMapping("/tasks")
    public Response addTask(@RequestBody Todo todo) {
        if (todo.getTask() == null || todo.getTask().isBlank()) {
            return new Response("No task provided", false);
        }
        todo.setCompleted(false); // default
        tasks.add(todo);
        return new Response("Task added", true);
    }

    @PutMapping("/tasks/{id}/toggle")
    public Response toggleTask(@PathVariable int id) {
        if (id >= 0 && id < tasks.size()) {
            Todo task = tasks.get(id);
            task.setCompleted(!task.isCompleted());
            return new Response("Toggled task", true);
        }
        return new Response("Invalid task ID", false);
    }

    @DeleteMapping("/tasks/{id}")
    public Response deleteTask(@PathVariable int id) {
        if (id >= 0 && id < tasks.size()) {
            tasks.remove(id);
            return new Response("Task deleted", true);
        }
        return new Response("Invalid task ID", false);
    }

    @DeleteMapping("/tasks")
    public Response clearAll() {
        tasks.clear();
        return new Response("All tasks cleared", true);
    }

    public record Response(String message, boolean success) {}
}
