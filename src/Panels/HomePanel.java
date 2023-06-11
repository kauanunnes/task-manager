package Panels;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class HomePanel extends JFrame {
    public HomePanel() {
        setTitle("Home");
        setSize(500, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(false);

        JLabel label = new JLabel("Bem-vindo ao sistema!");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBorder(new EmptyBorder(new Insets(30, 0, 0, 0)));
        add(label, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton cadastroButton = new JButton("Cadastro");
        cadastroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SignUpPanel();
                dispose();
            }
        });
        buttonPanel.add(cadastroButton);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginPanel();
                dispose();
            }
        });
        buttonPanel.add(loginButton);

        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
    }

}
