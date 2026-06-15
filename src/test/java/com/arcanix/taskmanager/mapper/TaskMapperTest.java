package com.arcanix.taskmanager.mapper;

import com.arcanix.taskmanager.dtos.CreateTaskDTO;
import com.arcanix.taskmanager.dtos.ResponseTaskDTO;
import com.arcanix.taskmanager.dtos.UpdateTaskDTO;
import com.arcanix.taskmanager.entities.Task;
import com.arcanix.taskmanager.enums.Priority;
import com.arcanix.taskmanager.enums.Status;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.UUID;

public class TaskMapperTest {

    @Test
    void shouldMapCreateTaskDtoToTask(){

        // Arrange

        CreateTaskDTO createDTO = new CreateTaskDTO("Título",
                                               "Descrição",
                                                         LocalDateTime.now().plusDays(7),
                                                         Priority.MEDIUM);

        // Act

        Task task = TaskMapper.createDtoToTask(createDTO);


        // Assert

        assertEquals(createDTO.title(), task.getTitle());
        assertEquals(createDTO.description(), task.getDescription());
        assertEquals(createDTO.deadline(), task.getDeadline());
        assertEquals(createDTO.priority(), task.getPriority());
    }

    @Test
    void shouldMapUpdateTaskDtoToTask(){

        // Arrange

        UpdateTaskDTO dto = new UpdateTaskDTO(UUID.randomUUID(),
                "Título", "Descrição", LocalDateTime.now().minusDays(7),
                LocalDateTime.now().plusDays(7), Priority.MEDIUM, Status.CREATED);

        // Act

        Task task = TaskMapper.updateDtoToTask(dto);

        // Assert

        assertEquals(dto.id(), task.getId());
        assertEquals(dto.title(), task.getTitle());
        assertEquals(dto.description(), task.getDescription());
        assertEquals(dto.createdAt(), task.getCreatedAt());
        assertEquals(dto.deadline(), task.getDeadline());
        assertEquals(dto.priority(), task.getPriority());
        assertEquals(dto.status(), task.getStatus());
    }

    @Test
    void shouldMapTaskToResponseDto(){

        // Arrange

        Task task = new Task(UUID.randomUUID(),
                "Título",
                "Descrição",
                LocalDateTime.now().minusDays(7),
                LocalDateTime.now().plusDays(7),
                Priority.MEDIUM,
                Status.IN_PROGRESS);

        // Act

        ResponseTaskDTO response = TaskMapper.taskToResponseDTO(task);

        // Assert

        assertEquals(task.getId(), response.id());
        assertEquals(task.getTitle(), response.title());
        assertEquals(task.getDescription(), response.description());
        assertEquals(task.getCreatedAt(), response.createdAt());
        assertEquals(task.getDeadline(), response.deadline());
        assertEquals(task.getPriority(), response.priority());
        assertEquals(task.getStatus(), response.status());
    }
}
