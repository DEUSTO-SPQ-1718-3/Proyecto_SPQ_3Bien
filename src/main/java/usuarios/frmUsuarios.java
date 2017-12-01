package usuarios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;

import main.VentanaInicial;
import profesores.Profesor;
import profesores.frmBorrarProfesor;
import profesores.frmModificarProfesor;
import profesores.frmProfesores;
import profesores.frmRegistrarProfesor;
import bbdd.MyDataAccess;

/**clase que gestiona las operaciones de los usuarios administradores
 * Opciones que se recogen: Añadir, modificar,borrar y refrescar
 * Visualizacion de los usuarios registrados en la ventana
* @author Grupo 3 DBS SS: Procesos software y de calidad 17-18
*
*/

public class frmUsuarios extends JFrame implements ActionListener
{
	//final static Logger logger = Logger.getLogger(frmUsuarios.class);
	
	Logger logger3 = Logger.getLogger("usuarios");
	
	JTextArea txtUsuarios;
	ArrayList<usuario> listaUsuarios;
	JScrollPane scrollPane;
	MyDataAccess conexion;
    ResultSet resultado;
   
    String nombre;
	String apellido;
	String nom_usuario;
    String contra;
    
    
	public frmUsuarios() {
	
		
		setBounds(400, 400, 430, 230); //Tamaño
		
		setTitle("MI ACADEMIA");
		
		listaUsuarios = new ArrayList<usuario>(); 
		
		//BD

		conexion = new MyDataAccess();
			    
		resultado = conexion.getQuery("select * from usuarios");
			    
			    
		//
			    
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(500, 200, 530, 440);
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 5, 400, 400);
		contentPane.add(scrollPane);
		
		completarLista();
			
		JButton btnRefesh = new JButton("REFRESH");
		btnRefesh.setBounds(420, 70, 100, 25);
		btnRefesh.addActionListener(this);
		btnRefesh.setActionCommand("Refresh");
		contentPane.add(btnRefesh);		
		
		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.setBounds(420, 120, 100, 25);
		btnModificar.addActionListener(this);
		btnModificar.setActionCommand("Modificar");
		contentPane.add(btnModificar);
		
		JButton btnAnyadir = new JButton("ANYADIR");
		btnAnyadir.setBounds(420, 170, 100, 25);
		btnAnyadir.addActionListener(this);
		btnAnyadir.setActionCommand("Anyadir");
		contentPane.add(btnAnyadir);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(420, 220, 100, 25);
		btnEliminar.addActionListener(this);
		btnEliminar.setActionCommand("Eliminar");
		contentPane.add(btnEliminar);		
		
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.setBounds(420, 270, 100, 25);
		btnSalir.addActionListener(this);
		btnSalir.setActionCommand("Salir");
		contentPane.add(btnSalir);
		
		this.setResizable(false);		
			
			
	}
	

	void completarLista() {
		// TODO Auto-generated method stub
		txtUsuarios = new JTextArea();
		txtUsuarios.setEditable(false);
		txtUsuarios.setColumns(50);
		
		try {
		      while(resultado.next()){
		   		    	  
		    	  nom_usuario = resultado.getString("nom_usuario");
			      contra = resultado.getString("contra");
			      nombre=resultado.getString("nombre");
			      apellido=resultado.getString("apellido");
			
		     
			      listaUsuarios.add(new usuario(nombre, apellido , nom_usuario , contra));	
		     		      
		      }
		      
		    }catch (SQLException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		      
		    }			
			
		txtUsuarios.setText("----Usuarios Registrados ----\n ");
		txtUsuarios.append(listaUsuarios.toString());	
		 
		scrollPane.setViewportView(txtUsuarios);
				
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		switch(e.getActionCommand()){
		
		
		case "Modificar":
			
			frmModificarUsuario modifUsu = new frmModificarUsuario();
			modifUsu.setVisible(true); 
			break;
			
		case "Anyadir":
	
			frmRegistrarUsuario ventanaanyadirUsuario = new frmRegistrarUsuario();
			ventanaanyadirUsuario.setVisible(true); 
			
			this.dispose();	
			break;
						
		case "Eliminar":
			
			frmBorrarUsuario borrarUsu = new frmBorrarUsuario();
			borrarUsu.setVisible(true);
			this.dispose();
			
			break;
			
		case "Refresh":
			
			this.dispose();
			frmUsuarios nuevo = new frmUsuarios();
			nuevo.setVisible(true); 
			 logger3.error("This is ERROR : Se ha refrescado la pagina de usuarios");
			 logger3.info("This is INFO : Se ha refrescado la pagina de usuarios");
			break;
			
					
		case "Salir":
			VentanaInicial menu = new VentanaInicial();
			menu.setVisible(true);
			//System.out.println("Cerrando programa...");
			//System.exit(0);
			break;
			
		}
	}
}


