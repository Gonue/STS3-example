package com.example.tododo.service;

import com.example.tododo.dto.TodoDto;
import com.example.tododo.entity.TodoEntity;
import com.example.tododo.repository.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoEntity add(TodoDto todoDto){
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setTitle(todoDto.getTitle());
        todoEntity.setOrder(todoDto.getOrder());
        todoEntity.setCompleted(todoDto.getCompleted());
        return todoRepository.save(todoEntity);
    }

    public TodoEntity findById(Long id){
        return todoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT));
    }

    public List<TodoEntity> findAll(){
        return todoRepository.findAll();
    }

    public TodoEntity updateById(Long id, TodoDto todoDto){
        TodoEntity todoEntity = findById(id);
        if(todoDto.getTitle() != null){
            todoEntity.setTitle(todoDto.getTitle());
        }
        if(todoDto.getOrder() != null){
            todoEntity.setOrder(todoDto.getOrder());
        }
        if(todoDto.getCompleted() != null){
            todoEntity.setCompleted(todoDto.getCompleted());
        }
        return todoRepository.save(todoEntity);
    }

    public void deleteById(Long id){
        todoRepository.deleteById(id);
    }
    public void deleteAll(){
        todoRepository.deleteAll();
    }

}
