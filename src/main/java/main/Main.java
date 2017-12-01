package main;

import java.sql.SQLException;

import org.apache.log4j.xml.DOMConfigurator;
import org.apache.log4j.Logger;
import Cuotas.enviar_Email;

/**Clase Main del programa
 * @package main
 * @brief Paquete con las clases de main para lanzar la aplicacion
 * @author Grupo 3 DBS SS: Procesos software y de calidad 17-18
 *
 */
public class Main {

	/** Metodo Main
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DOMConfigurator.configure("log4java.xml");
		 
		Logger logger1 = Logger.getLogger("aran");
		Logger logger2 = Logger.getLogger("aran.asier");
		
			
		//logger1.debug("vamos");
		//logger2.debug("vamosiepa");
		 
		
		frmPrincipal objP = new frmPrincipal ();
		objP.setVisible(true);
	
	    }
	    
	}
