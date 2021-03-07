package Backend.PatronMVC.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Backend.PatronMVC.controller.Controller;
import Backend.PatronMVC.model.dto.Cliente;


public class VentanaRegistro extends JFrame implements ActionListener{

	
	private static final long serialVersionUID = 1L;
	private Controller ClienteController; //objeto ClienteController que permite la relacion entre esta clase y la clase ClienteController
	private JLabel labelTitulo;
	private JTextField textCod,textNombre,textdni,textapellido,textDireccion;
	private JLabel cod,nombre,dni,apellido,Direccion;
	private JButton botonGuardar,botonCancelar;
	
	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana de registro
	 */
	public VentanaRegistro() {

		botonGuardar = new JButton();
		botonGuardar.setBounds(110, 220, 120, 25);
		botonGuardar.setText("Registrar");
		
		botonCancelar = new JButton();
		botonCancelar.setBounds(250, 220, 120, 25);
		botonCancelar.setText("Cancelar");

		labelTitulo = new JLabel();
		labelTitulo.setText("REGISTRO DE ClienteS");
		labelTitulo.setBounds(120, 20, 380, 30);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18));

		cod=new JLabel();
		cod.setText("Codigo");
		cod.setBounds(20, 80, 80, 25);
		add(cod);
		
		nombre=new JLabel();
		nombre.setText("Nombre");
		nombre.setBounds(20, 120, 80, 25);
		add(nombre);

		apellido=new JLabel();
		apellido.setText("apellido");
		apellido.setBounds(290, 160, 80, 25);
		add(apellido);
		
		dni=new JLabel();
		dni.setText("dni");
		dni.setBounds(290, 120, 80, 25);
		add(dni);
		
		Direccion=new JLabel();
		Direccion.setText("Direccion");
		Direccion.setBounds(20, 160, 80, 25);
		add(Direccion);
		
		textCod=new JTextField();
		textCod.setBounds(80, 80, 80, 25);
		add(textCod);
		
		textNombre=new JTextField();
		textNombre.setBounds(80, 120, 190, 25);
		add(textNombre);

		textapellido=new JTextField();
		textapellido.setBounds(340, 160, 80, 25);
		add(textapellido);
		
		textdni=new JTextField();
		textdni.setBounds(340, 120, 80, 25);
		add(textdni);
		
		textDireccion=new JTextField();
		textDireccion.setBounds(80, 160, 190, 25);
		add(textDireccion);
		
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
		textNombre.setText("");
		textdni.setText("");
		textapellido.setText("");
		textDireccion.setText("");
	}


	public void setCoordinador(Controller ClienteController) {
		this.ClienteController=ClienteController;
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource()==botonGuardar)
		{
			try {
				Cliente miCliente=new Cliente();
				miCliente.setIdCliente(Integer.parseInt(textCod.getText()));
				miCliente.setNombreCliente(textNombre.getText());			
				miCliente.setApellidoCliente(textapellido.getText());
				miCliente.setDireccionCliente(textDireccion.getText());
				miCliente.setDniCliente(Integer.parseInt(textdni.getText()));
				java.util.Date d = new java.util.Date();
				java.sql.Date date2 = new java.sql.Date(d.getTime());
				miCliente.setFecha(date2);
				
				ClienteController.registrarCliente(miCliente);	
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
