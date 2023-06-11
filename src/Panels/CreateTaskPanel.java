package Panels;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateTaskPanel extends JFrame {
    private JTextField titleField;
    private JTextField descriptionField;

    private JButton createTaskButton;

    public CreateTaskPanel() {
        setTitle("Adicionar nova tarefa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);

        JLabel label = new JLabel("Adicionar uma nova tarefa");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBorder(new EmptyBorder(new Insets(20, 0, 0, 0)));
        add(label, BorderLayout.NORTH);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(5, 1, 10, 10));

        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        panel1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel titleLabel = new JLabel("Titulo:");
        titleField = new JTextField(20);
        panel1.add(titleLabel, BorderLayout.WEST);
        panel1.add(titleField, BorderLayout.CENTER);

        mainPanel.add(panel1);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        panel2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel descriptionLabel = new JLabel("Descrição:");
        descriptionField = new JTextField(100);
        panel2.add(descriptionLabel, BorderLayout.WEST);
        panel2.add(descriptionField, BorderLayout.CENTER);

        mainPanel.add(panel2);

        JPanel panel5 = new JPanel();
        panel5.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel5.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Adicionando padding interno

        createTaskButton = new JButton("Criar");
        panel5.add(createTaskButton);

        mainPanel.add(panel5);

        createTaskButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                String description = descriptionField.getText();
                createNewTask(title, description);
            }
        });

        add(mainPanel);
        pack();

        setVisible(true);

    }

    void createNewTask(String title, String description) {}
}
