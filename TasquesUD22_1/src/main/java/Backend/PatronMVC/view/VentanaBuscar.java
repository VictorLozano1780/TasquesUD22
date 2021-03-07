package Backend.PatronMVC.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Backend.PatronMVC.model.dto.Cliente;
import Backend.PatronMVC.model.service.ClienteServ;
import Backend.PatronMVC.controller.Controller;

public class VentanaBuscar  extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private Controller ClienteController; //objeto ClienteController que permite la relacion entre esta clase y la clase ClienteController
	private JLabel labelTitulo;
	private JTextField textCod,textNombre,textdni,textapellido,textdireccion;
	private JLabel cod,nombre,dni,apellido,direccion;
	private JButton botonGuardar,botonCancelar,botonBuscar,botonModificar,botonEliminar;
	
	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana de busqueda
	 */
	public VentanaBuscar() {

		botonGuardar = new JButton();
		botonGuardar.setBounds(50, 220, 120, 25);
		botonGuardar.setText("Guardar");
		
		botonCancelar = new JButton();
		botonCancelar.setBounds(190, 250, 120, 25);
		botonCancelar.setText("Cancelar");
		
		botonBuscar = new JButton();
		botonBuscar.setBounds(170, 80, 50, 25);
		botonBuscar.setText("Ok");
		
		botonEliminar = new JButton();
		botonEliminar.setBounds(330, 220, 120, 25);
		botonEliminar.setText("Eliminar");
		
		botonModificar = new JButton();
		botonModificar.setBounds(190, 220, 120, 25);
		botonModificar.setText("Modificar");

		labelTitulo = new JLabel();
		labelTitulo.setText("ADMINISTRAR ClienteS");
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
		
		direccion=new JLabel();
		direccion.setText("direccion");
		direccion.setBounds(20, 160, 80, 25);
		add(direccion);
		
		dni=new JLabel();
		dni.setText("dni");
		dni.setBounds(290, 120, 80, 25);
		add(dni);
		
		textCod=new JTextField();
		textCod.setBounds(80, 80, 80, 25);
		add(textCod);
		
		textNombre=new JTextField();
		textNombre.setBounds(80, 120, 190, 25);
		add(textNombre);

		textapellido=new JTextField();
		textapellido.setBounds(340, 160, 80, 25);
		add(textapellido);
		
		textdireccion=new JTextField();
		textdireccion.setBounds(80, 160, 190, 25);
		add(textdireccion);
		
		textdni=new JTextField();
		textdni.setBounds(340, 120, 80, 25);
		add(textdni);
		
		botonModificar.addActionListener(this);
		botonEliminar.addActionListener(this);
		botonBuscar.addActionListener(this);
		botonGuardar.addActionListener(this);
		botonCancelar.addActionListener(this);

		add(botonCancelar);
		add(botonBuscar);
		add(botonModificar);
		add(botonEliminar);
		add(botonGuardar);
		add(labelTitulo);
		limpiar();
				
		setSize(480, 320);
		setTitle("Patron de Diseño/MVC");
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);

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
				miCliente.setDireccionCliente(textdni.getText());
				miCliente.setDniCliente(Integer.parseInt(textdireccion.getText()));
				miCliente.setFecha(new Date());

				ClienteController.modificarCliente(miCliente);
				
				if (ClienteServ.modificaCliente==true) {
					habilita(true, false, false, false, false, true, false, true, true);	
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos","Error",JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		if (e.getSource()==botonBuscar)
		{
			Cliente miCliente=ClienteController.buscarCliente(textCod.getText());
			if (miCliente!=null)
			{
				muestraCliente(miCliente);
			}
			else if(ClienteServ.consultaCliente==true){
				JOptionPane.showMessageDialog(null, "La Cliente no Existe","Advertencia",JOptionPane.WARNING_MESSAGE);
			}
		}
		
		if (e.getSource()==botonModificar)
		{
			habilita(false, true, true, true, true, false, true, false, false);
			
		}
		
		if (e.getSource()==botonEliminar)
		{
			if (!textCod.getText().equals(""))
			{
				int respuesta = JOptionPane.showConfirmDialog(this,
						"Esta seguro de eliminar la Cliente?", "Confirmación",
						JOptionPane.YES_NO_OPTION);
				if (respuesta == JOptionPane.YES_NO_OPTION)
				{
					ClienteController.eliminarCliente(textCod.getText());
					limpiar();
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "Ingrese un numero de Documento", "Información",JOptionPane.WARNING_MESSAGE);
			}
			
		}
		if (e.getSource()==botonCancelar)
		{
			this.dispose();
		}

	}



	/**
	 * permite cargar los datos de la Cliente consultada
	 * @param miCliente
	 */
	private void muestraCliente(Cliente miCliente) {
		textNombre.setText(miCliente.getNombreCliente());
		textdni.setText(miCliente.getApellidoCliente()+"");
		textapellido.setText(miCliente.getDireccionCliente()+"");
		textdireccion.setText(String.valueOf(miCliente.getDniCliente()));
		habilita(true, false, false, false, false, true, false, true, true);
	}


	/**
	 * Permite limpiar los componentes
	 */
	public void limpiar()
	{
		textCod.setText("");
		textNombre.setText("");
		textdni.setText("");
		textapellido.setText("");
		textdireccion.setText("");
		habilita(true, false, false, false, false, true, false, true, true);
	}


	/**
	 * Permite habilitar los componentes para establecer una modificacion
	 * @param codigo
	 * @param nombre
	 * @param dni
	 * @param tel
	 * @param direccion
	 * @param cargo
	 * @param bBuscar
	 * @param bGuardar
	 * @param bModificar
	 * @param bEliminar
	 */
	public void habilita(boolean codigo, boolean nombre, boolean dni, boolean tel, boolean direccion,	 boolean bBuscar, boolean bGuardar, boolean bModificar, boolean bEliminar)
	{
		textCod.setEditable(codigo);
		textNombre.setEditable(nombre);
		textdni.setEditable(dni);
		textapellido.setEditable(tel);
		textdireccion.setEditable(direccion);
		botonBuscar.setEnabled(bBuscar);
		botonGuardar.setEnabled(bGuardar);
		botonModificar.setEnabled(bModificar);
		botonEliminar.setEnabled(bEliminar);
	}
}
