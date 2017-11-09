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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


//en esta clase se recogen todos los metodos, atributos y recursos necesarios para poder borrar un profesor ya existente en la BD de la Academia

public class frmBorrarProfesor extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textFieldNombre;
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
		
		JLabel lblNombreProf = new JLabel("Indica el nombre del profesor que quieres borrar");
		lblNombreProf.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNombreProf.setBounds(10, 26, 400, 38);
		contentPane.add(lblNombreProf);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(270, 106, 80, 23);
		contentPane.add(btnAtras);
		btnAtras.addActionListener(this);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(215, 67, 80, 20);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
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
				break;
				
			case "Aceptar":
				String nombre=textFieldNombre.getText();
				borrarProfesor(nombre);
				
				
				break;
		}
		
	}
	
	
	void borrarProfesor(String nombre) {
		// TODO Auto-generated method stub
		
		String borrar= "Delete from profesores where nombre='"+nombre+"' ";
		//enviar la sentencia para borrar el profesor indicado mediante el nombre de la BD
		conexion.setQuery(borrar);
		
		this.dispose();
		JOptionPane.showMessageDialog(this,"El/la profesor/a "+nombre + " ha sido borrado/a correctamente");
				
	}
}