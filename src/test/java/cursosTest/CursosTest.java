package cursosTest;

import org.junit.Before;
import org.junit.Test;

import bbdd.MyDataAccess;
import cursos.clsAsistencia;
import cursos.clsCurso;
import cursos.frmApuntarseCurso;
import cursos.frmBorrarCurso;
import cursos.frmMenuCursos;
import cursos.frmModificarDatosCurso;
import cursos.frmRegistrarCurso;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.ResultSet;
import java.sql.SQLException;

import junit.framework.JUnit4TestAdapter;
/**Clase para realizar los test correspondientes a el modulo de Cursos.
 *\class CursosTest
 * @package cursosTest
 * @brief Paquete que con las clases de test correspondientes al modulo Cursos
 * @author Grupo 3 DBS SS: Procesos software y de calidad 17-18
 *
 */

public class CursosTest {
	
	private clsCurso C1;
	private clsCurso C2;
	private clsCurso C3;
	private clsAsistencia A1;
	private clsAsistencia A2;
	MyDataAccess conexion;
	frmRegistrarCurso registrar;
	frmBorrarCurso borrar;
	frmModificarDatosCurso modificar;
	frmMenuCursos menu;
	frmApuntarseCurso apuntarse;
	
	public static junit.framework.Test suite() {
		 return new JUnit4TestAdapter(CursosTest.class);
	}
	
	//setUp del curso C1 con atributos con valor
	@Before public void setUp() {
		C1= new clsCurso (101, "Programacion I","Curso inicial", 40,"lunes y martes de 10 a 12");
		C2= new clsCurso (102, "Programacion II", "Curso segundo", 40, "lunes y martes de 10 a 12");
		C3= new clsCurso (103, "Calculo", "Nociones basicas", 48, "viernes de 10 a 14");
		A1= new clsAsistencia (1, "11");
		A2= new clsAsistencia (22, "222");
		conexion = new MyDataAccess();
		registrar = new frmRegistrarCurso();
		borrar= new frmBorrarCurso();
		modificar= new frmModificarDatosCurso(C1);
		menu= new frmMenuCursos();
		apuntarse= new frmApuntarseCurso();
	}
	
	@Test public void testAnyadir() {
		
		registrar.registrarCurso(C1.getIdC(), C1.getNombreC(),C1.getDescripcion(), C1.getNumClase(),C1.getHorario());
		
		ResultSet comprobar;
		String nombre="";
		String desc="";
		int nClase=0;
		String horario="";
		
		comprobar = conexion.getQuery("SELECT * from cursos where idC=101");
		
		menu.cargarCursos();
		
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
		borrar.borrarCurso(101);
	}
	
	@Test public void testModificar() {
		registrar.registrarCurso(C3.getIdC(), C3.getNombreC(), C3.getDescripcion(), C3.getNumClase(), C3.getHorario());
		
		ResultSet comprobar;
		String nombre="";
		String desc="";
		int nClase=0;
		String horario="";
		
		comprobar = conexion.getQuery("SELECT * from cursos where idC=103");
		
		menu.cargarCursos();
		
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
		
		assertEquals(nombre, "Calculo");
		assertEquals(desc, "Nociones basicas");
		assertEquals(nClase, 48);
		assertEquals(horario, "viernes de 10 a 14");
		
		nombre="Calculo";
		desc="Nociones basicas y funcionales";
		nClase=58;
		horario="quedan suspendidas hasta nuevo aviso";
		
		conexion.setQuery("update cursos set idC=103, nombreC='"+ nombre +"',descripcion='"+ desc +"', numClase='"+ nClase +"', horario='"+ horario +"' where idC=103");
		
		
		comprobar = conexion.getQuery("SELECT * from cursos where idC=103");
		
		menu.cargarCursos();
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
		
		assertEquals(nombre, "Calculo");
		assertEquals(desc, "Nociones basicas y funcionales");
		assertEquals(nClase, 58);
		assertEquals(horario, "quedan suspendidas hasta nuevo aviso");
		
		//limpiar de BBDD el registro generado
		borrar.borrarCurso(103);
	}
	
	@Test public void testBorrar() {
		
		registrar.registrarCurso(C2.getIdC(), C2.getNombreC(), C2.getDescripcion(), C2.getNumClase(), C2.getHorario());
		
		ResultSet comprobar;
		String nombre="";
		String desc="";
		String horario="";
		
		comprobar = conexion.getQuery("SELECT * from cursos where idC=102");
		
		//limpiar de BBDD el registro generado
		borrar.borrarCurso(102);
		
		comprobar = conexion.getQuery("SELECT * from cursos where idC=102");
		
		menu.cargarCursos();
		
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
	
	/**
	 * testeamos que el estudiante pueda apuntarse correctamente al curso
	 */
	@Test public void testApuntarseCurso() {
		apuntarse.apuntarmeCurso(A1.getIdC(), A1.getDniE());
		
		ResultSet comprobar;
		String dniEst="";
		int idCurso=0;
		
		
		comprobar = conexion.getQuery("SELECT * from asistencia where idC=1 and dniE='11'");
		
			
		try {
			while(comprobar.next()) {
				dniEst=comprobar.getString("dniE");
				//System.out.println(dniEst);
				idCurso=comprobar.getInt("idC");
				//System.out.println(idCurso);
	
			} 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(dniEst, A1.getDniE());
		assertEquals(idCurso, A1.getIdC());		
		
		//limpiar esa fila en la BBDD
		conexion.setQuery("Delete from asistencia where idC=1 and dniE=11");
		
	}
	
	@Test public void testComprobarExistenciaCursoEstudiante() {
		apuntarse.apuntarmeCurso(A1.getIdC(), A1.getDniE());
		
		//esto debería devolver true ya que, compruebo un curso y estudiante que existen
		assertTrue(apuntarse.comprobarExistencia(A1.getIdC(), A1.getDniE()));
		assertFalse(apuntarse.comprobarExistencia(A2.getIdC(), A2.getDniE()));
	
		//borramos la fila
		conexion.setQuery("Delete from asistencia where idC=1 and dniE=11");
	}
	
	
	@Test public void testInformeCurso() {
		
	}
}
