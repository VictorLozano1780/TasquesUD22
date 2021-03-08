package Backend.PatronMVC;

import Backend.PatronMVC.controller.Controller;
import Backend.PatronMVC.model.service.CientificoServ;
import Backend.PatronMVC.model.service.ProyectoServ;
import Backend.PatronMVC.view.VentanaBuscarCientifico;
import Backend.PatronMVC.view.VentanaBuscarProyecto;
import Backend.PatronMVC.view.VentanaPrincipal;
import Backend.PatronMVC.view.VentanaRegistroCientifico;
import Backend.PatronMVC.view.VentanaRegistroProyecto;

public class mainApp {
	
	CientificoServ miCientificoServ;
	VentanaPrincipal miVentanaPrincipal;
	VentanaBuscarCientifico miVentanaBuscarCientifico;
	VentanaRegistroCientifico miVentanaRegistroCientifico;
	VentanaBuscarProyecto miVentanaBuscarProyecto;
	VentanaRegistroProyecto miVentanaRegistroProyecto;
	
	Controller CientificoController;
	ProyectoServ miProyectoServ;
	

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
		miVentanaRegistroCientifico=new VentanaRegistroCientifico();
		miVentanaBuscarCientifico= new VentanaBuscarCientifico();
		miVentanaRegistroProyecto = new VentanaRegistroProyecto();
		miVentanaBuscarProyecto = new VentanaBuscarProyecto();
		miCientificoServ=new CientificoServ();
		miProyectoServ = new ProyectoServ();
		CientificoController= new Controller();
		
		/*Se establecen las relaciones entre clases*/
		miVentanaPrincipal.setCoordinador(CientificoController);
		miVentanaRegistroCientifico.setCoordinador(CientificoController);
		miVentanaBuscarCientifico.setCoordinador(CientificoController);
		miCientificoServ.setController(CientificoController);
		miVentanaRegistroProyecto.setCoordinador(CientificoController);
		miVentanaBuscarProyecto.setCoordinador(CientificoController);
		miProyectoServ.setController(CientificoController);
		
		/*Se establecen relaciones con la clase coordinador*/
		CientificoController.setMiVentanaPrincipalCientifico(miVentanaPrincipal);
		CientificoController.setMiVentanaRegistroCientifico(miVentanaRegistroCientifico);
		CientificoController.setMiVentanaBuscar(miVentanaBuscarCientifico);
		CientificoController.setMiVentanaBuscarProyecto(miVentanaBuscarProyecto);
		CientificoController.setMiVentanaRegistroProyecto(miVentanaRegistroProyecto);
		CientificoController.setCientificoServ(miCientificoServ);
		CientificoController.setMiProyectoServ(miProyectoServ);
				
		miVentanaPrincipal.setVisible(true);
	}

}