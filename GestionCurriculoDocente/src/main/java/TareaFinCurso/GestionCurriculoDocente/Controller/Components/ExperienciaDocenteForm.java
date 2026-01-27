package TareaFinCurso.GestionCurriculoDocente.Controller.Components;

import javafx.scene.control.TextField;

public class ExperienciaDocenteForm {
   public  TextField institucion;
   public TextField catedra;
    
   public TextField fechaIni;
   public  TextField fechaFin;

    public ExperienciaDocenteForm( 
    TextField institucion,
    TextField catedra,
    TextField fechaIni,
    TextField fechaFin) {
        this.institucion = institucion;
        this.catedra = catedra;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
    }
}

