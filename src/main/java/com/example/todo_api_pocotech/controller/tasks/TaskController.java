package com.example.todo_api_pocotech.controller.tasks;

import com.example.todo_api_pocotech.service.tasks.TaskEntity;
import com.example.todo_api_pocotech.service.tasks.TaskService;
import com.example.todoapi.controller.TasksApi;
import com.example.todoapi.model.TaskDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TaskController implements TasksApi {

    private final TaskService taskService;

    @Override
    public ResponseEntity<TaskDTO> showTask() {

        TaskEntity entity = taskService.find();

        var dto = new TaskDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        return ResponseEntity.ok(dto);
    }
}
