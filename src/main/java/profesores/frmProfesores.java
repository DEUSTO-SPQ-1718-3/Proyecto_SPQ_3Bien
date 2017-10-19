package profesores;

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



public class frmProfesores extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public frmProfesores() {
	
		
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
		txtHabitacionesRegistradas.setText("- PROFESORES EN LA ACADEMIA - ");
		txtHabitacionesRegistradas.setColumns(50);
		txtHabitacionesRegistradas.setEditable(false);
						
		
		ArrayList<Profesor> listaProfesores = new ArrayList<Profesor>();

			listaProfesores.add(new Profesor("Javier", "Cerro", "634312434", "jc@gmail.com", "Kondeko aldapa 4, Tolosa", "Ingenieria Informatica"));
			listaProfesores.add(new Profesor("Jon", "Insausti", "655788451", "ji@gmail.com", "31 de Agosto 14, Donosti", "ADE"));
			listaProfesores.add(new Profesor("Joana", "Perez", "666544534", "jp@gmail.com", "Hondarribia Kalea 8, Lasarte", "Economicas"));
			listaProfesores.add(new Profesor("Edurne", "Etxezabal", "677945345", "ee@gmail.com", "Ibai gain kalea 2, Irun", "Ingenieria Industrial"));
			
					
		txtHabitacionesRegistradas.append(listaProfesores.toString()) ;						
			
					
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

			frmRegistrarProfesor ventanaanyadirProfesor = new frmRegistrarProfesor();
			ventanaanyadirProfesor.setVisible(true); 
			
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
