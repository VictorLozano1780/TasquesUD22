package Backend.PatronMVC;

import Backend.PatronMVC.controller.Controller;
import Backend.PatronMVC.model.service.ClienteServ;
import Backend.PatronMVC.model.service.VideosServ;
import Backend.PatronMVC.view.VentanaBuscar;
import Backend.PatronMVC.view.VentanaBuscarVideos;
import Backend.PatronMVC.view.VentanaPrincipal;
import Backend.PatronMVC.view.VentanaRegistro;
import Backend.PatronMVC.view.VentanaRegistroVideos;

public class mainApp {
	
	ClienteServ miClienteServ;
	VentanaPrincipal miVentanaPrincipal;
	VentanaBuscar miVentanaBuscar;
	VentanaRegistro miVentanaRegistro;
	Controller ClienteController;
	VideosServ miVideosServ;
	VentanaBuscarVideos miVentanaBuscarVideos;
	VentanaRegistroVideos miVentanaRegistroVideos;
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		mainApp miPrincipal=new mainApp();
		miPrincipal.iniciar();
	}

	/**
	 * Permite instanciar todas las clases con las que trabaja
	 * el sistema
	 */
	private void iniciar() {
		/*Se instancian las clases*/
		miVentanaPrincipal=new VentanaPrincipal();
		miVentanaRegistro=new VentanaRegistro();
		miVentanaBuscar= new VentanaBuscar();
		miVentanaRegistroVideos = new VentanaRegistroVideos();
		miVentanaBuscarVideos = new VentanaBuscarVideos();
		miClienteServ=new ClienteServ();
		miVideosServ = new VideosServ();
		ClienteController= new Controller();
		
		/*Se establecen las relaciones entre clases*/
		miVentanaPrincipal.setCoordinador(ClienteController);
		miVentanaRegistro.setCoordinador(ClienteController);
		miVentanaBuscar.setCoordinador(ClienteController);
		miClienteServ.setController(ClienteController);
		miVentanaRegistroVideos.setCoordinador(ClienteController);
		miVentanaBuscarVideos.setCoordinador(ClienteController);
		miVideosServ.setController(ClienteController);
		
		/*Se establecen relaciones con la clase coordinador*/
		ClienteController.setMiVentanaPrincipal(miVentanaPrincipal);
		ClienteController.setMiVentanaRegistro(miVentanaRegistro);
		ClienteController.setMiVentanaBuscar(miVentanaBuscar);
		ClienteController.setMiVentanaBuscarVideos(miVentanaBuscarVideos);
		ClienteController.setMiVentanaRegistroVideos(miVentanaRegistroVideos);
		ClienteController.setClienteServ(miClienteServ);
		ClienteController.setMiVideosServ(miVideosServ);
				
		miVentanaPrincipal.setVisible(true);
	}

}
