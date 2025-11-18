package com.example.todo_api_pocotech.service.tasks;

import com.example.todo_api_pocotech.repository.tasks.TaskRepository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskEntity find(long taskId){
        return taskRepository.select(taskId).map(record ->
            new TaskEntity(
                record.getId(),
                record.getTitle()
            )
        ).orElseThrow(() -> new TaskEntityNotFoundException(taskId));

    }

    public TaskEntity create(String title) {
        return new TaskEntity(999L, title);
    }
}
