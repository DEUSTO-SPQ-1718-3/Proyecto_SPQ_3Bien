package profesoresTest;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doThrow;
import bbdd.MyDataAccess;
import static org.junit.Assert.assertEquals;
import junit.framework.JUnit4TestAdapter;
import profesores.Profesor;
import profesores.clsGestionNomina;
import profesores.frmBorrarProfesor;
import profesores.frmProfesores;
import profesores.frmRegistrarProfesor;
/**Clase para realizar los test correspondientes a el modulo de Profesores.
 *\class ProfesoresTest
 * @package profesoresTest
 * @brief Paquete con las clases de test correspondientes al modulo Profesores.
 * @author Grupo 3 DBS SS: Procesos software y de calidad 17-18
 *
 */
public class ProfesoresTest {
	
	private Profesor prof1;
	private Profesor prof2;
	
	private frmRegistrarProfesor registrar_prof;
	private frmBorrarProfesor borrar_prof;
	private frmProfesores principal_prof;

	
	String dniEsperado;
	String nombreEsperado;
	String apellidoEsperado;
	String telefonoEsperado;
	String emailEsperado;
	String direccionEsperado;
	String estudiosEsperado;
	

	MyDataAccess conexion = new MyDataAccess();
	
	//Opcion 1 MOCKITO//
/*
	@Mock
	clsGestionNomina GestorNominaMock;	
	
	@Rule public MockitoRule rule = MockitoJUnit.rule();
	
*/
	
	//Opcion 2 MOCKITO
	
	clsGestionNomina GestorNominaMock = Mockito.mock(clsGestionNomina.class);
	
	
	public static junit.framework.Test suite() {
		 return new JUnit4TestAdapter(ProfesoresTest.class);
	}
	
	@Before public void setUp() {
		prof1= new Profesor ("222","Idoia","Sanchez","648176201","idoia@gmail.com","Madrid Etorbidea 4","ADE");
		
		
		registrar_prof = new frmRegistrarProfesor();
		borrar_prof = new frmBorrarProfesor();
		
		dniEsperado = "222";
		nombreEsperado = "Idoia";
		apellidoEsperado="Sanchez";
		telefonoEsperado = "648176201";
		emailEsperado = "idoia@gmail.com";
		direccionEsperado = "Madrid Etorbidea 4";
		estudiosEsperado = "ADE";
		
		
		prof2= new Profesor (GestorNominaMock);
		
	}
	

@Test public void testRegistrarProfesor() {
		
		//frmRegistrarProfesor ventana = new frmRegistrarProfesor();
		registrar_prof.registrarProfesor(prof1.getDni(),prof1.getNombre(),prof1.getApellido(),prof1.getTelefono(),prof1.getEmail(),prof1.getDireccion(),prof1.getEstudios());
		
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
	}
	
	@Test public void testBorrarProfesor() {
				
		conexion.setQuery("Delete from profesores where dni = '222'");	
		
		String dniBorrar ="222";
	
		
		//frmRegistrarProfesor ventana = new frmRegistrarProfesor();
		registrar_prof.registrarProfesor(prof1.getDni(),prof1.getNombre(),prof1.getApellido(),prof1.getTelefono(),prof1.getEmail(),prof1.getDireccion(),prof1.getEstudios());

		//frmBorrarProfesor borrarPrueba = new frmBorrarProfesor();
		borrar_prof.borrarProfesor(dniBorrar);



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
	
	@Test public void testModificarProfesor() {
		registrar_prof.registrarProfesor(prof1.getDni(),prof1.getNombre(),prof1.getApellido(),prof1.getTelefono(),prof1.getEmail(),prof1.getDireccion(),prof1.getEstudios());
		ResultSet resultadoBD;
		
		resultadoBD = conexion.getQuery("SELECT * from profesores where dni=222");
		
	
		try {
			while(resultadoBD.next()) {
		
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
		
		String dniMod;
		String nombreMod;
		String apellidoMod;
		String telefonoMod;
		String emailMod;
		String direccionMod;
		String estudiosMod;
		
		dniMod= "212";
		nombreMod = "Aaia";
		apellidoMod="Elola";
		telefonoMod = "648176201";
		emailMod = "ai@gmail.com";
		direccionMod = "Madrid Etorbidea 4";
		estudiosMod = "Derecho";
		
		
		conexion.setQuery("update profesores set dni='"+ dniMod+"',nombre='"+ nombreMod +"',apellido='"+ apellidoMod +"',telefono='"+ telefonoMod +"',email='"+ emailMod +"',direccion='"+ direccionMod +"',estudios='"+ estudiosMod +"' where dni = '222'");
				
		resultadoBD = conexion.getQuery("SELECT * from profesores where dni= "+dniMod+" ");
		
		try {
			while(resultadoBD.next()) {
				assertEquals( resultadoBD.getString("dni"), dniMod);
				assertEquals( resultadoBD.getString("nombre"), nombreMod);
				assertEquals( resultadoBD.getString("apellido"), apellidoMod);
				assertEquals( resultadoBD.getString("telefono"), telefonoMod);
				assertEquals( resultadoBD.getString("email"), emailMod);
				assertEquals( resultadoBD.getString("direccion"), direccionMod);
				assertEquals( resultadoBD.getString("estudios"), estudiosMod);			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		conexion.setQuery("Delete from profesores where dni = '222'");	
		conexion.setQuery("Delete from profesores where dni = '212'");	
	}

//SALARIO BASE --------------------------------------------------------------------------------
	@Test public void testCalcularSalarioBaseCompleta() {
		
		when(GestorNominaMock.calcularPrecioHora("jornada completa")).thenReturn(11.0);
					
		when(GestorNominaMock.obtenerHorasTrabajadas("jornada completa")).thenReturn(120);
		
		assertEquals(prof2.calcularSalarioBase("jornada completa"), 1320.0, 0.001);
				
		verify(GestorNominaMock, atLeast(1)).calcularPrecioHora("jornada completa");
				
		verify(GestorNominaMock, times(1)).obtenerHorasTrabajadas("jornada completa");
		
		
	}
	
	@Test public void testCalcularSalarioBaseMedia() {
		
		
		when(GestorNominaMock.calcularPrecioHora("media jornada")).thenReturn(13.0);
				
		when(GestorNominaMock.obtenerHorasTrabajadas("media jornada")).thenReturn(60);
					
		assertEquals(prof2.calcularSalarioBase("media jornada"), 780.0, 0.001);

		verify(GestorNominaMock, atLeast(1)).calcularPrecioHora("media jornada");
		
		verify(GestorNominaMock, times(1)).obtenerHorasTrabajadas("media jornada");
	
		
	}

	@Test public void testCalcularSalarioBaseBaja() {
	
	
	when(GestorNominaMock.calcularPrecioHora("baja")).thenReturn(0.0);
	
	when(GestorNominaMock.obtenerHorasTrabajadas("baja")).thenReturn(0);
			
	assertEquals(prof2.calcularSalarioBase("baja"), 0.0, 0.001);
	
	verify(GestorNominaMock, times(1)).calcularPrecioHora("baja");
		
	verify(GestorNominaMock, times(1)).obtenerHorasTrabajadas("baja");	
		
	}
	
//SALARIO TOTAL --------------------------------------------------------------------------------	
	@Test public void testCalcularSalarioTotalNormal() {
		
		when(GestorNominaMock.obtenerExtraMes("normal")).thenReturn(50.0);
		
		assertEquals(1050.0, prof2.calcularSalarioTotal("normal",1000.0), 0.001);
						
		verify(GestorNominaMock).obtenerExtraMes("normal");
				
		
	}
	
	@Test public void testCalcularSalarioTotalEspecial() {
		
		when(GestorNominaMock.obtenerExtraMes("especial")).thenReturn(100.0);
		
		assertEquals(1100.0, prof2.calcularSalarioTotal("especial",1000.0), 0.001);
						
		verify(GestorNominaMock).obtenerExtraMes("especial");
	
		
	}
	
	
//PAGAR --------------------------------------------------------------------------------------	
	
@Test public void testPagarOk() {
		
		when(GestorNominaMock.comprobarFechaCaducidad("112233")).thenReturn(true);
				
		when(GestorNominaMock.comprobarTarjeta("112233")).thenReturn(true);
				
		when(GestorNominaMock.realizarPago(1000.0)).thenReturn(true);
			
		//2 CASOS A MOSTRAR: Comentar/descomentar uno y otro
		
		//1) Se llama 1 vez a cada uno
		
				assertEquals("Pago realizado", prof2.pagar(1000.0,"112233"));
				
				verify(GestorNominaMock, atLeast(1)).comprobarFechaCaducidad("112233");
				verify(GestorNominaMock, times(1)).comprobarTarjeta("112233");
				verify(GestorNominaMock, times(1)).realizarPago(1000.0);
		
			
		//2) Se llama 2 veces a pagar() --> 2 veces a cada uno
		
		/*		assertEquals("Pago realizado", prof2.pagar(1000.0));		
				assertEquals("Pago realizado", prof2.pagar(1000.0));
				
				verify(GestorNominaMock, atLeast(1)).comprobarFechaCaducidad();
				verify(GestorNominaMock, atLeast(2)).comprobarTarjeta();
				verify(GestorNominaMock, times(2)).realizarPago(1000.0);
		
		*/
		
		
	}


	@Test public void testPagarMal() {
	
	when(GestorNominaMock.comprobarFechaCaducidad("112233")).thenReturn(false);
	
	when(GestorNominaMock.comprobarTarjeta("112233")).thenReturn(false);
	
	when(GestorNominaMock.realizarPago(1000.0)).thenReturn(true);
		
		
			assertEquals("Pago no se pudo realizar", prof2.pagar(1000.0, "112233"));
			
			verify(GestorNominaMock, atLeast(1)).comprobarFechaCaducidad("112233");
			
			//da error, porque da false el anterior. No llega aqu�
			verify(GestorNominaMock, times(0)).comprobarTarjeta("112233"); 
			//verify(GestorNominaMock, times(1)).comprobarTarjeta("112233"); 
						
			verify(GestorNominaMock, times(0)).realizarPago(1000.0);
			//verify(GestorNominaMock, times(1)).realizarPago(1000.0);
	
}
	

//EXCEPCION --------------------------------------------------------------------------------------------

	@Test public void testExcepcion() {
		
		doThrow(new NullPointerException()).when(GestorNominaMock).lanzaExcepcion();
		
	}
	
	
	
	
	
}
