package cuotas;

import org.junit.Before;

import org.junit.Test;

import Cuotas.Cuota;
import Cuotas.frmBorrarCuota;
import Cuotas.frmCrearCuota;
import Cuotas.frmModificarCuota;
import bbdd.MyDataAccess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.ResultSet;
import java.sql.SQLException;

import junit.framework.JUnit4TestAdapter;

/**Clase para realizar los test correspondientes a el modulo de Cuotas.
 * 
 * @author Grupo 3 DBS SS: Procesos software y de calidad 17-18
 *
 */
public class CuotasTest {

	Cuota C1;
	MyDataAccess conexion;
	frmCrearCuota crearCuota;
	frmBorrarCuota borrarCuota;
	frmModificarCuota modificarCuota;
//	frmMenuCursos menu;
//	frmApuntarseCurso apuntarse;
	
	public static junit.framework.Test suite() {
		 return new JUnit4TestAdapter(CuotasTest.class);
	}
	/**
	 * Inicializa los valores que se usaran en la clase.
	 */
	@Before public void setUp() {
		C1= new Cuota ("Pablo", "Villegas",5, 1500,"10/09/2017","PENDIENTE", 100);
		conexion = new MyDataAccess();
		crearCuota = new frmCrearCuota();
		borrarCuota = new frmBorrarCuota();
		modificarCuota = new frmModificarCuota();
		//menu= new frmMenuCursos();
		//apuntarse= new frmApuntarseCurso();
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
				//comprobar.next();//paso porque el primero es el ID
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
		
		System.out.println(nombre);
		System.out.println(id);
		
		modificarCuota.modificarCuota(nombre, apellido, horas, precio, fecha, id);
		
		comprobar = conexion.getQuery("SELECT * from cuotas where id  = '" + id + "'");

		try {
			while(comprobar.next()) {
				//comprobar.next();//paso porque el primero es el ID
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
		//conexion.setQuery("DELETE from cuotas where id = '"+ id + "'");
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
	
		System.out.println(id1);
		
		assertEquals(id1, 0);

		
	}
	
}