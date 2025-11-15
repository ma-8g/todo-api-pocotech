package com.example.todo_api_pocotech.controller;

import com.example.todoapi.controller.ApiApi;
import com.example.todoapi.model.Todo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController implements ApiApi {

    @Override
    public ResponseEntity<List<Todo>> getTodos() {
        return ResponseEntity.ok().build();
    }
}
