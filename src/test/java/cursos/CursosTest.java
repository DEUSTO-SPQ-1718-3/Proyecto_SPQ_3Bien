package cursos;

import org.junit.Before;
import org.junit.Test;

import estudiantes.Estudiante;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import junit.framework.JUnit4TestAdapter;


public class CursosTest {
	
	private clsCurso C1;
	private clsCurso C2;
	private clsCurso C3;
	
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
		
		registrar.registrarCurso(1, "Programacion I","Curso inicial", 40,"lunes y martes de 10 a 12");
		
	}
	
}
