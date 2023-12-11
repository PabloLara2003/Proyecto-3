package Interfaces;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Administrator;
import Interfaces.Empleado.Usuario; // Assuming Usuario is in the Empleado package
import Handlers.ControllerAdminHandler;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainInterface extends JFrame {

    private JPanel contentPane;
    private ControllerAdminHandler cah = new ControllerAdminHandler();
    private Administrator admin = new Administrator("Juan", "Sede 1");
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainInterface frame = new MainInterface();
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
    public MainInterface() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 283, 355);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 0, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton Cliente = new JButton("Cliente");
        Cliente.setBounds(87, 58, 99, 23);
        contentPane.add(Cliente);

        JButton Empleado = new JButton("Empleado");
        Empleado.setBounds(87, 104, 99, 23);
        contentPane.add(Empleado);

        JButton Administrador = new JButton("Administrador");
        Administrador.setBounds(87, 151, 99, 23);
        contentPane.add(Administrador);

        // Add ActionListener to the "Empleado" button
        Empleado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Create and show the "Iniciar Sesion" JFrame
                Interfaces.Empleado.Usuario EmpleadoFrame = new Interfaces.Empleado.Usuario();
                EmpleadoFrame.setVisible(true);

                // Close the current frame
                dispose();
            }
        });

        // Add ActionListener to the "Cliente" button
        Cliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Create and show the "Cliente" JFrame
                UserClientInterface clienteFrame = new UserClientInterface();
                clienteFrame.setVisible(true);

                // Close the current frame
                dispose();
            }
        });

        // Add ActionListener to the "Administrador" button
        Administrador.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Create and show the "Admin" JFrame
                Interfaces.AdminInterface administradorFrame = new Interfaces.AdminInterface(cah, admin);
                administradorFrame.setVisible(true);

                // Close the current frame
                dispose();
            }
        });
    }
}


