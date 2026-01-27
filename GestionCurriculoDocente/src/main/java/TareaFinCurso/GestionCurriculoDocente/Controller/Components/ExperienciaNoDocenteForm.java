package TareaFinCurso.GestionCurriculoDocente.Controller.Components;

import javafx.scene.control.TextField;
//Esta clase crea un formulario con texfields para ingresar una nueva experiencia, que se iran almacenando en la ventana Experiencia

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
