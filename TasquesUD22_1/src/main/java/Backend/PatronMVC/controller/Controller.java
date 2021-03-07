
/*
 * Esta parte del patrón es la que define la lógica de administración del sistema, 
 * establece la conexión entre la vista y el modelo.
 */

package Backend.PatronMVC.controller;

import Backend.PatronMVC.model.dto.Cliente;
import Backend.PatronMVC.model.dto.Videos;
import Backend.PatronMVC.model.service.ClienteServ;
import Backend.PatronMVC.model.service.VideosServ;
import Backend.PatronMVC.view.VentanaBuscar;
import Backend.PatronMVC.view.VentanaBuscarVideos;
import Backend.PatronMVC.view.VentanaPrincipal;
import Backend.PatronMVC.view.VentanaRegistro;
import Backend.PatronMVC.view.VentanaRegistroVideos;

public class Controller {

	private ClienteServ ClienteServ;
	private VentanaPrincipal miVentanaPrincipal;
	private VentanaRegistro miVentanaRegistro;
	private VentanaBuscar miVentanaBuscar;
	private VideosServ miVideosServ;
	private VentanaBuscarVideos miVentanaBuscarVideos;
	private VentanaRegistroVideos miVentanaRegistroVideos;

	// Metodos getter Setters de vistas
	public VentanaPrincipal getMiVentanaPrincipal() {
		return miVentanaPrincipal;
	}

	public void setMiVentanaPrincipal(VentanaPrincipal miVentanaPrincipal) {
		this.miVentanaPrincipal = miVentanaPrincipal;
	}

	public VentanaRegistro getMiVentanaRegistro() {
		return miVentanaRegistro;
	}

	public void setMiVentanaRegistro(VentanaRegistro miVentanaRegistro) {
		this.miVentanaRegistro = miVentanaRegistro;
	}

	public VentanaBuscar getMiVentanaBuscar() {
		return miVentanaBuscar;
	}

	public void setMiVentanaBuscar(VentanaBuscar miVentanaBuscar) {
		this.miVentanaBuscar = miVentanaBuscar;
	}

	public ClienteServ getClienteServ() {
		return ClienteServ;
	}

	public void setClienteServ(ClienteServ ClienteServ) {
		this.ClienteServ = ClienteServ;
	}

	public VideosServ getMiVideosServ() {
		return miVideosServ;
	}

	public void setMiVideosServ(VideosServ miVideosServ) {
		this.miVideosServ = miVideosServ;
	}

	public VentanaBuscarVideos getMiVentanaBuscarVideos() {
		return miVentanaBuscarVideos;
	}

	public void setMiVentanaBuscarVideos(VentanaBuscarVideos miVentanaBuscarVideos) {
		this.miVentanaBuscarVideos = miVentanaBuscarVideos;
	}

	public VentanaRegistroVideos getMiVentanaRegistroVideos() {
		return miVentanaRegistroVideos;
	}

	public void setMiVentanaRegistroVideos(VentanaRegistroVideos miVentanaRegistroVideos) {
		this.miVentanaRegistroVideos = miVentanaRegistroVideos;
	}

	// Hace visible las vistas de Registro y Consulta
	public void mostrarVentanaRegistro() {
		miVentanaRegistro.setVisible(true);
	}

	public void mostrarVentanaConsulta() {
		miVentanaBuscar.setVisible(true);
	}

	public void mostrarVentanaRegistroVideo() {
		miVentanaRegistroVideos.setVisible(true);
	}

	public void mostrarVentanaConsultaVideos() {
		miVentanaBuscarVideos.setVisible(true);
	}

	// Llamadas a los metodos CRUD de la capa service para validar los datos de las
	// vistas
	public void registrarCliente(Cliente miCliente) {
		ClienteServ.validarRegistro(miCliente);
	}

	public Cliente buscarCliente(String codigoCliente) {
		return ClienteServ.validarConsulta(codigoCliente);
	}

	public void modificarCliente(Cliente miCliente) {
		ClienteServ.validarModificacion(miCliente);
	}

	public void eliminarCliente(String codigo) {
		ClienteServ.validarEliminacion(codigo);
	}

	// Llamadas a los metodos CRUD de la capa service para validar los datos de las
	// vistas
	public void registrarVideo(Videos miVideo) {
		VideosServ.validarRegistro(miVideo);
	}

	public static Videos buscarVideos(String codigoVideos) {
		return VideosServ.validarConsulta(codigoVideos);
	}

	public void modificarVideos(Videos miVideo) {
		VideosServ.validarModificacion(miVideo);
	}

	public static void eliminarVideos(String codigo) {
		VideosServ.validarEliminacion(codigo);
	}

}
