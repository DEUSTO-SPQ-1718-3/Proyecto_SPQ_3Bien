package estudiantes;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bbdd.MyDataAccess;

import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class frmModificarEstudiante extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textFieldID;
	MyDataAccess conexion = new MyDataAccess();
	
	String dni;
    String nombre;
    String apellido;
    String telefono;
    String email;
    String colegio;
    String direccion;
    String nombre_contacto;
    String telf_contacto;		
	
	/**
	 * Create the frame.
	 */
	public frmModificarEstudiante() {
		setTitle("MI ACADEMIA - MODIFICAR ESTUDIANTE");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(500, 200, 530, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIDCurso = new JLabel("Indica el DNI del ESTUDIANTE que quieres MODIFICAR");
		lblIDCurso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIDCurso.setBounds(10, 26, 400, 38);
		contentPane.add(lblIDCurso);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(270, 106, 80, 23);
		contentPane.add(btnAtras);
		btnAtras.addActionListener(this);
		
		textFieldID = new JTextField();
		textFieldID.setBounds(215, 67, 80, 20);
		contentPane.add(textFieldID);
		textFieldID.setColumns(10);
		
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
		
		String modifdni=textFieldID.getText();
		String modificar= "Select * from estudiantes where dni='"+modifdni+"' ";
		//enviar la sentencia a la bbdd
		ResultSet resultado= conexion.getQuery(modificar);
		
		try {
			while(resultado.next()){
			    	  
				  dni = resultado.getString("dni");
			      nombre = resultado.getString("nombre");
			      apellido = resultado.getString("apellido");
			      telefono = resultado.getString("telefono");
			      email = resultado.getString("email");
			      colegio = resultado.getString("colegio");
			      direccion = resultado.getString("direccion");
			      nombre_contacto = resultado.getString("nombre_contacto");
			      telf_contacto = resultado.getString("telf_contacto");
			      
			      Estudiante estudiante = new Estudiante(dni, nombre, apellido, telefono, email,colegio, direccion, nombre_contacto, telf_contacto);
			      
			      frmModificarDatos modificardatos=new frmModificarDatos(estudiante);
			      modificardatos.setVisible(true);
			      
			      this.dispose();
			      
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
