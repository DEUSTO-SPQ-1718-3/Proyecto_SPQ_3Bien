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
	MyDataAccess conexion;
	frmRegistrarCurso registrar;
	
	public static junit.framework.Test suite() {
		 return new JUnit4TestAdapter(CursosTest.class);
	}
	
	//setUp del curso C1 con atributos con valor
	@Before public void setUp() {
		C1= new clsCurso (101, "Programacion I","Curso inicial", 40,"lunes y martes de 10 a 12");
		C2= new clsCurso (102, "Programacion II", "Curso segundo", 40, "lunes y martes de 10 a 12");
		C3= new clsCurso (3, "Calculo", "Nociones basicas", 48, "viernes de 10 a 14");
		conexion = new MyDataAccess();
		registrar = new frmRegistrarCurso();
	}
	
	@Test public void testAnyadir() {
		
		registrar.registrarCurso(C1.getIdC(), C1.getNombreC(),C1.getDescripcion(), C1.getNumClase(),C1.getHorario());
		
		ResultSet comprobar;
		String nombre="";
		String desc="";
		int nClase=0;
		String horario="";
		
		comprobar = conexion.getQuery("SELECT * from cursos where idC=101");
				
		try {
			while(comprobar.next()) {
				//comprobar.next();//paso porque el primero es el ID
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
		assertEquals(desc, "Curso inicial");
		assertEquals(nClase, 40);
		assertEquals(horario, "lunes y martes de 10 a 12");
		
		//limpiar de BBDD el registro generado
		conexion.setQuery("Delete from proyecto.cursos where idC=101");
	}
	
	@Test public void testBorrar() {
		
		registrar.registrarCurso(C2.getIdC(), C2.getNombreC(), C2.getDescripcion(), C2.getNumClase(), C2.getHorario());
		
		ResultSet comprobar;
		String nombre="";
		String desc="";
		
		String horario="";
		
		comprobar = conexion.getQuery("SELECT * from cursos where idC=102");
		
		//limpiar de BBDD el registro generado
		conexion.setQuery("Delete from proyecto.cursos where idC=102");
		
		comprobar = conexion.getQuery("SELECT * from cursos where idC=102");
		
		try {
			while(comprobar.next()) {
				//comprobar.next();
				nombre=comprobar.getString("nombreC");
				desc=comprobar.getString("descripcion");
				comprobar.next();
			    horario = comprobar.getString("horario");
			} 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(nombre, "");
		assertEquals(desc, "");
		assertEquals(horario, "");
		
	}
	
}
