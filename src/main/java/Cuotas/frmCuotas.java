package Cuotas;
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


public class frmCuotas extends JFrame implements ActionListener{

	/**
	 * 
	 */
	
	JTextArea txtCuotasRegistradas = new JTextArea();
	
	ArrayList<Cuota> listaCuotas = new ArrayList<Cuota>(); 
	 
	JButton btnPendientes = new JButton("TODOS");
	
	private static final long serialVersionUID = 7046431761927583577L;
	
	public frmCuotas() {
	
		
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
		
		
		txtCuotasRegistradas.setEditable(false);
		scrollPane.setViewportView(txtCuotasRegistradas);
		txtCuotasRegistradas.setText("- CUOTAS - ");
		txtCuotasRegistradas.setColumns(50);
		txtCuotasRegistradas.setEditable(false);

			listaCuotas.add(new Cuota("Xabi", "Perez", 10, 100,"09/17","PAGADO"));
			listaCuotas.add(new Cuota("Jon", "Gonzalez", 20, 200,"10/17", "PENDIENTE"));
			listaCuotas.add(new Cuota("Joana", "Lopez", 30, 300,"09/17", "PAGADO"));
			listaCuotas.add(new Cuota("Amaia", "Fermandez", 40, 400,"10/17", "PENDIENTE"));				
			
			sacarPendientes();
			
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
			
			//
			
			break;
			
					
		case "Salir":
			System.out.println("Cerrando programa...");
			System.exit(0);
			break;
			
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