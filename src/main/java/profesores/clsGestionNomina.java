package profesores;

/**Se recogen los métodos que nos proporcionará en un futuro un servidor externo para la gestion y el pago de las nominas a los profesores
 * @package profesores
 * @author Grupo 3 DBS SS: Procesos software y de calidad 17-18
 *
 */
public class clsGestionNomina {

	private double PrecioHora;
	private int HorasTrabajadas;
	private double extra;
	
	public int obtenerHorasTrabajadas(String tipo) {
		
		switch (tipo){
		
		case "jornada completa": HorasTrabajadas = 120; break;
		
		case "media jornada": HorasTrabajadas = 60; break;
		
		case "baja": HorasTrabajadas = 0; break;
						
		}
	
		return HorasTrabajadas;
		
	}

	public double calcularPrecioHora(String tipo)
	{
			
		switch (tipo){
			
		case "jornada completa": PrecioHora = 11.0; break;
		
		case "media jornada": PrecioHora = 13.0; break;
		
		case "baja": PrecioHora = 0.0; break;
			
			
		}
	
		return PrecioHora;			
		
	}
	
	public double obtenerExtraMes(String tipo) {
			
		
		switch (tipo){
		
		case "normal": extra = 50.0; break;
		
		case "especial": extra = 100.0; break;
		
	
		}
		
		return extra;
	}
	
	

	
	public boolean comprobarTarjeta(String tarjeta){
		
		boolean exito=false;
		
		//comprueba
		
		
		return exito;
	}
	

	//mes y año. Formato: MM/AA
	public boolean comprobarFechaCaducidad(String tarjeta){
		
		boolean exito=false;
		//comprueba
		
		
		return exito;
	}
	
	
	public boolean realizarPago (double nomina){
		
		boolean comprobar=false;
		
		//obtiene
		
		return comprobar;
	}	
	
	
	
	public void lanzaExcepcion () throws NullPointerException{
		
		//metodo que no hace nada
			
		
	}

	
	
}
