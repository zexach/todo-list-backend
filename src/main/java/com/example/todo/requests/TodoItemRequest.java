package com.example.todo.requests;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoItemRequest {
    private String title;
    private String description;
    private Date createdAt;
}
