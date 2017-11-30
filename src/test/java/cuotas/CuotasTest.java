package cuotas;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.ResultSet;
import java.sql.SQLException;

import junit.framework.JUnit4TestAdapter;


public class CuotasTest {

//	frmRegistrarCurso registrar;
//	frmBorrarCurso borrar;
//	frmModificarDatosCurso modificar;
//	frmMenuCursos menu;
//	frmApuntarseCurso apuntarse;
	
	public static junit.framework.Test suite() {
		 return new JUnit4TestAdapter(CuotasTest.class);
	}
	
	@Before public void setUp() {
		C1= new Cuota ("Pablo", "Villegas",5, 150,"10/09/2017","PENDIENTE", 100);
		conexion = new MyDataAccess();
//		registrar = new frmRegistrarCurso();
//		borrar= new frmBorrarCurso();
//		modificar= new frmModificarDatosCurso(C1);
//		menu= new frmMenuCursos();
//		apuntarse= new frmApuntarseCurso();
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
/*	@Test public void testApuntarseCurso() {
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
}*/
