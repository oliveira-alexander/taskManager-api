package com.arcanix.taskmanager.mapper;

import com.arcanix.taskmanager.dtos.CreateTaskDTO;
import com.arcanix.taskmanager.dtos.ResponseTaskDTO;
import com.arcanix.taskmanager.dtos.UpdateTaskDTO;
import com.arcanix.taskmanager.entities.Task;
import com.arcanix.taskmanager.enums.Status;

import java.time.LocalDateTime;

public class TaskMapper {
    public static Task createDtoToTask(CreateTaskDTO dto){
        return new Task(null,
                        dto.title(),
                        dto.description(),
                        LocalDateTime.now(),
                        dto.deadline(),
                        dto.priority(),
                        Status.CREATED);
    }

    public static Task updateDtoToTask(UpdateTaskDTO dto){
        return new Task(dto.id(),
                dto.title(),
                dto.description(),
                dto.createdAt(),
                dto.deadline(),
                dto.priority(),
                dto.status());
    }

    public static ResponseTaskDTO taskToResponseDTO(Task task){
        return new ResponseTaskDTO(task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getCreatedAt(),
                task.getDeadline(),
                task.getPriority(),
                task.getStatus());
    }
}
