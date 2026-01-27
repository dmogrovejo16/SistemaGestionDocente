package TareaFinCurso.GestionCurriculoDocente.Controller.Components;

import javafx.scene.control.TextField;

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
