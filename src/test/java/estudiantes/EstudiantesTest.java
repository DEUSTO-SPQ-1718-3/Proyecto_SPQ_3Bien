package estudiantes;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import junit.framework.JUnit4TestAdapter;
import cursos.clsCurso;

public class EstudiantesTest {
	
	private Estudiante estudiante1;
	
	private frmRegistrarEstudiante ventana1;
	private frmBorrarEstudiante ventana2;
	frmEstudiantes ventana3;
	
	public static junit.framework.Test suite() {
		 return new JUnit4TestAdapter(EstudiantesTest.class);
	}
	
	
	@Before public void setUp() {
		estudiante1= new Estudiante ("0000", "Sara","Martin","678111222","sm@gmail.com","Zurriola Ikastola","C/Mayor 6","Maria (madre)", "666458745");
		ventana1 = new frmRegistrarEstudiante();
		ventana2 = new frmBorrarEstudiante();
		ventana3 = new frmEstudiantes();
		
	}
	
	@Test public void testRegistrarEstudiante() {
		
				
		ventana1.registrarEstudiante(estudiante1.getDni(),estudiante1.getNombre(),estudiante1.getApellido(),estudiante1.getTelefono(),estudiante1.getEmail(),estudiante1.getColegio(),estudiante1.getDireccion(),estudiante1.getNombre_contacto(),estudiante1.getTelf_contacto());
						
	}
	
	@Test public void testBorrarEstudiante() {
		
			
		ventana2.borrarEstudiante("0000");
	}
	
	
	@Test public void testVerEstudiantes() {
		
		ventana3.setVisible(true);
		
		ventana3.completarLista();
	}
	
	
}
