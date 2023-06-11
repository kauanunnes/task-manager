import Entities.Gender;
import Entities.Task;
import Entities.User;
import Panels.*;
import Utils.LeitorTask;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
//                new UserPanel(Task.getTasks("matheus"));
                new HomePanel();
            }
        });
        ArrayList<User> users = User.getUsers();
        for (User user : users) {
            System.out.println(user.getName());
        }
    }
}
