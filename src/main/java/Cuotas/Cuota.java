package Cuotas;

import java.io.Serializable;
/**Clase con los atributos de una cuota que guardamos en la base de datos.
 * \class Cuota
 * @package Cuotas
 * @brief Paquete que configura el modulo Cuotas
 * @author Grupo 3 DBS SS: Procesos software y de calidad 17-18
 *
 */
public class Cuota implements Serializable{
	
	
	private static final long serialVersionUID = -5805334843360532846L;
	
	private int id;
	private String nombre;
	private String apellido;
	private int horas;
	private int precio;
	private String fecha;
	private String estado;
	
	
	public Cuota(){
		
		id =0;
		nombre="";
		apellido="";
		horas=0;
		precio=0;
		fecha ="";
		estado="";		
	}
	
	/**
	 * Clase constructor de Cuota
	 */
	public Cuota (String nombre, String apellido, int horas, int precio, String fecha, String estado, int id){
		
		this.id=id;
		this.nombre=nombre;
		this.apellido=apellido;
		this.horas=horas;
		this.precio=precio;
		this.fecha=fecha;
		this.estado=estado;
		
			
	}
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setHoras(int horas) {
		this.horas = horas;
	}


	public void setPrecio(int precio) {
		this.precio = precio;
	}


	public void setEstado(String estado) {
		this.estado = estado;
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
	
	/**Metodo para rellenar las listas de los frame.
	 * @return String con la informacion del cuota en cuestion.
	 */
public String toString(){
		
		StringBuffer salida = new StringBuffer();
		
		salida.append("\n--------- ");
		salida.append("\nID : ");
		salida.append(id);
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