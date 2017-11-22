package cursos;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;

import bbdd.MyDataAccess;
import javax.swing.JTextField;

/**clase que sirve para apuntar a un alumno a un determinado curso
 * debemos introducir el dni del alumno y el id del curso para formalizarlo
 * @author Grupo 3 DBS SS: Procesos software y de calidad 17-18
 *
 */
public class frmApuntarseCurso extends JFrame implements ActionListener{

	private JPanel contentPane;
	MyDataAccess conexion = new MyDataAccess();
	final static Logger logger = Logger.getLogger(frmApuntarseCurso.class);
	private JTextField textFieldID;
	private JTextField textFieldDNI;
	private ResultSet comprobar;
	/**
	 * Create the frame.
	 */
	public frmApuntarseCurso() {
		
		setBounds(100, 100, 356, 178);
		setTitle("MI ACADEMIA - APUNTARSE CURSO ");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(261, 11, 69, 23);
		contentPane.add(btnAtras);
		btnAtras.addActionListener(this);
		
		JLabel lblIDCurso = new JLabel("Indica el ID del curso que quieres apuntarte y tu DNI:");
		lblIDCurso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIDCurso.setBounds(10, 40, 320, 23);
		contentPane.add(lblIDCurso);
		
		JLabel lblIdCurso = new JLabel("ID Curso:");
		lblIdCurso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIdCurso.setBounds(10, 65, 63, 23);
		contentPane.add(lblIdCurso);
		
		JLabel lblIdEstudiante = new JLabel("DNI Estudiante:");
		lblIdEstudiante.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIdEstudiante.setBounds(152, 65, 92, 23);
		contentPane.add(lblIdEstudiante);
		
		JButton btnApuntarse = new JButton("Apuntame");
		btnApuntarse.setBounds(135, 106, 109, 23);
		contentPane.add(btnApuntarse);
		
		textFieldID = new JTextField();
		textFieldID.setBounds(67, 67, 69, 20);
		contentPane.add(textFieldID);
		textFieldID.setColumns(10);
		
		textFieldDNI = new JTextField();
		textFieldDNI.setBounds(243, 67, 87, 20);
		contentPane.add(textFieldDNI);
		textFieldDNI.setColumns(10);
		btnApuntarse.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		switch(e.getActionCommand()){
		
		
			case "Atras":
				logger.trace("This is TRACE : Ventana 'frmApuntarseCurso' se ha destruido");
				this.dispose();				
				break;
				
			case "Apuntame":
				int idC= Integer.parseInt(textFieldID.getText());
				String dni=textFieldDNI.getText();
				if(comprobarExistencia(idC, dni)==true) {
					apuntarmeCurso(idC, dni);
				}
				else {
					logger.error("This is Error : no se ha podido apuntar al curso");
				}
				this.dispose();			
				break;
		}
		
	}
	
	/**metodo que conecta con la bbdd, apunta al estudiante con dni indicado al curso correspondiente
	 * 
	 * @param idC identificador del curso
	 * @param dni identificador del estudiante
	 */
	void apuntarmeCurso(int idC, String dni) {
		String apuntar = "insert into asistencia values ('"+dni+"','"+idC+"')";
		conexion.setQuery(apuntar);
		
		JOptionPane.showMessageDialog(this,"Estudiante con DNI: "+dni+" apuntado al curso de ID "+idC + " CORRECTAMENTE");
	}
	
	/**metodo que comprueba si el dni del estdudiante existe en la bbdd
	 * si existe comprueba que el curso también
	 * 
	 * @param idC
	 * @param dni
	 * @return verdadero si ambos existen, falso si alguno de los dos no existe en bbdd
	 */
	boolean comprobarExistencia(int idC, String dni) {
		comprobar=conexion.getQuery("SELECT * from estudiantes where dni='"+dni+"'");
		String dniE="";
		int idCurso=-1;
		try {
			while(comprobar.next()) {
				dniE=comprobar.getString("dni");
			}
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(dniE.equals(dni)) {
			comprobar=conexion.getQuery("SELECT * from cursos where idC="+idC+"");
			try {
				while(comprobar.next()) {
					idCurso=comprobar.getInt("idC");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(idCurso==idC) {
				return true;
			}
			else {
				JOptionPane.showMessageDialog(this,"El curso no existe.");
				logger.error("This is Error : no se ha podido encontrar el curso");
			}
		}
		else {
			JOptionPane.showMessageDialog(this,"Los datos introducidos del estudiante no son correctos");
			logger.error("This is Error : no se ha podido encontrar el estudiante");
		}
		return false;
	}
	
}