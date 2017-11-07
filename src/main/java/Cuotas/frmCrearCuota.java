package Cuotas;

import java.awt.EventQueue;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import main.VentanaInicial;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.UIManager;

public class frmCrearCuota extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7046431761927583577L;
	
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblApellidos;
	private JLabel lblHoras;
	private JTextField textField_4;
	private JLabel lblPrecio;
	private JTextField textField_5;
	private JTextField textField;
	
	public frmCrearCuota() {
	
		
		setBounds(400, 400, 443, 290); //Tamaño
		
		setTitle("MI ACADEMIA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 430, 252);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setForeground(Color.BLACK);
		panel.setBackground(Color.WHITE);
		setLocationRelativeTo(null);
		
		JLabel lblCompletaLosCampos = new JLabel("CREAR CUOTA");
		lblCompletaLosCampos.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 11));
		lblCompletaLosCampos.setBounds(178, 22, 87, 14);
		panel.add(lblCompletaLosCampos);

		textField_2 = new JTextField();
		textField_2.setBounds(100, 139, 271, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(29, 66, 52, 14);
		panel.add(lblNombre);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(29, 142, 61, 14);
		panel.add(lblEmail);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(271, 63, 100, 20);
		panel.add(textField_1);

		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(229, 66, 46, 14);
		panel.add(lblFecha);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(100, 102, 271, 20);
		panel.add(textField_3);

		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(29, 105, 61, 14);
		panel.add(lblApellidos);

		lblHoras = new JLabel("Horas");
		lblHoras.setBounds(29, 178, 37, 14);
		panel.add(lblHoras);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(100, 175, 119, 20);
		panel.add(textField_4);

		lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(229, 178, 46, 14);
		panel.add(lblPrecio);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(271, 175, 100, 20);
		panel.add(textField_5);

		JButton btnNewButton = new JButton("ENVIAR");
		btnNewButton.setBounds(162, 216, 100, 23);
		panel.add(btnNewButton);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(100, 63, 119, 20);
		panel.add(textField);
			
		this.setResizable(true);
			
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		switch(e.getActionCommand()){
		
		
		case "Registrarse":
			
			VentanaInicial ventanaInicial = new VentanaInicial();
			ventanaInicial.setVisible(true); 
			
			break;
			
					
		case "Salir":
			System.out.println("Cerrando programa...");
			System.exit(0);
			break;
			
		}
	}
}