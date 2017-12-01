package usuarios;

import java.io.Serializable;

/**clase con los datos de los usuarios administradores que tienen autorizacion para manejar los datos de la Academia
 * 
 * @author Grupo 3 DBS SS: Procesos software y de calidad 17-18
 *
 */
public class usuario implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String nom_usuario;
	private String apellido;
	private String nombre;
	private String contra;
	
	
	public usuario()
	{
		apellido="";
		nom_usuario="";
		nombre="";
		contra="";
	}
	
	public usuario(String nombre,String apellido,String nom_usuario, String contra)
	{
		this.nombre=nombre;
		this.apellido= apellido;
		this.nom_usuario= nom_usuario;
		this.contra=contra;
	}
	
	/**metodo para estructurar la visualizacion de los datos de los usuarios sacados de la BD
	 * @return String con la informacion de lo usuarios registrados, exceptuando la contraseña
	 */
	@Override
	
	public String toString()
	{
		
		StringBuffer salida = new StringBuffer();
		
		salida.append("\n--------- ");
		salida.append("\nNombre:");
		salida.append(nombre);
		salida.append("\nApellido:");
		salida.append(apellido);
		salida.append("\nUsuario:");
		salida.append(nom_usuario);
		
		return salida.toString();
	}

	public String getNom_usuario() {
		return nom_usuario;
	}

	public void setNom_usuario(String nom_usuario) {
		this.nom_usuario = nom_usuario;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContra() {
		return contra;
	}

	public void setContra(String contra) {
		this.contra = contra;
	}
	
	
}
