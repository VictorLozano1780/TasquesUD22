package Backend.PatronMVC.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

import Backend.PatronMVC.model.conexion.Conexion;
import Backend.PatronMVC.model.dto.Proyecto;


/**
 * Clase que permite el acceso a la base de datos
 * CRUD
 *
 */

public class ProyectoDao
{

	public void registrarProyecto(Proyecto Proyecto)
	{
		Conexion conex= new Conexion();
		
		try {
			Statement st = conex.getConnection().createStatement();
			String sql= "INSERT INTO Proyectos VALUES ('"+Proyecto.getID()+"', '"
					+Proyecto.getNombre()+ "');";
					
			
			st.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente","Información",JOptionPane.INFORMATION_MESSAGE);
			System.out.println(sql);
			st.close();
			conex.desconectar();
			
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Registro");
		}
	}

	
	
	
	
	
	public Proyecto buscarProyecto(int ID) 
	{
		Conexion conex= new Conexion();
		Proyecto Proyecto= new Proyecto();
		boolean existe=false;
		try {
			String sql= "SELECT * FROM Proyectos where id = ? ";
			PreparedStatement consulta = conex.getConnection().prepareStatement(sql);
			consulta.setInt(1, ID);
			ResultSet res = consulta.executeQuery();
			while(res.next()){
				existe=true;
				Proyecto.setID(Integer.parseInt(res.getString("ID")));
				Proyecto.setNombre(res.getString("nombre"));
				
			 }
			res.close();
			conex.desconectar();
			System.out.println(sql);
					
			} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Error, no se conecto");
					System.out.println(e);
			}
		
			if (existe) {
				return Proyecto;
			}
			else return null;				
	}

	public void modificarProyecto(Proyecto Proyecto) {
		
		Conexion conex= new Conexion();
		try{
			String consulta="UPDATE Proyectos SET nombre= ?  WHERE id= ? ";
			PreparedStatement estatuto = conex.getConnection().prepareStatement(consulta);
			
            estatuto.setInt(1, Proyecto.getID());
            estatuto.setString(2, Proyecto.getNombre());
           
            estatuto.executeUpdate();
            
          JOptionPane.showMessageDialog(null, " Se ha Modificado Correctamente ","Confirmación",JOptionPane.INFORMATION_MESSAGE);
          System.out.println(consulta);
         

        }catch(SQLException	 e){

            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error al Modificar","Error",JOptionPane.ERROR_MESSAGE);

        }
	}

	public void eliminarProyecto(String codigo)
	{
		Conexion conex= new Conexion();
		try {
			String sql= "DELETE FROM Proyectos WHERE id='"+codigo+"'";
			Statement st = conex.getConnection().createStatement();
			st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, " Se ha Eliminado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);
            System.out.println(sql);
			st.close();
			conex.desconectar();
			
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Elimino");
		}
	}

}
