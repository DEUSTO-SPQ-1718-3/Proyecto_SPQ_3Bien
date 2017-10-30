package Cuotas;
import java.io.Serializable;

public class Cuota implements Serializable{
	
	
	private static final long serialVersionUID = -5805334843360532846L;
	
	
	private String nombre;
	private String apellido;
	private int horas;
	private int precio;
	private String fecha;
	private String estado;
	
	public Cuota(){
		
		nombre="";
		apellido="";
		horas=0;
		precio=0;
		fecha ="";
		estado="";		
	}
	
	
	public Cuota (String nombre, String apellido, int horas, int precio, String fecha, String estado){
		
		this.nombre=nombre;
		this.apellido=apellido;
		this.horas=horas;
		this.precio=precio;
		this.fecha=fecha;
		this.estado=estado;
		
			
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
		
	public int getHoras() {
		return horas;
	}
	public void setTelefono(int horas) {
		this.horas = horas;
	}	
	public int getPrecio() {
		return precio;
	}
	public void setEmail(int precio) {
		this.precio = precio;
	}	

	public String getFecha () {
		return fecha;
		
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	
	}
	public String getEstado() {
		return estado;
	}
	public void setDetalleAcademico(String estado) {
		this.estado = estado;
	}	
	
	
public String toString(){
		
		StringBuffer salida = new StringBuffer();
		
		salida.append("\n--------- ");
		salida.append("\nNombre : ");
		salida.append(nombre);
		salida.append("\nApellido : ");
		salida.append(apellido);
		salida.append("\nHoras : ");
		salida.append(horas);
		salida.append("\nPrecio : ");
		salida.append(precio);
		salida.append("\nFecha : ");
		salida.append(fecha);
		salida.append("\nEstado : ");
		salida.append(estado);
		
		return salida.toString();	
		
	}
	
}