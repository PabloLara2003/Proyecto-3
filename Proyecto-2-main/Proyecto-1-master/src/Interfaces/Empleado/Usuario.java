package Interfaces.Empleado;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class Usuario extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Usuario frame = new Usuario();
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
    public Usuario() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 283, 355);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 0, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        textField = new JTextField();
        textField.setBounds(125, 84, 96, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(125, 154, 96, 20);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        JTextPane Usuario = new JTextPane();
        Usuario.setText("Usuario:");
        Usuario.setForeground(Color.WHITE);
        Usuario.setBackground(Color.BLUE);
        Usuario.setBounds(53, 84, 49, 20);
        contentPane.add(Usuario);

        JTextPane Contrasena = new JTextPane();
        Contrasena.setText("Contraseña:");
        Contrasena.setForeground(Color.WHITE);
        Contrasena.setBackground(Color.BLUE);
        Contrasena.setBounds(52, 154, 63, 20);
        contentPane.add(Contrasena);

        JTextPane IniciarSesion = new JTextPane();
        IniciarSesion.setText("Iniciar Sesión");
        IniciarSesion.setForeground(Color.WHITE);
        IniciarSesion.setBackground(Color.BLUE);
        IniciarSesion.setBounds(106, 22, 78, 20);
        contentPane.add(IniciarSesion);

        JButton btnNewButton = new JButton("Continuar");
        btnNewButton.setBounds(95, 228, 89, 23);
        contentPane.add(btnNewButton);
        
        JButton CrearUsuario = new JButton("Crear Usuario");
        CrearUsuario.setBounds(80, 262, 115, 23);
        contentPane.add(CrearUsuario);

        // Add ActionListener to the "CrearUsuario" button
        CrearUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Move to the crear_Usuario frame
                Crear crearUsuarioFrame = new Crear();
                crearUsuarioFrame.setVisible(true);
                dispose(); // Close the current frame
            }
        });

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (validarCredenciales()) {
                    // Move to the Disponibilidad frame
                    Disponibilidad opcionesFrame = new Disponibilidad();
                    opcionesFrame.setVisible(true);
                    dispose(); // Close the current frame
                } else {
                    System.out.println("Credenciales incorrectas");
                }
            }
        });
    }

    private boolean validarCredenciales() {
        String usuario = textField.getText();
        String contraseña = textField_1.getText();
        String filePath = ".data/Crear_Usuario.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2 && parts[0].equals(usuario) && parts[1].equals(contraseña)) {
                    return true; // Credentials found
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false; // Credentials not found
    }
}
