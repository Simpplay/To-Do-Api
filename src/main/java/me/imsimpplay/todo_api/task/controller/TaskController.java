package me.imsimpplay.todo_api.task.controller;

import me.imsimpplay.todo_api.task.dto.TaskRequestDTO;
import me.imsimpplay.todo_api.task.dto.TaskResponseDTO;
import me.imsimpplay.todo_api.task.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public List<TaskResponseDTO> getAll() {
        return service.getAllTasks();
    }

    @PostMapping
    public TaskResponseDTO create(@RequestBody TaskRequestDTO task) {
        return service.createTask(task);
    }
}