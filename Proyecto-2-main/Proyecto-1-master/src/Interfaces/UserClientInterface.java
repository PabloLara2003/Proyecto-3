package Interfaces;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Reservations.Reservation;

public class UserClientInterface extends JFrame {
    private static int licenseNumber;
    private static String licenseExpCountry;
    private static String licenseExpDate;
    private static String licenseImageURL;

    private static int creditCardNumber;
    private static String creditCardExpDate;
    private static String creditCardSecurityCode;

    // Agrega una lista de textFields como variable de instancia
    private static List<JTextField> textFields;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Interfaz de Cliente");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Color backgroundColor = new Color(66, 57, 91);
        JPanel panel = new JPanel();
        panel.setBackground(backgroundColor);
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.setLayout(new GridLayout(3, 1, 10, 10));  // Cambiado a 3 filas

        JButton btnReserva = createButton("Realizar Reserva", frame);
        JButton btnCancela = createButton("Cancelar Reserva", frame);
        JButton btnPerfil = createButton("Perfil", frame);

        panel.add(btnReserva);
        panel.add(btnCancela);
        panel.add(btnPerfil);

        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }

    private static JButton createButton(String text, JFrame frame) {
        JButton button = new JButton(text);
        Color buttonColor = new Color(255, 255, 255);
        button.setBackground(buttonColor);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (text.equals("Realizar Reserva")) {
                    openLicenseWindow(frame);
                } else if (text.equals("Perfil")) {
                    openProfileWindow(frame);
                } else if (text.equals("Cancelar Reserva")) {
                    openCancelConfirmationWindow(frame);
                } else {
                    JOptionPane.showMessageDialog(null, "Has presionado el botón " + text);
                }
            }
        });
        return button;
    }

    private static void openCancelConfirmationWindow(JFrame parentFrame) {
        JFrame cancelFrame = new JFrame("Confirmación de Cancelación");
        cancelFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel cancelPanel = new JPanel();
        cancelPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        cancelPanel.setLayout(new GridLayout(3, 1, 10, 10));

        JLabel lblConfirmation = new JLabel("¿Desea cancelar la reservación hecha con nosotros?");
        JButton btnYes = new JButton("Sí");
        JButton btnNo = new JButton("No");

        btnYes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelFrame.dispose();  // Cierra la ventana de confirmación
                openCancellationSuccessWindow(parentFrame);  // Abre la ventana de éxito de cancelación
            }
        });

        btnNo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelFrame.dispose();  // Cierra la ventana de confirmación
            }
        });

        cancelPanel.add(lblConfirmation);
        cancelPanel.add(btnYes);
        cancelPanel.add(btnNo);

        cancelFrame.getContentPane().add(cancelPanel, BorderLayout.CENTER);
        cancelFrame.setSize(400, 150);
        cancelFrame.setLocationRelativeTo(parentFrame);
        cancelFrame.setVisible(true);
    }

    private static void openCancellationSuccessWindow(JFrame parentFrame) {
        JFrame successFrame = new JFrame("Cancelación Exitosa");
        successFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel successPanel = new JPanel();
        Color backgroundColor = new Color(66, 57, 91);
        successPanel.setBackground(backgroundColor);
        successPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        successPanel.setLayout(new GridLayout(3, 1, 10, 10));

        JLabel lblMessage = new JLabel("<html>Se ha cancelado tu reserva. Recuerda que el dinero descontado de tu tarjeta de crédito será devuelto en los próximos 5 días hábiles. Gracias por pensar en nosotros, esperamos servirte en otra oportunidad.</html>");
        lblMessage.setForeground(Color.WHITE);  // Establece el color del texto

        JButton btnClose = new JButton("Cerrar");
        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                successFrame.dispose();  // Cierra la ventana de éxito de cancelación
                parentFrame.setVisible(true);  // Muestra la ventana de interfaz de cliente
            }
        });

        successPanel.add(lblMessage);
        successPanel.add(btnClose);

        successFrame.getContentPane().add(successPanel, BorderLayout.CENTER);
        successFrame.setSize(500, 200);
        successFrame.setLocationRelativeTo(parentFrame);
        successFrame.setVisible(true);
    }

    public static void openProfileWindow(JFrame parentFrame) {
        JFrame profileFrame = new JFrame("Perfil del Usuario");
        profileFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel profilePanel = new JPanel();
        profilePanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        profilePanel.setLayout(new GridLayout(7, 2, 10, 10));

        String[] labels = {"Nombre:", "Fecha de Nacimiento:", "Teléfono:", "Nacionalidad:",
                "Documento de Identidad:"};

        // Inicializa la lista de textFields para el perfil
        List<JTextField> profileTextFields = new ArrayList<>();

        for (String label : labels) {
            JLabel lbl = new JLabel(label);
            JTextField textField = new JTextField();
            profileTextFields.add(textField);  // Agrega cada textField a la lista
            profilePanel.add(lbl);
            profilePanel.add(textField);
        }

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes guardar la información del perfil si es necesario
                profileFrame.dispose();
            }
        });

        profilePanel.add(btnGuardar);

        profileFrame.getContentPane().add(profilePanel, BorderLayout.CENTER);
        profileFrame.setSize(400, 300);
        profileFrame.setLocationRelativeTo(parentFrame);
        profileFrame.setVisible(true);
    }

    public static void openLicenseWindow(JFrame parentFrame) {
        JFrame licenseFrame = new JFrame("Licencia");
        licenseFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel licensePanel = new JPanel();
        licensePanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        licensePanel.setLayout(new GridLayout(7, 2, 10, 10));

        String[] labels = {"Número:", "País de expedición:", "Fecha de expedición:", "Foto de licencia (str):",
                "Documento de identidad:", "Elementos adicionales:"};

        // Inicializa la lista de textFields
        textFields = new ArrayList<>();

        for (String label : labels) {
            JLabel lbl = new JLabel(label);
            JTextField textField = new JTextField();
            textFields.add(textField);  // Agrega cada textField a la lista
            licensePanel.add(lbl);
            licensePanel.add(textField);
        }

        JButton btnContinuar = new JButton("Continuar");
        btnContinuar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                licenseNumber = Integer.parseInt(textFields.get(0).getText());
                licenseExpCountry = textFields.get(1).getText();
                licenseExpDate = textFields.get(2).getText();
                licenseImageURL = textFields.get(3).getText();

                openCreditCardWindow(parentFrame);
                licenseFrame.dispose();
            }
        });

        licensePanel.add(btnContinuar);

        licenseFrame.getContentPane().add(licensePanel, BorderLayout.CENTER);
        licenseFrame.setSize(400, 300);
        licenseFrame.setLocationRelativeTo(parentFrame);
        licenseFrame.setVisible(true);
    }

    private static void openCreditCardWindow(JFrame parentFrame) {
        JFrame creditCardFrame = new JFrame("Tarjeta de Crédito");
        creditCardFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel creditCardPanel = new JPanel();
        creditCardPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        creditCardPanel.setLayout(new GridLayout(4, 2, 10, 10));

        String[] labels = {"Número:", "Fecha de expedición:", "Código de seguridad:"};

        for (String label : labels) {
            JLabel lbl = new JLabel(label);
            JTextField textField = new JTextField();
            textFields.add(textField);  // Agrega cada textField a la lista
            creditCardPanel.add(lbl);
            creditCardPanel.add(textField);
        }

        JButton btnContinuar = new JButton("Continuar");
        btnContinuar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Accede a los textFields desde la lista textFields
                creditCardNumber = Integer.parseInt(textFields.get(6).getText());
                creditCardExpDate = textFields.get(7).getText();
                creditCardSecurityCode = textFields.get(8).getText();

                openPickUpWindow(parentFrame);
                creditCardFrame.dispose();
            }
        });

        creditCardPanel.add(btnContinuar);

        creditCardFrame.getContentPane().add(creditCardPanel, BorderLayout.CENTER);
        creditCardFrame.setSize(400, 200);
        creditCardFrame.setLocationRelativeTo(parentFrame);
        creditCardFrame.setVisible(true);
    }

    private static void openPickUpWindow(JFrame parentFrame) {
        JFrame pickUpFrame = new JFrame("Pick Up");
        pickUpFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel pickUpPanel = new JPanel();
        pickUpPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        pickUpPanel.setLayout(new GridLayout(13, 1, 10, 10));  // Incrementa el número de filas a 13

        // Agrega la nueva casilla para el nombre
        JLabel lblNombre = new JLabel("Nombre:");
        JTextField txtNombre = new JTextField();
        pickUpPanel.add(lblNombre);
        pickUpPanel.add(txtNombre);

        // Resto de las casillas
        String[] labels = {"Categoría del vehículo:", "Lugar de Recogida:", "Fecha y Hora (YYYY/MM/DD/hh/mm):", "Días de alquiler:",
                "¿Desea incluir seguro? (Sí/No):", "¿Desea incluir servicios adicionales? (Sí/No):",
                "Número de conductores adicionales:", "Temporada (summer, winter, fall, spring):"};

        for (String label : labels) {
            JLabel lbl = new JLabel(label);
            JTextField textField = new JTextField();
            textFields.add(textField);  // Agrega cada textField a la lista
            pickUpPanel.add(lbl);
            pickUpPanel.add(textField);
        }

        JButton btnContinuar = new JButton("Continuar");
        btnContinuar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openDeliveryWindow(parentFrame);
                pickUpFrame.dispose();
            }
        });

        pickUpPanel.add(btnContinuar);

        pickUpFrame.getContentPane().add(pickUpPanel, BorderLayout.CENTER);
        pickUpFrame.setSize(400, 450);  // Incrementa la altura de la ventana
        pickUpFrame.setLocationRelativeTo(parentFrame);
        pickUpFrame.setVisible(true);
    }

    private static void openDeliveryWindow(JFrame parentFrame) {
        JFrame deliveryFrame = new JFrame("Delivery");
        deliveryFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel deliveryPanel = new JPanel();
        deliveryPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        deliveryPanel.setLayout(new GridLayout(3, 2, 10, 10));

        String[] labels = {"Lugar de Entrega:", "Fecha y Hora (YYYY/MM/DD/hh/mm):"};

        for (String label : labels) {
            JLabel lbl = new JLabel(label);
            JTextField textField = new JTextField();
            textFields.add(textField);  // Agrega cada textField a la lista
            deliveryPanel.add(lbl);
            deliveryPanel.add(textField);
        }

        JButton btnEnviar = new JButton("Enviar");
        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openReservationWindow(parentFrame);
                deliveryFrame.dispose();
            }
        });

        deliveryPanel.add(btnEnviar);

        deliveryFrame.getContentPane().add(deliveryPanel, BorderLayout.CENTER);
        deliveryFrame.setSize(400, 200);
        deliveryFrame.setLocationRelativeTo(parentFrame);
        deliveryFrame.setVisible(true);
    }

    private static void openReservationWindow(JFrame parentFrame) {
        JFrame reservationFrame = new JFrame("Licencia Inscrita");
        reservationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel reservationPanel = new JPanel();
        reservationPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        reservationPanel.setLayout(new GridLayout(1, 1, 10, 10));

        Map<String, Object> licenseInfo = new Reservation().driverLicense(licenseNumber, licenseExpCountry, licenseExpDate, licenseImageURL);
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.append("Detalles de la Licencia:\n");
        for (Map.Entry<String, Object> entry : licenseInfo.entrySet()) {
            textArea.append(entry.getKey() + ": " + entry.getValue() + "\n");
        }

        JButton btnContinuar = new JButton("Continuar");
        btnContinuar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openCreditCardInscribedWindow(parentFrame);
                reservationFrame.dispose();
            }
        });

        reservationPanel.add(new JScrollPane(textArea));
        reservationPanel.add(btnContinuar);

        reservationFrame.getContentPane().add(reservationPanel, BorderLayout.CENTER);
        reservationFrame.setSize(400, 300);
        reservationFrame.setLocationRelativeTo(parentFrame);
        reservationFrame.setVisible(true);
    }

    private static void openCreditCardInscribedWindow(JFrame parentFrame) {
        JFrame creditCardInscribedFrame = new JFrame("Tarjeta Inscrita");
        creditCardInscribedFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel creditCardInscribedPanel = new JPanel();
        creditCardInscribedPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        creditCardInscribedPanel.setLayout(new GridLayout(2, 1, 10, 10));

        Map<String, Object> creditCardInfo = new Reservation().creditCard(creditCardNumber, creditCardExpDate, creditCardSecurityCode);
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.append("Detalles de la Tarjeta Inscrita:\n");
        for (Map.Entry<String, Object> entry : creditCardInfo.entrySet()) {
            textArea.append(entry.getKey() + ": " + entry.getValue() + "\n");
        }

        JButton btnContinuar = new JButton("Continuar");
        btnContinuar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openReservationSuccessWindow(parentFrame, creditCardInfo);
                creditCardInscribedFrame.dispose();
            }
        });

        creditCardInscribedPanel.add(new JScrollPane(textArea));
        creditCardInscribedPanel.add(btnContinuar);

        creditCardInscribedFrame.getContentPane().add(creditCardInscribedPanel, BorderLayout.CENTER);
        creditCardInscribedFrame.setSize(400, 300);
        creditCardInscribedFrame.setLocationRelativeTo(parentFrame);
        creditCardInscribedFrame.setVisible(true);
    }

    private static void openReservationSuccessWindow(JFrame parentFrame, Map<String, Object> creditCardInfo) {
        JFrame successFrame = new JFrame("Reserva Exitosa");
        successFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel successPanel = new JPanel();
        successPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        Color backgroundColor = new Color(66, 57, 91);
        successPanel.setBackground(backgroundColor);
        successPanel.setLayout(new GridLayout(2, 1, 10, 10));  // Modificado a 2 filas

        // Llamamos a la función createReservation con los datos de las ventanas PickUp y Delivery
        Map<String, Object> reservationDetails = new Reservation().createReservation(
                textFields.get(8).getText(),   // clientName
                textFields.get(9).getText(),   // vehicleCategory
                textFields.get(10).getText(),  // pickUpPOS
                textFields.get(11).getText(),  // pickUpDateHour
                textFields.get(17).getText(),  // deliverPOS
                textFields.get(18).getText(),  // deliverDateHourRange
                textFields.get(16).getText(),  // highSeason
                textFields.get(14).getText(),  // additionalService
                textFields.get(13).getText(),  // InsuranceService
                Integer.parseInt(textFields.get(15).getText()),  // addExtraDriver
                Integer.parseInt(textFields.get(12).getText())   // rentalDays
        );

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.append("Detalles de la Reserva:\n");
        for (Map.Entry<String, Object> entry : reservationDetails.entrySet()) {
            textArea.append(entry.getKey() + ": " + entry.getValue() + "\n");
        }

        // Agregamos la información de la tarjeta de crédito al área de texto
        textArea.append("\nDetalles de la Tarjeta Inscrita:\n");
        for (Map.Entry<String, Object> entry : creditCardInfo.entrySet()) {
            textArea.append(entry.getKey() + ": " + entry.getValue() + "\n");
        }

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                successFrame.dispose();  // Cierra la ventana actual
                parentFrame.setVisible(true);  // Muestra la ventana de interfaz de cliente
            }
        });

        successPanel.add(new JScrollPane(textArea));
        successPanel.add(btnGuardar);

        successFrame.getContentPane().add(successPanel, BorderLayout.CENTER);
        successFrame.setSize(400, 300);  // Modificado el tamaño de la ventana
        successFrame.setLocationRelativeTo(parentFrame);
        successFrame.setVisible(true);
    }
}




