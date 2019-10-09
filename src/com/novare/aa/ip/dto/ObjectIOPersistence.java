package com.novare.aa.ip.dto;

import com.novare.aa.ip.model.Project;
import com.novare.aa.ip.model.Task;
import com.novare.aa.ip.model.User;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ObjectIOPersistence {

    private static final String taskDB = "task_list.txt";
    //List<Task> readTasksList = new ArrayList<>();
    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void writeObjectToFile (List<TaskDTO> taskDTOList) throws IOException {

        FileOutputStream taskListStream = new FileOutputStream(taskDB);
        Iterator<TaskDTO> iterator = taskDTOList.iterator();
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(taskListStream, "utf-8"))) {
            writer.write("taskID\ttaskTitle\ttaskDetails\ttaskDueDate\ttaskStatus\ttaskProject\ttaskUser\n--------------------------------\n");
            while (iterator.hasNext()) {
                TaskDTO taskDTO = iterator.next();
                writer.write(taskDTO.getTask().getTaskID());
                writer.write("\t");
                writer.write(taskDTO.getTask().getTaskTitle());
                writer.write("\t");
                writer.write(formatter.format(taskDTO.getTask().getTaskDueDate()));
                writer.write("\t");
                writer.write(String.valueOf(taskDTO.getTask().getTaskStatus()));
                writer.write("\t");

                writer.write(taskDTO.getProject().getProjectTitle());
                writer.write("\t");
                writer.write(taskDTO.getUser().getFirstName());
                writer.write("\t");
                writer.write(taskDTO.getUser().getLastName());
                writer.write("\t");
                writer.newLine();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        finally {
            taskListStream.close();
        }
        System.out.println("Completed writing to file.");
    }

    public List<TaskDTO> readObjectsFromFile() throws ParseException {
        List<TaskDTO> readTaskDTOList = new ArrayList<>();
        int lineNo = 0;

        // Read file the file to Buffer; pass the appropriate Task out file path from previous program
        try (BufferedReader br = new BufferedReader(new FileReader(taskDB))) {
            String line;
            //get line by line from Buffer
            while ((line = br.readLine()) != null) {
                //Ignoring first 2 lines which are column names and line separator.
                if (++lineNo > 2) {
                    //Splitting the each line with 'tab' separator since input file is created with tab as separator.
                    String[] taskInfo = line.split("\t");
                    //Create Task Object and add to Tasks object list.
                    Task readTask = new Task(taskInfo[1], formatter.parse(taskInfo[2]));
                    readTask.setTaskID(taskInfo[0]);
                    readTask.setTaskStatus(Boolean.valueOf(taskInfo[3]));

                    Project readProject = new Project(taskInfo[4]);
                    User readUser = new User(taskInfo[5], taskInfo[6]);

                     readTaskDTOList.add(new TaskDTO(readTask, readProject, readUser));
                }
            }
            // Iterating through TaskDTO object list and print the values.
            //Iterator<TaskDTO> iterator = readTaskDTOList.iterator();
            //while (iterator.hasNext()) {
            //    TaskDTO taskDTO = iterator.next();
            //    System.out.print(taskDTO.toString());
            //}
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return readTaskDTOList;
    }
}
