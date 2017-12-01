package main;

import java.sql.SQLException;

import org.apache.log4j.xml.DOMConfigurator;

import Cuotas.enviar_Email;

/**Clase Main del programa
 * \class Main
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
		
		frmPrincipal objP = new frmPrincipal ();
		objP.setVisible(true);
	
	    }
	    
	}
