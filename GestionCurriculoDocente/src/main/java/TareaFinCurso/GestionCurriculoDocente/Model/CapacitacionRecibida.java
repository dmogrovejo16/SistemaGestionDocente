package TareaFinCurso.GestionCurriculoDocente.Model;

public class CapacitacionRecibida extends Capacitacion {

	public CapacitacionRecibida(String tipoEvento, String institucion, String fechaIni, String fechaFin, int numHoras) {
		super(tipoEvento, institucion, fechaIni, fechaFin, numHoras);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String tipoCapacitacion() {
		return "Recibida";
	}

}
