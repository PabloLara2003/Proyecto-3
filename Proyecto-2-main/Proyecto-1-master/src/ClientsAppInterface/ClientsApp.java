package ClientsAppInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import Interfaces.UserClientInterface;


public class ClientsApp extends JFrame {
	
    private static final String CSV_FILE = "usuarios.csv";

    private JTextField userText;
    private JPasswordField passwordText;

    public ClientsApp() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setTitle("Aplicación para Clientes");

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);

        setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Usuario:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        JButton loginButton = new JButton("Iniciar Sesión");
        loginButton.setBounds(10, 80, 150, 25);
        panel.add(loginButton);

        JButton registerButton = new JButton("Registrar Usuario");
        registerButton.setBounds(180, 80, 150, 25);
        panel.add(registerButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword());

                if (credentialsExist(username, password)) {
                    abrirVentanaPrincipal();
                } else {
                    JOptionPane.showMessageDialog(panel, "Credenciales incorrectas.");
                }
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword());

                guardarEnCSV(username, password);

                JOptionPane.showMessageDialog(panel, "Usuario registrado correctamente");
            }
        });
    }

    private boolean credentialsExist(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2 && parts[0].equals(username) && parts[1].equals(password)) {
                    return true; // Credenciales encontradas
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false; // Credenciales no encontradas
    }

    private void abrirVentanaPrincipal() {
        dispose(); // Cierra la ventana actual

        JFrame ventanaPrincipal = new JFrame("Ventana Principal");
        ventanaPrincipal.setSize(400, 300);
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        Color backgroundColor = new Color(66, 57, 91);
        panel.setBackground(backgroundColor);
        ventanaPrincipal.add(panel);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JButton perfilButton = new JButton("Perfil");
        JButton consultarVehiculoButton = new JButton("Consultar Vehículo");
        JButton realizarReservaButton = new JButton("Realizar Reserva");

        perfilButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        consultarVehiculoButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        realizarReservaButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        int espaciadoVertical = 10;
        panel.add(Box.createVerticalStrut(espaciadoVertical));
        perfilButton.setBackground(new Color(255, 255, 255));
        panel.add(perfilButton);
        panel.add(Box.createVerticalStrut(espaciadoVertical));
        panel.add(consultarVehiculoButton);
        panel.add(Box.createVerticalStrut(espaciadoVertical));
        panel.add(realizarReservaButton);
        panel.add(Box.createVerticalStrut(espaciadoVertical));

        perfilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserClientInterface.openProfileWindow(ventanaPrincipal);
            }
        });

        realizarReservaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserClientInterface.openLicenseWindow(ventanaPrincipal);
            }
        });

        consultarVehiculoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirVentanaVerificarVehiculo();
            }
        });

        ventanaPrincipal.setVisible(true);
    }

    private void abrirVentanaVerificarVehiculo() {
        JFrame ventanaVerificarVehiculo = new JFrame("Verificar Vehículo");
        ventanaVerificarVehiculo.setSize(300, 200);
        ventanaVerificarVehiculo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        ventanaVerificarVehiculo.add(panel);
        placeComponentsVerificarVehiculo(panel);

        ventanaVerificarVehiculo.setVisible(true);
    }

    private void placeComponentsVerificarVehiculo(JPanel panel) {
        panel.setLayout(new GridLayout(4, 2, 5, 5)); // 4 filas, 2 columnas, espacio vertical y horizontal de 5 píxeles

        JLabel lugarLabel = new JLabel("Lugar del alquiler:");
        JTextField lugarTextField = new JTextField();
        JLabel fechaInicioLabel = new JLabel("Fecha de inicio (dd/mm/yyyy):");
        JTextField fechaInicioTextField = new JTextField();
        JLabel fechaFinLabel = new JLabel("Fecha de fin (dd/mm/yyyy):");
        JTextField fechaFinTextField = new JTextField();

        panel.add(lugarLabel);
        panel.add(lugarTextField);
        panel.add(Box.createVerticalStrut(5)); // Espacio vertical de 5 píxeles
        panel.add(fechaInicioLabel);
        panel.add(fechaInicioTextField);
        panel.add(Box.createVerticalStrut(5)); // Espacio vertical de 5 píxeles
        panel.add(fechaFinLabel);
        panel.add(fechaFinTextField);

        JButton verificarButton = new JButton("Verificar");
        panel.add(verificarButton);

        verificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String lugar = lugarTextField.getText();
                String fechaInicio = fechaInicioTextField.getText();
                String fechaFin = fechaFinTextField.getText();

                // Puedes hacer algo con la información ingresada, por ejemplo, mostrar un mensaje.
                JOptionPane.showMessageDialog(panel, "Lugar: " + lugar + "\nFecha de inicio: " + fechaInicio + "\nFecha de fin: " + fechaFin);

                // Cierra la ventana de verificación de vehículo
                ((Window) panel.getParent()).dispose();
            }
        });
    }

    private void guardarEnCSV(String username, String password) {
        try (FileWriter writer = new FileWriter(CSV_FILE, true)) {
            writer.append(username).append(",").append(password).append("\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ClientsApp());
    }
}

