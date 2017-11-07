package estudiantes;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
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
import java.util.ArrayList;


public class frmEstudiantes extends JFrame implements ActionListener{

	/**
	 * 
	 */
	
	ArrayList<Estudiante> listaEstudiantes;
	JTextArea txtEstudiantes;
	
	private static final long serialVersionUID = 7046431761927583577L;
	
	public frmEstudiantes() {
			
		setTitle("MI ACADEMIA");
		
		listaEstudiantes = new ArrayList<Estudiante>();
				
		//BD		
		MyDataAccess conexion = new MyDataAccess();
	    ResultSet resultado;
	    String dni;
	    String nombre;
	    String apellido;
	    String telefono;
	    String email;
	    String colegio;
	    String direccion;
	    String nombre_contacto;
	    String telf_contacto;	
		
	    resultado = conexion.getQuery("select * from Estudiantes");
		   	    	    
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(500, 200, 530, 440);
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 5, 400, 400);
		contentPane.add(scrollPane);
		
		txtEstudiantes = new JTextArea();
		txtEstudiantes.setEditable(false);
		txtEstudiantes.setColumns(50);
		
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
		     
			      listaEstudiantes.add(new Estudiante(dni, nombre, apellido, telefono, email,colegio, direccion, nombre_contacto, telf_contacto));	
		     		      
		      }
		      
		    }catch (SQLException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		      
		    }			
			
		 txtEstudiantes.setText("----ESTUDIANTES MATRICULADOS ----\n ");
		 txtEstudiantes.append(listaEstudiantes.toString());	
		 
		scrollPane.setViewportView(txtEstudiantes);
		
									
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
			
			//
			
			break;
			
		case "Anyadir":
			
			frmRegistrarEstudiante ventanaanyadirEstudiantes = new frmRegistrarEstudiante();
			ventanaanyadirEstudiantes.setVisible(true); 
			
			break;
			
		case "Eliminar":
			
			//
			
			break;
			
					
		case "Salir":
			System.out.println("Cerrando programa...");
			System.exit(0);
			break;
			
		}
	}
}
