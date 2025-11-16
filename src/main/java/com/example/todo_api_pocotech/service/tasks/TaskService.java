package com.example.todo_api_pocotech.service.tasks;

import com.example.todo_api_pocotech.repository.tasks.TaskRepository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskEntity find(){
        return taskRepository.select().map(record ->
            new TaskEntity(
                record.getId(),
                record.getTitle()
            )
        ).orElseThrow(() -> new IllegalStateException("TODO")); //TODO

    }
}
