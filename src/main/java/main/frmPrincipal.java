package main;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;

import bbdd.MyDataAccess;
import estudiantes.frmBorrarEstudiante;
import usuarios.frmRegistrarUsuario;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.UIManager;

/**Clase principal del programa
 * @package main
 * @author Grupo 3 DBS SS: Procesos software y de calidad 17-18
 *
 */

public class frmPrincipal extends JFrame implements ActionListener{

	/**
	 * Clase frmPrincipal que hace de ventana principal
	 */
	private static final long serialVersionUID = 7046431761927583577L;
	
	final static Logger logger = Logger.getLogger(frmPrincipal.class);
	
	private JPanel contentPane;
	private JTextField textField_1;
	private JPasswordField textField_2;
	
	MyDataAccess conexion;
	
	public frmPrincipal() {
	
		
		setBounds(400, 400, 430, 230); //TamaÃ±o
		
		setTitle("MI ACADEMIA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		conexion = new MyDataAccess();
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 430, 230);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setForeground(Color.BLACK);
		panel.setBackground(new Color(153, 204, 255));
		setLocationRelativeTo(null);
		
		JLabel lblRegistrarUsuario = new JLabel("INICIAR SESION");
		lblRegistrarUsuario.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRegistrarUsuario.setBounds(75, 13, 152, 20);
		panel.add(lblRegistrarUsuario);
		
		JLabel lblNombreUsuario = new JLabel("Nombre Usuario:");
		lblNombreUsuario.setBounds(12, 51, 112, 16);
		panel.add(lblNombreUsuario);
		
		textField_1 = new JTextField();
		textField_1.setBounds(129, 48, 166, 22);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblUsuarioPaypal = new JLabel("Password:");
		lblUsuarioPaypal.setBounds(12, 80, 94, 16);
		panel.add(lblUsuarioPaypal);
		
		textField_2 = new JPasswordField();
		textField_2.setBounds(129, 77, 166, 22);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setBounds(20, 120, 130, 25);
		btnRegistrarse.addActionListener(this);
		btnRegistrarse.setActionCommand("Registrarse");
		panel.add(btnRegistrarse);
		
		
		JButton btnIniciar = new JButton("Iniciar Sesion");
		btnIniciar.setBounds(160, 120, 130, 25);
		btnIniciar.addActionListener(this);
		btnIniciar.setActionCommand("Iniciar Sesion");
		panel.add(btnIniciar);
				
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.setBounds(300, 120, 100, 25);
		btnSalir.addActionListener(this);
		btnSalir.setActionCommand("Salir");
		panel.add(btnSalir);
			
		this.setResizable(true);		
			
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		switch(e.getActionCommand()){
		
		
		case "Iniciar Sesion":
			
			String nombre = textField_1.getText();
			String pass = new String(textField_2.getPassword());
			
			boolean exito = false;
			
			exito = acreditarse(nombre, pass);
			
			if (exito) {
				
				VentanaInicial ventanaInicial = new VentanaInicial();
				ventanaInicial.setVisible(true); 
				logger.info("This is INFO : Se ha iniciado sesion con usuario: "+nombre);
			}
			
			else {
				JOptionPane.showMessageDialog(this,"Usuario con nombre "+nombre + " NO se ha podido iniciar sesion");
				logger.error("This is ERROR : No se ha podido registrar");
				frmPrincipal objP = new frmPrincipal ();
				objP.setVisible(true);
			
			}
			
			
			break;
			
		case "Registrarse":
			
			frmRegistrarUsuario registrar = new frmRegistrarUsuario();
			registrar.setVisible(true); 
			
			break;
			
					
		case "Salir":
			System.out.println("Cerrando programa...");
			System.exit(0);
			break;
			
		}
	}

	/**
	 * Documentacion de acreditarse()
	 * método que permite al usuario validar sus credenciales para acceder a la aplicacion
	 * @param nombre de usuario y su contraseña
	 * @return exito (true) si se ha podido acreditar bien
	 */
	private boolean acreditarse(String nombre, String pass) {
		
		boolean exito = false;
		String nombreBD="";
		String passBD="";
				
		//String usuario= "Select * from usuarios where nom_usuario='"+nombre+"' ";
		String usuario= "Select * from usuarios where nom_usuario='"+nombre+"' ";
		//enviar la sentencia a la bbdd
		
		System.out.println(usuario);
		
		ResultSet resultado= conexion.getQuery(usuario);
		
		try {
			while(resultado.next()){
				nombreBD = resultado.getString("nom_usuario");
				passBD = resultado.getString("contra");
				this.dispose();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("BD: "+nombreBD + " "+passBD);
		
		
		if ((nombreBD.equals(nombre))&&(passBD.equals(pass))) {
			
			exito = true;
		}
					
		return exito;
		
		
	}
}
