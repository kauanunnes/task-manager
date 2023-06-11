package Panels;

import Entities.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class LoginPanel extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    public LoginPanel() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10));

        JPanel usernamePanel = new JPanel();
        usernamePanel.setLayout(new BorderLayout());
        usernamePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(10);

        usernamePanel.add(usernameLabel, BorderLayout.WEST);
        usernamePanel.add(usernameField, BorderLayout.CENTER);

        panel.add(usernamePanel);

        JPanel passwordPanel = new JPanel();
        passwordPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
        passwordPanel.setLayout(new BorderLayout());


        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(16);

        passwordPanel.add(passwordLabel, BorderLayout.WEST);
        passwordPanel.add(passwordField, BorderLayout.CENTER);

        panel.add(passwordPanel);

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new BorderLayout());
        loginPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        loginButton = new JButton("Login");


        loginPanel.add(loginButton);

        panel.add(loginPanel);

        add(panel);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                login(username, password);
            }
        });
        pack();
        setVisible(true);
    }

    public void login(String username, String password) {
        ArrayList<User> users = User.getUsers();
        AtomicReference<User> currentUser = new AtomicReference<User>();
        AtomicBoolean flag = new AtomicBoolean(false);
        users.forEach(user -> {
            if (Objects.equals(user.getName(), username)) {
                if (user.checkPassword(password)) {
                  flag.set(true);
                  currentUser.set(user);
                }
            }
        });
        if (flag.get()) {
            JOptionPane.showMessageDialog(LoginPanel.this, "Login efetuado com sucesso!");
            dispose();
            new UserPanel(currentUser.get().getTasks());
        } else {
            JOptionPane.showMessageDialog(LoginPanel.this, "Usuário ou senha inválidos.");
        }
    }
}
