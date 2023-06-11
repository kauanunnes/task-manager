package Entities;
import Utils.LeitorArquivo;
import Utils.LeitorUser;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class User {
    private String name;
    private Gender gender;
    private Date birthday;
    private ArrayList<Task> tasks;
    private String password;
    public User(String name, String password, Gender gender, Date birthday) {
        this.name = name;
        this.gender = gender;
        this.password = password;
        this.birthday = birthday;
        this.tasks = new ArrayList<>();
    }

    public User(String name, String password, Gender gender, Date birthday, ArrayList<Task> tasks) {
        this.name = name;
        this.gender = gender;
        this.password = password;
        this.birthday = birthday;
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

    public Date getBirthday() {
        return birthday;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public boolean checkPassword(String password) {
        return Objects.equals(this.password, password);
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }
}