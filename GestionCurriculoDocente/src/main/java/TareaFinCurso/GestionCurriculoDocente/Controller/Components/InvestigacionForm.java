package TareaFinCurso.GestionCurriculoDocente.Controller.Components;

import javafx.scene.control.TextField;
//Esta clase crea un formulario para ingresar una nueva investigacion, que se iran apilando en la ventana de investigaciones
public class InvestigacionForm {
   public TextField titulo;
   public TextField institucion;
   public TextField anio;


    public InvestigacionForm( 
    		 TextField titulo,
    		 TextField institucion,
    		 TextField anio) {
        this.institucion = institucion;
        this.titulo = titulo;
        this.anio = anio;

    }
}
