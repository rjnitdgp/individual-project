package com.novare.aa.ip.dto;

import com.novare.aa.ip.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskManagementDTO {
    List<TaskDTO> getAllTaskDTO();
    void saveTaskDTO(TaskDTO taskDTO);
}

