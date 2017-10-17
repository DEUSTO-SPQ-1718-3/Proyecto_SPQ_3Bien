package cursos;

public class clsGestorCursos {

	public void RegistrarCurso (int idC, String nombreC, String desc) {
		clsCurso objCurso = new clsCurso(idC, nombreC, desc);
		//objCurso habrá que hacer que se almacene en la bbdd o que se pase por parámetro a la clase que interacctúa con bbdd
	}
}
