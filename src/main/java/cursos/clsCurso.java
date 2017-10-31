package cursos;

public class clsCurso {
	
	private int idC; //el identificador del curso
	private String nombreC; //el nombre que llevará el curso
	private String descripcion; //una breve descripción de su objetivo
	private int numClase; // la clase que se impartirça
	private String horario; //el horario que tendrá
	//private Profesor profesor; //datos del profesor que lo imparte
	//private ArrayList<Alumno> listaMatriculados; //datos de los alumnos matriculados para un determinado curso
	
	
	@Override
	public String toString() {
		return "Curso con id:" + idC + ", con título '" + nombreC + "', impartido en la clase "
				+ numClase + " y su horario es de " + horario + ".\n";
	}


	public clsCurso(int idC, String nombreC, String descripcion, int numClase, String horario) {
		super();
		this.idC = idC;
		this.nombreC = nombreC;
		this.descripcion = descripcion;
		this.setNumClase(numClase);
		this.setHorario(horario);
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


	public int getNumClase() {
		return numClase;
	}


	public void setNumClase(int numClase) {
		this.numClase = numClase;
	}


	public String getHorario() {
		return horario;
	}


	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	
	
}
