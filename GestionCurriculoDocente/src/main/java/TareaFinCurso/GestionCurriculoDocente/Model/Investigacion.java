package TareaFinCurso.GestionCurriculoDocente.Model;

public class Investigacion extends ProduccionAcademica{
String institucion;

public Investigacion(String titulo, int anio, String institucion) {
	super(titulo, anio);
	this.institucion = institucion;
}

public String getInstitucion() {
	return institucion;
}

public void setInstitucion(String institucion) {
	this.institucion = institucion;
}
}
