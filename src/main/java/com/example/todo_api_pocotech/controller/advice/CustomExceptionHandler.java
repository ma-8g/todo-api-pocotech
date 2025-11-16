package com.example.todo_api_pocotech.controller.advice;

import com.example.todo_api_pocotech.service.tasks.TaskEntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(TaskEntityNotFoundException.class)
    public ResponseEntity<Void> handleTaskEntityNotFoundException(TaskEntityNotFoundException e) {
        return ResponseEntity.notFound().build();
    }
}
