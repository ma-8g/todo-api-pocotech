package com.example.todo_api_pocotech.service.tasks;

public class TaskEntityNotFoundException extends RuntimeException {

    private final long taskId;
    public TaskEntityNotFoundException(long taskId) {
        super("TaskEntity (ID " + taskId + "is not found.");
        this.taskId = taskId;
    }
}
