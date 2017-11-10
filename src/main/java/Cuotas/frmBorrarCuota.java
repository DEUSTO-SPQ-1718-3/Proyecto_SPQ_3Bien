package Cuotas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bbdd.MyDataAccess;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class frmBorrarCuota extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmBorrarCuota frame = new frmBorrarCuota();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmBorrarCuota() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 278, 168);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Selecciona el id de la que deseas eliminar");
		lblNewLabel.setBounds(10, 11, 254, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(92, 56, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblId = new JLabel("id");
		lblId.setBounds(74, 59, 18, 14);
		contentPane.add(lblId);
		
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		btnNewButton = new JButton("BORRAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int id = Integer.parseInt(textField.getText());
				
				//BD
				
				MyDataAccess conexion = new MyDataAccess();

			    //
				
				String query = "delete from cuotas where id = '" + id + "'";
				conexion.setQuery(query);
			}
		});
		btnNewButton.setBounds(92, 88, 86, 20);
		contentPane.add(btnNewButton);
	}
}
