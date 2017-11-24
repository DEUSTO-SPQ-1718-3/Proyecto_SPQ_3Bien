package usuarios;

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
	private JTextField textFieldNom_usu;
	private JTextField textFieldContra;

	
	private String nomReferente;

	
	MyDataAccess conexion = new MyDataAccess();
	
	
	public frmModificarDatos(usuario usuario, String nomModificado) {
		getContentPane().setLayout(null);
		
		setBounds(500, 200, 530, 440);
		this.setResizable(false);
		
		setTitle("MI ACADEMIA");
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(40, 60, 60, 25);
		getContentPane().add(lblNombre);
		
		textFieldNombre = new JTextField(usuario.getNombre());
		textFieldNombre.setBounds(150, 60, 86, 25);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(40, 100, 60, 25);
		getContentPane().add(lblApellido);
				
		textFieldApellido = new JTextField(usuario.getApellido());
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(150, 100, 160, 25);
		getContentPane().add(textFieldApellido);	
		
		
		JLabel lblNom_usu = new JLabel("Usuario");
		lblNom_usu.setBounds(40, 140, 60, 25);
		getContentPane().add(lblNom_usu);
		
		
		textFieldNom_usu = new JTextField(usuario.getNom_usuario());
		textFieldNom_usu.setColumns(10);
		textFieldNom_usu.setBounds(150, 140, 160, 25);
		getContentPane().add(textFieldNom_usu);
		
		
		JLabel lblContra = new JLabel("Contraseña");
		lblContra.setBounds(40, 200, 160, 25);
		getContentPane().add(lblContra);
						
		textFieldContra = new JTextField(usuario.getContra());
		textFieldContra.setColumns(10);
		textFieldContra.setBounds(150, 200, 160, 25);
		getContentPane().add(textFieldContra);
		
		
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
				frmUsuarios objAtras=new frmUsuarios();
				objAtras.setVisible(true);
				this.dispose();
				break;
				
			case "MODIFICAR":
				
				
				String nombre=textFieldNombre.getText();
				String apellido=textFieldApellido.getText();
				String nom_usu=textFieldNom_usu.getText();
				String contra=textFieldContra.getText();
				
				String registrar= "update usuarios set nom_usuario='"+ nom_usu +"',contra='"+ contra +"',nombre='"+ nombre +"',apellido='"+ apellido +"' where nom_usuario = '"+nomReferente+"'";
				//se envia el script SQL a la BBDD y se registra el usuario
			
								
				conexion.setQuery(registrar);
				
				this.dispose();
				
				JOptionPane.showMessageDialog(this,"Usuario  modificado");
				
				break;
	
		}
		
	}
}

