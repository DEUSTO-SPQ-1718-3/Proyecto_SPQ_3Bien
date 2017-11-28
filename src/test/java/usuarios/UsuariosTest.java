package usuarios;

import org.junit.Before;
import org.junit.Test;

import bbdd.MyDataAccess;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import junit.framework.JUnit4TestAdapter;


public class UsuariosTest {
	
	private usuario usuario1;
	
	private frmRegistrarUsuario registrar_usu; //ventana 1
	private frmBorrarUsuario borrar_usu; //ventana 2
	frmUsuarios ventana3;
	MyDataAccess conexion;
	
	public static junit.framework.Test suite() {
		 return new JUnit4TestAdapter(UsuariosTest.class);
	}
	
	
	@Before public void setUp() {
		usuario1= new usuario ("a_a", "123","Ane","Martin");
		registrar_usu = new frmRegistrarUsuario();
		borrar_usu = new frmBorrarUsuario();
		ventana3 = new frmUsuarios();
		conexion = new MyDataAccess();
	}
	
	@Test public void testRegistrarEstudiante() {
		
				
		registrar_usu.registrarUsuario(usuario1.getNom_usuario(), usuario1.getContra(), usuario1.getNombre(),usuario1.getApellido());
					
		ResultSet comprobar;
		String nom_usuario="";
		String contra="";
		String nombre="";
		String apellido="";
		
		comprobar = conexion.getQuery("SELECT * from usuarios where nom_usuario='a_a'");
				
		try {
			while(comprobar.next()) {
				//comprobar.next();//paso porque el primero es el ID
				nom_usuario=comprobar.getString("nom_usuario");
				contra=comprobar.getString("contra");
				nombre=comprobar.getString("nombre");
				apellido = comprobar.getString("apellido");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(nom_usuario, "a_a");
		assertEquals(contra, "123");
		assertEquals(nombre, "Ane");
		assertEquals(apellido, "Martin");
				
		//limpiar de BBDD el registro generado
		conexion.setQuery("Delete from proyecto.usuarios where nom_usuario='a_a'");

					
	}
	
	@Test public void testBorrarEstudiante() {
		
		conexion.setQuery("Delete from usuarios where nom_usuario='a_a'");	
		
		registrar_usu.registrarUsuario(usuario1.getNom_usuario(), usuario1.getContra(), usuario1.getNombre(),usuario1.getApellido());
		
		ResultSet comprobar;
		
		String nom_usuario="";
		String contra="";
		String nombre="";
		String apellido="";
		
		conexion.setQuery("Delete from usuarios where nom_usuario='a_a'");
		
		comprobar = conexion.getQuery("SELECT * from usuarios where nom_usuario='a_a'");
				
		try {
			while(comprobar.next()) {
				//comprobar.next();//paso porque el primero es el ID
				nom_usuario=comprobar.getString("nom_usuario");
				contra=comprobar.getString("contra");
				nombre=comprobar.getString("nombre");
				apellido = comprobar.getString("apellido");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(nom_usuario, "");
		assertEquals(contra, "");
		assertEquals(nombre, "");
		assertEquals(apellido, "");
		
	}
	
}

