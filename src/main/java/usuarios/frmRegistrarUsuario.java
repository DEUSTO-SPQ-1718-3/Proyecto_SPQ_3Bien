package usuarios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;

import org.apache.log4j.Logger;

import profesores.frmRegistrarProfesor;
import bbdd.MyDataAccess;

/**frame en el que se recogen todos los metodos, atributos y recursos necesarios para registrar o anadir un nuevo usuario a la BD de la Academia
 * 
 * @author Grupo 3 DBS SS: Procesos software y de calidad 17-18
 *
 */
//en esta clase se recogen todos los metodos, atributos y recursos necesarios para registrar o anadir un nuevo usuario a la BD de la Academia

public class frmRegistrarUsuario extends JFrame implements ActionListener{
	
	final static Logger logger = Logger.getLogger(frmRegistrarUsuario.class);
	
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldNom_usuario;
	private JTextField textFieldContra;
	private JTextField textFieldContra2;

	
	MyDataAccess conexion = new MyDataAccess();
    ResultSet resultado;
	
    /**
     * ficha para rellenar los datos del nuevo usuario, que luego seran almacenados en la BD
     * 
     */
	public frmRegistrarUsuario() {
		getContentPane().setLayout(null);
		
		setBounds(700, 350, 530, 440);
		this.setResizable(false);
		
		setTitle("MI ACADEMIA: Añadir un usuario");
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(40, 20, 60, 25);
		getContentPane().add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(150, 20, 86, 25);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);		
		
		JLabel lblApellido = new JLabel("Apellidos");
		lblApellido.setBounds(40, 100, 60, 25);
		getContentPane().add(lblApellido);
				
		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(150, 100, 160, 25);
		getContentPane().add(textFieldApellido);	
		
		JLabel lblNom_usuario = new JLabel("Usuario");
		lblNom_usuario.setBounds(40, 140, 60, 25);
		getContentPane().add(lblNom_usuario);
						
		textFieldNom_usuario = new JTextField();
		textFieldNom_usuario.setColumns(10);
		textFieldNom_usuario.setBounds(150, 140, 160, 25);
		getContentPane().add(textFieldNom_usuario);
		
		JLabel lblContra = new JLabel("Contraseña");
		lblContra.setBounds(40, 200, 160, 25);
		getContentPane().add(lblContra);
		
		
		textFieldContra = new JPasswordField();
		textFieldContra.setColumns(10);
		textFieldContra.setBounds(150, 200, 160, 25);
		getContentPane().add(textFieldContra);
		
		JLabel lblContra2 = new JLabel("Repite Contraseña");
		lblContra2.setBounds(40, 280, 60, 25);
		getContentPane().add(lblContra2);
		
		textFieldContra2 = new JPasswordField();
		textFieldContra2.setColumns(10);
		textFieldContra2.setBounds(150, 280, 160, 25);
		getContentPane().add(textFieldContra2);
		
		
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(350, 100,120, 40);
		getContentPane().add(btnAtras);
		btnAtras.addActionListener(this);
		
		JButton btnDarDeAlta = new JButton("Dar de alta");
		btnDarDeAlta.setBounds(350, 200, 120, 40);
		getContentPane().add(btnDarDeAlta);
		btnDarDeAlta.addActionListener(this);
		
	}
	//ficha para rellenar los datos del nuevo usuario, que luego seran almacenados en la BD


	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getActionCommand())
		{
			case "Atras":
				frmUsuarios objAtras=new frmUsuarios();
				objAtras.setVisible(true);
				this.dispose();
				break;
				
			case "Dar de alta":
			
				recogerDatos();
				
			
		}
	}
	
	/**
	 * Se recogen los datos introducidos por el nuevo usuario a registrar, 
	 * impidiendo que el nombre de usuario coincida con otro ya existente. 
	 * Tambien se verificando que la contraseña este bien escrita, piendole
	 * al usuario que lo escriba dos veces.
	 */
	void recogerDatos()
	{
		String nombre= textFieldNombre.getText();
		String apellido=textFieldApellido.getText();
		String nom_usuario=textFieldNom_usuario.getText();
		String contra=textFieldContra.getText();
		String contra2=textFieldContra2.getText();
		
		
		String nom_usuarioBD;
		conexion = new MyDataAccess();
		
		int usu=0;
	    
		resultado = conexion.getQuery("select nom_usuario from usuarios");
		
		try {
		      while(resultado.next()){
		   		    	  
		    	  nom_usuarioBD = resultado.getString("nom_usuario");
		    	  
		    	  if(nom_usuarioBD.equals(nom_usuario))
		    	  {
		    		 usu=1;
		    		 JOptionPane.showMessageDialog(this,"El nombre de usuario elegido ya existe");	
		    		 
		    	  }	      
		      }
		      
		    }catch (SQLException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		      
		    }			
		
		if(usu==0)
		{
			if (contra.equals(contra2))
			{
			registrarUsuario(nombre,apellido,nom_usuario,contra);
			JOptionPane.showMessageDialog(this,"Nuevo usuario registrado");
			}
	
			else
			{
			JOptionPane.showMessageDialog(this,"Las contraseñas no coinciden, por favor, introduzca de nuevo.");	
			}
		}
	}
		
	/**
	 * Se registra un nuevo usuario en la BD con los siguientes campos: 
	 * @param nombre
	 * @param apellido
	 * @param nom_usuario
	 * @param contra
	 */
	
	void registrarUsuario (String nombre, String apellido, String nom_usuario, String contra)
		{
			// TODO Auto-generated method stub
					
			String registrar= "insert into usuarios values("+"'"+ nom_usuario +"','"+ contra +"','"+ nombre +"','"+ apellido+"')";
			
			
			conexion.setQuery(registrar);
			
			logger.error("This is ERROR : Se ha enviado la sentencia sql de registrar un usuario a la BD");
			
			//se envia el script SQL a la BBDD y queda registrado el nuevo usuario insertado
		
			
			this.dispose();
			
			
			logger.trace("This is TRACE : frmReistrarEstudiante se ha destruido");
			
			
			
			
				
		
		}
		
	
}


