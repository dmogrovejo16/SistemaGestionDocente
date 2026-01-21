package TareaFinCurso.GestionCurriculoDocente;

public abstract class Experiencia {
String institucion;

public Experiencia(String institucion) {
	super();
	this.institucion = institucion;
}

public String getInstitucion() {
	return institucion;
}

public void setInstitucion(String institucion) {
	this.institucion = institucion;
}

public abstract String getTipo();

}
