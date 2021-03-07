/**
 * 
 */
package Backend.PatronMVC.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Backend.PatronMVC.controller.Controller;
import Backend.PatronMVC.model.dto.Videos;
import Backend.PatronMVC.model.service.VideosServ;

/**
 * @author Víctor Lozano
 *
 */
public class VentanaBuscarVideos extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Controller VideosController; //objeto VideosController que permite la relacion entre esta clase y la clase VideosController
	private JLabel labelTitulo;
	private JTextField textCod,textNombre,textdni,textapellido,textdireccion;
	private JLabel cod,title,cli_id,director;
	private JButton botonGuardar,botonCancelar,botonBuscar,botonModificar,botonEliminar;
	
	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana de busqueda
	 */
	public VentanaBuscarVideos() {

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
		labelTitulo.setText("ADMINISTRAR Videos");
		labelTitulo.setBounds(120, 20, 380, 30);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18));

		cod=new JLabel();
		cod.setText("Codigo");
		cod.setBounds(20, 80, 80, 25);
		add(cod);
		
		title=new JLabel();
		title.setText("Title");
		title.setBounds(20, 120, 80, 25);
		add(title);

		director=new JLabel();
		director.setText("Director");
		director.setBounds(290, 160, 80, 25);
		add(director);
		
		cli_id=new JLabel();
		cli_id.setText("Cli_ID");
		cli_id.setBounds(290, 120, 80, 25);
		add(cli_id);
		
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


	public void setCoordinador(Controller VideosController) {
		this.VideosController=VideosController;
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource()==botonGuardar)
		{
			try {
				Videos miVideos=new Videos();
				miVideos.setIdVideos(Integer.parseInt(textCod.getText()));
				miVideos.setTitleVideos(textNombre.getText());
				miVideos.setDirectorVideos(textapellido.getText());
				miVideos.setClienteIdVideos(Integer.parseInt(textdireccion.getText()));

				VideosController.modificarVideos(miVideos);
				
				if (VideosServ.modificaVideos==true) {
					habilita(true, false, false, false, false, true, false, true, true);	
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos","Error",JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		if (e.getSource()==botonBuscar)
		{
			Videos miVideos=Controller.buscarVideos(textCod.getText());
			if (miVideos!=null)
			{
				muestraVideos(miVideos);
			}
			else if(VideosServ.consultaVideos==true){
				JOptionPane.showMessageDialog(null, "La Videos no Existe","Advertencia",JOptionPane.WARNING_MESSAGE);
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
						"Esta seguro de eliminar la Videos?", "Confirmación",
						JOptionPane.YES_NO_OPTION);
				if (respuesta == JOptionPane.YES_NO_OPTION)
				{
					Controller.eliminarVideos(textCod.getText());
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
	 * permite cargar los datos de la Videos consultada
	 * @param miVideos
	 */
	private void muestraVideos(Videos miVideos) {
		textNombre.setText(miVideos.getTitleVideos());
		textdni.setText(miVideos.getDirectorVideos()+"");
		textapellido.setText(miVideos.getClienteIdVideos()+"");
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
		botonBuscar.setEnabled(bBuscar);
		botonGuardar.setEnabled(bGuardar);
		botonModificar.setEnabled(bModificar);
		botonEliminar.setEnabled(bEliminar);
	}
}
