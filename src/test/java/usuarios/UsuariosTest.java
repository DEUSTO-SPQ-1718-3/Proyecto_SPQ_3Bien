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
	
	@Test public void testRegistrarUsuario() {
		
		conexion.setQuery("Delete from profesores where dni = '222'");	
		
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
	
	@Test public void testBorrarUsuario() {
		
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
	
	@Test public void testModificarProfesor() 
	{
		conexion.setQuery("Delete from usuarios where nom_usuario= 'a_a' ");	
		registrar_usu.registrarUsuario(usuario1.getNom_usuario(), usuario1.getContra(), usuario1.getNombre(),usuario1.getApellido());
		
		ResultSet resultadoBD;
		resultadoBD = conexion.getQuery("SELECT * from usuarios where nom_usuario= 'a_a'");
		
		String nom_usuario="";
		String contra="";
		String nombre="";
		String apellido="";
	
		
		try {
			while(resultadoBD.next()) {
				//comprobar.next();//paso porque el primero es el ID
				nom_usuario=resultadoBD.getString("nom_usuario");
				contra=resultadoBD.getString("contra");
				nombre=resultadoBD.getString("nombre");
				apellido = resultadoBD.getString("apellido");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//String registrar= "update profesores set nombre='"+ nombre +"',apellido='"+ apellido +"',telefono='"+ telefono +"',email='"+ email +"',direccion='"+ direccion +"',estudios='"+ estudios +"' where nombre = '"+nomReferente+"'";
		
		String nom_usuarioMod="w_w";
		String contraMod="aaa";
		String nombreMod="Ion";
		String apellidoMod="Kazabon";
		
		
			
		
		conexion.setQuery("update usuarios set nom_usuario='"+ nom_usuarioMod+"',contra='"+ contraMod +"',nombre='"+ nombreMod +"',apellido='"+ apellidoMod +"' where nom_usuario = 'a_a'");
		
		
		resultadoBD = conexion.getQuery("SELECT * from usuarios where nom_usuario='w_w'");
		
		//principal_prof.completarLista();
		try {
			while(resultadoBD.next()) {
				//comprobar.next();//paso porque el primero es el ID
				assertEquals( resultadoBD.getString("nom_usuario"), nom_usuarioMod);
				assertEquals( resultadoBD.getString("contra"), contraMod);
				assertEquals( resultadoBD.getString("nombre"), nombreMod);
				assertEquals( resultadoBD.getString("apellido"), apellidoMod);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		conexion.setQuery("Delete from usuarios where nom_usuario= 'w_w'");	
	}
	
}

