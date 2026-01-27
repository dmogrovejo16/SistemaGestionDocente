package TareaFinCurso.GestionCurriculoDocente.Controller.Components;

import javafx.scene.control.TextField;
//Esta clase crea un formulario con texfields para ingresar una nueva capacitacion, que se iran almacenando en la ventana Capacitaciones

public class CapacitacionRecibidaForm {
	public TextField institucion;
	public TextField tipoEvento;
	public  TextField numHoras;
	public  TextField fechaIni;
	public TextField fechaFin;

    public CapacitacionRecibidaForm( 
    		 TextField tipoEvento,
    		 TextField institucion,
    		 TextField numHoras,
    		 TextField fechaIni,
    		 TextField fechaFin) {
        this.institucion = institucion;
        this.tipoEvento = tipoEvento;
        this.numHoras = numHoras;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
    }
}
