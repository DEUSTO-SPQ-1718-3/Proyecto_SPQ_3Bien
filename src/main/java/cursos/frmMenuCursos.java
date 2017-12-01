package cursos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import bbdd.MyDataAccess;
import main.VentanaInicial;

import javax.swing.JButton;
import javax.swing.AbstractAction;
import javax.swing.Action;

import org.apache.log4j.Logger;

/**Clase principal del modulo Cursos
 * Menu en el que mostramos las opciones a los usuarios de la aplicacion y le redirigimos a la pantalla que quieran
 * Opciones: AÒadir curso, modificar, borrar, ver informes asistencia, apuntar un estudiante al curso
 * El propio menu muestra los cursos que tenemos en la base de datos
 * @package cursos
 * @author Grupo 3 DBS SS: Procesos software y de calidad 17-18
 *
 */
public class frmMenuCursos extends JFrame implements ActionListener{
	private static final long serialVersionUID = 7046431761927583577L;
	private ArrayList<clsCurso> listaCursos = new ArrayList<clsCurso>();
	MyDataAccess conexion = new MyDataAccess();
	final static Logger logger = Logger.getLogger(frmMenuCursos.class);//para los mensajes de log4java
	ResultSet visualizar;
	int idC;
	String nombreC;
	String descripcion;
	int numClase;
	String horario;
	
	public frmMenuCursos() {
	
		
		setBounds(400, 400, 430, 230); //Tama√±o
		
		setTitle("MI ACADEMIA");	
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 350, 530, 440);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 5, 400, 400);
		contentPane.add(scrollPane);
		
		JTextArea txtCursosRegistrados = new JTextArea();
		txtCursosRegistrados.setEditable(false);
		scrollPane.setViewportView(txtCursosRegistrados);
		//txtHabitacionesRegistradas.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtCursosRegistrados.setText("- CURSOS REGISTRADOS - \n");
		txtCursosRegistrados.setColumns(50);
		txtCursosRegistrados.setEditable(false);
		
		//RELLENAR LA LISTA CON LOS DATOS DE LA BBDD
		visualizar = conexion.getQuery("SELECT * from cursos");
		cargarCursos();		    
				
		txtCursosRegistrados.append(listaCursos.toString());		
		
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
		btnSalir.setBounds(420, 310, 100, 25);
		btnSalir.addActionListener(this);
		btnSalir.setActionCommand("Salir");
		contentPane.add(btnSalir);
		btnSalir.addActionListener(this);
		
		JButton btnInformes = new JButton("INFORMES");
		btnInformes.setActionCommand("Informes");
		btnInformes.setBounds(420, 268, 100, 25);
		contentPane.add(btnInformes);
		btnInformes.addActionListener(this);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setActionCommand("Atras");
		btnAtras.setBounds(443, 7, 71, 23);
		contentPane.add(btnAtras);
		btnAtras.addActionListener(this);
		
		JButton btnApuntarse = new JButton("APUNTARSE");
		btnApuntarse.setActionCommand("Apuntarse");
		btnApuntarse.setBounds(415, 60, 105, 32);
		contentPane.add(btnApuntarse);
		btnApuntarse.addActionListener(this);
				
			
		this.setResizable(false);		
			
	}
	
	
	public void cargarCursos() {
		// TODO Auto-generated method stub
				
		try {
		    while(visualizar.next()){
		    idC= visualizar.getInt("idC");
		    nombreC = visualizar.getString("nombreC");
		    descripcion = visualizar.getString("descripcion");
		    numClase = visualizar.getInt("numClase");
		    horario = visualizar.getString("horario");
		      
			listaCursos.add(new clsCurso(idC, nombreC, descripcion, numClase, horario));	
		 }
		 }catch (SQLException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		 }
		
	}


	public void actionPerformed(ActionEvent e) {
		
		
		switch(e.getActionCommand()){
		
		
		case "Modificar":
			frmModificarCurso objMod= new frmModificarCurso();
			objMod.setVisible(true);
			this.dispose();			
			break;
			
		case "Anyadir":
			frmRegistrarCurso objAlta=new frmRegistrarCurso();
			objAlta.setVisible(true);
			this.dispose();			
			break;
			
		case "Eliminar":
			frmBorrarCurso objB=new frmBorrarCurso();
			logger.info("This is INFO : Se va a abrir la ventana para hacer el BORRADO");
			objB.setVisible(true);			
			break;
			
		case "Informes":
			frmInformeCursos objI =new frmInformeCursos();
			logger.info("This is INFO : Se va a abrir la ventana para visualizar los INFORMES");
			objI.setVisible(true);
			this.dispose();
			//
					
			break;
					
		case "Atras":
			VentanaInicial objV= new VentanaInicial();
			logger.trace("This is TRACE : Ventana 'frmMenuCursos' se ha destruido");
			objV.setVisible(true);
			this.dispose();
			break;
			
		case "Apuntarse":
			frmApuntarseCurso objA= new frmApuntarseCurso();
			logger.trace("This is TRACE : Ventana 'frmMenuCursos' se ha ocultado");
			objA.setVisible(true);
			break;
			
		case "SALIR":
			System.out.println("Cerrando programa...");
			logger.trace("This is TRACE : ACADEMIA se ha destruido");
			System.exit(0);
			break;
			
		}
	}
}