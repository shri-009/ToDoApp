import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ToDoApp extends JFrame {
    private DefaultListModel<String> listModel;
    private JList<String> taskList;
    private JTextField inputField;
    private JButton addButton;
    private JButton deleteButton;

    public ToDoApp() {
        super("To-Do App");
        initComponents();
        layoutComponents();
        initListeners();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initComponents() {
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        inputField = new JTextField(20);
        addButton = new JButton("Add Task");
        deleteButton = new JButton("Delete Selected");
    }

    private void layoutComponents() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.add(inputField, BorderLayout.NORTH);

        JPanel buttons = new JPanel();
        buttons.add(addButton);
        buttons.add(deleteButton);
        panel.add(buttons, BorderLayout.CENTER);

        panel.add(new JScrollPane(taskList), BorderLayout.SOUTH);
        add(panel);
    }

    private void initListeners() {
        addButton.addActionListener(e -> {
            String text = inputField.getText().trim();
            if (!text.isEmpty()) {
                listModel.addElement(text);
                inputField.setText("");
            }
        });

        deleteButton.addActionListener(e -> {
            int idx = taskList.getSelectedIndex();
            if (idx != -1) {
                listModel.remove(idx);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ToDoApp::new);
    }
}
