/**
 * 
 */
package Backend.PatronMVC.model.dto;

/**
 * @author Víctor Lozano
 *
 */
public class Videos {
	private Integer idVideos;
	private String titleVideos;
	private String directorVideos;
	private Integer clienteIdVideos;
	/**
	 * @return the idVideos
	 */
	public Integer getIdVideos() {
		return idVideos;
	}
	/**
	 * @param idVideos the idVideos to set
	 */
	public void setIdVideos(Integer idVideos) {
		this.idVideos = idVideos;
	}
	/**
	 * @return the titleVideos
	 */
	public String getTitleVideos() {
		return titleVideos;
	}
	/**
	 * @param titleVideos the titleVideos to set
	 */
	public void setTitleVideos(String titleVideos) {
		this.titleVideos = titleVideos;
	}
	/**
	 * @return the directorVideos
	 */
	public String getDirectorVideos() {
		return directorVideos;
	}
	/**
	 * @param directorVideos the directorVideos to set
	 */
	public void setDirectorVideos(String directorVideos) {
		this.directorVideos = directorVideos;
	}
	/**
	 * @return the clienteIdVideos
	 */
	public Integer getClienteIdVideos() {
		return clienteIdVideos;
	}
	/**
	 * @param clienteIdVideos the clienteIdVideos to set
	 */
	public void setClienteIdVideos(Integer clienteIdVideos) {
		this.clienteIdVideos = clienteIdVideos;
	}
	
}
