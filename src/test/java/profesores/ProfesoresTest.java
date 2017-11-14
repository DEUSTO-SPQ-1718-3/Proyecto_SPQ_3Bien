package profesores;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import bbdd.MyDataAccess;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import junit.framework.JUnit4TestAdapter;
import cursos.clsCurso;

public class ProfesoresTest {
	
	private Profesor prof1;
	private Profesor prof2;
	private Profesor prof3;
	private Profesor prof4;
	
	String dniEsperado;
	String nombreEsperado;
	String apellidoEsperado;
	String telefonoEsperado;
	String emailEsperado;
	String direccionEsperado;
	String estudiosEsperado;
	
	MyDataAccess conexion = new MyDataAccess();
	
	public static junit.framework.Test suite() {
		 return new JUnit4TestAdapter(ProfesoresTest.class);
	}
	
	
	@Before public void setUp() {
		prof1= new Profesor ("222","Idoia","Sanchez","648176201","idoia@gmail.com","Madrid Etorbidea 4","ADE");
			
		dniEsperado = "222";
		nombreEsperado = "Idoia";
		apellidoEsperado="Sanchez";
		telefonoEsperado = "648176201";
		emailEsperado = "idoia@gmail.com";
		direccionEsperado = "Madrid Etorbidea 4";
		estudiosEsperado = "ADE";
		
	}
	
	@Test public void testRegistrarProfesor() {
	/*	
		frmRegistrarProfesor ventana = new frmRegistrarProfesor();
		ventana.registrarProfesor(prof1.getDni(),prof1.getNombre(),prof1.getApellido(),prof1.getTelefono(),prof1.getEmail(),prof1.getDireccion(),prof1.getEstudios());
		
		String registrado= "Select * from profesores where dni='222' ";
		//enviar la sentencia a la bbdd
		ResultSet resultadoBD= conexion.getQuery(registrado);
		
		
		try {
			while(resultadoBD.next()) {
				//comprobar.next();//paso porque el primero es el ID
				assertEquals( resultadoBD.getString("dni"), dniEsperado);
				assertEquals( resultadoBD.getString("nombre"), nombreEsperado);
				assertEquals( resultadoBD.getString("apellido"), apellidoEsperado);
				assertEquals( resultadoBD.getString("telefono"), telefonoEsperado);
				assertEquals( resultadoBD.getString("email"), emailEsperado);
				assertEquals( resultadoBD.getString("direccion"), direccionEsperado);
				assertEquals( resultadoBD.getString("estudios"), estudiosEsperado);				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		
			conexion.setQuery("Delete from profesores where dni = '222'");				
	
	
	*/
		
	}
	
	@Test public void testBorrarEstudiante() {
				
		conexion.setQuery("Delete from profesores where dni = '222'");	
		
		String dniBorrar ="222";
	
		
		frmRegistrarProfesor ventana = new frmRegistrarProfesor();
		ventana.registrarProfesor(prof1.getDni(),prof1.getNombre(),prof1.getApellido(),prof1.getTelefono(),prof1.getEmail(),prof1.getDireccion(),prof1.getEstudios());

		frmBorrarProfesor borrarPrueba = new frmBorrarProfesor();
		borrarPrueba.borrarProfesor(dniBorrar);



		//conexion.setQuery("Delete from profesores where nombre = 'Idoia'");	

		String comprobarBorrado= "Select * from profesores where dni='222' ";
		
		ResultSet resultadoBD= conexion.getQuery(comprobarBorrado);

		String dniEsperado="";
		String nombreEsperado = "";
		String apellidoEsperado="";
		String telefonoEsperado = "";
		String emailEsperado = "";
		String direccionEsperado = "";
		String estudiosEsperado = "";
		
		try {
			while(resultadoBD.next()) {
				//comprobar.next();//paso porque el primero es el ID
				assertEquals( resultadoBD.getString("dni"), dniEsperado);
				assertEquals( resultadoBD.getString("nombre"), nombreEsperado);
				assertEquals( resultadoBD.getString("apellido"), apellidoEsperado);
				assertEquals( resultadoBD.getString("telefono"), telefonoEsperado);
				assertEquals( resultadoBD.getString("email"), emailEsperado);
				assertEquals( resultadoBD.getString("direccion"), direccionEsperado);
				assertEquals( resultadoBD.getString("estudios"), estudiosEsperado);				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		


		}
	}
}
