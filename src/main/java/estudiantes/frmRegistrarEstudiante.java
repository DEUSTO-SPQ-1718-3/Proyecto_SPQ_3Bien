package estudiantes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class frmRegistrarEstudiante extends JFrame implements ActionListener{
	
	private JTextField textFieldDni;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldTelefono;
	private JTextField textFieldEmail;
	private JTextField textFieldColegio;
	private JTextField textFieldDireccion;
	private JTextField textFieldNombreC;
	private JTextField textFieldTelfC;
	
	
	public frmRegistrarEstudiante() {
		getContentPane().setLayout(null);
		
		setBounds(700, 350, 530, 440);
		this.setResizable(false);
		
		setTitle("MI ACADEMIA");
		
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
		
		JLabel lblColegio = new JLabel("Colegio");
		lblColegio.setBounds(40, 240, 60, 25);
		getContentPane().add(lblColegio);
		
		textFieldColegio = new JTextField();
		textFieldColegio.setColumns(10);
		textFieldColegio.setBounds(150, 240, 160, 25);
		getContentPane().add(textFieldColegio);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(40, 280, 60, 25);
		getContentPane().add(lblDireccion);
		
		textFieldDireccion = new JTextField();
		textFieldDireccion.setColumns(10);
		textFieldDireccion.setBounds(150, 280, 160, 25);
		getContentPane().add(textFieldDireccion);
		
		JLabel lblNC = new JLabel("Nombre contacto");
		lblNC.setBounds(40, 320, 100, 25);
		getContentPane().add(lblNC);
		
		textFieldNombreC = new JTextField();
		textFieldNombreC.setColumns(10);
		textFieldNombreC.setBounds(150, 320, 160, 25);
		getContentPane().add(textFieldNombreC);
		
		JLabel lblTC = new JLabel("Telf contacto");
		lblTC.setBounds(40, 360, 100, 25);
		getContentPane().add(lblTC);
		
		textFieldTelfC = new JTextField();
		textFieldTelfC.setColumns(10);
		textFieldTelfC.setBounds(150, 360, 160, 25);
		getContentPane().add(textFieldTelfC);	
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(350, 100,120, 40);
		getContentPane().add(btnAtras);
		
		JButton btnDarDeAlta = new JButton("Dar de alta");
		btnDarDeAlta.setBounds(350, 200, 120, 40);
		getContentPane().add(btnDarDeAlta);
		
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
			case "Dar de alta":
				//clsGestorCursos objGC= new clsGestorCursos();
				//int idC= 1;//lo suyo seria que se generara auto. con el numero correspondiente de las bbdd
				String dni=textFieldNombre.getText();
				String nombre=textFieldNombre.getText();
				String apellido=textFieldApellido.getText();
				String telefono=textFieldTelefono.getText();
				String email=textFieldEmail.getText();
				String colegio=textFieldColegio.getText();
				String direccion=textFieldDireccion.getText();
				String nombre_contacto=textFieldNombreC.getText();
				String telf_contacto=textFieldTelfC.getText();
				
				Estudiante nuevoEstudiante = new Estudiante(dni, nombre, apellido, telefono, email, colegio, direccion, nombre_contacto, telf_contacto);
								
				break;
	
		}
		
	}
}

