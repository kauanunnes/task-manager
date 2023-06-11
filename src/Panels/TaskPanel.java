package Panels;

import Entities.Task;

import javax.swing.*;
import java.awt.*;

public class TaskPanel extends JPanel {
    public TaskPanel(Task task) {
        JLabel label = new JLabel(task.getTitle());
        JLabel label1 = new JLabel(task.getDescription());
        add(label);
        add(label1);
    }
}
