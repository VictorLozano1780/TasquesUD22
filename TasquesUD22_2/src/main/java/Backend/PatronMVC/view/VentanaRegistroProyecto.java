package Backend.PatronMVC.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Backend.PatronMVC.controller.Controller;
import Backend.PatronMVC.model.dto.Proyecto;
//import Backend.PatronMVC.model.dto.Proyecto;


public class VentanaRegistroProyecto extends JFrame implements ActionListener{

	
	private static final long serialVersionUID = 1L;
	private Controller ProyectoController; //objeto ProyectoController que permite la relacion entre esta clase y la clase ProyectoController
	private JLabel labelTitulo;
	private JTextField textCod,textNombreApellido,textEdad,textTelefono,textProfesion;
	private JLabel cod,nombreApellido,edad,telefono,profesion;
	private JButton botonGuardar,botonCancelar;
	
	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana de registro
	 */
	public VentanaRegistroProyecto() {

		botonGuardar = new JButton();
		botonGuardar.setBounds(110, 220, 120, 25);
		botonGuardar.setText("Registrar");
		
		botonCancelar = new JButton();
		botonCancelar.setBounds(250, 220, 120, 25);
		botonCancelar.setText("Cancelar");

		labelTitulo = new JLabel();
		labelTitulo.setText("Registro de Proyectos");
		labelTitulo.setBounds(120, 20, 380, 30);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18));

		cod=new JLabel();
		cod.setText("Codigo");
		cod.setBounds(20, 80, 80, 25);
		add(cod);
		
		nombreApellido=new JLabel();
		nombreApellido.setText("Nombre");
		nombreApellido.setBounds(20, 120, 80, 25);
		add(nombreApellido);

		telefono=new JLabel();
		telefono.setText("telefono");
		telefono.setBounds(290, 160, 80, 25);
		add(telefono);
		telefono.setVisible(false);
		
		edad=new JLabel();
		edad.setText("Edad");
		edad.setBounds(290, 120, 80, 25);
		add(edad);
		edad.setVisible(false);
		
		profesion=new JLabel();
		profesion.setText("Profesion");
		profesion.setBounds(20, 160, 80, 25);
		add(profesion);
		profesion.setVisible(false);
		
		textCod=new JTextField();
		textCod.setBounds(80, 80, 80, 25);
		add(textCod);
		
		textNombreApellido=new JTextField();
		textNombreApellido.setBounds(80, 120, 190, 25);
		add(textNombreApellido);

		textTelefono=new JTextField();
		textTelefono.setBounds(340, 160, 80, 25);
		add(textTelefono);
		textTelefono.setVisible(false);
		
		textEdad=new JTextField();
		textEdad.setBounds(340, 120, 80, 25);
		add(textEdad);
		textEdad.setVisible(false);
		
		textProfesion=new JTextField();
		textProfesion.setBounds(80, 160, 190, 25);
		add(textProfesion);
		textProfesion.setVisible(false);
		
		botonGuardar.addActionListener(this);
		botonCancelar.addActionListener(this);
		add(botonCancelar);
		add(botonGuardar);
		add(labelTitulo);
		limpiar();
		setSize(480, 300);
		setTitle("Patron de Diseño/MVC");
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);

	}


	private void limpiar() 
	{
		textCod.setText("");
		textNombreApellido.setText("");
		textEdad.setText("");
		textTelefono.setText("");
		textProfesion.setText("");
	}


	public void setCoordinador(Controller ProyectoController) {
		this.ProyectoController=ProyectoController;
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource()==botonGuardar)
		{
			try {
				Proyecto miProyecto=new Proyecto();
				miProyecto.setID(Integer.parseInt(textCod.getText()));
				miProyecto.setNombre(textNombreApellido.getText());
				//miProyecto.setTelefonoProyecto(Integer.parseInt(textTelefono.getText()));
				//miProyecto.setEdadProyecto(Integer.parseInt(textEdad.getText()));
				//miProyecto.setProfesionProyecto(textProfesion.getText());
				
				ProyectoController.registrarProyecto(miProyecto);	
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos","Error",JOptionPane.ERROR_MESSAGE);
				System.out.println(ex);
			}
		}
		if (e.getSource()==botonCancelar)
		{
			this.dispose();
		}
	}
	
	

}
