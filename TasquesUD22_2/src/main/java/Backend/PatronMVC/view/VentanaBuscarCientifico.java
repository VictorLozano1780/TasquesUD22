package Backend.PatronMVC.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Backend.PatronMVC.model.dto.Cientifico;
//import Backend.PatronMVC.model.dto.Cientifico;
import Backend.PatronMVC.model.service.CientificoServ;
import Backend.PatronMVC.controller.Controller;

public class VentanaBuscarCientifico  extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private Controller CientificoController; //objeto CientificoController que permite la relacion entre esta clase y la clase CientificoController
	private JLabel labelTitulo;
	private JTextField textCod,textNombre,textID,textTelefono,textProfesion;
	private JLabel cod,nombre,ID,telefono,profesion;
	private JButton botonGuardar,botonCancelar,botonBuscar,botonModificar,botonEliminar;
	
	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana de busqueda
	 */
	public VentanaBuscarCientifico() {

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
		labelTitulo.setText("Administrar Cientificos");
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

		telefono=new JLabel();
		telefono.setText("telefono");
		telefono.setBounds(290, 160, 80, 25);
		add(telefono);
		telefono.setVisible(false);
		
		profesion=new JLabel();
		profesion.setText("profesion");
		profesion.setBounds(20, 160, 80, 25);
		add(profesion);
		profesion.setVisible(false);
		
		ID=new JLabel();
		ID.setText("ID");
		ID.setBounds(290, 120, 80, 25);
		add(ID);
		ID.setVisible(false);
		
		
		textCod=new JTextField();
		textCod.setBounds(80, 80, 80, 25);
		add(textCod);
		
		textNombre=new JTextField();
		textNombre.setBounds(80, 120, 190, 25);
		add(textNombre);

		textTelefono=new JTextField();
		textTelefono.setBounds(340, 160, 80, 25);
		add(textTelefono);
		textTelefono.setVisible(false);
		
		textProfesion=new JTextField();
		textProfesion.setBounds(80, 160, 190, 25);
		add(textProfesion);
		textProfesion.setVisible(false);
		
		textID=new JTextField();
		textID.setBounds(340, 120, 80, 25);
		add(textID);
		textID.setVisible(false);
		
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


	public void setCoordinador(Controller CientificoController) {
		this.CientificoController=CientificoController;
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource()==botonGuardar)
		{
			try {
				Cientifico miCientifico=new Cientifico();
				miCientifico.setID(Integer.parseInt(textCod.getText()));
				miCientifico.setNombreApellido(textNombre.getText());
				//Cientifico.setTelefonoCientifico(Integer.parseInt(textTelefono.getText()));
				//Cientifico.setEdadCientifico(Integer.parseInt(textEdad.getText()));
				//Cientifico.setProfesionCientifico(textProfesion.getText());

				CientificoController.modificarCientifico(miCientifico);
				
				if (CientificoServ.modificaCientifico==true) {
					habilita(true, false, false, false, false, true, false, true, true);	
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos","Error",JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		if (e.getSource()==botonBuscar)
		{
			Cientifico miCientifico=CientificoController.buscarCientifico(textCod.getText());
			if (miCientifico!=null)
			{
				muestraCientifico(miCientifico);
			}
			else if(CientificoServ.consultaCientifico==true){
				JOptionPane.showMessageDialog(null, "El Cientifico no Existe","Advertencia",JOptionPane.WARNING_MESSAGE);
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
						"Esta seguro de eliminar la Cientifico?", "Confirmación",
						JOptionPane.YES_NO_OPTION);
				if (respuesta == JOptionPane.YES_NO_OPTION)
				{
					CientificoController.eliminarCientifico(textCod.getText());
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
	 * permite cargar los datos de la Cientifico consultada
	 * @param miCientifico
	 */
	private void muestraCientifico(Cientifico miCientifico) {
		textNombre.setText(miCientifico.getNombreApellido());
		textID.setText(miCientifico.getID()+"");
		//textTelefono.setText(Cientifico.getTelefonoCientifico()+"");
		//textProfesion.setText(Cientifico.getProfesionCientifico());
		habilita(true, false, false, false, false, true, false, true, true);
	}


	/**
	 * Permite limpiar los componentes
	 */
	public void limpiar()
	{
		textCod.setText("");
		textNombre.setText("");
		textID.setText("");
		textTelefono.setText("");
		textProfesion.setText("");
		habilita(true, false, false, false, false, true, false, true, true);
	}


	/**
	 * Permite habilitar los componentes para establecer una modificacion
	 * @param codigo
	 * @param nombre
	 * @param ID
	 * @param tel
	 * @param profesion
	 * @param cargo
	 * @param bBuscar
	 * @param bGuardar
	 * @param bModificar
	 * @param bEliminar
	 */
	public void habilita(boolean codigo, boolean nombre, boolean ID, boolean tel, boolean profesion,	 boolean bBuscar, boolean bGuardar, boolean bModificar, boolean bEliminar)
	{
		textCod.setEditable(codigo);
		textNombre.setEditable(nombre);
		textID.setEditable(ID);
		textTelefono.setEditable(tel);
		textProfesion.setEditable(profesion);
		botonBuscar.setEnabled(bBuscar);
		botonGuardar.setEnabled(bGuardar);
		botonModificar.setEnabled(bModificar);
		botonEliminar.setEnabled(bEliminar);
	}
}
