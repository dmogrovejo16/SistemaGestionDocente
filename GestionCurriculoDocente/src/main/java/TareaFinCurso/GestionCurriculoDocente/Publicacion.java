package TareaFinCurso.GestionCurriculoDocente;

public class Publicacion extends ProduccionAcademica {
String editorial;

public Publicacion(String titulo, int anio, String editorial) {
	super(titulo, anio);
	this.editorial = editorial;
}

public String getEditorial() {
	return editorial;
}

public void setEditorial(String editorial) {
	this.editorial = editorial;
}




}
