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

/**
 * @author Víctor Lozano
 *
 */
public class VentanaRegistroVideos extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private Controller ClienteController; //objeto ClienteController que permite la relacion entre esta clase y la clase ClienteController
	private JLabel labelTitulo;
	private JTextField textCod,texttitle,textCli_ID,textDirector;
	private JLabel cod,title,director,cli_id;
	private JButton botonGuardar,botonCancelar;
	
	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana de registro
	 */
	public VentanaRegistroVideos() {

		botonGuardar = new JButton();
		botonGuardar.setBounds(110, 220, 120, 25);
		botonGuardar.setText("Registrar");
		
		botonCancelar = new JButton();
		botonCancelar.setBounds(250, 220, 120, 25);
		botonCancelar.setText("Cancelar");

		labelTitulo = new JLabel();
		labelTitulo.setText("REGISTRO DE Videos");
		labelTitulo.setBounds(120, 20, 380, 30);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18));

		cod=new JLabel();
		cod.setText("Codigo Videos");
		cod.setBounds(20, 80, 80, 25);
		getContentPane().add(cod);
		
		title=new JLabel();
		title.setText("Title");
		title.setBounds(20, 120, 80, 25);
		getContentPane().add(title);

		cli_id=new JLabel();
		cli_id.setText("Cliente Id");
		cli_id.setBounds(290, 160, 80, 25);
		getContentPane().add(cli_id);
		
		director=new JLabel();
		director.setText("Director");
		director.setBounds(290, 120, 80, 25);
		getContentPane().add(director);
	
		
		textCod=new JTextField();
		textCod.setBounds(104, 80, 80, 25);
		getContentPane().add(textCod);
		
		texttitle=new JTextField();
		texttitle.setBounds(80, 120, 190, 25);
		getContentPane().add(texttitle);

		textDirector=new JTextField();
		textDirector.setBounds(340, 120, 80, 25);
		getContentPane().add(textDirector);
		
		textCli_ID=new JTextField();
		textCli_ID.setBounds(340, 160, 80, 25);
		getContentPane().add(textCli_ID);

		
		botonGuardar.addActionListener(this);
		botonCancelar.addActionListener(this);
		getContentPane().add(botonCancelar);
		getContentPane().add(botonGuardar);
		getContentPane().add(labelTitulo);
		limpiar();
		setSize(480, 300);
		setTitle("Patron de Diseño/MVC");
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

	}


	private void limpiar() 
	{
		textCod.setText("");
		texttitle.setText("");
		textCli_ID.setText("");
		textDirector.setText("");
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
				Videos miCliente=new Videos();
				miCliente.setIdVideos(Integer.parseInt(textCod.getText()));
				miCliente.setTitleVideos(texttitle.getText());			
				miCliente.setDirectorVideos(textDirector.getText());
				miCliente.setClienteIdVideos(Integer.parseInt(textCli_ID.getText()));
				
				ClienteController.registrarVideo(miCliente);	
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
