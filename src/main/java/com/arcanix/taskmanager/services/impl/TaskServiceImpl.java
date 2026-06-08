package com.arcanix.taskmanager.services.impl;

import com.arcanix.taskmanager.dtos.CreateTaskDTO;
import com.arcanix.taskmanager.dtos.ResponseTaskDTO;
import com.arcanix.taskmanager.dtos.UpdateTaskDTO;
import com.arcanix.taskmanager.entities.Task;
import com.arcanix.taskmanager.mapper.TaskMapper;
import com.arcanix.taskmanager.repositories.TaskRepository;
import com.arcanix.taskmanager.services.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository repository;

    public TaskServiceImpl(TaskRepository repository){
        this.repository = repository;
    }

    @Override
    public List<ResponseTaskDTO> findAll() {
        return repository.findAll().stream()
                                   .map(TaskMapper::taskToResponseDTO)
                                   .toList();
    }

    @Override
    public ResponseTaskDTO create(CreateTaskDTO dto) {
        Task task = TaskMapper.createDtoToTask(dto);

        repository.save(task);

        return TaskMapper.taskToResponseDTO(task);
    }

    @Override
    public ResponseTaskDTO update(UpdateTaskDTO dto) {
        Task task = TaskMapper.updateDtoToTask(dto);

        repository.save(task);

        return TaskMapper.taskToResponseDTO(task);
    }

    @Override
    public void delete(UUID id) {
        if (repository.existsById(id))
            repository.deleteById(id);
        // Throw Exception
    }
}
