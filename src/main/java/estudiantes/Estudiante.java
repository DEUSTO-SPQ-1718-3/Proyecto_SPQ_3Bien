package estudiantes;
import java.io.Serializable;

/**Clase que es un Estudiante
 * 
 * @author Grupo 3 DBS SS: Procesos software y de calidad 17-18
 *
 */
public class Estudiante implements Serializable{
	
	
	private static final long serialVersionUID = -5805334843360532846L;
	
	private String dni;
	private String nombre;
	private String apellido;
	private String telefono;
	private String email;
	private String colegio;
	private String direccion;
	private String nombre_contacto;
	private String telf_contacto;
	
	/**Constructor vac�o
	 * 
	 */
	public Estudiante(){
		
		dni="";		
		nombre="";
		apellido="";
		telefono="";
		email="";
		colegio="";
		direccion="";
		nombre_contacto="";
		telf_contacto="";	
	}
	
	/**Constructor con par�metros
	 * 
	 * @param dni Identidficador y clave primaria del estudiante
	 * @param nombre nombre del estudiante en cuestion
	 * @param apellido apellido del estudiante en cuestion
	 * @param telefono telefono del estudiante
	 * @param email email del estudiante
	 * @param colegio colegio del estudiante
	 * @param direccion direccion del estudiante
	 * @param nombre_contacto el nombre de la persona de contacto
	 * @param telf_contacto telefono de la persona de contacto
	 *  
	 */
	public Estudiante (String dni, String nombre, String apellido, String telefono, String email, String colegio, String direccion, String nombre_contacto, String telf_contacto ){
		
		this.dni=dni;
		this.nombre=nombre;
		this.apellido=apellido;
		this.telefono=telefono;
		this.email=email;
		this.colegio=colegio;
		this.direccion=direccion;
		this.nombre_contacto=nombre_contacto;
		this.telf_contacto=telf_contacto;
				
	}
	
	
	
	
	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getColegio() {
		return colegio;
	}


	public void setColegio(String colegio) {
		this.colegio = colegio;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getNombre_contacto() {
		return nombre_contacto;
	}


	public void setNombre_contacto(String nombre_contacto) {
		this.nombre_contacto = nombre_contacto;
	}


	public String getTelf_contacto() {
		return telf_contacto;
	}


	public void setTelf_contacto(String telf_contacto) {
		this.telf_contacto = telf_contacto;
	}

	/**toString para formato de impresion de atributos
	 * @return String con la informacion del estudiante 
	 */
public String toString(){
		
		StringBuffer salida = new StringBuffer();
		
		
		salida.append("\n--------- ");
		salida.append("\nDNI : ");
		salida.append(dni);
		salida.append("\nNombre : ");
		salida.append(nombre);
		salida.append("\nApellido : ");
		salida.append(apellido);
		salida.append("\nTelefono : ");
		salida.append(telefono);
		salida.append("\nEmail : ");
		salida.append(email);
		salida.append("\nColegio : ");
		salida.append(colegio);
		salida.append("\nDireccion : ");
		salida.append(direccion);
		salida.append("\nNombre de contacto : ");
		salida.append(nombre_contacto);
		salida.append("\nTelefono de contacto : ");
		salida.append(telf_contacto);
		return salida.toString();	
		
	}

}
