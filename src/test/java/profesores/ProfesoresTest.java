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
	
	MyDataAccess conexion = new MyDataAccess();
	
	public static junit.framework.Test suite() {
		 return new JUnit4TestAdapter(ProfesoresTest.class);
	}
	
	
	@Before public void setUp() {
		prof1= new Profesor ("Idoia","Sanchez","648176201","idoia@gmail.com","Madrid Etorbidea 4","ADE");
			
	}
	
	@Test public void testRegistrarProfesor() throws SQLException {
		
		frmRegistrarProfesor ventana = new frmRegistrarProfesor();
		ventana.registrarProfesor(prof1.getNombre(),prof1.getApellido(),prof1.getTelefono(),prof1.getEmail(),prof1.getDireccion(),prof1.getEstudios());
		
		String registrado= "Select * from profesores where nombre='Idoia' ";
		//enviar la sentencia a la bbdd
		ResultSet resultadoBD= conexion.getQuery(registrado);
		
		String nombreEsperado = "Idoia";
		String apellidoEsperado="Sanchez";
		String telefonoEsperado = "648176201";
		String emailEsperado = "idoia@gmail.com";
		String direccionEsperado = "Madrid Etorbidea 4";
		String estudiosEsperado = "ADE";
		

		assertEquals( resultadoBD.getString("nombre"), nombreEsperado);
		assertEquals( resultadoBD.getString("apellido"), apellidoEsperado);
		assertEquals( resultadoBD.getString("telefono"), telefonoEsperado);
		assertEquals( resultadoBD.getString("email"), emailEsperado);
		assertEquals( resultadoBD.getString("direccion"), direccionEsperado);
		assertEquals( resultadoBD.getString("estudios"), estudiosEsperado);
		
						
	}
	
	//@Test public void testBorrarEstudiante() {
		
	//	frmBorrarProfesor ventana = new frmBorrarProfesor();
		
	//	ventana.borrarProfesor("Idoia");

		//assertEquals
	//}


	
	
	//@Test public void testVerEstudiantes() {
		
	//	frmEstudiantes ventana = new frmEstudiantes();
	//	ventana.setVisible(true);
		
	//	ventana.completarLista();
	//}
	
	
}

