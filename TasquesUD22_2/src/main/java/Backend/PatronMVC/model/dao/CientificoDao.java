package Backend.PatronMVC.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

import Backend.PatronMVC.model.conexion.Conexion;
import Backend.PatronMVC.model.dto.Cientifico;


/**
 * Clase que permite el acceso a la base de datos
 * CRUD
 *
 */
public class CientificoDao
{

	public void registrarCientifico(Cientifico miCientifico)
	{
		Conexion conex= new Conexion();
		
		try {
			Statement st = conex.getConnection().createStatement();
			String sql= "INSERT INTO Cientifico VALUES ('"+miCientifico.getID()+"', '"
					+miCientifico.getNombreApellido()+ "');";
					
			
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

	
	
	
	
	
	public Cientifico buscarCientifico(int codigo) 
	{
		Conexion conex= new Conexion();
		Cientifico Cientifico= new Cientifico();
		boolean existe=false;
		try {
			String sql= "SELECT * FROM Cientifico where id = ? ";
			PreparedStatement consulta = conex.getConnection().prepareStatement(sql);
			consulta.setInt(1, codigo);
			ResultSet res = consulta.executeQuery();
			while(res.next()){
				existe=true;
				Cientifico.setID(Integer.parseInt(res.getString("ID")));
				Cientifico.setNombreApellido(res.getString("NombreApellido"));
				
			 }
			res.close();
			conex.desconectar();
			System.out.println(sql);
					
			} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Error, no se conecto");
					System.out.println(e);
			}
		
			if (existe) {
				return Cientifico;
			}
			else return null;				
	}

	public void modificarCientifico(Cientifico miCientifico) {
		
		Conexion conex= new Conexion();
		try{
			String consulta="UPDATE Cientifico SET nombre = ?  WHERE id= ? ";
			PreparedStatement estatuto = conex.getConnection().prepareStatement(consulta);
			
            estatuto.setInt(1, miCientifico.getID());
            estatuto.setString(2, miCientifico.getNombreApellido());
           
            estatuto.executeUpdate();
            
          JOptionPane.showMessageDialog(null, " Se ha Modificado Correctamente ","Confirmación",JOptionPane.INFORMATION_MESSAGE);
          System.out.println(consulta);
         

        }catch(SQLException	 e){

            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error al Modificar","Error",JOptionPane.ERROR_MESSAGE);

        }
	}

	public void eliminarCientifico(String codigo)
	{
		Conexion conex= new Conexion();
		try {
			String sql= "DELETE FROM Cientifico WHERE id='"+codigo+"'";
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
