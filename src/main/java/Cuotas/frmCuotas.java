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
/**Clase para la configuracion del frame principal de la aplicacion en la que se mostraran todas
 *las cuotas de las que se dispone.
 * \class frmCuotas
 * @package Cuotas
 * @author Grupo 3 DBS SS: Procesos software y de calidad 17-18
 *
 */
public class frmCuotas extends JFrame implements ActionListener{

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
	
	/**
	 *Crea el frame.
	 */
	public frmCuotas() {
	
		
		setBounds(500, 200, 530, 440); //Tama�o
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
		
		actualizar(listaCuotas);
		sacarPendientes();
		
		JButton btnActualizar = new JButton("REFRESH");
		btnActualizar.setBounds(420, 20, 100, 25);
		btnActualizar.addActionListener(this);
		btnActualizar.setActionCommand("Refresh");
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
		
		JButton btnAnyadir = new JButton("A�ADIR");
		btnAnyadir.setBounds(420, 170, 100, 25);
		btnAnyadir.addActionListener(this);
		btnAnyadir.setActionCommand("Anyadir");
		contentPane.add(btnAnyadir);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(420, 220, 100, 25);
		btnEliminar.addActionListener(this);
		btnEliminar.setActionCommand("Eliminar");
		contentPane.add(btnEliminar);
		
		JButton btnEnviar = new JButton("ENVIAR");
		btnEnviar.setBounds(420, 270, 100, 25);
		btnEnviar.addActionListener(this);
		btnEnviar.setActionCommand("Enviar");
		contentPane.add(btnEnviar);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.setBounds(420, 320, 100, 25);
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
			
			frmModificarCuota ventanaModificar = new frmModificarCuota();
			ventanaModificar.setVisible(true);
			
			break;
			
		case "Anyadir":
			
			
			frmCrearCuota ventanaInicial = new frmCrearCuota();
			ventanaInicial.setVisible(true); 
			
			
			
			break;
			
		case "Eliminar":
			
			frmBorrarCuota ventanaBorrar = new frmBorrarCuota();
			ventanaBorrar.setVisible(true);
			
			break;
			
		case "Refresh":
			
			listaCuotas.clear();
			
			actualizar(listaCuotas);
			
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
			 
		case "Enviar":
		
			frmEnviarCuota enviarCuota = new frmEnviarCuota();
			enviarCuota.setVisible(true);
			break;
			
					
		case "Salir":
			System.out.println("Cerrando programa...");
			System.exit(0);
			break;
			
		}
	}
	/**
	 *Vuelve a lanzar la query a la BD para actualizar los valores y sacarlos por pantalla.
	 */
	public void actualizar (ArrayList <Cuota> listaCuotas)
	
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
	
	/**
	 *Sirve para sacar por pantalla unicamente aquellas cuotas que esten PENDIENTES.
	 */
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