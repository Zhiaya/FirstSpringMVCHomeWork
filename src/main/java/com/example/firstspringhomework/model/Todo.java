package com.example.firstspringhomework.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class Todo {

    private int id;
    private String task;
    private String description;
    private String isDone;
    private LocalDateTime createdAt;

    public Todo() {
        int nextId = 0;
        this.id = ++nextId;
    }

}

