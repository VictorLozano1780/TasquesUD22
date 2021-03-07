/**
 * 
 */
package Backend.PatronMVC.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Backend.PatronMVC.model.conexion.Conexion;
import Backend.PatronMVC.model.dto.Videos;

/**
 * @author Víctor Lozano
 *
 */
public class VideosDao {
	public void registrarVideos(Videos miVideos)
	{
		Conexion conex= new Conexion();
		
		try {
			Statement st = conex.getConnection().createStatement();
			String sql= "INSERT INTO videos VALUES ('"+miVideos.getIdVideos()+"', '"
					+miVideos.getTitleVideos()+"', '"+miVideos.getDirectorVideos()+"', '"
					+miVideos.getClienteIdVideos()+"');";
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

	public Videos buscarVideos(int codigo) 
	{
		Conexion conex= new Conexion();
		Videos Videos= new Videos();
		boolean existe=false;
		try {
			String sql= "SELECT * FROM videos where id = ? ";
			PreparedStatement consulta = conex.getConnection().prepareStatement(sql);
			consulta.setInt(1, codigo);
			ResultSet res = consulta.executeQuery();
			while(res.next()){
				existe=true;
				Videos.setIdVideos(Integer.parseInt(res.getString("id")));
				Videos.setTitleVideos(res.getString("title"));
				Videos.setDirectorVideos(res.getString("director"));
				Videos.setClienteIdVideos(Integer.parseInt(res.getString("Cliente id")));
			 }
			res.close();
			conex.desconectar();
			System.out.println(sql);
					
			} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Error, no se conecto");
					System.out.println(e);
			}
		
			if (existe) {
				return Videos;
			}
			else return null;				
	}

	public void modificarVideos(Videos miVideos) {
		
		Conexion conex= new Conexion();
		try{
			String consulta="UPDATE videos SET id= ? ,title = ? , director=? , cli_id=?, WHERE id= ? ";
			PreparedStatement estatuto = conex.getConnection().prepareStatement(consulta);
			
            estatuto.setInt(1, miVideos.getIdVideos());
            estatuto.setString(2, miVideos.getTitleVideos());
            estatuto.setString(3, miVideos.getDirectorVideos());
            estatuto.setInt(4, miVideos.getClienteIdVideos());
            estatuto.executeUpdate();
            
          JOptionPane.showMessageDialog(null, " Se ha Modificado Correctamente ","Confirmación",JOptionPane.INFORMATION_MESSAGE);
          System.out.println(consulta);
         

        }catch(SQLException	 e){

            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error al Modificar","Error",JOptionPane.ERROR_MESSAGE);

        }
	}

	public void eliminarVideos(String codigo)
	{
		Conexion conex= new Conexion();
		try {
			String sql= "DELETE FROM videos WHERE id='"+codigo+"'";
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
