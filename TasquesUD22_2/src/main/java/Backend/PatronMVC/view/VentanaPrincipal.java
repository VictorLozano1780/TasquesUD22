package Backend.PatronMVC.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JTextArea;

import Backend.PatronMVC.controller.Controller;


public class VentanaPrincipal extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	private Controller personaController; //objeto CientificoController que permite la relacion entre esta clase y la clase CientificoController

	private JTextArea areaIntroduccion;
	private JLabel labelTitulo, labelSeleccion;
	private JButton botonRegistrar,botonBuscar,botonRegistrarProyecto,botonBuscarProyecto;
	

	/**
	 * Establece la informacion que se presentara como introduccion del sistema
	 */
	public String textoIntroduccion = "";

	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana principal
	 */
	public VentanaPrincipal() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		botonRegistrar = new JButton();
		botonRegistrar.setBounds(80, 280, 160, 25);
		botonRegistrar.setText("Registrar Cientificos");
		
		botonBuscar = new JButton();
		botonBuscar.setBounds(240, 280, 160, 25);
		botonBuscar.setText("Buscar Cientificos");

		
		botonRegistrarProyecto = new JButton("Registrar Proyecto");
		botonRegistrarProyecto.setBounds(500, 280, 160, 23);
		getContentPane().add(botonRegistrarProyecto);
		
		botonBuscarProyecto = new JButton("Buscar Proyecto");
		botonBuscarProyecto.setBounds(660, 280, 160, 23);
		getContentPane().add(botonBuscarProyecto);
		
		botonRegistrarProyecto.addActionListener(this);
		botonBuscarProyecto.addActionListener(this);
		
		
		labelTitulo = new JLabel();
		labelTitulo.setText("PATRON MODELO VISTA CONTROLADOR");
		labelTitulo.setBounds(280, 40, 380, 30);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 15));

		labelSeleccion = new JLabel();
		labelSeleccion.setText("Escoja que operacion desea realizar");
		labelSeleccion.setBounds(325, 240, 250, 25);

		textoIntroduccion = "Ejercicio 2 - Unidad21"
				+ "\n\n"
				+ "En esta aplicación podremos registrar, actualizar, buscar y eliminar registros de la tabla Cientifico" +
				"y la tabla Proyecto";

		areaIntroduccion = new JTextArea();
		areaIntroduccion.setBounds(250, 90, 380, 140);
		areaIntroduccion.setEditable(false);
		areaIntroduccion.setFont(new java.awt.Font("Verdana", 0, 14));
		areaIntroduccion.setLineWrap(true);
		areaIntroduccion.setText(textoIntroduccion);
		areaIntroduccion.setWrapStyleWord(true);
		areaIntroduccion.setBorder(javax.swing.BorderFactory.createBevelBorder(
				javax.swing.border.BevelBorder.LOWERED, null, null, null,
				new java.awt.Color(0, 0, 0)));

		botonRegistrar.addActionListener(this);
		botonBuscar.addActionListener(this);
		add(botonBuscar);
		add(botonRegistrar);
		add(labelSeleccion);
		add(labelTitulo);
		add(areaIntroduccion);
	
		setSize(880, 350);
		setTitle("Patron de Diseño/MVC");
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);
		
		
		

	}


	public void setCoordinador(Controller personaController) {
		this.personaController=personaController;
	}
	
	//public void setCoordinador(Controller CientificoController) {
	//	this.CientificoController=CientificoController;
	//}

	//public void setCoordinador(Controller proyectocontroller) {
	//	this.proyectoController=proyectoController;
	//}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==botonRegistrar) {
			personaController.mostrarVentanaRegistro();			
		}
		if (e.getSource()==botonBuscar) {
			personaController.mostrarVentanaConsulta();			
		}
		if (e.getSource()==botonBuscarProyecto) {
			personaController.mostrarVentanaConsultaProyecto();			
		}
		if (e.getSource()==botonRegistrarProyecto) {
			personaController.mostrarVentanaRegistroProyecto();			
		}
	}
}
