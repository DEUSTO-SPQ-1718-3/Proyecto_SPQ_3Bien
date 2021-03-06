package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Cuotas.frmCuotas;
import cursos.frmMenuCursos;
import estudiantes.frmEstudiantes;
import cursos.frmRegistrarCurso;
import estudiantes.frmEstudiantes;
import profesores.frmProfesores;
import usuarios.frmUsuarios;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**Clase de la ventana de menu del programa
 * \class VentanaInicial
 * @package main
 * @author Grupo 3 DBS SS: Procesos software y de calidad 17-18
 *
 */
public class VentanaInicial extends JFrame {

	private JPanel contentPane;

	/**Constructor
	 * 
	 */
	
	public VentanaInicial() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(500, 200, 530, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.setResizable(false);
		
		JButton btnNewButton = new JButton("PROFESORES");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frmProfesores objP=new frmProfesores();
				objP.setVisible(true);
				//inicializa ventana PROFESORES
				
				
			}
		});
		btnNewButton.setBounds(75, 47, 153, 91);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CURSOS");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//inicializa ventana CURSOS
				frmMenuCursos objC= new frmMenuCursos();
				objC.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(294, 47, 153, 91);
		contentPane.add(btnNewButton_1);
		
		JButton btnCuotas = new JButton("CUOTAS");
		btnCuotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//inicializa ventana CUOTAS
				Cuotas.frmCuotas ventanaEstudiantes = new Cuotas.frmCuotas();
				ventanaEstudiantes.setVisible(true);
				
			}
		});
		btnCuotas.setBounds(75, 176, 153, 91);
		contentPane.add(btnCuotas);
		
		JButton btnAlumnos = new JButton("ESTUDIANTES");
		btnAlumnos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				frmEstudiantes ventanaEstudiantes = new frmEstudiantes();
				ventanaEstudiantes.setVisible(true); 
			
			}	
		});
		btnAlumnos.setBounds(294, 176, 153, 91);
		contentPane.add(btnAlumnos);
		
		JButton btnUsuarios = new JButton("Usuarios");
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					
				frmUsuarios ventanaUsuarios = new frmUsuarios();
				ventanaUsuarios.setVisible(true); 
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

