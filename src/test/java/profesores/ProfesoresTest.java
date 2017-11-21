package profesores;

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
			
			//da error, porque da false el anterior. No llega aquí
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
