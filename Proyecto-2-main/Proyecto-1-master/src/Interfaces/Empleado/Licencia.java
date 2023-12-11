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

public class Licencia extends JFrame {

    private JPanel contentPane;
    private JTextField numero;
    private JTextField pais_exp;
    private JTextField fecha_exp;
    private JTextField foto_lic;
    private JTextField documento_ID;
    private JTextField elementos;
    private JTextPane FechaDeExpedicion;
    private JTextPane PaisDeExpedicion;
    private JTextPane DocumentoDeIdentidad;
    private JTextPane ElementosAdicionales;
    private JTextPane Numero_5;
    private JTextPane Numero;
    private JButton btnGuardar;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Licencia frame = new Licencia();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Licencia() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 283, 355);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 0, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        numero = new JTextField();
        numero.setBounds(125, 11, 96, 20);
        contentPane.add(numero);
        numero.setColumns(10);

        pais_exp = new JTextField();
        pais_exp.setColumns(10);
        pais_exp.setBounds(125, 42, 96, 34);
        contentPane.add(pais_exp);

        fecha_exp = new JTextField();
        fecha_exp.setColumns(10);
        fecha_exp.setBounds(125, 91, 96, 34);
        contentPane.add(fecha_exp);

        foto_lic = new JTextField();
        foto_lic.setColumns(10);
        foto_lic.setBounds(125, 136, 96, 44);
        contentPane.add(foto_lic);

        documento_ID = new JTextField();
        documento_ID.setColumns(10);
        documento_ID.setBounds(125, 191, 96, 33);
        contentPane.add(documento_ID);

        elementos = new JTextField();
        elementos.setColumns(10);
        elementos.setBounds(125, 235, 96, 34);
        contentPane.add(elementos);

        FechaDeExpedicion = new JTextPane();
        FechaDeExpedicion.setToolTipText("");
        FechaDeExpedicion.setText("Fecha de expedición:");
        FechaDeExpedicion.setForeground(Color.WHITE);
        FechaDeExpedicion.setBackground(Color.BLUE);
        FechaDeExpedicion.setBounds(48, 42, 58, 34);
        contentPane.add(FechaDeExpedicion);

        PaisDeExpedicion = new JTextPane();
        PaisDeExpedicion.setText("Pais de expedición:");
        PaisDeExpedicion.setForeground(Color.WHITE);
        PaisDeExpedicion.setBackground(Color.BLUE);
        PaisDeExpedicion.setBounds(48, 92, 58, 33);
        contentPane.add(PaisDeExpedicion);

        DocumentoDeIdentidad = new JTextPane();
        DocumentoDeIdentidad.setText("documento de identidad:");
        DocumentoDeIdentidad.setForeground(Color.WHITE);
        DocumentoDeIdentidad.setBackground(Color.BLUE);
        DocumentoDeIdentidad.setBounds(48, 133, 58, 48);
        contentPane.add(DocumentoDeIdentidad);

        ElementosAdicionales = new JTextPane();
        ElementosAdicionales.setText("Elementos Adicionales:");
        ElementosAdicionales.setForeground(Color.WHITE);
        ElementosAdicionales.setBackground(Color.BLUE);
        ElementosAdicionales.setBounds(48, 190, 58, 34);
        contentPane.add(ElementosAdicionales);

        Numero_5 = new JTextPane();
        Numero_5.setText("Foto de licencia:");
        Numero_5.setForeground(Color.WHITE);
        Numero_5.setBackground(Color.BLUE);
        Numero_5.setBounds(48, 235, 58, 34);
        contentPane.add(Numero_5);

        Numero = new JTextPane();
        Numero.setText("Numero:");
        Numero.setForeground(Color.WHITE);
        Numero.setBackground(Color.BLUE);
        Numero.setBounds(48, 11, 58, 20);
        contentPane.add(Numero);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(90, 284, 114, 23);
        contentPane.add(btnGuardar);

        // Add ActionListener to the "Guardar" button
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarDatosEnCSV();
            }
        });
    }

    private void guardarDatosEnCSV() {
        String numeroText = numero.getText();
        String paisExpText = pais_exp.getText();
        String fechaExpText = fecha_exp.getText();
        String fotoLicText = foto_lic.getText();
        String documentoIDText = documento_ID.getText();
        String elementosText = elementos.getText();

        // Crear la carpeta .data si no existe
        File dataFolder = new File(".data");
        if (!dataFolder.exists()) {
            dataFolder.mkdir();
        }

        String filePath = ".data/licencia.csv";

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("Numero,PaisExp,FechaExp,FotoLic,DocumentoID,Elementos\n");
            writer.write(numeroText + "," + paisExpText + "," + fechaExpText + "," +
                    fotoLicText + "," + documentoIDText + "," + elementosText + "\n");
            System.out.println("Datos guardados en el archivo licencia.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}