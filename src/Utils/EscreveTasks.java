package Utils;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import Entities.Task;
import Entities.User;

public class EscreveTasks {
    public static void writeTasksToFile(String username, Task task, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(username + ",");
            writer.write(task.getTitle() + ",");
            writer.write(task.getDescription() + ",");
            writer.write(task.isFinished() ? "1" : "0" + ","); // Write the boolean as "1" or "0"
            writer.write(task.getCreatedAt());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
