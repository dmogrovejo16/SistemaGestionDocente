package TareaFinCurso.GestionCurriculoDocente.Model;

public class CapacitacionImpartida extends Capacitacion {

	public CapacitacionImpartida(String tipoEvento, String institucion, String fechaIni, String fechaFin,
			int numHoras) {
		super(tipoEvento, institucion, fechaIni, fechaFin, numHoras);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String tipoCapacitacion() {
		return " Impartida ";
	}
	
	

}
