package cursos;

public class clsGestorCursos {

	public void RegistrarCurso (int idC, String nombreC, String desc) {
		clsCurso objCurso = new clsCurso(idC, nombreC, desc);
		//objCurso habr� que hacer que se almacene en la bbdd o que se pase por par�metro a la clase que interacct�a con bbdd
	}
}
