import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserManagementApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Gestión de Usuarios");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel nameLabel = new JLabel("Nombre:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(nameLabel, gbc);

        JTextField nameField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(nameField, gbc);

        JLabel typeLabel = new JLabel("Tipo:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(typeLabel, gbc);

        JComboBox<String> typeComboBox = new JComboBox<>(new String[] { "Admin", "Usuario" });
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(typeComboBox, gbc);

        JButton addButton = new JButton("Añadir");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(addButton, gbc);

        JButton closeButton = new JButton("Cerrar");
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(closeButton, gbc);

        JLabel adminListLabel = new JLabel("Lista de administradores:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(adminListLabel, gbc);

        JList<String> adminList = new JList<>(new DefaultListModel<>());
        JScrollPane adminScrollPane = new JScrollPane(adminList);
        adminScrollPane.setPreferredSize(new Dimension(300, 200));
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(adminScrollPane, gbc);

        JLabel userListLabel = new JLabel("Lista de usuarios:");
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(userListLabel, gbc);

        JList<String> userList = new JList<>(new DefaultListModel<>());
        JScrollPane userScrollPane = new JScrollPane(userList);
        userScrollPane.setPreferredSize(new Dimension(300, 200));
        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(userScrollPane, gbc);

        frame.add(panel);
        frame.setVisible(true);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String type = (String) typeComboBox.getSelectedItem();
                if (type.equals("Admin")) {
                    ((DefaultListModel<String>) adminList.getModel()).addElement(name);
                } else {
                    ((DefaultListModel<String>) userList.getModel()).addElement(name);
                }
                nameField.setText("");
            }
        });

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }
}
