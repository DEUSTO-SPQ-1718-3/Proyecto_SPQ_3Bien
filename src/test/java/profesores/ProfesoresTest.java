package profesores;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doThrow;
import bbdd.MyDataAccess;
import static org.junit.Assert.assertEquals;
import junit.framework.JUnit4TestAdapter;

public class ProfesoresTest {
	
	private Profesor prof1;
	private Profesor prof2;

	
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
			
		dniEsperado = "222";
		nombreEsperado = "Idoia";
		apellidoEsperado="Sanchez";
		telefonoEsperado = "648176201";
		emailEsperado = "idoia@gmail.com";
		direccionEsperado = "Madrid Etorbidea 4";
		estudiosEsperado = "ADE";
		
		
		prof2= new Profesor (GestorNominaMock);
		
	}
	/*
	@Test public void testRegistrarProfesor() {
		
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
	
	
	
		
	}*/
	/*
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
	}*/
	
	

	@Test public void testCalcularSalarioBase() {
		
		Answer <Integer> baja = new Answer<Integer>()
		{
		public Integer baja() throws Throwable {
	            //String mensaje = "Empleado en estado de baja";
	      int calculo;  
	      //calcular el salario en caso de baja
	      
	      calculo =0;
				
			return calculo;
	            
	           
	            
	            
			}

		@Override
		public Integer answer(InvocationOnMock arg0) throws Throwable {
			// TODO Auto-generated method stub
			return null;
		}
		
        
		};
		
		when(GestorNominaMock.calcularSalarioBase("jornada commpleta")).thenReturn(1500);
		when(GestorNominaMock.calcularSalarioBase("baja")).then(baja);
		
		when(GestorNominaMock.calcularSalarioBase("media jornada")).thenReturn(950);
		
		when(GestorNominaMock.obtenerHorasTrabajadas()).thenReturn(100);
		
		assertEquals(prof2.calcularSalarioBase(), 1000.0, 0.001);
				
		verify(GestorNominaMock).obtenerHorasTrabajadas();
		
		//verify(GestorNominaMock).calcularSalarioBase("media jornada");
		
		}
	
	@Test public void testCalcularSalarioTotal() {
		
		when(GestorNominaMock.obtenerExtraMes()).thenReturn(10.0);
		
		assertEquals(1010.0, prof2.calcularSalarioTotal(1000), 0.001);
		//assertEquals(1000.0, prof2.calcularSalarioTotal(1000), 0.001);
				
		verify(GestorNominaMock).obtenerExtraMes();
		
		
		
	}
	
	/*
	@Test public void testPagar() {
		
		when(GestorNominaMock.comprobarFechaCaducidad()).thenReturn(true);
		when(GestorNominaMock.comprobarTarjeta()).thenReturn(true);
		when(GestorNominaMock.realizarPago(1000.0)).thenReturn(true);
			
		//2 CASOS A MOSTRAR: Comentar/descomentar uno y otro
		
		//1) Se llama 1 vez a cada uno
		
				assertEquals("Pago realizado", prof2.pagar(1000.0));
				
				verify(GestorNominaMock, atLeast(1)).comprobarFechaCaducidad();
				verify(GestorNominaMock, times(1)).comprobarTarjeta();
				verify(GestorNominaMock, times(1)).realizarPago(1000.0);
		
			
		//2) Se llama 2 veces a pagar() --> 2 veces a cada uno
		/*
				assertEquals("Pago realizado", prof2.pagar(1000.0));		
				assertEquals("Pago realizado", prof2.pagar(1000.0));
				
				verify(GestorNominaMock, atLeast(1)).comprobarFechaCaducidad();
				verify(GestorNominaMock, atLeast(2)).comprobarTarjeta();
				verify(GestorNominaMock, times(2)).realizarPago(1000.0);
		
		
	

	}

*/
	
@Test public void testPagar() {
		
		when(GestorNominaMock.comprobarFechaCaducidad(true)).thenReturn(true);
		when(GestorNominaMock.comprobarFechaCaducidad(false)).thenReturn(false);
		
		when(GestorNominaMock.comprobarTarjeta(true)).thenReturn(true);
		when(GestorNominaMock.comprobarTarjeta(false)).thenReturn(true);
		
		when(GestorNominaMock.realizarPago(1000.0)).thenReturn(true);
			
		//2 CASOS A MOSTRAR: Comentar/descomentar uno y otro
		
		//1) Se llama 1 vez a cada uno
		
				assertEquals("Pago realizado", prof2.pagar(1000.0));
				
				verify(GestorNominaMock, atLeast(1)).comprobarFechaCaducidad(true);
				verify(GestorNominaMock, times(1)).comprobarTarjeta(true);
				verify(GestorNominaMock, times(1)).realizarPago(1000.0);
		
			
		//2) Se llama 2 veces a pagar() --> 2 veces a cada uno
		
		/*		assertEquals("Pago realizado", prof2.pagar(1000.0));		
				assertEquals("Pago realizado", prof2.pagar(1000.0));
				
				verify(GestorNominaMock, atLeast(1)).comprobarFechaCaducidad();
				verify(GestorNominaMock, atLeast(2)).comprobarTarjeta();
				verify(GestorNominaMock, times(2)).realizarPago(1000.0);
		
		*/
		
		
	}
	
	@Test public void testExcepcion() {
		
		doThrow(new NullPointerException()).when(GestorNominaMock).lanzaExcepcion();
		
	}
	
	
	
	
	
}
