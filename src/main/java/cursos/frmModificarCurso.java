package cursos;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bbdd.MyDataAccess;

import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import org.apache.log4j.Logger;

/**Frame que sirve para que el usuario nos indique el curso que quiere modificar
 * Nos introduce el ID que quiera, y lanzamos desde aqui la consulta a la BBDD, si existe, nos llevara a otra ventana que podemos modificar datos
 * @package cursos
 * @author Grupo 3 DBS SS: Procesos software y de calidad 17-18
 *
 */
public class frmModificarCurso extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textFieldID;
	MyDataAccess conexion = new MyDataAccess();
	final static Logger logger = Logger.getLogger(frmModificarCurso.class);
	
	int idC;
    String nombreC;
    String descrip;
    int numClase;
    String horario;
 	
	
	/**
	 * Create the frame.
	 */
	public frmModificarCurso() {
		setTitle("MI ACADEMIA - MODIFICAR CURSO");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(500, 200, 530, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIDCurso = new JLabel("Indica el ID del CURSO que quieres MODIFICAR");
		lblIDCurso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIDCurso.setBounds(10, 26, 400, 38);
		contentPane.add(lblIDCurso);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(270, 106, 80, 23);
		contentPane.add(btnAtras);
		btnAtras.addActionListener(this);
		
		textFieldID = new JTextField();
		textFieldID.setBounds(215, 67, 80, 20);
		contentPane.add(textFieldID);
		textFieldID.setColumns(10);
		
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
				logger.trace("This is TRACE : Ventana 'frmModificarCurso' se ha destruido");
				this.dispose();				
				break;
				
			case "Aceptar":
				recogerInformacion();
												
				break;
		}
		
	}
	
	/**
	 * el curso que haya especificado el usuario introduciendo el ID del mismo, se lanza la consulta a la BBDD
	 * mostrara el curso indicado si existe
	 */
	private void recogerInformacion() {
		// TODO Auto-generated method stub
		
		String modifIDC=textFieldID.getText();
		String modificar= "Select * from cursos where idC='"+modifIDC+"' ";
		//enviar la sentencia a la bbdd
		ResultSet resultado= conexion.getQuery(modificar);
		
		try {
			while(resultado.next()){
			    	  
				  idC = resultado.getInt("idC");
			      nombreC = resultado.getString("nombreC");
			      descrip = resultado.getString("descripcion");
			      numClase = resultado.getInt("numClase");
			      horario = resultado.getString("horario");
			     
			      clsCurso curso = new clsCurso(idC, nombreC, descrip, numClase, horario);
			      
			      frmModificarDatosCurso modificardatos=new frmModificarDatosCurso(curso);
			      modificardatos.setVisible(true);
			      
			      this.dispose();
			      
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}