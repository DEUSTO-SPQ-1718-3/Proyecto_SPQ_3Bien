package cursos;

import org.junit.Before;
import org.junit.Test;

import bbdd.MyDataAccess;
import estudiantes.Estudiante;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.ResultSet;
import java.sql.SQLException;

import junit.framework.JUnit4TestAdapter;


public class CursosTest {
	
	private clsCurso C1;
	private clsCurso C2;
	private clsCurso C3;
	MyDataAccess conexion = new MyDataAccess();
	
	public static junit.framework.Test suite() {
		 return new JUnit4TestAdapter(CursosTest.class);
	}
	
	//setUp del curso C1 con atributos con valor
	@Before public void setUp() {
		C1= new clsCurso (1, "Programacion I","Curso inicial", 40,"lunes y martes de 10 a 12");
		C2= new clsCurso (2, "Contabilidad I", "Curso iniciacion", 29, "martes y jueves de 8 a 10");
		C3= new clsCurso (3, "Calculo", "Nociones basicas", 48, "viernes de 10 a 14");
	}
	
	@Test public void testAnyadir() {
		
		frmRegistrarCurso registrar = new frmRegistrarCurso();
		
		registrar.registrarCurso(101, "Programacion I","Curso inicial", 40,"lunes y martes de 10 a 12");
		
		ResultSet comprobar;
		String nombre="";
		String desc="";
		int nClase=0;
		String horario="";
		
		comprobar = conexion.getQuery("SELECT * from cursos where idC=101");
				
		try {
			while(comprobar.next()) {
				comprobar.next();//paso porque el primero es el ID
				nombre=comprobar.getString("nombreC");
				desc=comprobar.getString("descripcion");
				nClase = comprobar.getInt("numClase");
			    horario = comprobar.getString("horario");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(nombre, "Programacion I");
		assertEquals(desc, "Curso inicial I");
		assertEquals(nClase, 40);
		assertEquals(horario, "lunes y martes de 10 a 12");
		
		//limpiar de BBDD el registro generado
		conexion.setQuery("Delete from proyecto.cursos where idC=101");
	}
	
	@Test public void testBorrar() {
		frmRegistrarCurso registrar = new frmRegistrarCurso();
		
		registrar.registrarCurso(102, "Programacion II","Curso segundo", 40,"lunes y martes de 10 a 12");
		
		ResultSet comprobar;
		String nombre="";
		String desc="";
		int nClase=0;
		String horario="";
		
		comprobar = conexion.getQuery("SELECT * from cursos where idC=102");
		
		//limpiar de BBDD el registro generado
		conexion.setQuery("Delete from proyecto.cursos where idC=102");
		
		comprobar = conexion.getQuery("SELECT * from cursos where idC=102");
		
		try {
			while(comprobar.next()) {
				comprobar.next();
				nombre=comprobar.getString("nombreC");
				desc=comprobar.getString("descripcion");
				nClase = comprobar.getInt("numClase");
			    horario = comprobar.getString("horario");
			} 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(nombre, null);
		assertEquals(desc, null);
		assertEquals(nClase, null);
		assertEquals(horario, null);
		
	}
	
}
