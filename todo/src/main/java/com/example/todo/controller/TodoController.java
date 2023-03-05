package com.example.todo.controller;


import com.example.todo.entity.TodoEntity;
import com.example.todo.entity.TodoRequest;
import com.example.todo.entity.TodoResponse;
import com.example.todo.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/todo")
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    public ResponseEntity<TodoResponse> create(@RequestBody TodoRequest request){
        if(ObjectUtils.isEmpty(request.getTitle()))
            return ResponseEntity.badRequest().build();
        if(ObjectUtils.isEmpty(request.getOrder()))
            request.setOrder(0L);
        if(ObjectUtils.isEmpty(request.getCompleted()))
            request.setCompleted(false);

        TodoEntity result = todoService.add(request);
        return ResponseEntity.ok(new TodoResponse(result));

    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoResponse> readOne(@PathVariable Long id){
        TodoEntity result = todoService.searchById(id);
        return ResponseEntity.ok(new TodoResponse(result));
    }

    @GetMapping
    public ResponseEntity<List<TodoResponse>> readAll(){
        List<TodoEntity> list = todoService.searchAll();
        List<TodoResponse> response = list.stream().map(TodoResponse::new).collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TodoResponse> update(@PathVariable Long id, @RequestBody TodoRequest todoRequest){
        TodoEntity result = todoService.updateById(id, todoRequest);
        return ResponseEntity.ok(new TodoResponse(result));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOne(@PathVariable Long id){
        todoService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping
    public ResponseEntity<?> deleteAll(){
        todoService.deleteAll();
        return ResponseEntity.ok().build();
    }
}
