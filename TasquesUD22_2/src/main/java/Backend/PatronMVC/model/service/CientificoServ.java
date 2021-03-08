/*
 * Esta clase permite realizar las operaciones asociadas a la lógica de negocio como tal, desde ella realizamos las validaciones 
 * y llamadas a las operaciones CRUD del sistema.
 * 
 * En caso de que se requieran procesos adicionales asociados a la lógica de negocio, aquí será donde se creen los métodos para 
 * dichos procesos, por ejemplo el método validarRegistro determina si los datos son correctos y permite registrar la Cientifico en
 * el Dao.
 */

package Backend.PatronMVC.model.service;

import javax.swing.JOptionPane;


import Backend.PatronMVC.model.dao.CientificoDao;
import Backend.PatronMVC.model.dto.Cientifico;
import Backend.PatronMVC.controller.Controller;

public class CientificoServ {
	
	private Controller CientificoController; 
	public static boolean consultaCientifico=false;
	public static boolean modificaCientifico=false;
	
	//Metodo de vinculación con el controller principal
	public void setCientificoController(Controller CientificoController) {
		this.setController(CientificoController);		
	}

	//Metodo que valida los datos de Registro antes de pasar estos al DAO
	public void validarRegistro(Cientifico miCientifico) {
		CientificoDao miCientificoDao;
		if (miCientifico.getID() > 99) {
			miCientificoDao = new CientificoDao();
			miCientificoDao.registrarCientifico(miCientifico);						
		}else {
			JOptionPane.showMessageDialog(null,"El documento del Cientifico debe ser mas de 3 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
			
		}
		
	}
	
	//Metodo que valida los datos de consulta antes de pasar estos al DAO
	public Cientifico validarConsulta(String codigoCientifico) {
		CientificoDao miCientificoDao;
		
		try {
			int codigo=Integer.parseInt(codigoCientifico);	
			if (codigo > 99) {
				miCientificoDao = new CientificoDao();
				consultaCientifico=true;
				return miCientificoDao.buscarCientifico(codigo);						
			}else{
				JOptionPane.showMessageDialog(null,"El documento de la Cientifico debe ser mas de 3 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
				consultaCientifico=false;
			}
			
		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"Debe ingresar un dato numerico","Error",JOptionPane.ERROR_MESSAGE);
			consultaCientifico=false;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Se ha presentado un Error","Error",JOptionPane.ERROR_MESSAGE);
			consultaCientifico=false;
		}
					
		return null;
	}

	//Metodo que valida los datos de Modificación antes de pasar estos al DAO
	public void validarModificacion(Cientifico Cientifico) {
		CientificoDao miCientificoDao;
		if (Cientifico.getNombreApellido().length()>5) {
			miCientificoDao = new CientificoDao();
			miCientificoDao.modificarCientifico(Cientifico);	
			modificaCientifico=true;
		}else{
			JOptionPane.showMessageDialog(null,"El nombre de la Cientifico debe ser mayor a 5 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
			modificaCientifico=false;
		}
	}

	//Metodo que valida los datos de Eliminación antes de pasar estos al DAO
	public void validarEliminacion(String codigo) {
		CientificoDao miCientificoDao=new CientificoDao();
		miCientificoDao.eliminarCientifico(codigo);
	}

	
	
	public Controller getCientificoController() {
		return CientificoController;
	}

	public void setController(Controller CientificoController) {
		this.CientificoController = CientificoController;
	}



}
