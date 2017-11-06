package cursos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmBorrarCurso extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textFieldID;

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
				//frmMenuCursos objMC= new frmMenuCursos();
				//objMC.setVisible(true);
				this.dispose();				
				break;
				
			case "Aceptar":
				
				this.dispose();			
				break;
		}
		
	}
}
