package profesores;

import java.io.Serializable;
import org.apache.log4j.Logger;



/**clase de profesores con los atributos, constructores y getters&setters
 * @package profesores
 * @brief Paquete que configura el modulo profesores
 * @author Grupo 3 DBS SS: Procesos software y de calidad 17-18
 *
 */
public class Profesor implements Serializable{
	
	final static Logger logger = Logger.getLogger(Profesor.class);

	private static final long serialVersionUID = 1L;
	
	private String dni;
	private String nombre;
	private String apellido;
	private String telefono;
	private String email;
	private String direccion;
	private String estudios;
	
	private clsGestionNomina gestorNominas;
	
	static final double PRECIO_HORA=10;
	
	private double SalarioBase;
	private double SalarioTotal;
	private String PagarMensaje;
	
	
	public Profesor(){
		
		dni = "";
		nombre="";
		apellido="";
		telefono="";
		email="";
		direccion="";
		estudios="";		
	}
	
	
	public Profesor (String dni, String nombre, String apellido, String telefono, String email, String direccion, String estudios){
		
		this.dni=dni;
		this.nombre=nombre;
		this.apellido=apellido;
		this.telefono=telefono;
		this.email=email;
		this.direccion=direccion;
		this.estudios=estudios;
		
			
	}
	
	public Profesor (clsGestionNomina gestorNominas ){
		
	
		this.gestorNominas = gestorNominas;
			
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

	public String getDireccion(){
		return direccion;
	}

	public void setDireccion (String direccion) {
		this.direccion = direccion;
	}
	public String getEstudios() {
		return estudios;
	}
	public void setEstudios(String estudios) {
		this.estudios = estudios;
	}	
	
	/**metodo para la visualizacion de los profesores en la ventada de los mismos
	 * @return String con la informacion de los profesores estructurado
	 */
	public String toString(){
		
		StringBuffer salida = new StringBuffer();
		
		salida.append("\n--------- ");
		salida.append("\nDni :");
		salida.append(dni);
		salida.append("\nNombre : ");
		salida.append(nombre);
		salida.append("\nApellido : ");
		salida.append(apellido);
		salida.append("\nTelefono : ");
		salida.append(telefono);
		salida.append("\nEmail : ");
		salida.append(email);
		salida.append("\nDireccion : ");
		salida.append(direccion);
		salida.append("\nEstudios : ");
		salida.append(estudios);
		
		//logger.info("This is INFO : Se generado la estructura de visualizacion de los datos de los profesores");
		
		return salida.toString();	
		
	}
	
	/**metodo utilizado para realizar el ejemplo de Mockito
	 * @return double con el salario base calculado
	 */

	public double calcularSalarioBase(String tipo) {
		
		int horas = gestorNominas.obtenerHorasTrabajadas(tipo);
		
		// = gestorNominas.obtenerHorasTrabajadas(tipo);
		
		double precio = gestorNominas.calcularPrecioHora(tipo);		
		
		SalarioBase = horas*precio;
	
		return SalarioBase;			
		
	}

	/**metodo utilizado para realizar el ejemplo de Mockito
	 * @return double con el salario total, somando las horas extra
	 */
	
	public double calcularSalarioTotal(String tipo, double SalarioBase) {
		
		double extra = gestorNominas.obtenerExtraMes(tipo);
		
		SalarioTotal = SalarioBase + extra;
		
		return SalarioTotal;
		
	}
	
	/**metodo utilizado para realizar el ejemplo de Mockito
	 * @return String para informar si el pago se ha realizado o no
	 */
	
	public String pagar (double SalarioTotal, String tarjeta) {
		
		PagarMensaje = "Pago no se pudo realizar";
				
		if (gestorNominas.comprobarFechaCaducidad(tarjeta)) {
			
			if (gestorNominas.comprobarTarjeta(tarjeta)) {
				
				if (gestorNominas.realizarPago(SalarioTotal)) {
					
					PagarMensaje = "Pago realizado";
					
				}
				
			}
			
		}
		
		//System.out.println (PagarMensaje);
		
		return PagarMensaje;
	}
	
}