package com.example.tododo.controller;


import com.example.tododo.dto.TodoDto;
import com.example.tododo.entity.TodoEntity;
import com.example.tododo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;
    @Value("${server.service.url}")
    private String serviceUrl;

    @PostMapping
    public ResponseEntity<TodoDto> create(@RequestBody TodoDto todoDto){
        if (ObjectUtils.isEmpty(todoDto.getTitle()))
            return ResponseEntity.badRequest().build();
        if (ObjectUtils.isEmpty(todoDto.getOrder()))
            todoDto.setOrder(0L);
        if (ObjectUtils.isEmpty(todoDto.getCompleted()))
            todoDto.setCompleted(false);
        TodoEntity result = todoService.add(todoDto);
        TodoDto response = new TodoDto(result, serviceUrl);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoDto> findById(@PathVariable Long id){
        TodoEntity result = todoService.findById(id);
        TodoDto response = new TodoDto(result, serviceUrl);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<TodoDto>> findAll(){
        List<TodoEntity> list = todoService.findAll();
        List<TodoDto> response = list
                .stream()
                .map(result -> new TodoDto(result, serviceUrl))
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TodoDto> update(@PathVariable Long id, @RequestBody TodoDto todoDto){
        TodoEntity result = todoService.updateById(id, todoDto);
        TodoDto response = new TodoDto(result, serviceUrl);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        todoService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAll(){
        todoService.deleteAll();
        return ResponseEntity.ok().build();
    }
}
