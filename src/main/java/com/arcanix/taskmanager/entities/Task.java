package com.arcanix.taskmanager.entities;

import com.arcanix.taskmanager.enums.Priority;
import com.arcanix.taskmanager.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "tasks")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime deadline;
    private Priority priority;
    private Status status;

    // Constructors

    public Task (UUID id, String title, String description, LocalDateTime createdAt,
                 LocalDateTime deadline, Priority priority, Status status){
        if (id == null)
            this.id = UUID.randomUUID();
        else
            this.id = id;

        this.title = title;
        this.description = description;

        if (createdAt == null)
            this.createdAt = LocalDateTime.now();
        else
            this.createdAt = createdAt;

        this.deadline = deadline;
        this.priority = priority;
        this.status = status;
    }

}
