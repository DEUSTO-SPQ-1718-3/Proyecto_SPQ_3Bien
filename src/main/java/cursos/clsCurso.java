package cursos;

public class clsCurso {
	
	private int idC;
	private String nombreC;
	private String descripcion;
	//private Profesor profesor; //datos del profesor que lo imparte
	//private ArrayList<Alumno> listaMatriculados; //datos de los alumnos matriculados para un determinado curso
	
	
	public clsCurso(int idC, String nombreC, String descripcion) {
		super();
		this.idC = idC;
		this.nombreC = nombreC;
		this.descripcion = descripcion;
	}


	public int getIdC() {
		return idC;
	}
	public void setIdC(int idC) {
		this.idC = idC;
	}

	public String getNombreC() {
		return nombreC;
	}
	public void setNombreC(String nombreC) {
		this.nombreC = nombreC;
	}

	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
