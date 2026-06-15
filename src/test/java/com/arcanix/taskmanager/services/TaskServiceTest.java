package com.arcanix.taskmanager.services;

import com.arcanix.taskmanager.dtos.CreateTaskDTO;
import com.arcanix.taskmanager.dtos.ResponseTaskDTO;
import com.arcanix.taskmanager.entities.Task;
import com.arcanix.taskmanager.enums.Priority;
import com.arcanix.taskmanager.enums.Status;
import com.arcanix.taskmanager.mapper.TaskMapper;
import com.arcanix.taskmanager.repositories.TaskRepository;
import com.arcanix.taskmanager.services.impl.TaskServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {

    @Mock
    private TaskRepository repository;

    @InjectMocks
    private TaskServiceImpl service;

    @Test
    void shouldFindAllTasks(){
        // Arrange
            Task taskA = new Task(UUID.randomUUID(),
                    "Título A", "Descrição A", LocalDateTime.now().minusDays(7),
                    LocalDateTime.now().plusDays(7), Priority.MEDIUM, Status.IN_PROGRESS);

            Task taskB = new Task(UUID.randomUUID(),
                    "Título B", "Descrição B", LocalDateTime.now().minusDays(7),
                    LocalDateTime.now().plusDays(7), Priority.LOW, Status.DONE);

            when(repository.findAll())
                    .thenReturn(List.of(taskA, taskB));

        // Act
            List<ResponseTaskDTO> serviceTaskList = service.findAll();

        // Assert
            assertEquals(serviceTaskList.get(0).id(), taskA.getId());
            assertEquals(serviceTaskList.get(0).title(), taskA.getTitle());

            assertEquals(serviceTaskList.get(1).id(), taskB.getId());

    }

}
