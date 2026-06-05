package com.arcanix.taskmanager.dtos;

import com.arcanix.taskmanager.enums.Priority;
import com.arcanix.taskmanager.enums.Status;

import java.time.LocalDateTime;

public record CreateTaskDTO(String title,
                            String description,
                            LocalDateTime createdAt,
                            LocalDateTime deadline,
                            Priority priority,
                            Status status) {
}
