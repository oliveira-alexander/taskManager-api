package com.arcanix.taskmanager.controllers;

import com.arcanix.taskmanager.dtos.CreateTaskDTO;
import com.arcanix.taskmanager.dtos.ResponseTaskDTO;
import com.arcanix.taskmanager.dtos.UpdateTaskDTO;
import com.arcanix.taskmanager.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ResponseTaskDTO>> findAll(){
        return ResponseEntity.status(HttpStatus.OK)
                             .body(service.findAll());
    }

    @PostMapping
    public ResponseEntity<ResponseTaskDTO> create(@RequestBody CreateTaskDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(service.create(dto));
    }

    @PutMapping
    public ResponseEntity<ResponseTaskDTO> update(@RequestBody UpdateTaskDTO dto){
        return ResponseEntity.status(HttpStatus.OK)
                             .body(service.update(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK)
                             .body(null);
    }

}
