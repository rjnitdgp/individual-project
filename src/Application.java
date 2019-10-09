import com.novare.aa.ip.dto.TaskDTO;
import com.novare.aa.ip.dto.TaskManagementDTOImpl;

public class Application {
    public static void main(String[] args) {
        System.out.println("*****Welcome*****");

        TaskManagementDTOImpl taskDTO = new TaskManagementDTOImpl();

       /* Task taskOne = new Task("Eat Food", new Date());
        User userOne = new User("Mota", "Agrawal");
        Project projectOne = new Project("FOOD");

        Task taskTwo = new Task("Drink Water", new Date());
        User userTwo = new User("Noni", "Agrawal");
        Project projectTwo = new Project("WATER");


        taskDTO.save(new TaskDTO(taskOne, projectOne, userOne));
        taskDTO.save(new TaskDTO(taskTwo, projectTwo, userTwo));
        */

        System.out.println(taskDTO.getAll().size());

        for(TaskDTO t: taskDTO.getAll()) {
            System.out.println(t.getTask().getTaskTitle());
            System.out.println(t.getProject().getProjectTitle());
            System.out.println(t.getUser().getFirstName());
        }
    }
}
