package com.novare.aa.ip.dto;

import java.util.ArrayList;
import java.util.List;

public class TaskManagementDTOImpl implements TaskManagementDTO {

    private List<TaskDTO> taskDTO = new ArrayList<>();
    private ObjectIOPersistence io = new ObjectIOPersistence();

    @Override
    public List<TaskDTO> getAllTaskDTO() {
        try {
            System.out.println("Testing reading out from file to create TaskDTO object");
            List<TaskDTO> result = io.readObjectsFromFile();
            return result;
        } catch (Exception e) {}
        return null;
    }

    @Override
    public void saveTaskDTO(TaskDTO taskdto) {
        taskDTO.add(taskdto);
        try {
            io.writeObjectToFile(taskDTO);
        } catch (Exception e) {}
    }
}
