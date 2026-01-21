package TareaFinCurso.GestionCurriculoDocente.Model;


public class Titulo {
 String institucion, titulo, ciudad, fecha;
 
 public Titulo() {}

 public Titulo(String institucion, String titulo, String ciudad, String fecha) {
	super();
	this.institucion = institucion;
	this.titulo = titulo;
	this.ciudad = ciudad;
	this.fecha = fecha;
 }

 public String getInstitucion() {
	return institucion;
 }

 public void setInstitucion(String institucion) {
	this.institucion = institucion;
 }

 public String getTitulo() {
	return titulo;
 }

 public void setTitulo(String titulo) {
	this.titulo = titulo;
 }

 public String getCiudad() {
	return ciudad;
 }

 public void setCiudad(String ciudad) {
	this.ciudad = ciudad;
 }

 public String getFecha() {
	return fecha;
 }

 public void setFecha(String fecha) {
	this.fecha = fecha;
 }
 
 
}
