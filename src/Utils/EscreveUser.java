package Utils;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import Entities.User;

public class EscreveUser {
    public static void writeUserToFile(User user, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(user.getName() + ",");
            writer.write(user.getGender().getGender() + ",");
            writer.write(user.getBirthday().toString() + ",");
            
            writer.newLine();
            System.out.println("User data written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}