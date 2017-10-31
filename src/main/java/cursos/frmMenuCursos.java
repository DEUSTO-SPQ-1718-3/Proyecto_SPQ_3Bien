package cursos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import main.VentanaInicial;

import javax.swing.JButton;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class frmMenuCursos extends JFrame implements ActionListener{
private static final long serialVersionUID = 7046431761927583577L;
	
	public frmMenuCursos() {
	
		
		setBounds(400, 400, 430, 230); //TamaÃ±o
		
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
						
		
		ArrayList<clsCurso> listaCursos = new ArrayList<clsCurso>();

			listaCursos.add(new clsCurso(1, "Microeconmía I", "Curso de iniciación a la microeconomía", 10, "Lun-mie de 16-17"));
			listaCursos.add(new clsCurso(2, "Programación I", "Curso de iniciación a la programación", 11, "Mar-jue de 10-11"));
			
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