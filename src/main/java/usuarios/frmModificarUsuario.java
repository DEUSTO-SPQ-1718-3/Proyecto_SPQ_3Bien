package usuarios;

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

public class frmModificarUsuario extends JFrame implements ActionListener{

	//final static Logger logger = Logger.getLogger(frmBorrarEstudiante.class);
	
	private JPanel contentPane;
	private JTextField textFieldNom_usu;
	MyDataAccess conexion = new MyDataAccess();
	
	
	String nombre;
	String apellido;
	String nom_usu;
	String contra;

	
	/**
	 * Create the frame.
	 */
	public frmModificarUsuario() {
		setTitle("MI ACADEMIA - Modificar Usuario");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(500, 200, 530, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreUsu = new JLabel("Indica el nombre de usuario que quieres modificar");
		lblNombreUsu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNombreUsu.setBounds(10, 26, 400, 38);
		contentPane.add(lblNombreUsu);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(270, 106, 80, 23);
		contentPane.add(btnAtras);
		btnAtras.addActionListener(this);
		
		textFieldNom_usu = new JTextField();
		textFieldNom_usu.setBounds(215, 67, 80, 20);
		contentPane.add(textFieldNom_usu);
		textFieldNom_usu.setColumns(10);
		
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
		
		String nom=textFieldNom_usu.getText();
		String modificar= "Select * from usuarios where nom_usuario='"+nom+"' ";
		//enviar la sentencia a la bbdd
		ResultSet resultado= conexion.getQuery(modificar);
	
		//logger.trace("This is TRACE : Se han lanzado la query de Select Estudiante");
		
		try {
			while(resultado.next()){
			    	  
			      nombre = resultado.getString("nombre");
			      apellido = resultado.getString("apellido");
			      nom_usu=resultado.getString("nom_usuario");
			      contra = resultado.getString("contra");
			      
			      usuario usuario = new usuario(nombre, apellido, nom_usu, contra);
			      
			      //logger.info("This is INFO : Se ha creado un objeto Usuario con los datos de BD del usuario "+nom_usu);
			      
			      frmModificarDatos modificardatos=new frmModificarDatos(usuario, nom);
			      modificardatos.setVisible(true);
			      
			      this.dispose();
			      
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
