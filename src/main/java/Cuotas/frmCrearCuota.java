package Cuotas;

import java.awt.EventQueue;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import bbdd.MyDataAccess;
import main.VentanaInicial;

import javax.naming.event.ObjectChangeListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.JRadioButton;
/**Clase para la configuracion del frame y de la funcionalidad crear cuota.
 * \class frmCrearCuota
 * @package Cuotas
 * @author Grupo 3 DBS SS: Procesos software y de calidad 17-18
 *
 */
public class frmCrearCuota extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7046431761927583577L;
	
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_3;
	private JLabel lblApellidos;
	private JLabel lblHoras;
	private JTextField textField_4;
	private JLabel lblPrecio;
	private JTextField textField_5;
	private JTextField textField;
	JRadioButton rdbtnPendiente;
	JRadioButton rdbtnPagada;
	String pendiente1 = "PENDIENTE";
	
	
	/**
	 * Crea el frame.
	 */
	public frmCrearCuota() {

	
		
		setBounds(400, 400, 418, 318); //Tamaño
		
		setTitle("MI ACADEMIA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 430, 307);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setForeground(Color.BLACK);
		panel.setBackground(Color.WHITE);
		setLocationRelativeTo(null);
		
		JLabel lblCompletaLosCampos = new JLabel("CREAR CUOTA");
		lblCompletaLosCampos.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 11));
		lblCompletaLosCampos.setBounds(158, 23, 87, 14);
		panel.add(lblCompletaLosCampos);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(29, 66, 52, 14);
		panel.add(lblNombre);

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
		lblHoras.setBounds(29, 144, 37, 14);
		panel.add(lblHoras);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(100, 141, 119, 20);
		panel.add(textField_4);

		lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(229, 144, 46, 14);
		panel.add(lblPrecio);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(271, 141, 100, 20);
		panel.add(textField_5);

		JButton btnNewButton = new JButton("ENVIAR");
		btnNewButton.setBounds(158, 249, 100, 23);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(this);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(100, 63, 119, 20);
		panel.add(textField);
		
		JButton btnNewButton_1 = new JButton("Calcular");
		btnNewButton_1.setBounds(271, 171, 100, 23);
		panel.add(btnNewButton_1);
		
		rdbtnPendiente = new JRadioButton("Pendiente");
		rdbtnPendiente.setSelected(true);
		rdbtnPendiente.setBounds(99, 218, 93, 23);
		panel.add(rdbtnPendiente);
		
		rdbtnPagada = new JRadioButton("Pagado");
		rdbtnPagada.setBounds(229, 218, 87, 23);
		panel.add(rdbtnPagada);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(100, 218, 216, 23);
		panel.add(panel_1);
		btnNewButton_1.addActionListener(this);
		
		ButtonGroup group = new ButtonGroup();
	    group.add(rdbtnPagada);
	    group.add(rdbtnPendiente);
			
		this.setResizable(true);
		
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		switch(e.getActionCommand()){
		
		case "Calcular":
					
		textField_5.setText(Integer.toString(Integer.parseInt(textField_4.getText())*30));

		break;
		
		case "ENVIAR":
			
		String nombre = textField.getText();
		String apellidos = textField_3.getText();
		int horas = Integer.parseInt(textField_4.getText());
		int precio = Integer.parseInt(textField_5.getText());
		String fecha = textField_1.getText();
		
		if (rdbtnPagada.isSelected())
			
		{
			
			pendiente1 = "PAGADO";
			
		}
		
		creaCuota (nombre, apellidos, horas, precio, fecha, pendiente1);
		
		break;
			
		}
	}
	
	/**
	 * Lanza la query correspondiente para crear una nueva fila en la BD.
	 */
		public void  creaCuota (String nombre, String apellidos, int horas, int precio, String fecha, String pendiente1)
		
		{
			
			//BD
			
			MyDataAccess conexion = new MyDataAccess();
		    ResultSet resultado;
		    
		    //
			
			String query = "insert into cuotas values (" + "'" + nombre + "','" + apellidos + "','" + horas + "','" + precio + "','" + fecha + "','"  + pendiente1 + "'," + null + ")";
			conexion.setQuery(query);	
			
		}
	
}