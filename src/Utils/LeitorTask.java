package Utils;

import Entities.Task;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class LeitorTask extends LeitorArquivo{
    public LeitorTask(String filename) {
        super(filename);
    }

    @Override
    public ArrayList read() {
        return null;
    }

    @Override
    public ArrayList<Task> read(String username) {
        ArrayList<Task> tasks = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(this.filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String user = values[0];
                if (!Objects.equals(user, username)) {
                    continue;
                }
                String title = values[1];
                String description = values[2];
                String isFinished = values[3];
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date createdAt = sdf.parse(values[4]);
                Task task = new Task(title, description, isFinished, createdAt);
                System.out.println(isFinished);
                tasks.add(task);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return tasks;
    }
}
