package Cuotas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bbdd.MyDataAccess;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;



public class frmEnviarCuota extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnNewButton;
	
	String nombre;
	String apellido;
	String email;
	int horas;
	int precio;
	String fecha;
	
	ArrayList<Cuota> listaCuotas = new ArrayList<Cuota>(); 


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmBorrarCuota frame = new frmBorrarCuota();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmEnviarCuota() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 278, 168);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Selecciona el id de la cuota que quieras enviar");
		lblNewLabel.setBounds(10, 11, 254, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(92, 56, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblId = new JLabel("id");
		lblId.setBounds(74, 59, 18, 14);
		contentPane.add(lblId);
		
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		btnNewButton = new JButton("ENVIAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int id = Integer.parseInt(textField.getText());
				
				//BD
				
				MyDataAccess conexion = new MyDataAccess();
				ResultSet resultado;

			    //
				
				String query = "select estudiantes.email as email, estudiantes.nombre as nombre, estudiantes.apellido as apellido, cuotas.precio as precio, cuotas.horas as horas, cuotas.fecha as fecha from estudiantes inner join cuotas on cuotas.nombre = estudiantes.nombre where cuotas.id = '" + id + "'";
				resultado = conexion.getQuery(query);
				
				try {
				      while(resultado.next()){
				      nombre = resultado.getString("nombre");
				      apellido = resultado.getString("apellido");
				      email = resultado.getString("email");
				      horas = resultado.getInt("horas");
				      precio = resultado.getInt("precio");
				      fecha = resultado.getString("fecha");
				      
				      }
				    }catch (SQLException e) {
				      // TODO Auto-generated catch block
				      e.printStackTrace();
				    }

				enviar_Email enviarEmail = new enviar_Email();
				enviarEmail.mandarCorreo(nombre, apellido, email, horas, precio, fecha);
				
			}
		});
		
		
		
		btnNewButton.setBounds(92, 88, 86, 20);
		contentPane.add(btnNewButton);
	}
}
