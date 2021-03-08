/*
 * Esta clase permite realizar las operaciones asociadas a la lógica de negocio como tal, desde ella realizamos las validaciones 
 * y llamadas a las operaciones CRUD del sistema.
 * 
 * En caso de que se requieran procesos adicionales asociados a la lógica de negocio, aquí será donde se creen los métodos para 
 * dichos procesos, por ejemplo el método validarRegistro determina si los datos son correctos y permite registrar la Proyecto en
 * el Dao.
 */

package Backend.PatronMVC.model.service;

import javax.swing.JOptionPane;

import Backend.PatronMVC.model.dao.ProyectoDao;
import Backend.PatronMVC.model.dto.Proyecto;
import Backend.PatronMVC.controller.Controller;

public class ProyectoServ {
	
	private Controller proyectoController; 
	public static boolean consultaProyecto=false;
	public static boolean modificaProyecto=false;
	
	//Metodo de vinculación con el controller principal
	public void setProyectoController(Controller ProyectoController) {
		this.setController(ProyectoController);		
	}

	//Metodo que valida los datos de Registro antes de pasar estos al DAO
	public static void validarRegistro(Proyecto Proyecto) {
		ProyectoDao ProyectoDao;
		if (Proyecto.getID() > 99) {
			ProyectoDao = new ProyectoDao();
			ProyectoDao.registrarProyecto(Proyecto);						
		}else {
			JOptionPane.showMessageDialog(null,"El documento de la Proyecto debe ser mas de 3 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
			
		}
		
	}
	
	//Metodo que valida los datos de consulta antes de pasar estos al DAO
	public static Proyecto validarConsulta(String codigoProyecto) {
		ProyectoDao miProyectoDao;
		
		try {
			int codigo=Integer.parseInt(codigoProyecto);	
			if (codigo > 99) {
				miProyectoDao = new ProyectoDao();
				consultaProyecto=true;
				return miProyectoDao.buscarProyecto(codigo);						
			}else{
				JOptionPane.showMessageDialog(null,"El documento de la Proyecto debe ser mas de 3 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
				consultaProyecto=false;
			}
			
		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"Debe ingresar un dato numerico","Error",JOptionPane.ERROR_MESSAGE);
			consultaProyecto=false;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Se ha presentado un Error","Error",JOptionPane.ERROR_MESSAGE);
			consultaProyecto=false;
		}
					
		return null;
	}

	//Metodo que valida los datos de Modificación antes de pasar estos al DAO
	public static void validarModificacion(Proyecto Proyecto) {
		ProyectoDao miProyectoDao;
		if (Proyecto.getNombre().length()>5) {
			miProyectoDao = new ProyectoDao();
			miProyectoDao.modificarProyecto(Proyecto);	
			modificaProyecto=true;
		}else{
			JOptionPane.showMessageDialog(null,"El nombre de la Proyecto debe ser mayor a 5 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
			modificaProyecto=false;
		}
	}

	//Metodo que valida los datos de Eliminación antes de pasar estos al DAO
	public static void validarEliminacion(String codigo) {
		ProyectoDao miProyectoDao=new ProyectoDao();
		miProyectoDao.eliminarProyecto(codigo);
	}

	
	
	public Controller getProyectoController() {
		return proyectoController;
	}

	public void setController(Controller ProyectoController) {
		this.proyectoController = ProyectoController;
	}



}
