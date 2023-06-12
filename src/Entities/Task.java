package Entities;
import Utils.EscreveTasks;
import Utils.LeitorTask;
import Utils.LeitorUser;

import java.text.SimpleDateFormat;
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

    public Task(String title, String description, String isFinished, Date createdAt) {
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        if (isFinished.equals("1")) {
            this.isFinished = true;
        } else this.isFinished = false;
    }

    public static ArrayList<Task> getTasks(String username) {
        String filePath = "data/tasks.csv";
        LeitorTask leitor = new LeitorTask(filePath);
        return leitor.read(username);
    }

    public static void addTask(String username, Task task) {
        String filePath = "data/tasks.csv";
        EscreveTasks.writeTasksToFile(username, task, filePath);
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCreatedAt() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(this.createdAt);
    }

    public boolean isFinished() {
        return isFinished;
    }
}
