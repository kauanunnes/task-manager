package Panels;

import Entities.Task;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class UserPanel extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;

    public UserPanel(ArrayList<Task> tasks) {
        setTitle("Lista de Tarefas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setResizable(false);
        setLocationRelativeTo(null);

        tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableModel.addColumn("Título");
        tableModel.addColumn("Descrição");
        tableModel.addColumn("Finalizada");
        tableModel.addColumn("Criada em");

        for (Task task : tasks) {
            String msg;
            if (task.isFinished()){
                msg = "Finalizada";
            } else {
                msg = "Não finalizada";
            }
            Object[] rowData = {task.getTitle(), task.getDescription(), msg, task.getCreatedAt()};
            tableModel.addRow(rowData);
        }

        table = new JTable(tableModel);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        int tableWidth = getWidth() - 20; // Subtrai 20 para deixar um pequeno espaço de margem
        int columnCount = table.getColumnCount();
        int columnWidth = tableWidth / columnCount;

        for (int i = 0; i < columnCount; i++) {
            table.getColumnModel().getColumn(i).setPreferredWidth(columnWidth);
        }

        getContentPane().add(new JScrollPane(table));
        setVisible(true);

    }
}
