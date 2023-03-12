package com.example.tododo.controller;
import static org.mockito.ArgumentMatchers.any;
import com.example.tododo.dto.TodoDto;
import com.example.tododo.entity.TodoEntity;
import com.example.tododo.service.TodoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TodoController.class)
@MockBean(JpaMetamodelMappingContext.class)
@AutoConfigureRestDocs
class TodoControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TodoService todoService; //service mock 객체

    private TodoEntity expected;

    @BeforeEach
    public void setup() {
        this.expected = new TodoEntity();
        this.expected.setId(1L);
        this.expected.setTitle("test");
        this.expected.setOrder(0L);
        this.expected.setCompleted(false);
    }

    @Test
    @DisplayName("todo 생성")
    public void create() throws Exception {
        when(this.todoService.add(any(TodoDto.class)))
                .then((i) -> {
                    TodoDto request = i.getArgument(0, TodoDto.class);
                    return new TodoEntity(this.expected.getId(), request.getTitle(), request.getOrder(), request.getCompleted());
                });

        TodoDto request = new TodoDto();
        request.setTitle(expected.getTitle());

        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(request);

        this.mockMvc.perform(post("/todo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(expected.getId()))
                .andExpect(jsonPath("$.title").value(expected.getTitle()))
                .andExpect(jsonPath("$.order").value(expected.getOrder()))
                .andExpect(jsonPath("$.completed").value(expected.getCompleted()));
    }

    @Test
    @DisplayName("단일 검색")
    void findById() throws Exception{
        given(todoService.findById(1L)).willReturn(expected);

        mockMvc.perform(
                get("/todo/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(expected.getId()))
                .andExpect(jsonPath("$.title").value(expected.getTitle()))
                .andExpect(jsonPath("$.order").value(expected.getOrder()))
                .andExpect(jsonPath("$.completed").value(expected.getCompleted()));
    }

    @Test
    @DisplayName("전체 검색")
    void findAll()throws Exception{
        List<TodoEntity> mockList = new ArrayList<>();
        int expectedLength = 5;
        for (int i = 0; i < expectedLength; i++){
            mockList.add(mock(TodoEntity.class));
        }

        given(todoService.findAll()).willReturn(mockList);

        mockMvc.perform(
                get("/todo"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(expectedLength));
    }


    @Test
    @DisplayName("수정")
    void patchTodo() throws Exception{

        TodoEntity response = new TodoEntity();
        response.setId(1L);
        response.setTitle("호이");

        given(todoService.updateById(any(Long.class),any(TodoDto.class))).willReturn(response);

        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(expected);

        ResultActions actions = mockMvc.perform(
                patch("/todo/1")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content));

        actions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(expected.getId()))
                .andExpect(jsonPath("$.title").value(response.getTitle()));
    }




    @Test
    @DisplayName("단건 삭제")
    void deleteById() throws Exception{
        mockMvc.perform(
                delete("/todo/1"))
                .andExpect(status().isOk());
    }


    @Test
    @DisplayName("전체 삭제")
    void deleteAll() throws Exception{
        mockMvc.perform(
                delete("/todo"))
                .andExpect(status().isOk());
    }
}