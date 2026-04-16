package me.imsimpplay.todo_api.task.service;

import me.imsimpplay.todo_api.task.dto.TaskRequestDTO;
import me.imsimpplay.todo_api.task.dto.TaskResponseDTO;
import me.imsimpplay.todo_api.task.mapper.TaskMapper;
import me.imsimpplay.todo_api.task.model.Task;
import me.imsimpplay.todo_api.task.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<TaskResponseDTO> getAllTasks() {
        return repository.findAll().stream().map(TaskMapper::toDTO).collect(Collectors.toList());
    }

    public Task getTaskById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public TaskResponseDTO createTask(TaskRequestDTO taskDTO) {
        Task task = TaskMapper.toEntity(taskDTO);
        task.setCreatedAt(LocalDateTime.now());
        Task saved = repository.save(task);
        return TaskMapper.toDTO(saved);
    }
}
