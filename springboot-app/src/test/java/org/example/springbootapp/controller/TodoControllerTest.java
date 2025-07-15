package org.example.springbootapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.springbootapp.model.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TodoController.class)
public class TodoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testAddAndGetTasks() throws Exception {
        mockMvc.perform(post("/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new Todo("Buy milk", false))))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Task added"));

        mockMvc.perform(get("/tasks"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Buy milk")));
    }

    @Test
    void testDeleteInvalidTask() throws Exception {
        mockMvc.perform(delete("/tasks/99"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(false));
    }
}
