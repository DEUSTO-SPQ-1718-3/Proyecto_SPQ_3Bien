package estudiantes;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;

import bbdd.MyDataAccess;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.util.ArrayList;

/**Clase principal del modulo Estudiantes
 * Menu en el que mostramos las opciones a los usuarios de la aplicacion y le redirigimos a la pantalla que quieran
 * Opciones: Añadir estudiante, modificar, borrar,
 * El propio menu muestra los estudiantes que tenemos en la base de datos
 * 
 * @author Grupo 3 DBS SS: Procesos software y de calidad 17-18
 *
 */
public class frmEstudiantes extends JFrame implements ActionListener{

	/**
	 * 
	 */
	
	ArrayList<Estudiante> listaEstudiantes;
	JTextArea txtEstudiantes;
	JScrollPane scrollPane;
	MyDataAccess conexion;
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
	
	private static final long serialVersionUID = 7046431761927583577L;
	
	final static Logger logger = Logger.getLogger(frmEstudiantes.class);
	
	/**Constructor de Estudiante
	 *  
	 */
	public frmEstudiantes() {
			
		setTitle("MI ACADEMIA");
		
		listaEstudiantes = new ArrayList<Estudiante>();
				
		//BD		
		conexion = new MyDataAccess();
	    	
	    resultado = conexion.getQuery("select * from Estudiantes");
	    logger.info("This is INFO : Query SELECT lanzada");
	    logger.trace("This is TRACE : Query SELECT lanzada");
	    
	    
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(500, 200, 530, 440);
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 5, 400, 400);
		contentPane.add(scrollPane);
		
		completarLista();
			
		JButton btnRefesh = new JButton("REFRESH");
		btnRefesh.setBounds(420, 70, 100, 25);
		btnRefesh.addActionListener(this);
		btnRefesh.setActionCommand("Refresh");
		contentPane.add(btnRefesh);		
		
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
	
	/**Método para mostrar los estudiantes en la base de datos en la pantala 
	 *  
	 */
	void completarLista() {
		// TODO Auto-generated method stub
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
				
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		switch(e.getActionCommand()){
		
		
		case "Modificar":
			 logger.debug("This is INFO : Llamando a ventana de MODIFICADOS");
			 logger.error("This is ALL : Llamada a ventana de MODIFICADOS");
			
			frmModificarEstudiante modif = new frmModificarEstudiante();
			modif.setVisible(true); 
			
			break;
			
		case "Anyadir":
			
			frmRegistrarEstudiante ventanaanyadirEstudiantes = new frmRegistrarEstudiante();
			ventanaanyadirEstudiantes.setVisible(true); 
			
			break;
			
		case "Eliminar":
			
			frmBorrarEstudiante borrarEst = new frmBorrarEstudiante();
			borrarEst.setVisible(true); 
			
			break;
			
					
		case "Salir":
			System.out.println("Cerrando programa...");
			System.exit(0);
			break;
			
		case "Refresh":
			this.dispose();
			frmEstudiantes nuevo = new frmEstudiantes();
			nuevo.setVisible(true); 
			
		}
	}
}
