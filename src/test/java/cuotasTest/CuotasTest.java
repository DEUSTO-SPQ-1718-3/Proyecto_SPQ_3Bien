package cuotasTest;

import org.junit.Before;

import org.junit.Test;

import Cuotas.Cuota;
import Cuotas.frmBorrarCuota;
import Cuotas.frmCrearCuota;
import Cuotas.frmCuotas;
import Cuotas.frmEnviarCuota;
import Cuotas.frmModificarCuota;
import bbdd.MyDataAccess;
import estudiantes.Estudiante;
import estudiantes.frmRegistrarEstudiante;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import junit.framework.JUnit4TestAdapter;

/**Clase para realizar los test correspondientes a el modulo de Cuotas.
 *\class CuotasTest
 * @package cuotasTest
 * @brief Paquete con las clases de test orrespondientes al modulo Cuotas
 * @author Grupo 3 DBS SS: Procesos software y de calidad 17-18
 *
 */
public class CuotasTest {

	Cuota C1;
	Cuota C2;
	Estudiante E1;
	MyDataAccess conexion;
	frmCrearCuota crearCuota;
	frmBorrarCuota borrarCuota;
	frmModificarCuota modificarCuota;
	frmCuotas cuotas;
	frmEnviarCuota enviarCuota;
	frmRegistrarEstudiante registrarEstudiante;
	
	public static junit.framework.Test suite() {
		 return new JUnit4TestAdapter(CuotasTest.class);
	}
	/**
	 * Inicializa los valores que se usaran en la clase.
	 */
	@Before public void setUp() {
		C1= new Cuota ("Pablo", "Villegas",5, 1500,"10/09/2017","PENDIENTE", 100);
		C2= new Cuota ("Evaristo", "Villegas",5, 1500,"10/09/2017","PENDIENTE", 100);
		E1 = new Estudiante ("1111", "Evaristo","Villegas","678111222","pablovillegas@gmail.com","Zurriola Ikastola","C/Mayor 6","Maria (madre)", "666458745");
		conexion = new MyDataAccess();
		crearCuota = new frmCrearCuota();
		borrarCuota = new frmBorrarCuota();
		modificarCuota = new frmModificarCuota();
		enviarCuota = new frmEnviarCuota();
		registrarEstudiante = new frmRegistrarEstudiante();
	}
	
	/**
	 * Test sobre el metodo CreaCuota
	 */
	@Test public void testCreaCuota() {
		
		crearCuota.creaCuota("Pablo", "Villegas", 5, 1500, "10/09/2017", "PENDIENTE");
		
		ResultSet comprobar;
		String nombre="";
		String apellido="";
		int horas =0;
		int precio =0;
		String fecha ="";
		String estado ="";
		int id =0;
		
		comprobar = conexion.getQuery("SELECT * from cuotas order by id desc limit 1");
		
		try {
			while(comprobar.next()) {
				nombre=comprobar.getString("nombre");
				apellido=comprobar.getString("apellido");
				horas = comprobar.getInt("horas");
			    precio = comprobar.getInt("precio");
			    fecha = comprobar.getString("fecha");
			    estado = comprobar.getString("estado");
			    id = comprobar.getInt("id");
			    
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(nombre, C1.getNombre());
		assertEquals(apellido, C1.getApellido());
		assertEquals(horas, C1.getHoras());
		assertEquals(precio, C1.getPrecio());
		assertEquals(fecha, C1.getFecha());
		assertEquals(estado, C1.getEstado());
		
		//limpiar de BBDD el registro generado
		conexion.setQuery("DELETE from cuotas where id = '"+ id + "'");

	}
	/**
	 * Test sobre el metodo ModificarCuota
	 */
	@Test public void testModificarCuota() {

		crearCuota.creaCuota("Javier", "Cerro", 7, 150, "10/09/2018", "PENDIENTE");
		
		ResultSet comprobar;
		String nombre="";
		String apellido="";
		int horas =0;
		int precio =0;
		String fecha ="";
		String estado ="";
		int id =0;
		
		comprobar = conexion.getQuery("SELECT * from cuotas order by id desc limit 1");
		
		try {
			while(comprobar.next()) {

			    id = comprobar.getInt("id");
			    
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		nombre="Pablo";
		apellido="Villegas";
		horas=5;
		precio=1500;
		fecha="10/09/2017";

		modificarCuota.modificarCuota(nombre, apellido, horas, precio, fecha, id);
		
		comprobar = conexion.getQuery("SELECT * from cuotas where id  = '" + id + "'");

		try {
			while(comprobar.next()) {
				nombre=comprobar.getString("nombre");
				apellido=comprobar.getString("apellido");
				horas = comprobar.getInt("horas");
			    precio = comprobar.getInt("precio");
			    fecha = comprobar.getString("fecha");
			    estado = comprobar.getString("estado");
			    id = comprobar.getInt("id");
			    
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		assertEquals(nombre, C1.getNombre());
		assertEquals(apellido, C1.getApellido());
		assertEquals(horas, C1.getHoras());
		assertEquals(precio, C1.getPrecio());
		assertEquals(fecha, C1.getFecha());
		assertEquals(estado, C1.getEstado());
		
		//limpiar de BBDD el registro generado
		conexion.setQuery("DELETE from cuotas where id = '"+ id + "'");
	}
	/**
	 * Test sobre el metodo BorrarCuota.
	 */	
@Test public void testBorrarCuota() {
		
		
	crearCuota.creaCuota("Pablo", "Villegas", 5, 1500, "10/09/2017", "PENDIENTE");
	
	ResultSet comprobar;
	String nombre="";
	String apellido="";
	int horas =0;
	int precio =0;
	String fecha ="";
	String estado ="";
	int id =0;
	int id1 =0;
	
	comprobar = conexion.getQuery("SELECT * from cuotas order by id desc limit 1");
	
	try {
		while(comprobar.next()) {
		    id = comprobar.getInt("id");
		    
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		borrarCuota.borrarCuota(id);
		
		comprobar = conexion.getQuery("SELECT * from cuotas where id = '" + id + "'");
		
		try {
			while(comprobar.next()) {
			    id1 = comprobar.getInt("id");
			    
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(id1, 0);

		
	}
/**
 * Test sobre el metodo buscarDatos.
 */	

@Test public void testbuscarDatos() {
	
	registrarEstudiante.registrarEstudiante("1111", "Evaristo","Villegas","678111222","pablovillegas@gmail.com","Zurriola Ikastola","C/Mayor 6","Maria (madre)", "666458745");
	crearCuota.creaCuota("Evaristo", "Villegas", 5, 1500, "10/09/2017", "PENDIENTE");
	
	ResultSet comprobar;
	String nombre="";
	String apellido="";
	int horas =0;
	int precio =0;
	String fecha ="";
	String estado ="";
	int id =0;
	
	comprobar = conexion.getQuery("SELECT * from cuotas order by id desc limit 1");
	
	try {
		while(comprobar.next()) {

		    id = comprobar.getInt("id");
		    
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	ArrayList resultado = enviarCuota.buscarDatos(id);

	assertEquals((String) resultado.get(0), C2.getNombre());
	assertEquals((String) resultado.get(1), C2.getApellido());
	assertEquals((String) resultado.get(2), E1.getEmail());
	assertEquals((int) resultado.get(3), C2.getHoras());
	assertEquals((int) resultado.get(4), C2.getPrecio());
	assertEquals((String) resultado.get(5), C2.getFecha());
	
	//limpiar de BBDD el registro generado
	conexion.setQuery("DELETE from cuotas where id = '"+ id + "'");
	conexion.setQuery("DELETE from estudiantes where dni = 1111");
	

}
	
}