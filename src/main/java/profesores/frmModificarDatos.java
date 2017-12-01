package profesores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import bbdd.MyDataAccess;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

/**Se recogen lo datos de frmModificarProfesor, y aqui es realemtente donde se da la opción de que el
 * usuario realice las modificaciones, y que esas modificaciones sean guardades correctamente en la BD
 * \class frmModificarDatos
 * @package profesores
 * @author Grupo 3 DBS SS: Procesos software y de calidad 17-18
 *
 */
public class frmModificarDatos extends JFrame implements ActionListener{
	
	//final static Logger logger = Logger.getLogger(frmModificarDatos.class);
	
	Logger logger1 = Logger.getLogger("modificar");
	
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldTelefono;
	private JTextField textFieldEmail;
	private JTextField textFieldDireccion;
	private JTextField textFieldEstudios;
	
	private String nomReferente;

	
	MyDataAccess conexion = new MyDataAccess();
	
	
	public frmModificarDatos(Profesor profesor, String nomModificado) {
		getContentPane().setLayout(null);
		
		setBounds(500, 200, 530, 440);
		this.setResizable(false);
		
		setTitle("MI ACADEMIA");
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(40, 60, 60, 25);
		getContentPane().add(lblNombre);
		
		textFieldNombre = new JTextField(profesor.getNombre());
		textFieldNombre.setBounds(150, 60, 86, 25);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(40, 100, 60, 25);
		getContentPane().add(lblApellido);
				
		textFieldApellido = new JTextField(profesor.getApellido());
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(150, 100, 160, 25);
		getContentPane().add(textFieldApellido);	
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(40, 140, 60, 25);
		getContentPane().add(lblTelefono);
						
		textFieldTelefono = new JTextField(profesor.getTelefono());
		textFieldTelefono.setColumns(10);
		textFieldTelefono.setBounds(150, 140, 160, 25);
		getContentPane().add(textFieldTelefono);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(40, 200, 160, 25);
		getContentPane().add(lblEmail);
		
		
		textFieldEmail = new JTextField(profesor.getEmail());
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(150, 200, 160, 25);
		getContentPane().add(textFieldEmail);
		
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(40, 280, 60, 25);
		getContentPane().add(lblDireccion);
		
		textFieldDireccion = new JTextField(profesor.getDireccion());
		textFieldDireccion.setColumns(10);
		textFieldDireccion.setBounds(150, 280, 160, 25);
		getContentPane().add(textFieldDireccion);
		
		JLabel lblEstudios = new JLabel("Estudios");
		lblEstudios.setBounds(40, 320, 100, 25);
		getContentPane().add(lblEstudios);
		
		textFieldEstudios = new JTextField(profesor.getEstudios());
		textFieldEstudios.setColumns(10);
		textFieldEstudios.setBounds(150, 320, 160, 25);
		getContentPane().add(textFieldEstudios);
		
	
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(350, 100,120, 40);
		getContentPane().add(btnAtras);
		btnAtras.addActionListener(this);
		
		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.setBounds(350, 200, 120, 40);
		getContentPane().add(btnModificar);
		btnModificar.addActionListener(this);
		
		nomReferente= nomModificado;
		
		
	}
	//ficha para rellenar, que sera enviada a la BBDD para almacenar los datos correspondientes

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getActionCommand())
		{
			case "Atras":
				frmProfesores objAtras=new frmProfesores();
				objAtras.setVisible(true);
				this.dispose();
				logger1.trace("This is TRACE : Se ha destruido la ventana de modificar datos del profesor");
				break;
				
			case "MODIFICAR":
				
				
				String nombre=textFieldNombre.getText();
				String apellido=textFieldApellido.getText();
				String telefono=textFieldTelefono.getText();
				String email=textFieldEmail.getText();
				String direccion=textFieldDireccion.getText();
				String estudios=textFieldEstudios.getText();
				
				String registrar= "update profesores set nombre='"+ nombre +"',apellido='"+ apellido +"',telefono='"+ telefono +"',email='"+ email +"',direccion='"+ direccion +"',estudios='"+ estudios +"' where nombre = '"+nomReferente+"'";
				//se envia el script SQL a la BBDD y se registra el curso
						
				conexion.setQuery(registrar);
				logger1.trace("This is TRACE : Se ha modificado un profesor");
		
				this.dispose();
				
				JOptionPane.showMessageDialog(this,"Profesor  modificado");
				
				break;
	
		}
		
	}
}
