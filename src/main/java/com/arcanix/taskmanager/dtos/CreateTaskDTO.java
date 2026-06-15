package com.arcanix.taskmanager.dtos;

import com.arcanix.taskmanager.enums.Priority;

import java.time.LocalDateTime;

public record CreateTaskDTO(String title,
                            String description,
                            LocalDateTime deadline,
                            Priority priority
) {
}
