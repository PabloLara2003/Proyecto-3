package Interfaces.Empleado;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class Disponibilidad_2 extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Disponibilidad_2 frame = new Disponibilidad_2();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Disponibilidad_2() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 283, 355);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 0, 255));
        contentPane.setForeground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setModel(new DefaultComboBoxModel<>(new String[]{"carro 1", "carro 2", "carro 3", "carro 4", "carro 5"}));
        comboBox.setToolTipText("");
        comboBox.setBounds(61, 43, 147, 22);
        contentPane.add(comboBox);

        JButton C_Disponibilidad = new JButton("Cambiar Disponibilidad");
        C_Disponibilidad.setBounds(61, 177, 147, 23);
        contentPane.add(C_Disponibilidad);

        JButton Cerrar_S = new JButton("cerrar Sesión");
        Cerrar_S.setBounds(76, 262, 114, 23);
        contentPane.add(Cerrar_S);

        JComboBox<String> comboBox_1 = new JComboBox<>();
        comboBox_1.setModel(new DefaultComboBoxModel<>(new String[]{"disponible", "ocupado", "limpieza"}));
        comboBox_1.setToolTipText("");
        comboBox_1.setBounds(61, 76, 147, 22);
        contentPane.add(comboBox_1);

        // Add ActionListener to the "Cerrar_S" button
        Cerrar_S.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Close the application
                System.exit(0);
            }
        });

        // Add ActionListener to the "C_Disponibilidad" button
        C_Disponibilidad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedCar = comboBox.getSelectedItem().toString();
                String newStatus = comboBox_1.getSelectedItem().toString();

                try {
                    String filePath = "data/Disponibilidad.csv";
                    if (!fileExists(filePath)) {
                        createFile(filePath);
                    }
                    cambiarDisponibilidad(filePath, selectedCar, newStatus);
                    JOptionPane.showMessageDialog(null, "Disponibilidad de " + selectedCar + " cambiada a " + newStatus);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    private boolean fileExists(String fileName) {
        File file = new File(fileName);
        return file.exists();
    }

    private void createFile(String fileName) throws IOException {
        File file = new File(fileName);
        file.getParentFile().mkdirs();  // Create parent directories if they don't exist
        file.createNewFile();
    }

    private void cambiarDisponibilidad(String filePath, String selectedCar, String newStatus) throws IOException {
        File file = new File(filePath);
        File tempFile = new File("data/tempDisponibilidad.csv");

        try (BufferedReader br = new BufferedReader(new FileReader(file));
             FileWriter fw = new FileWriter(tempFile)) {

            String line;
            boolean found = false;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2 && parts[0].trim().equals(selectedCar)) {
                    // Update the status
                    line = selectedCar + "," + newStatus;
                    found = true;
                }
                fw.write(line + System.lineSeparator());
            }

            if (!found) {
                // If the car entry was not found, add a new entry
                fw.write(selectedCar + "," + newStatus + System.lineSeparator());
            }
        }

        // Rename the temp file to the original file
        tempFile.renameTo(file);
    }
}
