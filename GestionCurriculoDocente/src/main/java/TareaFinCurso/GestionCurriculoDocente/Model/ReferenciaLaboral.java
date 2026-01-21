package TareaFinCurso.GestionCurriculoDocente.Model;

public class ReferenciaLaboral extends Experiencia{
	 String jefeInmediato, telefonoJefe;

	public ReferenciaLaboral(String institucion, String jefeInmediato, String telefonoJefe) {
		super(institucion);
		this.jefeInmediato = jefeInmediato;
		this.telefonoJefe = telefonoJefe;
	}

	public String getJefeInmediato() {
		return jefeInmediato;
	}

	public void setJefeInmediato(String jefeInmediato) {
		this.jefeInmediato = jefeInmediato;
	}

	public String getTelefonoJefe() {
		return telefonoJefe;
	}

	public void setTelefonoJefe(String telefonoJefe) {
		this.telefonoJefe = telefonoJefe;
	}

	public ReferenciaLaboral(String institucion) {
		super(institucion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return " Referencia ";
	}

}
