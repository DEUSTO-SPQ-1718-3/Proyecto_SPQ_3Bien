package estudiantes;

import org.junit.Before;
import org.junit.Test;

import bbdd.MyDataAccess;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import junit.framework.JUnit4TestAdapter;


public class EstudiantesTest {
	
	private Estudiante estudiante1;
	
	private frmRegistrarEstudiante ventana1;
	private frmBorrarEstudiante ventana2;
	frmEstudiantes ventana3;
	MyDataAccess conexion;
	
	public static junit.framework.Test suite() {
		 return new JUnit4TestAdapter(EstudiantesTest.class);
	}
	
	
	@Before public void setUp() {
		estudiante1= new Estudiante ("0000", "Sara","Martin","678111222","sm@gmail.com","Zurriola Ikastola","C/Mayor 6","Maria (madre)", "666458745");
		ventana1 = new frmRegistrarEstudiante();
		ventana2 = new frmBorrarEstudiante();
		ventana3 = new frmEstudiantes();
		conexion = new MyDataAccess();
	}
	
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
	
	@Test public void testBorrarEstudiante() {
		
		conexion.setQuery("Delete from estudiantes where dni='0000'");	
		
		ventana1.registrarEstudiante(estudiante1.getDni(),estudiante1.getNombre(),estudiante1.getApellido(),estudiante1.getTelefono(),estudiante1.getEmail(),estudiante1.getColegio(),estudiante1.getDireccion(),estudiante1.getNombre_contacto(),estudiante1.getTelf_contacto());
		
		ResultSet comprobar;
		String dni="";
		String nombre="";
		String colegio="";
		
		conexion.setQuery("Delete from estudiantes where dni='0000'");
		
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
		
		assertEquals(dni, "");
		assertEquals(nombre, "");
		assertEquals(colegio, "");
		
	}
	
}
