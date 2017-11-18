package cursos;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import org.apache.log4j.Logger;

public class frmBorrarCurso extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textFieldID;
	MyDataAccess conexion = new MyDataAccess();
	final static Logger logger = Logger.getLogger(frmBorrarCurso.class);
	
	/**
	 * Create the frame.
	 */
	public frmBorrarCurso() {
		setTitle("MI ACADEMIA - BORRAR CURSO");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 356, 178);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIDCurso = new JLabel("Indica el ID del curso que quieres borrar");
		lblIDCurso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIDCurso.setBounds(10, 26, 247, 38);
		contentPane.add(lblIDCurso);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(261, 11, 69, 23);
		contentPane.add(btnAtras);
		btnAtras.addActionListener(this);
		
		textFieldID = new JTextField();
		textFieldID.setBounds(215, 67, 42, 20);
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
				logger.trace("This is TRACE : Ventana 'frmBorrarCurso' se ha destruido");
				this.dispose();				
				break;
				
			case "Aceptar":
				int BorrarID=Integer.parseInt(textFieldID.getText());
				borrarCurso(BorrarID);
				this.dispose();			
				break;
		}
		
	}

	void borrarCurso(int borrarID) {
		// TODO Auto-generated method stub
		String borrar= "Delete from cursos where idC='"+borrarID+"' ";
		//enviar la sentencia a la bbdd
		conexion.setQuery(borrar);
		logger.info("This is INFO : Se ha borrado el curso con el id introducido");
		JOptionPane.showMessageDialog(this,"Curso de ID "+borrarID+ " borrado CORRECTAMENTE");
	}
}
