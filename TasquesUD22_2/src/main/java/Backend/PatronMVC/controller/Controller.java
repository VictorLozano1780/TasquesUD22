
/*
 * Esta parte del patrón es la que define la lógica de administración del sistema, 
 * establece la conexión entre la vista y el modelo.
 */

package Backend.PatronMVC.controller;

import Backend.PatronMVC.model.dto.Cientifico;
import Backend.PatronMVC.model.dto.Proyecto;
import Backend.PatronMVC.model.service.CientificoServ;
import Backend.PatronMVC.model.service.ProyectoServ;
import Backend.PatronMVC.view.VentanaBuscarCientifico;
import Backend.PatronMVC.view.VentanaBuscarProyecto;
import Backend.PatronMVC.view.VentanaPrincipal;
import Backend.PatronMVC.view.VentanaRegistroCientifico;
import Backend.PatronMVC.view.VentanaRegistroProyecto;

public class Controller {

	private CientificoServ CientificoServ;
	private VentanaPrincipal miVentanaPrincipal;
	private VentanaRegistroCientifico miVentanaRegistro;
	private VentanaBuscarCientifico miVentanaBuscarCientifico;
	private VentanaBuscarProyecto miVentanaBuscarProyecto;
	private ProyectoServ miProyectoServ;
	private VentanaRegistroProyecto miVentanaRegistroProyecto;

	// Metodos getter Setters de vistas
	public VentanaPrincipal getMiVentanaPrincipal() {
		return miVentanaPrincipal;
	}

	public void setMiVentanaPrincipalCientifico(VentanaPrincipal miVentanaPrincipal) {
		this.miVentanaPrincipal = miVentanaPrincipal;
	}

	public VentanaRegistroCientifico getMiVentanaRegistroCientifico() {
		return miVentanaRegistro;
	}

	public void setMiVentanaRegistroCientifico(VentanaRegistroCientifico miVentanaRegistro) {
		this.miVentanaRegistro = miVentanaRegistro;
	}

	public VentanaBuscarCientifico getMiVentanaBuscar() {
		return miVentanaBuscarCientifico;
	}

	public void setMiVentanaBuscar(VentanaBuscarCientifico miVentanaBuscarCientifico) {
		this.miVentanaBuscarCientifico = miVentanaBuscarCientifico;
	}

	public CientificoServ getCientificoServ() {
		return CientificoServ;
	}

	public void setCientificoServ(CientificoServ CientificoServ) {
		this.CientificoServ = CientificoServ;
	}

	public ProyectoServ getMiProyectoServ() {
		return miProyectoServ;
	}

	public void setMiProyectoServ(ProyectoServ miProyectoServ) {
		this.miProyectoServ = miProyectoServ;
	}

	public VentanaBuscarProyecto getMiVentanaBuscarProyecto() {
		return miVentanaBuscarProyecto;
	}

	public void setMiVentanaBuscarProyecto(VentanaBuscarProyecto miVentanaBuscarProyecto) {
		this.miVentanaBuscarProyecto = miVentanaBuscarProyecto;
	}

	public VentanaRegistroProyecto getMiVentanaRegistroProyecto() {
		return miVentanaRegistroProyecto;
	}

	public void setMiVentanaRegistroProyecto(VentanaRegistroProyecto miVentanaRegistroProyecto) {
		this.miVentanaRegistroProyecto = miVentanaRegistroProyecto;
	}

	// Hace visible las vistas de Registro y Consulta
	public void mostrarVentanaRegistro() {
		miVentanaRegistro.setVisible(true);
	}

	public void mostrarVentanaConsulta() {
		miVentanaBuscarCientifico.setVisible(true);
	}

	public void mostrarVentanaRegistroProyecto() {
		miVentanaRegistroProyecto.setVisible(true);
	}

	public void mostrarVentanaConsultaProyecto() {
		miVentanaBuscarProyecto.setVisible(true);
	}

	// Llamadas a los metodos CRUD de la capa service para validar los datos de las
	// vistas
	public void registrarCientifico(Cientifico miCientifico) {
		CientificoServ.validarRegistro(miCientifico);
	}

	public Cientifico buscarCientifico(String codigoCientifico) {
		return CientificoServ.validarConsulta(codigoCientifico);
	}

	public void modificarCientifico(Cientifico miCientifico) {
		CientificoServ.validarModificacion(miCientifico);
	}

	public void eliminarCientifico(String codigo) {
		CientificoServ.validarEliminacion(codigo);
	}

	// Llamadas a los metodos CRUD de la capa service para validar los datos de las
	// vistas
	public void registrarProyecto(Proyecto miProyecto) {
		ProyectoServ.validarRegistro(miProyecto);
	}

	public static Proyecto buscarProyecto(String codigoProyecto) {
		return ProyectoServ.validarConsulta(codigoProyecto);
	}

	public void modificarProyecto(Proyecto miProyecto) {
		ProyectoServ.validarModificacion(miProyecto);
	}

	public static void eliminarProyecto(String codigo) {
		ProyectoServ.validarEliminacion(codigo);
	}

}