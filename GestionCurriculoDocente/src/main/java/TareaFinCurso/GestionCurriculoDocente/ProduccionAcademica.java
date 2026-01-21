package TareaFinCurso.GestionCurriculoDocente;

public class ProduccionAcademica {
 String titulo;
 int anio;
 public String getTitulo() {
	return titulo;
 }
 public void setTitulo(String titulo) {
	this.titulo = titulo;
 }
 public int getAnio() {
	return anio;
 }
 public void setAnio(int anio) {
	this.anio = anio;
 }
 public ProduccionAcademica(String titulo, int anio) {
	super();
	this.titulo = titulo;
	this.anio = anio;
 }
 
}
