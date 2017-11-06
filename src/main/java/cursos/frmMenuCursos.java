package cursos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import Cuotas.Cuota;
import bbdd.MyDataAccess;
import main.VentanaInicial;

import javax.swing.JButton;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class frmMenuCursos extends JFrame implements ActionListener{
private static final long serialVersionUID = 7046431761927583577L;
private ArrayList<clsCurso> listaCursos = new ArrayList<clsCurso>();
MyDataAccess conexion = new MyDataAccess();

	public frmMenuCursos() {
	
		
		setBounds(400, 400, 430, 230); //Tamaño
		
		setTitle("MI ACADEMIA");	
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 350, 530, 440);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 5, 400, 400);
		contentPane.add(scrollPane);
		
		JTextArea txtCursosRegistrados = new JTextArea();
		txtCursosRegistrados.setEditable(false);
		scrollPane.setViewportView(txtCursosRegistrados);
		//txtHabitacionesRegistradas.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtCursosRegistrados.setText("- CURSOS REGISTRADOS - \n");
		txtCursosRegistrados.setColumns(50);
		txtCursosRegistrados.setEditable(false);
		
		//RELLENAR LA LISTA CON LOS DATOS DE LA BBDD
		 ResultSet visualizar;
		 int idC;
		 String nombreC;
		 String descripcion;
		 int numClase;
		 String horario;
		    
		visualizar = conexion.getQuery("SELECT * from cursos");
		
		try {
		    while(visualizar.next()){
		    idC= visualizar.getInt("idC");
		    nombreC = visualizar.getString("nombreC");
		    descripcion = visualizar.getString("descripcion");
		    numClase = visualizar.getInt("numClase");
		    horario = visualizar.getString("horario");
		      
			listaCursos.add(new clsCurso(idC, nombreC, descripcion, numClase, horario));	
		 }
		 }catch (SQLException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		 }
		
		
		txtCursosRegistrados.append(listaCursos.toString());		
		
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
		btnSalir.setBounds(420, 310, 100, 25);
		btnSalir.addActionListener(this);
		btnSalir.setActionCommand("Salir");
		contentPane.add(btnSalir);
		
		JButton btnInformes = new JButton("INFORMES");
		btnInformes.setActionCommand("Informes");
		btnInformes.setBounds(420, 268, 100, 25);
		contentPane.add(btnInformes);
		btnInformes.addActionListener(this);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setActionCommand("Atras");
		btnAtras.setBounds(443, 7, 71, 23);
		contentPane.add(btnAtras);
		btnAtras.addActionListener(this);		
			
		this.setResizable(false);		
			
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		
		switch(e.getActionCommand()){
		
		
		case "Modificar":
			
			//
			
			break;
			
		case "Anyadir":
			frmRegistrarCurso objAlta=new frmRegistrarCurso();
			objAlta.setVisible(true);
			this.dispose();			
			break;
			
		case "Eliminar":
			frmBorrarCurso objB=new frmBorrarCurso();
			objB.setVisible(true);			
			break;
			
		case "Informes":
					
			//
					
			break;
					
		case "Atras":
			VentanaInicial objV= new VentanaInicial();
			objV.setVisible(true);
			this.dispose();
					
		case "SALIR":
			System.out.println("Cerrando programa...");
			System.exit(0);
			break;
			
		}
	}
}