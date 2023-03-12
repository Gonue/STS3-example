package com.example.tododo.dto;

import com.example.tododo.entity.TodoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoDto {
    private Long id;
    private String title;
    private Long order;
    private Boolean completed;
    private String url;


    public TodoDto(TodoEntity todoEntity, String serviceUrl) {
        this.id = todoEntity.getId();
        this.title = todoEntity.getTitle();
        this.order = todoEntity.getOrder();
        this.completed = todoEntity.getCompleted();
        this.url = "http://localhost:8080/todo/" + this.id;
    }
}