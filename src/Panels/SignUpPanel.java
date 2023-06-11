package Panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpPanel extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JTextField birthdayField;
    private JButton registerButton;

    public SignUpPanel() {
        setTitle("Signup Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(5, 1, 10, 10));

        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        panel1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(20);
        panel1.add(usernameLabel, BorderLayout.WEST);
        panel1.add(usernameField, BorderLayout.CENTER);

        mainPanel.add(panel1);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        panel2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);
        panel2.add(passwordLabel, BorderLayout.WEST);
        panel2.add(passwordField, BorderLayout.CENTER);

        mainPanel.add(panel2);

        JPanel panel3 = new JPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel3.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Adicionando padding interno

        JLabel genderLabel = new JLabel("Gender:");
        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);

        panel3.add(genderLabel);
        panel3.add(maleRadioButton);
        panel3.add(femaleRadioButton);

        mainPanel.add(panel3);

        JPanel panel4 = new JPanel();
        panel4.setLayout(new BorderLayout());
        panel4.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Adicionando padding interno

        JLabel birthdayLabel = new JLabel("Birthday:");
        birthdayField = new JTextField(20);
        panel4.add(birthdayLabel, BorderLayout.WEST);
        panel4.add(birthdayField, BorderLayout.CENTER);

        mainPanel.add(panel4);

        JPanel panel5 = new JPanel();
        panel5.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel5.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Adicionando padding interno

        registerButton = new JButton("Register");
        panel5.add(registerButton);

        mainPanel.add(panel5);

        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String gender = maleRadioButton.isSelected() ? "Male" : "Female";
                String birthday = birthdayField.getText();

                // Lógica de registro do usuário
                cadastrar(username, password, gender, birthday);
            }
        });

        add(mainPanel);

        pack();
        setVisible(true);
    }

    private void cadastrar(String username, String password, String gender, String birthday) {
        // Lógica de registro do usuário (pode ser substituída por sua própria lógica)
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("Gender: " + gender);
        System.out.println("Birthday: " + birthday);
    }
}
