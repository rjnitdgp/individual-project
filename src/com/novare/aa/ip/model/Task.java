package com.novare.aa.ip.model;

import java.io.Serializable;
import java.util.Date;

public class Task implements Serializable {

    //default serialVersion id
    private static final long serialVersionUID = 1L;

    private static int globalTaskID = 0;
    private String taskID;
    private String taskTitle;
    private Date taskDueDate;
    private Boolean taskStatus;

    public Task(String taskTitle, Date taskDueDate)
    {
        globalTaskID++;
        this.taskID = Integer.toString(globalTaskID);
        this.taskTitle = taskTitle;
        this.taskDueDate = taskDueDate;
        this.taskStatus = false;
    }

    public String getTaskID() {
        return taskID;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public Date getTaskDueDate() {
        return taskDueDate;
    }

    public Boolean getTaskStatus() {
        return taskStatus;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public void setTaskDueDate(Date taskDueDate) {
        this.taskDueDate = taskDueDate;
    }

    public void setTaskStatus(Boolean taskStatus) {
        this.taskStatus = taskStatus;
    }

    public void setTaskID(String taskID) {
        this.taskID = taskID;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskID=" + taskID +
                ", taskTitle='" + taskTitle + '\'' +
                ", taskDueDate=" + taskDueDate +
                ", taskStatus=" + taskStatus +
                '}';
    }
}
