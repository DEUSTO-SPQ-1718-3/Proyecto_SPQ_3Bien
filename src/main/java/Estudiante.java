import java.io.Serializable;

public class Estudiante implements Serializable{
	
	
	private static final long serialVersionUID = -5805334843360532846L;
	
	
	private String nombre;
	private String apellido;
	private String telefono;
	private String email;
	private String detalleAcademico;
	
	public Estudiante(){
		
		nombre="";
		apellido="";
		telefono="";
		email="";
		detalleAcademico="";		
	}
	
	
	public Estudiante (String nombre, String apellido, String telefono, String email, String detalleAcademico){
		
		this.nombre=nombre;
		this.apellido=apellido;
		this.telefono=telefono;
		this.email=email;
		this.detalleAcademico=detalleAcademico;
		
			
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
	public String getDetalleAcademico() {
		return detalleAcademico;
	}
	public void setDetalleAcademico(String detalleAcademico) {
		this.detalleAcademico = detalleAcademico;
	}	
	
	
public String toString(){
		
		StringBuffer salida = new StringBuffer();
		
		salida.append("\n--------- ");
		salida.append("\nNombre : ");
		salida.append(nombre);
		salida.append("\nApellido : ");
		salida.append(apellido);
		salida.append("\nTelefono : ");
		salida.append(telefono);
		salida.append("\nEmail : ");
		salida.append(email);
		salida.append("\nDetalle Academico : ");
		salida.append(detalleAcademico);
		
		return salida.toString();	
		
	}
	
}