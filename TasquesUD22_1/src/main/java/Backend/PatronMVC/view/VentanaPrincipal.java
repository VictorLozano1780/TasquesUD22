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
	
	private Controller personaController; //objeto PersonaController que permite la relacion entre esta clase y la clase PersonaController
	private JTextArea areaIntroduccion;
	private JLabel labelTitulo, labelSeleccion;
	private JButton botonRegistrar,botonBuscar, botonRegistrarVideo,botonBuscarVideo;
	

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
		botonRegistrar.setBounds(10, 280, 120, 25);
		botonRegistrar.setText("Registrar cliente");
		
		botonBuscar = new JButton();
		botonBuscar.setBounds(129, 280, 120, 25);
		botonBuscar.setText("Buscar cliente");

		labelTitulo = new JLabel();
		labelTitulo.setText("PATRON MODELO VISTA CONTROLADOR");
		labelTitulo.setBounds(60, 40, 380, 30);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 15));

		labelSeleccion = new JLabel();
		labelSeleccion.setText("Escoja que operacion desea realizar");
		labelSeleccion.setBounds(75, 240, 250, 25);

		textoIntroduccion = "Esta aplicación presenta un ejemplo práctico del patron "
				+ "de diseño MVC.\n\n"
				+ "La aplicación permite registrar, actualizar, buscar y eliminar registros de una tabla Cliente y un Video.";

		areaIntroduccion = new JTextArea();
		areaIntroduccion.setBounds(50, 90, 380, 140);
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
		getContentPane().add(botonBuscar);
		getContentPane().add(botonRegistrar);
		getContentPane().add(labelSeleccion);
		getContentPane().add(labelTitulo);
		getContentPane().add(areaIntroduccion);
	
		setSize(480, 350);
		setTitle("Patron de Diseño/MVC");
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		botonRegistrarVideo = new JButton("Registrar video");
		botonRegistrarVideo.setBounds(245, 281, 120, 23);
		getContentPane().add(botonRegistrarVideo);
		
		botonBuscarVideo = new JButton("Buscar video");
		botonBuscarVideo.setBounds(361, 281, 103, 23);
		getContentPane().add(botonBuscarVideo);
		
		botonRegistrarVideo.addActionListener(this);
		botonBuscarVideo.addActionListener(this);

	}


	public void setCoordinador(Controller personaController) {
		this.personaController=personaController;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==botonRegistrar) {
			personaController.mostrarVentanaRegistro();			
		}
		if (e.getSource()==botonBuscar) {
			personaController.mostrarVentanaConsulta();			
		}
		if (e.getSource()==botonBuscarVideo) {
			personaController.mostrarVentanaConsultaVideos();			
		}
		if (e.getSource()==botonRegistrarVideo) {
			personaController.mostrarVentanaRegistroVideo();			
		}
	}
}
