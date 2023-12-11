package Interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controller.Administrator;
import Handlers.ControllerAdminHandler;

public class AdminInterface extends JFrame implements ActionListener {
	JButton BtnRegVehiculo;
	JButton BtnElmiVehiculo;
	JButton BtnRegCategoria;
	JButton BtnRegSede;
	JButton BtnRegEmpleado;
	JButton BtnAtrasCV;
	JButton BtnAtrasRD;
	JButton BtnAtrasCF;
	Color backgroundColor = new Color(66, 57, 91);
	ControllerAdminHandler adminF;
	Administrator admin;
	
	public AdminInterface(ControllerAdminHandler cah, Administrator adminP) {
		setSize(500, 650);
		setTitle("Admin");
		setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setBackground(backgroundColor);
        adminF = cah;
        admin = adminP;

        add(panel);
        panel.setLayout(new GridLayout(11,3));
               
        for (int i = 1; i <= 33; i++) {
	        if (i == 5) {
		        BtnRegVehiculo = new JButton("Register Vehiculo");
		        BtnRegVehiculo.addActionListener(this);
		        panel.add(BtnRegVehiculo);
	        }else if (i == 11) {
		        BtnElmiVehiculo = new JButton("Eliminar Vehiculo");
		        BtnElmiVehiculo.addActionListener(this);
		        panel.add(BtnElmiVehiculo);
	        }else if (i == 17) {
		        BtnRegCategoria = new JButton("Register Categoria");
		        BtnRegCategoria.addActionListener(this);
		        panel.add(BtnRegCategoria);
	        }else if (i == 23) {
		        BtnRegSede = new JButton("Registrar Sede");
		        BtnRegSede.addActionListener(this);
		        panel.add(BtnRegSede);
        	}else if (i == 29) {
		        BtnRegEmpleado = new JButton("Register Empleado");
		        BtnRegEmpleado.addActionListener(this);
		        panel.add(BtnRegEmpleado);
			}else {
				panel.add(new JLabel(""));
			}
        }
	}
	
	public void crearRegVehiculo(JFrame parentFrame) {
		JFrame licenseFrame = new JFrame("Registrar Vehiculo");
        licenseFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel licensePanel = new JPanel();
        licensePanel.setBackground(backgroundColor);
        licensePanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        licensePanel.setLayout(new GridLayout(11, 2, 10, 10));

        String[] labels = {"ID:", "Placa:", "Marca:",  "Modelo:", "Color:", "Categoría:",
                "Fecha de disponibilidad:", "Sede:", "Estado:", "Kilometraje:"};
        JTextField txtFCal = new JTextField();
        for (String label : labels) {
            JLabel lbl = new JLabel(label);
            lbl.setForeground(Color.white);
            JTextField textField = new JTextField();
            licensePanel.add(lbl);
            licensePanel.add(textField);
       }
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	licenseFrame.setVisible(false);
        }});
        licensePanel.add(btnCancelar);
        JButton btnContinuar = new JButton("Registrar");
        btnContinuar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	JTextField txtID = (JTextField) licensePanel.getComponent(1);
                JTextField txtPlaca = (JTextField) licensePanel.getComponent(3);
                JTextField txtMarca = (JTextField) licensePanel.getComponent(5);
                JTextField txtModelo = (JTextField) licensePanel.getComponent(7);
                JTextField txtColor = (JTextField) licensePanel.getComponent(9);
                JTextField txtCategoria = (JTextField) licensePanel.getComponent(11);
                JTextField txtFecha = (JTextField) licensePanel.getComponent(13);
                JTextField txtSede = (JTextField) licensePanel.getComponent(15);
                JTextField txtEstado = (JTextField) licensePanel.getComponent(17);
                JTextField txtKilometraje = (JTextField) licensePanel.getComponent(19);
            	if ((!txtID.getText().isEmpty())&&(!txtPlaca.getText().isEmpty())&&(!txtMarca.getText().isEmpty())&&(!txtModelo.getText().isEmpty())&&(!txtColor.getText().isEmpty())&&(!txtCategoria.getText().isEmpty())&&(!txtFecha.getText().isEmpty())&&(!txtSede.getText().isEmpty())&&(!txtEstado.getText().isEmpty())&&(!txtKilometraje.getText().isEmpty())) {
            		Date fecha = new Date(txtFecha.getText());
            		Date hoy = new Date();
            		Boolean disp = false;
            		if (fecha.getYear() < hoy.getYear() || (fecha.getYear() == hoy.getYear() && fecha.getMonth() < hoy.getMonth()) || (fecha.getYear() == hoy.getYear() && fecha.getMonth() == hoy.getMonth() && fecha.getDay() <= hoy.getDay())) {
            			disp = true;
            		}
            		adminF.addCar(admin, Integer.parseInt(txtID.getText()), txtPlaca.getText(), txtCategoria.getText(), txtMarca.getText(), txtModelo.getText(), Float.parseFloat(txtKilometraje.getText()), disp, txtEstado.getText(), txtSede.getText(), txtColor.getText());
            		JOptionPane.showMessageDialog(null, "Se ha registrado el vehiculo con exito");
	            	licenseFrame.setVisible(false);
            	}
            	else
            		JOptionPane.showMessageDialog(null, "No se han rellenado todas las casillas");
            }});
        licensePanel.add(btnContinuar);
        licenseFrame.getContentPane().add(licensePanel, BorderLayout.CENTER);
        licenseFrame.setSize(400, 500);
        licenseFrame.setLocationRelativeTo(parentFrame);
        licenseFrame.setVisible(true);
	}
	
	public void eleminarVehiculo(JFrame parentFrame) {
		JFrame licenseFrame = new JFrame("Eliminar Vehiculo");
        licenseFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel licensePanel = new JPanel();
        licensePanel.setBackground(backgroundColor);
        licensePanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        licensePanel.setLayout(new GridLayout(4, 2, 10, 10));
        JLabel lbl = new JLabel("ID");
        lbl.setForeground(Color.white);
        JTextField textField = new JTextField();
        licensePanel.add(lbl);
        licensePanel.add(textField);
        licensePanel.add(new JLabel());
        licensePanel.add(new JLabel());
        licensePanel.add(new JLabel());
        licensePanel.add(new JLabel());
      
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	licenseFrame.setVisible(false);
        }});
        licensePanel.add(btnCancelar);
        JButton btnContinuar = new JButton("Registrar");
        btnContinuar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	JTextField txtPlaca = (JTextField) licensePanel.getComponent(1);
            	if ((!txtPlaca.getText().isEmpty())) {
	            	JOptionPane.showMessageDialog(null, "Se ha eliminado el vehiculo con exito");
	            	licenseFrame.setVisible(false);
            	}
            	else
            		JOptionPane.showMessageDialog(null, "No se han rellenado todas las casillas");
            }});
        licensePanel.add(btnContinuar);
        licenseFrame.getContentPane().add(licensePanel, BorderLayout.CENTER);
        licenseFrame.setSize(400, 300);
        licenseFrame.setLocationRelativeTo(parentFrame);
        licenseFrame.setVisible(true);
	}
	
	public void registrarCategoria(JFrame parentFrame) {
		JFrame licenseFrame = new JFrame("Registrar Categoria");
        licenseFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel licensePanel = new JPanel();
        licensePanel.setBackground(backgroundColor);
        licensePanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        licensePanel.setLayout(new GridLayout(7, 2, 10, 10));

        String[] labels = {"ID:", "", "Tarifa diaria:", "",
                "Tarifa extra:", ""};

        for (String label : labels) {
        	if(!label.isEmpty()) {
        		JLabel lbl = new JLabel(label);
        		lbl.setForeground(Color.white);
                JTextField textField = new JTextField();
                licensePanel.add(lbl);
                licensePanel.add(textField);
        		
        	}else {
        		licensePanel.add(new JLabel());
                licensePanel.add(new JLabel());
        	}
            
       }
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	licenseFrame.setVisible(false);
        }});
        licensePanel.add(btnCancelar);
        JButton btnContinuar = new JButton("Registrar");
        btnContinuar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	JTextField txtPlaca = (JTextField) licensePanel.getComponent(1);
                JTextField txtModelo = (JTextField) licensePanel.getComponent(5);
                JTextField txtColor = (JTextField) licensePanel.getComponent(9);
                
            	if ((!txtPlaca.getText().isEmpty())&&(!txtModelo.getText().isEmpty())&&(!txtColor.getText().isEmpty())) {
	            	JOptionPane.showMessageDialog(null, "Se ha registrado la categoria con exito");
	            	licenseFrame.setVisible(false);
            	}
            	else
            		JOptionPane.showMessageDialog(null, "No se han rellenado todas las casillas");
            }});
        licensePanel.add(btnContinuar);
        licenseFrame.getContentPane().add(licensePanel, BorderLayout.CENTER);
        licenseFrame.setSize(400, 300);
        licenseFrame.setLocationRelativeTo(parentFrame);
        licenseFrame.setVisible(true);
	}
	
	public void registrarSede(JFrame parentFrame) {
		JFrame licenseFrame = new JFrame("Registrar sede");
        licenseFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel licensePanel = new JPanel();
        licensePanel.setBackground(backgroundColor);
        licensePanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        licensePanel.setLayout(new GridLayout(7, 2, 10, 10));

        String[] labels = {"Nombre sede:", "", "Direccion:", "",
                "Horario de atencion", ""};

        for (String label : labels) {
        	if(!label.isEmpty()) {
        		JLabel lbl = new JLabel(label);
        		lbl.setForeground(Color.white);
                JTextField textField = new JTextField();
                licensePanel.add(lbl);
                licensePanel.add(textField);
        		
        	}else {
        		licensePanel.add(new JLabel());
                licensePanel.add(new JLabel());
        	}
        }
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	licenseFrame.setVisible(false);
        }});
        licensePanel.add(btnCancelar);
        JButton btnContinuar = new JButton("Registrar");
        btnContinuar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	JTextField txtPlaca = (JTextField) licensePanel.getComponent(1);
                JTextField txtModelo = (JTextField) licensePanel.getComponent(5);
                JTextField txtColor = (JTextField) licensePanel.getComponent(9);
            	if ((!txtPlaca.getText().isEmpty())&&(!txtModelo.getText().isEmpty())&&(!txtColor.getText().isEmpty())) {
	            	JOptionPane.showMessageDialog(null, "Se ha registrado la sede con exito");
	            	licenseFrame.setVisible(false);
            	}
            	else
            		JOptionPane.showMessageDialog(null, "No se han rellenado todas las casillas");
            }});
        licensePanel.add(btnContinuar);
        licenseFrame.getContentPane().add(licensePanel, BorderLayout.CENTER);
        licenseFrame.setSize(400, 300);
        licenseFrame.setLocationRelativeTo(parentFrame);
        licenseFrame.setVisible(true);
	}

	public void registrarEmpleado(JFrame parentFrame) {
		JFrame licenseFrame = new JFrame("Registrar empleado");
        licenseFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel licensePanel = new JPanel();
        licensePanel.setBackground(backgroundColor);
        licensePanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        licensePanel.setLayout(new GridLayout(9, 2, 10, 10));

        String[] labels = {"Nombre:", "", "Cedula:", "",
                "Nuevo usuario:","", "Nueva contraseñá:",""};

        for (String label : labels) {
        	if(!label.isEmpty()) {
        		JLabel lbl = new JLabel(label);
        		lbl.setForeground(Color.white);
                JTextField textField = new JTextField();
                licensePanel.add(lbl);
                licensePanel.add(textField);
        		
        	}else {
        		licensePanel.add(new JLabel());
                licensePanel.add(new JLabel());
        	}
        }
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	licenseFrame.setVisible(false);
        }});
        licensePanel.add(btnCancelar);
        JButton btnContinuar = new JButton("Registrar");
        btnContinuar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	JTextField txtPlaca = (JTextField) licensePanel.getComponent(1);
                JTextField txtModelo = (JTextField) licensePanel.getComponent(5);
                JTextField txtColor = (JTextField) licensePanel.getComponent(9);
                JTextField txtA = (JTextField) licensePanel.getComponent(13);
            	if ((!txtPlaca.getText().isEmpty())&&(!txtModelo.getText().isEmpty())&&(!txtColor.getText().isEmpty())&&(!txtA.getText().isEmpty())) {
	            	JOptionPane.showMessageDialog(null, "Se ha registrado el empleado con exito");
	            	licenseFrame.setVisible(false);
            	}
            	else
            		JOptionPane.showMessageDialog(null, "No se han rellenado todas las casillas");
            }});
        licensePanel.add(btnContinuar);
        licenseFrame.getContentPane().add(licensePanel, BorderLayout.CENTER);
        licenseFrame.setSize(400, 300);
        licenseFrame.setLocationRelativeTo(parentFrame);
        licenseFrame.setVisible(true);
	}


	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == BtnRegVehiculo) {
			crearRegVehiculo(this);
		}else if (e.getSource() == BtnElmiVehiculo) {
			eleminarVehiculo(this);
//			setVisible(false);
//			elmiVehiculo.setVisible(true);
		}else if (e.getSource() == BtnRegCategoria) {
			registrarCategoria(this);
//			regVehiculo.setVisible(false);
		}else if (e.getSource() == BtnRegSede) {
			registrarSede(this);
//			setVisible(true);
//			elmiVehiculo.setVisible(false);
		}else if (e.getSource() == BtnRegEmpleado) {
			registrarEmpleado(this);
//			elmiVehiculo.setVisible(false);
	}
	}
}