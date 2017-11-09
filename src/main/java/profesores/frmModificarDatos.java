package profesores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import bbdd.MyDataAccess;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class frmModificarDatos extends JFrame implements ActionListener{
	
	
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldTelefono;
	private JTextField textFieldEmail;
	private JTextField textFieldDireccion;
	private JTextField textFieldEstudios;

	
	MyDataAccess conexion = new MyDataAccess();
	
	
	public frmModificarDatos(Profesor profesor) {
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
				break;
				
			case "MODIFICAR":
				
		
				String nombre=textFieldNombre.getText();
				String apellido=textFieldApellido.getText();
				String telefono=textFieldTelefono.getText();
				String email=textFieldEmail.getText();
				String direccion=textFieldDireccion.getText();
				String estudios=textFieldEstudios.getText();
				
				String registrar= "update profesores set nombre='"+ nombre +"',apellido='"+ apellido +"',telefono='"+ telefono +"',email='"+ email +"',direccion='"+ direccion +"',estudios='"+ estudios +"'";
				//se envia el script SQL a la BBDD y se registra el curso
								
				conexion.setQuery(registrar);
				
				this.dispose();
				
				JOptionPane.showMessageDialog(this,"Profesor  modificado");
				
				break;
	
		}
		
	}
}
