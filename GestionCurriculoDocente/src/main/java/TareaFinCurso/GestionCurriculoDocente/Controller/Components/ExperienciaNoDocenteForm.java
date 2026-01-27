package TareaFinCurso.GestionCurriculoDocente.Controller.Components;

import javafx.scene.control.TextField;

public class ExperienciaNoDocenteForm {
	public  TextField institucion;
	public   TextField funcion;
	    
	public TextField fechaIni;
	public  TextField fechaFin;

	    public ExperienciaNoDocenteForm( 
	    TextField institucion,
	    TextField funcion,
	    TextField fechaIni,
	    TextField fechaFin) {
	        this.institucion = institucion;
	        this.funcion = funcion;
	        this.fechaIni = fechaIni;
	        this.fechaFin = fechaFin;
	    }
}
