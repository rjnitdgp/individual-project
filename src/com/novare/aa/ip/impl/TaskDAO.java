package com.novare.aa.ip.impl;

import com.novare.aa.ip.model.Task;

import java.util.List;
import java.util.Optional;

//TODO
public interface TaskDAO {
    Optional<Task> get(long id);
    List<Task> getAll();
    void save(Task task);
    void update(Task task, String[] params);
    void delete(Task task);
}

