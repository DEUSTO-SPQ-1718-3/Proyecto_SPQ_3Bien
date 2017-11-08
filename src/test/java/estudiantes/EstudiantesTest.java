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
	private Estudiante estudiante2;
	private Estudiante estudiante3;
	private Estudiante estudiante4;

	
	public static junit.framework.Test suite() {
		 return new JUnit4TestAdapter(EstudiantesTest.class);
	}
	
	
	@Before public void setUp() {
		estudiante1= new Estudiante ("0000", "Sara","Martin","678111222","sm@gmail.com","Zurriola Ikastola","C/Mayor 6","Maria (madre)", "666458745");
				
	}
	
	@Test public void testRegistrarEstudiante() {
		
		frmRegistrarEstudiante ventana = new frmRegistrarEstudiante();
		
		ventana.registrarEstudiante(estudiante1.getDni(),estudiante1.getNombre(),estudiante1.getApellido(),estudiante1.getTelefono(),estudiante1.getEmail(),estudiante1.getColegio(),estudiante1.getDireccion(),estudiante1.getNombre_contacto(),estudiante1.getTelf_contacto());
						
	}
	
	@Test public void testBorrarEstudiante() {
		
		frmBorrarEstudiante ventana = new frmBorrarEstudiante();
		
		ventana.borrarEstudiante("0000");
	}
	
	
	@Test public void testVerEstudiantes() {
		
		frmEstudiantes ventana = new frmEstudiantes();
		ventana.setVisible(true);
		
		ventana.completarLista();
	}
	
	
}
