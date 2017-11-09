package profesores;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import Cuotas.Cuota;
import bbdd.MyDataAccess;

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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import main.VentanaInicial;
import main.frmPrincipal;
import cursos.frmRegistrarCurso;

import java.util.ArrayList;



public class frmProfesores extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public frmProfesores() {
	
		
		setBounds(400, 400, 430, 230); //Tamaño
		
		setTitle("MI ACADEMIA");
		
		ArrayList<Profesor> listaProfesores = new ArrayList<Profesor>(); 
		
		//BD
		
		MyDataAccess conexion = new MyDataAccess();
			    ResultSet resultado;
			    String nombre;
			    String apellido;
			    String telefono;
			    String email;
			    String direccion;
			    String estudios;
			    
			    resultado = conexion.getQuery("select * from profesores");
		//
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 350, 530, 440);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 5, 400, 400);
		contentPane.add(scrollPane);
		
		JTextArea txtHabitacionesRegistradas = new JTextArea();
		txtHabitacionesRegistradas.setEditable(false);
		scrollPane.setViewportView(txtHabitacionesRegistradas);
		//txtHabitacionesRegistradas.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtHabitacionesRegistradas.setText("- PROFESORES EN LA ACADEMIA - ");
		txtHabitacionesRegistradas.setColumns(50);
		txtHabitacionesRegistradas.setEditable(false);					
		
		 try {
		      while(resultado.next()){
		      nombre = resultado.getString("nombre");
		      apellido = resultado.getString("apellido");
		      telefono = resultado.getString("telefono");
		      email = resultado.getString("email");
		      direccion = resultado.getString("direccion");
		      estudios = resultado.getString("estudios");
		      
			listaProfesores.add(new Profesor(nombre, apellido, telefono, email, direccion, estudios));	
		      }
		    }catch (SQLException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    }			
			
					
		txtHabitacionesRegistradas.append(listaProfesores.toString()) ;						
			
					
		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.setBounds(420, 120, 100, 25);
		btnModificar.addActionListener(this);
		btnModificar.setActionCommand("Modificar");
		contentPane.add(btnModificar);
		
		JButton btnAnyadir = new JButton("ANYADIR");
		btnAnyadir.setBounds(420, 170, 100, 25);
		btnAnyadir.addActionListener(this);
		btnAnyadir.setActionCommand("Anyadir");
		contentPane.add(btnAnyadir);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(420, 220, 100, 25);
		btnEliminar.addActionListener(this);
		btnEliminar.setActionCommand("Eliminar");
		contentPane.add(btnEliminar);		
		
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.setBounds(420, 270, 100, 25);
		btnSalir.addActionListener(this);
		btnSalir.setActionCommand("Salir");
		contentPane.add(btnSalir);
			
		this.setResizable(false);		
			
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		switch(e.getActionCommand()){
		
		
		case "Modificar":
			
			frmModificarProfesor modifProf = new frmModificarProfesor();
			modifProf.setVisible(true); 
			break;
			
		case "Anyadir":
			
			//
			
			frmRegistrarProfesor ventanaanyadirProfesor = new frmRegistrarProfesor();
			ventanaanyadirProfesor.setVisible(true); 
			this.dispose();	
			break;
			
	
			
		case "Eliminar":
			
			frmBorrarProfesor borrarProf = new frmBorrarProfesor();
			borrarProf.setVisible(true);
			this.dispose();
			
			break;
			
					
		case "Salir":
			VentanaInicial menu = new VentanaInicial();
			menu.setVisible(true);
			//System.out.println("Cerrando programa...");
			//System.exit(0);
			break;
			
		}
	}
}
