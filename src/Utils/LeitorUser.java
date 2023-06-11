package Utils;
import Entities.Gender;
import Entities.Task;
import Entities.User;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class LeitorUser extends LeitorArquivo {
    public LeitorUser(String filename) {
        super(filename);
    }
    public ArrayList<User> read() {
            ArrayList<User> users = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(this.filename))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(",");
                    String name = values[0];
                    String password = values[1];
                    char genderChar = values[2].charAt(0);
                    Gender gender = new Gender(genderChar);
                    ArrayList<Task> tasks = Task.getTasks(name);

                    Date birthday = null;
                    try {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        birthday = dateFormat.parse(values[3]);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    User user = new User(name, password, gender, birthday, tasks);

                    users.add(user);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return users;
        }

    @Override
    public ArrayList read(String value) {
        return null;
    }

}
