package cursos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import bbdd.MyDataAccess;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

/**Si el ID que hemos introducido en frmModificarCurso esta dado de alta, podremos modificar los datos a excepcion de su ID
 * \class frmModificarDatos
 * @package cursos
 * @author Grupo 3 DBS SS: Procesos software y de calidad 17-18
 *
 */
public class frmModificarDatosCurso extends JFrame implements ActionListener{
	
	private JTextField textFieldidC;
	private JTextField textFieldNombreC;
	private JTextField textFieldDesc;
	private JTextField textFieldNumC;
	private JTextField textFieldHorario;
	
	MyDataAccess conexion = new MyDataAccess();
	final static Logger logger = Logger.getLogger(frmModificarDatosCurso.class);
	
	
	public frmModificarDatosCurso (clsCurso curso) {
		getContentPane().setLayout(null);
		
		setBounds(500, 200, 530, 315);
		this.setResizable(false);
		
		setTitle("MI ACADEMIA");
		
		JLabel lblidC = new JLabel("ID Curso");
		lblidC.setBounds(40, 20, 60, 25);
		getContentPane().add(lblidC);
		
		textFieldidC = new JTextField(String.valueOf(curso.getIdC()));
		textFieldidC.setBounds(150, 20, 86, 25);
		getContentPane().add(textFieldidC);
		textFieldidC.setColumns(10);	
		textFieldidC.setEditable(false);
		
		JLabel lblNombreC = new JLabel("Nombre");
		lblNombreC.setBounds(40, 60, 60, 25);
		getContentPane().add(lblNombreC);
		
		textFieldNombreC = new JTextField(curso.getNombreC());
		textFieldNombreC.setBounds(150, 60, 86, 25);
		getContentPane().add(textFieldNombreC);
		textFieldNombreC.setColumns(10);
		
		JLabel lblDescrip = new JLabel("Descripci\u00F3n");
		lblDescrip.setBounds(40, 118, 72, 25);
		getContentPane().add(lblDescrip);
				
		textFieldDesc = new JTextField(curso.getDescripcion());
		textFieldDesc.setColumns(10);
		textFieldDesc.setBounds(150, 100, 160, 60);
		getContentPane().add(textFieldDesc);	
		
		JLabel lblNumC = new JLabel("N\u00BA Clase");
		lblNumC.setBounds(40, 171, 60, 25);
		getContentPane().add(lblNumC);
						
		textFieldNumC = new JTextField(String.valueOf(curso.getNumClase()));
		textFieldNumC.setColumns(10);
		textFieldNumC.setBounds(150, 171, 160, 25);
		getContentPane().add(textFieldNumC);
		
		JLabel lblHorario = new JLabel("Horario");
		lblHorario.setBounds(40, 221, 96, 25);
		getContentPane().add(lblHorario);
		
		
		textFieldHorario = new JTextField(curso.getHorario());
		textFieldHorario.setColumns(10);
		textFieldHorario.setBounds(150, 221, 160, 25);
		getContentPane().add(textFieldHorario);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(350, 103,120, 40);
		getContentPane().add(btnAtras);
		btnAtras.addActionListener(this);
		
		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.setBounds(350, 174, 120, 40);
		getContentPane().add(btnModificar);
		btnModificar.addActionListener(this);
	}
	//ficha para rellenar, que sera enviada a la BBDD para almacenar los datos correspondientes

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getActionCommand())
		{
			case "Atras":
				frmMenuCursos objAtras=new frmMenuCursos();
				logger.trace("This is TRACE : Ventana 'frmModificarDatosCurso' se ha destruido");
				objAtras.setVisible(true);
				this.dispose();
				break;
				
			case "MODIFICAR":
				
				int idC;
				idC=Integer.parseInt(textFieldidC.getText());
				String nombreC=textFieldNombreC.getText();
				String descrip=textFieldDesc.getText();
				int numC=Integer.parseInt(textFieldNumC.getText());
				String horario=textFieldHorario.getText();
				
				modificarCurso(idC, nombreC, descrip, numC, horario);
				
				this.dispose();				
				break;
	
		}
		
	}
	
	/**Nuevos valores para el curso que queremos modificar
	 * 
	 * @param idC no tiene opcion de cambiar el id, no es editable
	 * @param nombreC nombre del curso
	 * @param descrip descripcion breve del curso
	 * @param numC numero de clase en la que se imparte
	 * @param horario del curso
	 */
	private void modificarCurso(int idC, String nombreC, String descrip, int numC, String horario) {
		// TODO Auto-generated method stub
		logger.trace("This is TRACE : Se han recogido los datos introducidos para modificar");
		
		String registrar= "update cursos set idC='"+ idC +"',nombreC='"+ nombreC +"',descripcion='"+ descrip +"', numClase='"+ numC +"', horario='"+ horario +"' where idC='"+idC+"'";
		//se envia el script SQL a la BBDD y se registra el curso			
		conexion.setQuery(registrar);
		JOptionPane.showMessageDialog(this,"Curso con ID: "+idC + " modificado CORRECTAMENTE");
	}
}