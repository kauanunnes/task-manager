package Utils;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import Entities.Task;
import Entities.User;

public class EscreveTasks {
    public static void writeTasksToFile(User user, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Task task : user.getTasks()) {
                writer.write(task.getTitle() + ",");
                writer.write(task.getDescription() + ",");
                writer.write(task.getCreatedAt().toString() + ",");
                writer.write(task.isFinished() ? "1" : "0"); // Write the boolean as "1" or "0"
                writer.newLine();
            }
            
            System.out.println("Task data written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
