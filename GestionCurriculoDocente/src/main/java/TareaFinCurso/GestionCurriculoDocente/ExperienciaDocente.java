package TareaFinCurso.GestionCurriculoDocente;

public class ExperienciaDocente extends Experiencia{
 String catedra, fechaIni,fechaFin;
	public ExperienciaDocente(String institucion, String catedra, String fechaIni, String fechaFin) {
	super(institucion);
	this.catedra = catedra;
	this.fechaIni = fechaIni;
	this.fechaFin = fechaFin;
}
	public String getCatedra() {
		return catedra;
	}
	public void setCatedra(String catedra) {
		this.catedra = catedra;
	}
	public String getFechaIni() {
		return fechaIni;
	}
	public void setFechaIni(String fechaIni) {
		this.fechaIni = fechaIni;
	}
	public String getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	public ExperienciaDocente(String institucion) {
		super(institucion);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return " Docente ";
	}

}
