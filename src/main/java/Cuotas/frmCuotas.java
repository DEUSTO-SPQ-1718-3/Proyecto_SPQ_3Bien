package Cuotas;
import java.awt.Dimension;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import bbdd.MyDataAccess;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.util.ArrayList;
import java.sql.*;
public class frmCuotas extends JFrame implements ActionListener{

	/**
	 * 
	 */
	
    int id;
    String nombre;
    String apellido;
    int horas;
    int precio;
    String fecha;
    String estado;
	
	JTextArea txtCuotasRegistradas = new JTextArea();
	
	ArrayList<Cuota> listaCuotas = new ArrayList<Cuota>(); 
	 
	JButton btnPendientes = new JButton("TODOS");
	
	private static final long serialVersionUID = 7046431761927583577L;
	
	public frmCuotas() {
	
		
		setBounds(500, 200, 530, 440); //Tamaño
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		setTitle("MI ACADEMIA");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 530, 440);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 5, 400, 400);
		contentPane.add(scrollPane);
		
		
		txtCuotasRegistradas.setEditable(false);
		scrollPane.setViewportView(txtCuotasRegistradas);
		txtCuotasRegistradas.setText("- CUOTAS - ");
		txtCuotasRegistradas.setColumns(50);
		txtCuotasRegistradas.setEditable(false);
		
		actualizar();
		sacarPendientes();
		
		JButton btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.setBounds(420, 20, 100, 25);
		btnActualizar.addActionListener(this);
		btnActualizar.setActionCommand("Actualizar");
		contentPane.add(btnActualizar);
			
		btnPendientes.setBounds(420, 70, 100, 25);
		btnPendientes.addActionListener(this);
		btnPendientes.setActionCommand("Todos");
		contentPane.add(btnPendientes);			
		
		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.setBounds(420, 120, 100, 25);
		btnModificar.addActionListener(this);
		btnModificar.setActionCommand("Modificar");
		contentPane.add(btnModificar);
		
		JButton btnAnyadir = new JButton("AÑADIR");
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
		
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		switch(e.getActionCommand()){
		
		case "Todos":
			
			if(btnPendientes.getText().equals("TODOS"))
				
			{
			
			txtCuotasRegistradas.setText(null);
				
			txtCuotasRegistradas.append(listaCuotas.toString());
				
			btnPendientes.setText("PENDIENTES");
			
			}
			
			else
				
			{
				
			txtCuotasRegistradas.setText(null);
				
			sacarPendientes();
			
			btnPendientes.setText("TODOS");	
				
			}
			
			break;
		
		
		case "Modificar":
			
			//
			
			break;
			
		case "Anyadir":
			
			
			frmCrearCuota ventanaInicial = new frmCrearCuota();
			ventanaInicial.setVisible(true); 
			
			
			
			break;
			
		case "Eliminar":
			
			frmBorrarCuota ventanaBorrar = new frmBorrarCuota();
			ventanaBorrar.setVisible(true);
			
			break;
			
		case "Actualizar":
			
			listaCuotas.clear();
			
			actualizar();
			
			if(btnPendientes.getText().equals("PENDIENTES"))
				
			{
			
			txtCuotasRegistradas.setText(null);
				
			txtCuotasRegistradas.append(listaCuotas.toString());
			
			}
			
			else
				
			{
				
			txtCuotasRegistradas.setText(null);
				
			sacarPendientes();
				
			}
			
			
			 break;
			
					
		case "Salir":
			System.out.println("Cerrando programa...");
			System.exit(0);
			break;
			
		}
	}
	
	public void actualizar ()
	
	{
		
		//BD
		
				MyDataAccess conexion = new MyDataAccess();
			    ResultSet resultado;
			    
			    resultado = conexion.getQuery("select * from Cuotas");
			      //
				
				try {
				      while(resultado.next()){
				      id = resultado.getInt("id");
				      nombre = resultado.getString("nombre");
				      apellido = resultado.getString("apellido");
				      horas = resultado.getInt("horas");
				      precio = resultado.getInt("precio");
				      fecha = resultado.getString("fecha");
				      estado = resultado.getString("estado");
				      
					listaCuotas.add(new Cuota(nombre, apellido, horas, precio,fecha, estado, id));	
				      }
				    }catch (SQLException e) {
				      // TODO Auto-generated catch block
				      e.printStackTrace();
				    }	
		
	}
	
	public void sacarPendientes ()
	
	{		
		
		for (int n =0; n < listaCuotas.size(); n++)
			
		{
			
			if (listaCuotas.get(n).getEstado().equals("PENDIENTE"))
			
			{
			
			txtCuotasRegistradas.append((listaCuotas.get(n)).toString());
			
			}
			
		}	
		
		
	}
}