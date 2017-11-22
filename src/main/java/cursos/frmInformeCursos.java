package cursos;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;

import bbdd.MyDataAccess;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/** frame que visualiza los cursos y sus asistencias 
 * ordenados por los cursos con mas alumnos a menos
 * 
 * @author Grupo 3 DBS SS: Procesos software y de calidad 17-18
 *
 */
public class frmInformeCursos extends JFrame implements ActionListener{

	private JPanel contentPane;
	ArrayList<clsAsistencia> listAsistencia;
	MyDataAccess conexion = new MyDataAccess();
	JScrollPane scrollPane;
	JTextArea txtAsistencia;
	 ResultSet resultado;
	 String dni; //del estudiante
	 int id; //del curso
	
	final static Logger logger = Logger.getLogger(frmRegistrarCurso.class);
	/**
	 * Create the frame.
	 */
	public frmInformeCursos() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("MI ACADEMIA - INFORMES");
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 0, 336, 261);
		contentPane.add(scrollPane);
		
		listAsistencia = new ArrayList<clsAsistencia>();
		//pido una lista ordenada de los cursos por cantidad de asistentes
		resultado=conexion.getQuery("select COUNT(dniE), idC from Asistencia group by idC order by COUNT(dniE) desc");
		completarLista();
				
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(358, 11, 76, 23);
		getContentPane().add(btnAtras);
		btnAtras.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getActionCommand())
		{
			case "Atras":
				frmMenuCursos objAtras=new frmMenuCursos();
				logger.trace("This is TRACE : Ventana 'frmInformeCursos' se ha destruido");
				objAtras.setVisible(true);
				this.dispose();
				break;
		}
	}
	
	void completarLista() {
		
		txtAsistencia = new JTextArea();
		txtAsistencia.setEditable(false);
		txtAsistencia.setColumns(50);
		
		
		try {
		      while(resultado.next()){
		   		    	  
		    	  dni = resultado.getString("COUNT(dniE)");
			      id = resultado.getInt("idC");
			      
			      listAsistencia.add(new clsAsistencia(id, dni));
		     		      
		      }
		      
		    }catch (SQLException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		      
		    }			
			
		 txtAsistencia.setText("ASISTENCIA A CURSOS\n ");
		 txtAsistencia.append(listAsistencia.toString());	
		 
		scrollPane.setViewportView(txtAsistencia);
		
	}
}
