package Interfaces.Empleado;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ingreso extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Ingreso frame = new Ingreso();
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
    public Ingreso() {
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
                Usuario iniciarSesionFrame = new Usuario();
                iniciarSesionFrame.setVisible(true);

                // Close the current frame
                dispose();
            }
        });
    }
}