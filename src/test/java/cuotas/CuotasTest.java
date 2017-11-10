package cuotas;

/*import org.junit.Before;
import org.junit.Test;

import Cuotas.Cuota;
import Cuotas.frmCrearCuota;
import bbdd.MyDataAccess;
import estudiantes.Estudiante;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.ResultSet;
import java.sql.SQLException;

import junit.framework.JUnit4TestAdapter;


public class CuotasTest {
	
	private Cuota C1;

	MyDataAccess conexion = new MyDataAccess();
	
	public static junit.framework.Test suite() {
		 return new JUnit4TestAdapter(CuotasTest.class);
	}
	
	//setUp del curso C1 con atributos con valor
	@Before public void setUp() {
		C1= new Cuota ("Pa", "Vi", 10, 300, "2/02/2017", "PENDIENTE", 100);
	}
	
	@Test public void testAnyadir() {
		
		frmCrearCuota registrar = new frmCrearCuota();
		
		registrar.creaCuota("Pa", "Vi", 10, 300, "2/02/2017", "PENDIENTE");
		
		ResultSet comprobar;
		String nombre="";
		String apellido="";
		int horas=0;
		String fecha="";
		
		comprobar = conexion.getQuery("SELECT * from cursos where horas = 10");
				
		try {
			while(comprobar.next()) {
				comprobar.next();//paso porque el primero es el ID
				nombre=comprobar.getString("nombre");
				apellido=comprobar.getString("apellido");
				horas = comprobar.getInt("horas");
			    fecha = comprobar.getString("fecha");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(nombre, "Pa");
		assertEquals(apellido, "Vi");
		assertEquals(horas, 10);
		assertEquals(fecha, "2/02/2017");
		
		//limpiar de BBDD el registro generado
		conexion.setQuery("Delete from proyecto.cursos where horas = 10");
	}
	
}*/
