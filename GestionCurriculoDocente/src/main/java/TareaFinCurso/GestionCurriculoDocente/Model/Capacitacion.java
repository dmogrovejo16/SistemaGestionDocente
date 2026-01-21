package TareaFinCurso.GestionCurriculoDocente.Model;

public abstract class Capacitacion {
String tipoEvento, institucion, fechaIni, fechaFin;
int numHoras;
public String getTipoEvento() {
	return tipoEvento;
}
public void setTipoEvento(String tipoEvento) {
	this.tipoEvento = tipoEvento;
}
public String getInstitucion() {
	return institucion;
}
public void setInstitucion(String institucion) {
	this.institucion = institucion;
}
public String getFechaIni() {
	return fechaIni;
}
public void setFechaIni(String fechaIni) {
	this.fechaIni = fechaIni;
}
@Override
public String toString() {
	return "Capacitacion [tipoEvento=" + tipoEvento + ", institucion=" + institucion + ", fechaIni=" + fechaIni
			+ ", fechaFin=" + fechaFin + ", numHoras=" + numHoras + ", getTipoEvento()=" + getTipoEvento()
			+ ", getInstitucion()=" + getInstitucion() + ", getFechaIni()=" + getFechaIni() + ", getFechaFin()="
			+ getFechaFin() + ", getNumHoras()=" + getNumHoras() + ", getClass()=" + getClass() + ", hashCode()="
			+ hashCode() + ", toString()=" + super.toString() + "]";
}
public String getFechaFin() {
	return fechaFin;
}
public void setFechaFin(String fechaFin) {
	this.fechaFin = fechaFin;
}
public int getNumHoras() {
	return numHoras;
}
public void setNumHoras(int numHoras) {
	this.numHoras = numHoras;
}
public Capacitacion(String tipoEvento, String institucion, String fechaIni, String fechaFin, int numHoras) {
	super();
	this.tipoEvento = tipoEvento;
	this.institucion = institucion;
	this.fechaIni = fechaIni;
	this.fechaFin = fechaFin;
	this.numHoras = numHoras;
}

public abstract String tipoCapacitacion();

}
