package profesores;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bbdd.MyDataAccess;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

import estudiantes.frmBorrarEstudiante;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**en esta clase se recogen todos los metodos, atributos y recursos necesarios
 * para poder borrar un profesor ya existente en la BD de la Academia
 * \class frmBorrarProfesor
 * @package profesores
 * @author Grupo 3 DBS SS: Procesos software y de calidad 17-18
 *
 */
//en esta clase se recogen todos los metodos, atributos y recursos necesarios para poder borrar un profesor ya existente en la BD de la Academia

public class frmBorrarProfesor extends JFrame implements ActionListener{

	final static Logger logger = Logger.getLogger(frmBorrarProfesor.class);
	
	private JPanel contentPane;
	private JTextField textFieldDni;
	MyDataAccess conexion = new MyDataAccess();
	
	
	/**
	 * Create the frame.
	 */
	public frmBorrarProfesor() {
		setTitle("MI ACADEMIA - Borrar profesor");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(500, 200, 530, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDniProf = new JLabel("Indica el dni del profesor que quieres borrar");
		lblDniProf.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDniProf.setBounds(10, 26, 400, 38);
		contentPane.add(lblDniProf);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(270, 106, 80, 23);
		contentPane.add(btnAtras);
		btnAtras.addActionListener(this);
		
		textFieldDni = new JTextField();
		textFieldDni.setBounds(215, 67, 80, 20);
		contentPane.add(textFieldDni);
		textFieldDni.setColumns(10);
		
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
				this.dispose();	
				logger.trace("This is TRACE : Se ha destruido la ventana de borrar profesor");
				break;
			
				
			case "Aceptar":
				String dni=textFieldDni.getText();
				borrarProfesor(dni);
					
				break;
		}
		
	}
	
	/**
	 * Se borran de la BD los datos correspondientes al dni del profesor que se pasa por parametro
	 * @param dni
	 */
	
	public void borrarProfesor(String dni) {
		// TODO Auto-generated method stub
		
		String borrar= "Delete from profesores where dni='"+dni+"' ";
		//enviar la sentencia para borrar el profesor indicado mediante el nombre de la BD
		conexion.setQuery(borrar);
		
		logger.info("This is INFO : Se ha eliminado un profesor de la base de datos");
		
		this.dispose();
		JOptionPane.showMessageDialog(this,"El/la profesor/a con dni "+dni + " ha sido borrado/a correctamente");
				
	}
}