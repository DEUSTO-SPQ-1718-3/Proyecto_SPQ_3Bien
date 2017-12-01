package estudiantes;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;

import bbdd.MyDataAccess;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**frame si con el metodo para borrar un estudiante, le pasaremos su dni por pantalla y si coincide con alguno de las bbdd lo borrara
 * sino saldra un mensaje diciendo que no existe esa fila
 * \class frmBorrarEstudiante
 * @package estudiantes
 * @author Grupo 3 DBS SS: Procesos software y de calidad 17-18
 *
 */

public class frmBorrarEstudiante extends JFrame implements ActionListener{

	final static Logger logger = Logger.getLogger(frmBorrarEstudiante.class);
	
	private JPanel contentPane;
	private JTextField textFieldID;
	MyDataAccess conexion = new MyDataAccess();
	
	/**
	 * Construccion ventana
	 */
	public frmBorrarEstudiante() {
		setTitle("MI ACADEMIA - BORRAR ESTUDIANTE");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(500, 200, 530, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIDCurso = new JLabel("Indica el DNI del ESTUDIANTE que quieres borrar");
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
				logger.trace("This is TRACE : Ventana 'frmBorrarEstudiante' se ha destruido");
				this.dispose();				
				break;
				
			case "Aceptar":
				String borrardni=textFieldID.getText();
				borrarEstudiante(borrardni);
								
				break;
		}
		
	}
	/**metodo para borrar el estudiante, el string lo indica el usuario de la aplicacion por pantalla
	 * 
	 * @param borrarEstudiante le pasamos el dni del estudiante (string)
	 */
	public void borrarEstudiante(String borrardni) {
		// TODO Auto-generated method stub
		
		String borrar= "Delete from estudiantes where dni='"+borrardni+"'";
		
		conexion.setQuery(borrar);
		logger.info("This is INFO : Se ha lanzado Query de Delete");
		
		this.dispose();
		JOptionPane.showMessageDialog(this,"Estudiante con DNI "+borrardni + " borrado CORRECTAMENTE");
				
	}
}
