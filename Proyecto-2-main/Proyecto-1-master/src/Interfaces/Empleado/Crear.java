package Interfaces.Empleado;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class Crear extends JFrame {

    private JPanel contentPane;
    private JTextField usuario_1;
    private JTextField contrasena_1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Crear frame = new Crear();
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
    public Crear() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 283, 355);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 0, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        usuario_1 = new JTextField();
        usuario_1.setBounds(130, 56, 96, 20);
        contentPane.add(usuario_1);
        usuario_1.setColumns(10);

        contrasena_1 = new JTextField();
        contrasena_1.setBounds(130, 143, 96, 20);
        contentPane.add(contrasena_1);
        contrasena_1.setColumns(10);

        JTextPane Usuario = new JTextPane();
        Usuario.setText("Usuario:");
        Usuario.setForeground(Color.WHITE);
        Usuario.setBackground(Color.BLUE);
        Usuario.setBounds(57, 56, 49, 20);
        contentPane.add(Usuario);

        JTextPane Contrasena = new JTextPane();
        Contrasena.setText("Contraseña:");
        Contrasena.setForeground(Color.WHITE);
        Contrasena.setBackground(Color.BLUE);
        Contrasena.setBounds(57, 143, 63, 20);
        contentPane.add(Contrasena);

        JButton Inicio = new JButton("Iniciar sesión");
        Inicio.setBounds(95, 240, 109, 23);
        contentPane.add(Inicio);

        JButton Continuar = new JButton("Guardar");
        Continuar.setBounds(105, 208, 89, 23);
        contentPane.add(Continuar);

        // ActionListener para el botón "Inicio"
        Inicio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Crear una instancia del JFrame Usuario y mostrarlo
                Usuario usuarioFrame = new Usuario();
                usuarioFrame.setVisible(true);
                
                // Cerrar el JFrame actual
                dispose();
            }
        });

        // ActionListener para el botón "Continuar"
        Continuar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarDatosEnCSV();
                System.out.println("Usuario guardado");
            }
        });
    }

    // Función para guardar en el archivo CSV
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
