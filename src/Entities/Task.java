package Entities;
import Utils.LeitorTask;
import Utils.LeitorUser;
import java.util.ArrayList;
import java.util.Date;

public class Task {
    private String title;
    private String description;
    private Date createdAt;
    private boolean isFinished;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.createdAt = new Date();
        this.isFinished = false;
    }

    public Task(String title, String description, boolean isFinished, Date createdAt) {
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.isFinished = isFinished;
    }

    public static ArrayList<Task> getTasks(String username) {
        String filePath = "data/tasks.csv";
        LeitorTask leitor = new LeitorTask(filePath);
        return leitor.read(username);
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public boolean isFinished() {
        return isFinished;
    }
}
