package profesores;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;

import bbdd.MyDataAccess;

import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class frmModificarProfesor extends JFrame implements ActionListener{

	//final static Logger logger = Logger.getLogger(frmBorrarEstudiante.class);
	
	private JPanel contentPane;
	private JTextField textFieldNombre;
	MyDataAccess conexion = new MyDataAccess();
	
	String nombre;
	String apellido;
	String telefono;
	String email;
	String direccion;
	String estudios;
	
	/**
	 * Create the frame.
	 */
	public frmModificarProfesor() {
		setTitle("MI ACADEMIA - Modificar Profesor");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(500, 200, 530, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreProf = new JLabel("Indica el nombre del profesor que quieres modificar");
		lblNombreProf.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNombreProf.setBounds(10, 26, 400, 38);
		contentPane.add(lblNombreProf);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(270, 106, 80, 23);
		contentPane.add(btnAtras);
		btnAtras.addActionListener(this);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(215, 67, 80, 20);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(130, 106, 89, 23);
		contentPane.add(btnAceptar);
		btnAceptar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		switch(e.getActionCommand()){
		
		
			case "Atras":
				
				this.dispose();				
				break;
				
			case "Aceptar":
				recogerInformacion();
												
				break;
		}
		
	}

	private void recogerInformacion() {
		// TODO Auto-generated method stub
		
		String nom=textFieldNombre.getText();
		String modificar= "Select * from profesores where nombre='"+nom+"' ";
		//enviar la sentencia a la bbdd
		ResultSet resultado= conexion.getQuery(modificar);
	
		//logger.trace("This is TRACE : Se han lanzado la query de Select Estudiante");
		
		try {
			while(resultado.next()){
			    	  
				  
			      nombre = resultado.getString("nombre");
			      apellido = resultado.getString("apellido");
			      telefono = resultado.getString("telefono");
			      email = resultado.getString("email");
			      direccion = resultado.getString("direccion");
			      estudios = resultado.getString("estudios");
			      
			      Profesor profesor = new Profesor(nombre, apellido, telefono, email, direccion, estudios);
			      
			      //logger.info("This is INFO : Se ha creado un objeto Estudiante con los datos de BD de DNI "+dni);
			      
			      frmModificarDatos modificardatos=new frmModificarDatos(profesor, nom);
			      modificardatos.setVisible(true);
			      
			      this.dispose();
			      
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}