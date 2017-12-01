package estudiantes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import bbdd.MyDataAccess;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**Si el dni que hemos introducido en frmModificarEstudiante esta dado de alta, podremos modificar los datos a excepcion de su dni
 * @package estudiantes
 * @author Grupo 3 DBS SS: Procesos software y de calidad 17-18
 *
 */
public class frmModificarDatos extends JFrame implements ActionListener{
	
	private JTextField textFieldDni;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldTelefono;
	private JTextField textFieldEmail;
	private JTextField textFieldColegio;
	private JTextField textFieldDireccion;
	private JTextField textFieldNombreC;
	private JTextField textFieldTelfC;
	
	MyDataAccess conexion = new MyDataAccess();
	
	/**Nuevos valores para el estudiante que queremos modificar
	 * 
	 * @param objeto Estudiante
	 */
	public frmModificarDatos(Estudiante estudiante) {
		getContentPane().setLayout(null);
		
		setBounds(500, 200, 530, 440);
		this.setResizable(false);
		
		setTitle("MI ACADEMIA");
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(40, 20, 60, 25);
		getContentPane().add(lblDni);
		
		textFieldDni = new JTextField(estudiante.getDni());
		textFieldDni.setBounds(150, 20, 86, 25);
		getContentPane().add(textFieldDni);
		textFieldDni.setColumns(10);	
		textFieldDni.setEditable(false);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(40, 60, 60, 25);
		getContentPane().add(lblNombre);
		
		textFieldNombre = new JTextField(estudiante.getNombre());
		textFieldNombre.setBounds(150, 60, 86, 25);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellidos");
		lblApellido.setBounds(40, 100, 60, 25);
		getContentPane().add(lblApellido);
				
		textFieldApellido = new JTextField(estudiante.getApellido());
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(150, 100, 160, 25);
		getContentPane().add(textFieldApellido);	
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(40, 140, 60, 25);
		getContentPane().add(lblTelefono);
						
		textFieldTelefono = new JTextField(estudiante.getTelefono());
		textFieldTelefono.setColumns(10);
		textFieldTelefono.setBounds(150, 140, 160, 25);
		getContentPane().add(textFieldTelefono);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(40, 200, 160, 25);
		getContentPane().add(lblEmail);
		
		
		textFieldEmail = new JTextField(estudiante.getEmail());
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(150, 200, 160, 25);
		getContentPane().add(textFieldEmail);
		
		JLabel lblColegio = new JLabel("Colegio");
		lblColegio.setBounds(40, 240, 60, 25);
		getContentPane().add(lblColegio);
		
		textFieldColegio = new JTextField(estudiante.getColegio());
		textFieldColegio.setColumns(10);
		textFieldColegio.setBounds(150, 240, 160, 25);
		getContentPane().add(textFieldColegio);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(40, 280, 60, 25);
		getContentPane().add(lblDireccion);
		
		textFieldDireccion = new JTextField(estudiante.getDireccion());
		textFieldDireccion.setColumns(10);
		textFieldDireccion.setBounds(150, 280, 160, 25);
		getContentPane().add(textFieldDireccion);
		
		JLabel lblNC = new JLabel("Nombre contacto");
		lblNC.setBounds(40, 320, 100, 25);
		getContentPane().add(lblNC);
		
		textFieldNombreC = new JTextField(estudiante.getNombre_contacto());
		textFieldNombreC.setColumns(10);
		textFieldNombreC.setBounds(150, 320, 160, 25);
		getContentPane().add(textFieldNombreC);
		
		JLabel lblTC = new JLabel("Telf contacto");
		lblTC.setBounds(40, 360, 100, 25);
		getContentPane().add(lblTC);
		
		textFieldTelfC = new JTextField(estudiante.getTelf_contacto());
		textFieldTelfC.setColumns(10);
		textFieldTelfC.setBounds(150, 360, 160, 25);
		getContentPane().add(textFieldTelfC);	
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(350, 100,120, 40);
		getContentPane().add(btnAtras);
		btnAtras.addActionListener(this);
		
		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.setBounds(350, 200, 120, 40);
		getContentPane().add(btnModificar);
		btnModificar.addActionListener(this);
	}
	//ficha para rellenar, que sera enviada a la BBDD para almacenar los datos correspondientes

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getActionCommand())
		{
			case "Atras":
				frmEstudiantes objAtras=new frmEstudiantes();
				objAtras.setVisible(true);
				this.dispose();
				break;
				
			case "MODIFICAR":
				
				String dni=textFieldDni.getText();
				String nombre=textFieldNombre.getText();
				String apellido=textFieldApellido.getText();
				String telefono=textFieldTelefono.getText();
				String email=textFieldEmail.getText();
				String colegio=textFieldColegio.getText();
				String direccion=textFieldDireccion.getText();
				String nombre_contacto=textFieldNombreC.getText();
				String telf_contacto=textFieldTelfC.getText();
				
				String registrar= "update estudiantes set dni='"+ dni +"',nombre='"+ nombre +"',apellido='"+ apellido +"',telefono='"+ telefono +"',email='"+ email +"',colegio='"+ colegio +"',direccion='"+ direccion +"',nombre_contacto='"+ nombre_contacto +"',telf_contacto='"+telf_contacto+"' where dni='"+dni+"'";
				//se envia el script SQL a la BBDD y se registra el curso
								
				conexion.setQuery(registrar);
				
				this.dispose();
				
				JOptionPane.showMessageDialog(this,"Estudiante con DNI "+dni + " modificado CORRECTAMENTE");
				
				break;
	
		}
		
	}
}


