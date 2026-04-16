package me.imsimpplay.todo_api.task.mapper;

import me.imsimpplay.todo_api.task.dto.TaskRequestDTO;
import me.imsimpplay.todo_api.task.dto.TaskResponseDTO;
import me.imsimpplay.todo_api.task.model.Task;

// TODO: Use mapstruct
public class TaskMapper {

    public static Task toEntity(TaskRequestDTO dto) {
        Task task = new Task();
        task.setTitle(dto.title());
        task.setDescription(dto.description());
        task.setCompleted(false);
        return task;
    }

    public static TaskResponseDTO toDTO(Task task) {
        return new TaskResponseDTO(task.getId(), task.getTitle(), task.isCompleted());
    }
}
