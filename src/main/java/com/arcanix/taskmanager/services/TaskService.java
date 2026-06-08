package com.arcanix.taskmanager.services;

import com.arcanix.taskmanager.dtos.CreateTaskDTO;
import com.arcanix.taskmanager.dtos.ResponseTaskDTO;
import com.arcanix.taskmanager.dtos.UpdateTaskDTO;

import java.util.List;
import java.util.UUID;

public interface TaskService {
    List<ResponseTaskDTO> findAll();

    ResponseTaskDTO create(CreateTaskDTO dto);
    ResponseTaskDTO update(UpdateTaskDTO dto);
    void delete(UUID id);
}
