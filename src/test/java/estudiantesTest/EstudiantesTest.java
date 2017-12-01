package estudiantesTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.databene.contiperf.*;
import org.databene.contiperf.junit.ContiPerfRule;

import bbdd.MyDataAccess;
import estudiantes.Estudiante;
import estudiantes.frmBorrarEstudiante;
import estudiantes.frmEstudiantes;
import estudiantes.frmRegistrarEstudiante;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import junit.framework.JUnit4TestAdapter;


/**Clase para realizar los test correspondientes a el modulo de Estudiantes.
 *\class EstudiantesTest
 * @package estudiantesTest
 * @brief Paquete con las clases de test correspondientes al modulo Estudiantes
 * @author Grupo 3 DBS SS: Procesos software y de calidad 17-18
 *
 */

public class EstudiantesTest {
	
	@Rule public ContiPerfRule i = new ContiPerfRule();
	
	private Estudiante estudiante1;
	private Estudiante estudiante2;
	private frmRegistrarEstudiante ventana1;
	private frmBorrarEstudiante ventana2;
	frmEstudiantes ventana3;
	MyDataAccess conexion;
	
	public static junit.framework.Test suite() {
		 return new JUnit4TestAdapter(EstudiantesTest.class);
	}
	
	@Before public void setUp() {
		estudiante1= new Estudiante ("0000", "Sara","Martin","678111222","sm@gmail.com","Zurriola Ikastola","C/Mayor 6","Maria (madre)", "666458745");
		estudiante2= new Estudiante ("0001", "Sara","Martin","678111222","sm@gmail.com","Zurriola Ikastola","C/Mayor 6","Maria (madre)", "666458745");
		ventana1 = new frmRegistrarEstudiante();
		ventana2 = new frmBorrarEstudiante();
		ventana3 = new frmEstudiantes();
		conexion = new MyDataAccess();
	}
	
	
	@PerfTest(invocations = 5, threads = 1)
	@Required (max=2000, average=1000)
	@Test public void testRegistrarEstudiante() {
		
	ventana1.registrarEstudiante(estudiante1.getDni(),estudiante1.getNombre(),estudiante1.getApellido(),estudiante1.getTelefono(),estudiante1.getEmail(),estudiante1.getColegio(),estudiante1.getDireccion(),estudiante1.getNombre_contacto(),estudiante1.getTelf_contacto());
				
	ResultSet comprobar;
	String dni="";
	String nombre="";
	String colegio="";
	
	comprobar = conexion.getQuery("SELECT * from estudiantes where dni='0000'");
			
	try {
		while(comprobar.next()) {
			//comprobar.next();//paso porque el primero es el ID
			dni=comprobar.getString("dni");
			nombre=comprobar.getString("nombre");
			colegio = comprobar.getString("colegio");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	assertEquals(dni, "0000");
	assertEquals(nombre, "Sara");
	assertEquals(colegio, "Zurriola Ikastola");
			
	//limpiar de BBDD el registro generado
	conexion.setQuery("Delete from proyecto.estudiantes where dni='0000'");
		
		
	}	
	
	
	@PerfTest(invocations = 5, threads = 1)
	@Required (max=4000, average=1500)
	@Test public void testBorrarEstudiante(){
		
		ResultSet comprobar;
		
					
			ventana1.registrarEstudiante(estudiante2.getDni(),estudiante2.getNombre(),estudiante2.getApellido(),estudiante2.getTelefono(),estudiante2.getEmail(),estudiante2.getColegio(),estudiante2.getDireccion(),estudiante2.getNombre_contacto(),estudiante2.getTelf_contacto());
			
			
			String dni="";
			String nombre="";
			String colegio="";
			
			ventana2.borrarEstudiante("0001");
			
			comprobar = conexion.getQuery("SELECT * from estudiantes where dni='0001'");
				
			
			try {
				while(comprobar.next()) {
					//comprobar.next();//paso porque el primero es el ID
					dni=comprobar.getString("dni");
					nombre=comprobar.getString("nombre");
					colegio = comprobar.getString("colegio");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			assertEquals(dni, "");
			assertEquals(nombre, "");
			assertEquals(colegio, "");
							
		
	}
	
}
