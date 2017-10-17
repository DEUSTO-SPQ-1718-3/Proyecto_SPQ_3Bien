package cursos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class frmRegistrarCurso extends JFrame implements ActionListener{
	private JTextField textFieldNombre;
	private JTextField textFieldDesc;
	public frmRegistrarCurso() {
		getContentPane().setLayout(null);
		
		setTitle("MI ACADEMIA");
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(465, 11, 59, 23);
		getContentPane().add(btnAtras);
		
		JButton btnDarDeAlta = new JButton("Dar de alta");
		btnDarDeAlta.setBounds(218, 319, 126, 32);
		getContentPane().add(btnDarDeAlta);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(39, 61, 86, 20);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(40, 36, 46, 14);
		getContentPane().add(lblNombre);
		
		textFieldDesc = new JTextField();
		textFieldDesc.setColumns(10);
		textFieldDesc.setBounds(39, 135, 160, 79);
		getContentPane().add(textFieldDesc);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(40, 110, 59, 14);
		getContentPane().add(lblDescripcion);
		btnAtras.addActionListener(this);
	}
	//ficha para rellenar, que sera enviada a la BBDD para almacenar los datos correspondientes

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getActionCommand())
		{
			case "Atras":
				frmMenuCursos objAtras=new frmMenuCursos();
				objAtras.setVisible(true);
				this.dispose();
				break;
			case "Dar de alta":
				//clsGestorCursos objGC= new clsGestorCursos();
				int idC= 1;//lo suyo seria que se generara auto. con el numero correspondiente de las bbdd
				String nombreC=textFieldNombre.getText();
				String desc=textFieldDesc.getText();
				
				//objGC.RegistrarCurso(idC, nombreC, desc);
				//objGC=null;
				break;
	
		}
		
	}
}
