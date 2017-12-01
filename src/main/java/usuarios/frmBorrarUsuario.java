package usuarios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bbdd.MyDataAccess;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**en esta clase se recogen todos los metodos, atributos y recursos necesarios
 * para poder borrar un usuario ya existente en la BD de la Academia
 * 
 * @author Grupo 3 DBS SS: Procesos software y de calidad 17-18
 *
 */
//en esta clase se recogen todos los metodos, atributos y recursos necesarios para poder borrar un usuario ya existente en la BD de la Academia

public class frmBorrarUsuario extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textFieldNom_usu;
	MyDataAccess conexion = new MyDataAccess();
	
	/**
	 * Create the frame.
	 */
	public frmBorrarUsuario() {
		setTitle("MI ACADEMIA - Borrar usuario");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(500, 200, 530, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNom_usuario = new JLabel("Indica el nombre de usuario del usuario que quieres borrar");
		lblNom_usuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNom_usuario.setBounds(10, 26, 400, 38);
		contentPane.add(lblNom_usuario);
		
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
				String nom_usu=textFieldNom_usu.getText();
				borrarUsuario(nom_usu);
				
				break;
		}
		
	}
	
	
	/**
	 * Se borran de la BD los datos correspondientes al nom_usuario del usuario que se pasa por parametro
	 * @param nom_usu
	 */
	void borrarUsuario(String nom_usu) {
		// TODO Auto-generated method stub
		
		String borrar= "Delete from usuarios where nom_usuario='"+nom_usu+"' ";
		//enviar la sentencia para borrar el profesor indicado mediante el nombre de la BD
		conexion.setQuery(borrar);
		
		this.dispose();
		JOptionPane.showMessageDialog(this,"El usuario con nombre de usuario "+nom_usu + " ha sido borrado correctamente");
				
	}
}