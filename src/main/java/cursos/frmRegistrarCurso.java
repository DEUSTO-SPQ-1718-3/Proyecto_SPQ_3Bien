package cursos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import bbdd.MyDataAccess;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class frmRegistrarCurso extends JFrame implements ActionListener{
	
	private JTextField textFieldNombre;
	private JTextField textFieldDesc;
	private JTextField textFieldAula;
	private JTextField textFieldHorario;
	MyDataAccess conexion = new MyDataAccess();
	
	public frmRegistrarCurso() {
		

		setBounds(400, 400, 443, 291);
		setTitle("MI ACADEMIA - REGISTRAR CURSO");
		setResizable(false);
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(39, 61, 86, 20);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		getContentPane().setLayout(null);
		
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
		
		JLabel lblNDeAula = new JLabel("N\u00BA de Aula");
		lblNDeAula.setBounds(153, 36, 69, 14);
		getContentPane().add(lblNDeAula);
		
		textFieldAula = new JTextField();
		textFieldAula.setColumns(10);
		textFieldAula.setBounds(153, 61, 46, 20);
		getContentPane().add(textFieldAula);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(358, 11, 69, 23);
		getContentPane().add(btnAtras);
		btnAtras.addActionListener(this);
		
		JButton btnNuevoCurso = new JButton("Nuevo curso");
		btnNuevoCurso.setBounds(153, 228, 116, 23);
		getContentPane().add(btnNuevoCurso);
		btnNuevoCurso.addActionListener(this);
		
		JLabel lblHorario = new JLabel("Horario");
		lblHorario.setBounds(275, 36, 69, 14);
		getContentPane().add(lblHorario);
		
		textFieldHorario = new JTextField();
		textFieldHorario.setColumns(10);
		textFieldHorario.setBounds(275, 61, 101, 32);
		getContentPane().add(textFieldHorario);
		
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
			case "Nuevo curso":
				int idC;//se genera aleatorio, el usuario no puede meter el numero para que no se repita
				idC=(int) (Math.random() * 99999) + 1;
				String nombreC=textFieldNombre.getText();
				String desc=textFieldDesc.getText();
				int numC=Integer.parseInt(textFieldAula.getText());
				String horario=textFieldHorario.getText();
				
				//llamada al metodo que registra
				registrarCurso(idC, nombreC, desc, numC, horario);
				
				break;
	
		}
		
	}

	void registrarCurso(int idC, String nombreC, String desc, int numC, String horario) {
		// TODO Auto-generated method stub
		
		String registrar= "insert into cursos values("+"'"+ idC +"','"+ nombreC +"','"+ desc +"','"+ numC +"','"+ horario +"')";
		//se envia el script SQL a la BBDD y se registra el curso
		conexion.setQuery(registrar);
		
		JOptionPane.showMessageDialog(this,"Curso con ID "+idC + " anyadido CORRECTAMENTE");
		
	}
}
