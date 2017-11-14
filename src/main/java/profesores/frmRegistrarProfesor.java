package profesores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;

import bbdd.MyDataAccess;


//en esta clase se recogen todos los metodos, atributos y recursos necesarios para registrar o anadir un nuevo profesor a la BD de la Academia

public class frmRegistrarProfesor extends JFrame implements ActionListener{
	

	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldTelefono;
	private JTextField textFieldEmail;
	private JTextField textFieldEstudios;
	private JTextField textFieldDireccion;
	private JTextField textFieldDni;
	
	MyDataAccess conexion = new MyDataAccess();
	
	
	
	public frmRegistrarProfesor() {
		getContentPane().setLayout(null);
		
		setBounds(700, 350, 530, 440);
		this.setResizable(false);
		
		setTitle("MI ACADEMIA: A�adir un profesor");
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(40, 20, 60, 25);
		getContentPane().add(lblDni);
		
		textFieldDni = new JTextField();
		textFieldDni.setBounds(150, 20, 86, 25);
		getContentPane().add(textFieldDni);
		textFieldDni.setColumns(10);		
		
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(40, 60, 60, 25);
		getContentPane().add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(150, 60, 86, 25);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellidos");
		lblApellido.setBounds(40, 100, 60, 25);
		getContentPane().add(lblApellido);
				
		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(150, 100, 160, 25);
		getContentPane().add(textFieldApellido);	
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(40, 140, 60, 25);
		getContentPane().add(lblTelefono);
						
		textFieldTelefono = new JTextField();
		textFieldTelefono.setColumns(10);
		textFieldTelefono.setBounds(150, 140, 160, 25);
		getContentPane().add(textFieldTelefono);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(40, 200, 160, 25);
		getContentPane().add(lblEmail);
		
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(150, 200, 160, 25);
		getContentPane().add(textFieldEmail);
		
		JLabel lblEstudios = new JLabel("Estudios");
		lblEstudios.setBounds(40, 240, 60, 25);
		getContentPane().add(lblEstudios);
		
		textFieldEstudios = new JTextField();
		textFieldEstudios.setColumns(10);
		textFieldEstudios.setBounds(150, 240, 160, 25);
		getContentPane().add(textFieldEstudios);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(40, 280, 60, 25);
		getContentPane().add(lblDireccion);
		
		textFieldDireccion = new JTextField();
		textFieldDireccion.setColumns(10);
		textFieldDireccion.setBounds(150, 280, 160, 25);
		getContentPane().add(textFieldDireccion);
		
		
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(350, 100,120, 40);
		getContentPane().add(btnAtras);
		btnAtras.addActionListener(this);
		
		JButton btnDarDeAlta = new JButton("Dar de alta");
		btnDarDeAlta.setBounds(350, 200, 120, 40);
		getContentPane().add(btnDarDeAlta);
		btnDarDeAlta.addActionListener(this);
		
	}
	//ficha para rellenar los datos del nuevo profesor, que luego seran almacenados en la BD


	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getActionCommand())
		{
			case "Atras":
				frmProfesores objAtras=new frmProfesores();
				objAtras.setVisible(true);
				this.dispose();
				break;
				
			case "Dar de alta":
			
				
				String dni=textFieldDni.getText();
				String nombre=textFieldNombre.getText();
				String apellido=textFieldApellido.getText();
				String telefono=textFieldTelefono.getText();
				String email=textFieldEmail.getText();
				String direccion=textFieldDireccion.getText();
				String estudios=textFieldEstudios.getText();
		

				registrarProfesor(dni,nombre,apellido,telefono,email,direccion,estudios);
				JOptionPane.showMessageDialog(this,"Nuevo profesor registrado");
				
				break;
				
			}

	
	}
		
		void registrarProfesor (String dni, String nombre, String apellido, String telefono, String email, String direccion, String estudios)
		{
			// TODO Auto-generated method stub
					
			String registrar= "insert into profesores values("+"'"+ dni +"','"+ nombre +"','"+ apellido +"','"+ telefono +"','"+ email +"','"+ direccion +"','"+ estudios+"')";
			
			
			conexion.setQuery(registrar);
			
			//se envia el script SQL a la BBDD y queda registrado el nuevo profesor insertado
		
			
			this.dispose();
			
			
			//logger.fatal("This is FATAL : frmReistrarEstudiante se ha destruido");
			
			
			
			
				
		
		}
		
	
}

