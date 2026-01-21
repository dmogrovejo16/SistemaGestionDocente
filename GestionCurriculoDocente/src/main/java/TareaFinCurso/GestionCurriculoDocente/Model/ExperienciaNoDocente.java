package TareaFinCurso.GestionCurriculoDocente.Model;

public class ExperienciaNoDocente extends Experiencia {
	 String funcion, fechaIni,fechaFin; //Atriutos que tiene una experiencia no docente

	 
	 //GETTERS Y SETTERS DE LOS ATRIBUTOS
	public String getFuncion() {
		return funcion;
	}

	 public void setFuncion(String funcion) {
		 this.funcion = funcion;
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

	public ExperienciaNoDocente(String institucion, String funcion, String fechaIni, String fechaFin) { //Constructor con atributos
		super(institucion);
		this.funcion = funcion;
		this.fechaIni = fechaIni;
		this.fechaFin = fechaFin;
	}

	public ExperienciaNoDocente(String institucion) {
		super(institucion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return " No Docente ";
	}

}
