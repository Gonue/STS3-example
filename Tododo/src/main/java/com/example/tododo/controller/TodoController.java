package com.example.tododo.controller;


import com.example.tododo.dto.TodoDto;
import com.example.tododo.entity.TodoEntity;
import com.example.tododo.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/todo")
@AllArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    public ResponseEntity<TodoDto> create(@RequestBody TodoDto todoDto){
        TodoEntity result = todoService.add(todoDto);
        return ResponseEntity.ok(new TodoDto(result));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoDto> findById(@PathVariable Long id){
        TodoEntity result = todoService.searchById(id);
        return ResponseEntity.ok(new TodoDto(result));
    }

    @GetMapping
    public ResponseEntity<List<TodoDto>> findAll(){
        List<TodoEntity> list = todoService.findAll();
        List<TodoDto> res = list.stream().map(TodoDto::new).collect(Collectors.toList());
        return ResponseEntity.ok(res);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TodoDto> update(@PathVariable Long id, @RequestBody TodoDto todoDto){
        TodoEntity result = todoService.updateById(id, todoDto);
        return ResponseEntity.ok(new TodoDto(result));
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
