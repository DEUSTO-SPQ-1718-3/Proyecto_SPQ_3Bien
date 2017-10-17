import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaInicial extends JFrame {

	private JPanel contentPane;

	public VentanaInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 350, 530, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.setResizable(false);
		
		JButton btnNewButton = new JButton("PROFESORES");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//inicializa ventana PROFESORES
				
				
			}
		});
		btnNewButton.setBounds(75, 47, 153, 91);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CURSOS");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				//inicializa ventana CURSOS
				
				
			}
		});
		btnNewButton_1.setBounds(294, 47, 153, 91);
		contentPane.add(btnNewButton_1);
		
		JButton btnCuotas = new JButton("CUOTAS");
		btnCuotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//inicializa ventana CUOTAS
				
			}
		});
		btnCuotas.setBounds(75, 176, 153, 91);
		contentPane.add(btnCuotas);
		
		JButton btnAlumnos = new JButton("ALUMNOS");
		btnAlumnos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//inicializa ventana ALUMNOS
				
				
			}
		});
		btnAlumnos.setBounds(294, 176, 153, 91);
		contentPane.add(btnAlumnos);
		
		JButton btnUsuarios = new JButton("Usuarios");
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					//inicializa ventana USUARIOS
				
				
			}
		});
		btnUsuarios.setBounds(100, 305, 100, 50);
		contentPane.add(btnUsuarios);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					System.out.println("Cerrando programa...");
					System.exit(0);			
				
			}
		});
		btnSalir.setBounds(320, 305, 100, 50);
		contentPane.add(btnSalir);
	}
}
