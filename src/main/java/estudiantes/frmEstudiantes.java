import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.util.ArrayList;


public class frmEstudiantes extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7046431761927583577L;
	
	public frmEstudiantes() {
	
		
		setBounds(400, 400, 430, 230); //Tamaño
		
		setTitle("MI ACADEMIA");
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 350, 530, 440);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 5, 400, 400);
		contentPane.add(scrollPane);
		
		JTextArea txtHabitacionesRegistradas = new JTextArea();
		txtHabitacionesRegistradas.setEditable(false);
		scrollPane.setViewportView(txtHabitacionesRegistradas);
		//txtHabitacionesRegistradas.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtHabitacionesRegistradas.setText("- ESTUDIANTES MATRICULADOS - ");
		txtHabitacionesRegistradas.setColumns(50);
		txtHabitacionesRegistradas.setEditable(false);
						
		
		ArrayList<Estudiante> listaEstudiantes = new ArrayList<Estudiante>();

			listaEstudiantes.add(new Estudiante("Xabi", "Perez", "9943434", "xp@gmail.com", "va al colegio x y cslcjsaldjsd"));
			listaEstudiantes.add(new Estudiante("Jon", "Gonzalez", "945345", "jg@gmail.com", "va al colegio x y dfgdfgdfg"));
			listaEstudiantes.add(new Estudiante("Ainhoa", "Garcia", "99544534", "ag@gmail.com", "va al colegio x y sdfaldfgdfgfdfdjsd"));
			listaEstudiantes.add(new Estudiante("Amaia", "Fermandez", "945345", "af@gmail.com", "va al colegio x y sdfsdfretrt"));
			
					
		txtHabitacionesRegistradas.append(listaEstudiantes.toString()) ;						
			
					
		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.setBounds(420, 120, 100, 25);
		btnModificar.addActionListener(this);
		btnModificar.setActionCommand("Modificar");
		contentPane.add(btnModificar);
		
		JButton btnAnyadir = new JButton("ANYADIR");
		btnAnyadir.setBounds(420, 170, 100, 25);
		btnAnyadir.addActionListener(this);
		btnAnyadir.setActionCommand("Anyadir");
		contentPane.add(btnAnyadir);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(420, 220, 100, 25);
		btnEliminar.addActionListener(this);
		btnEliminar.setActionCommand("Eliminar");
		contentPane.add(btnEliminar);		
		
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.setBounds(420, 270, 100, 25);
		btnSalir.addActionListener(this);
		btnSalir.setActionCommand("Salir");
		contentPane.add(btnSalir);
			
		this.setResizable(false);		
			
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		switch(e.getActionCommand()){
		
		
		case "Modificar":
			
			//
			
			break;
			
		case "Anyadir":
			
			//
			
			break;
			
		case "Eliminar":
			
			//
			
			break;
			
					
		case "Salir":
			System.out.println("Cerrando programa...");
			System.exit(0);
			break;
			
		}
	}
}
