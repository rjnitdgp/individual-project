package com.novare.aa.ip.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Project implements Serializable {

    //default serialVersion id
    private static final long serialVersionUID = 1L;


    private String projectTitle;
    private HashMap<Project, ArrayList<Task>> projectTasks;

    public Project(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectTitle='" + projectTitle + '\'' +
                '}';
    }
}
