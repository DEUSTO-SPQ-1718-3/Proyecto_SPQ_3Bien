package bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**Clase que realiza la conexion con la BD
 * \class MyDataAccess
 * @package bbdd
 * @brief Paquete que dispone de las clases relacionadas con la conexion a la BD
 * @author Grupo 3 DBS SS: Procesos software y de calidad 17-18
 *
 */
public class MyDataAccess {

 private String _usuario="root";
 private String _pwd= "";
 private static String _bd="proyecto";
 static String _url = "jdbc:mysql://localhost/"+_bd;
 private Connection conn = null;
 
 public MyDataAccess() {
  
   try{
     Class.forName("com.mysql.jdbc.Connection");
     conn = (Connection)DriverManager.getConnection(_url, _usuario, _pwd);
     if(conn != null)
     {
       System.out.println("Conexi-n a base de datos "+_url+" . . . Ok");
     }
   }
   catch(SQLException ex)
   {
      System.out.println("Hubo un problema al intentar conecarse a la base de datos"+_url);
   }
   catch(ClassNotFoundException ex)
   {
      System.out.println(ex);
   }  
 }
	/**
	 * Metodo para querys de consulta que devuelven un valor. (Select)
	 */
 public ResultSet getQuery(String _query)
 {
    Statement state = null;
    ResultSet resultado = null;
    try{
      state = (Statement) conn.createStatement();
      resultado = state.executeQuery(_query);
    }
    catch(SQLException e)
    {
      e.printStackTrace();
    }
    return resultado;
 }
	/**
	 * Metodo para querys que realizan cambios en la BD y no devuelven valor. (Insert, Delete y Update)
	 */
 public void setQuery(String _query){

    Statement state = null;
  
    try{   
      state=(Statement) conn.createStatement();
      state.execute(_query);

    }catch (SQLException e){
      e.printStackTrace();
    }
 }
}