package cursos;

/**clase que sirve para declarar los atributos que tendra
 * cada fila cuando un alumno se apunte a un curso
 * @author Grupo 3 DBS SS: Procesos software y de calidad 17-18
 *
 */
public class clsAsistencia {
	private int idC;
	private String dniE;
	
	
	
	public clsAsistencia(int idC, String dniE) {
		super();
		this.idC = idC;
		this.dniE = dniE;
	}
	
	/**metodo para ver por la aplicacion los estudiantes agrupados por curso
	 * 
	 * @return devuelve un String en el que se agrupan los estudiantes por cada curso
	 */
	public String toString() {
		return "CURSO=" + idC + " ASISTEN un TOTAL de: " +dniE+" estudiantes\n";
	}
	
	public int getIdC() {
		return idC;
	}

	public void setIdC(int idC) {
		this.idC = idC;
	}

	public String getDniE() {
		return dniE;
	}

	public void setDniE(String dniE) {
		this.dniE = dniE;
	}
	
	
	

}
