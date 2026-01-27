package TareaFinCurso.GestionCurriculoDocente.Controller.Components;

import javafx.scene.control.TextField;
//Esta clase crea un formulario con texfields para ingresar una nueva referencia laboral, que se iran almacenando en la ventana Experiencia

public class ReferenciasLaboralesForm {
	public  TextField institucion;
	public  TextField jefeInmediato;
	public  TextField telefono;

	    public ReferenciasLaboralesForm( 
	    TextField institucion,
	    TextField jefeInmediato,
	    TextField telefono) {
	        this.institucion = institucion;
	        this.jefeInmediato = jefeInmediato;
	        this.telefono = telefono;
	    }
}
