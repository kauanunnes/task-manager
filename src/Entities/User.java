package Entities;
import Utils.EscreveUser;
import Utils.LeitorArquivo;
import Utils.LeitorUser;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class User {
    private String name;
    private Gender gender;
    private ArrayList<Task> tasks;
    private String password;
    public User(String name, String password, Gender gender) {
        this.name = name;
        this.gender = gender;
        this.password = password;
        this.tasks = new ArrayList<>();
    }

    public User(String name, String password, Gender gender, ArrayList<Task> tasks) {
        this.name = name;
        this.gender = gender;
        this.password = password;
        this.tasks = tasks;
    }

    public static ArrayList<User> getUsers() {
        String filePath = "data/users.csv";
        LeitorUser leitor = new LeitorUser(filePath);
        return leitor.read();
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public boolean checkPassword(String password) {
        return Objects.equals(this.password, password);
    }

    public static void register(User user) {
        String filePath = "data/users.csv";
        EscreveUser.writeUserToFile(user, filePath);
    }

    public String getPassword() { return this.password;}

    public static void addTask(Task task, String username) {

        Task.addTask(username, task);
    }
}
