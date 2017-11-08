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

public class frmBorrarEstudiante extends JFrame implements ActionListener{

	final static Logger logger = Logger.getLogger(frmBorrarEstudiante.class);
	
	private JPanel contentPane;
	private JTextField textFieldID;
	MyDataAccess conexion = new MyDataAccess();
	
	/**
	 * Create the frame.
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

	void borrarEstudiante(String borrardni) {
		// TODO Auto-generated method stub
		
		String borrar= "Delete from estudiantes where dni='"+borrardni+"' ";
		
		conexion.setQuery(borrar);
		logger.info("This is INFO : Se ha lanzado Query de Delete");
		
		this.dispose();
		JOptionPane.showMessageDialog(this,"Estudiante con DNI "+borrardni + " borrado CORRECTAMENTE");
				
	}
}
