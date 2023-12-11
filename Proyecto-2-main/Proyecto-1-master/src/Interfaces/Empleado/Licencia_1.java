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
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class Licencia_1 extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField usuario_1;  // Assuming these fields are part of your requirements
    private JTextField contrasena_1;  // Assuming these fields are part of your requirements

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Licencia_1 frame = new Licencia_1();
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
    public Licencia_1() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 0, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnNewButton = new JButton("Cerrar Sesión");
        btnNewButton.setBounds(178, 214, 121, 23);
        contentPane.add(btnNewButton);

        JButton btnAadirConductor = new JButton("Añadir Conductor");
        btnAadirConductor.setBounds(178, 170, 121, 23);
        contentPane.add(btnAadirConductor);

        textField = new JTextField();
        textField.setBounds(232, 72, 96, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        JTextPane txtpnIdDeReserva = new JTextPane();
        txtpnIdDeReserva.setText("ID de Reserva:");
        txtpnIdDeReserva.setForeground(Color.WHITE);
        txtpnIdDeReserva.setBackground(Color.BLUE);
        txtpnIdDeReserva.setBounds(145, 72, 91, 20);
        contentPane.add(txtpnIdDeReserva);

        // Add ActionListener to the "Añadir Conductor" button
        btnAadirConductor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String reservaId = textField.getText();
                if (existeReserva(reservaId)) {
                    // Move to the Licencia frame
                    Licencia licenciaFrame = new Licencia();
                    licenciaFrame.setVisible(true);
                    dispose(); // Close the current frame
                } else {
                    System.out.println("La reserva no existe");
                    // You can add additional handling for the case where the reservation doesn't exist.
                }
            }
        });

        // Add ActionListener to the "Cerrar Sesión" button
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Close the application
                System.exit(0);
            }
        });
    }

    private boolean existeReserva(String reservaId) {
        // Check if the reservation exists in "Reserva.csv"
        String filePath = ".data/Reserva.csv";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 0 && parts[0].equals(reservaId)) {
                    return true; // Reservation found
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false; // Reservation not found
    }

    private void guardarDatosEnCSV() {
        String usuario = usuario_1.getText();
        String contraseña = contrasena_1.getText();

        // Crear la carpeta .data si no existe
        File dataFolder = new File(".data");
        if (!dataFolder.exists()) {
            dataFolder.mkdir();
        }

        String filePath = ".data/Crear_Usuario.csv";

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("Usuario,Contraseña\n");
            writer.write(usuario + "," + contraseña + "\n");
            System.out.println("Datos guardados en el archivo Crear_Usuario.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
