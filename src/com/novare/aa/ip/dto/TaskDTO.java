package com.novare.aa.ip.dto;

import com.novare.aa.ip.model.Project;
import com.novare.aa.ip.model.Task;
import com.novare.aa.ip.model.User;

public class TaskDTO {
    private Task task;
    private Project project;
    private User user;

    public TaskDTO(Task task, Project project, User user) {
        this.task = task;
        this.project = project;
        this.user = user;
    }

    public Task getTask() {
        return task;
    }

    public Project getProject() {
        return project;
    }

    public User getUser() {
        return user;
    }
}
