/**
 * 
 */
package Backend.PatronMVC.model.service;

import javax.swing.JOptionPane;

import Backend.PatronMVC.controller.Controller;
import Backend.PatronMVC.model.dao.VideosDao;
import Backend.PatronMVC.model.dto.Videos;

/**
 * @author Víctor Lozano
 *
 */
public class VideosServ {
	private Controller VideosController; 
	public static boolean consultaVideos=false;
	public static boolean modificaVideos=false;
	
	//Metodo de vinculación con el controller principal
	public void setVideosController(Controller VideosController) {
		this.setController(VideosController);		
	}

	//Metodo que valida los datos de Registro antes de pasar estos al DAO
	public static void validarRegistro(Videos miVideos) {
		VideosDao miVideosDao;
		if (miVideos.getIdVideos() > 0) {
			miVideosDao = new VideosDao();
			miVideosDao.registrarVideos(miVideos);						
		}else {
			JOptionPane.showMessageDialog(null,"El id de videos no puede ser menor de 0","Advertencia",JOptionPane.WARNING_MESSAGE);
			
		}
		
	}
	
	//Metodo que valida los datos de consulta antes de pasar estos al DAO
	public static Videos validarConsulta(String codigoVideos) {
		VideosDao miVideosDao;
		
		try {
			int codigo=Integer.parseInt(codigoVideos);	
			if (codigo > 0) {
				miVideosDao = new VideosDao();
				consultaVideos=true;
				return miVideosDao.buscarVideos(codigo);						
			}else{
				JOptionPane.showMessageDialog(null,"El id de videos no puede ser menor de 0","Advertencia",JOptionPane.WARNING_MESSAGE);
				consultaVideos=false;
			}
			
		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"Debe ingresar un dato numerico","Error",JOptionPane.ERROR_MESSAGE);
			consultaVideos=false;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Se ha presentado un Error","Error",JOptionPane.ERROR_MESSAGE);
			consultaVideos=false;
		}
					
		return null;
	}

	//Metodo que valida los datos de Modificación antes de pasar estos al DAO
	public static void validarModificacion(Videos miVideos) {
		VideosDao miVideosDao;
		if (miVideos.getDirectorVideos().length()<250) {
			miVideosDao = new VideosDao();
			miVideosDao.modificarVideos(miVideos);	
			modificaVideos=true;
		}else{
			JOptionPane.showMessageDialog(null,"El director no puede ser mayor a 250 caracteres","Advertencia",JOptionPane.WARNING_MESSAGE);
			modificaVideos=false;
		}
	}

	//Metodo que valida los datos de Eliminación antes de pasar estos al DAO
	public static void validarEliminacion(String codigo) {
		VideosDao miVideosDao=new VideosDao();
		miVideosDao.eliminarVideos(codigo);
	}

	
	
	public Controller getVideosController() {
		return VideosController;
	}

	public void setController(Controller VideosController) {
		this.VideosController = VideosController;
	}



}
