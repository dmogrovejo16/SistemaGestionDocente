package TareaFinCurso.GestionCurriculoDocente.Controller.Components;

import javafx.scene.control.TextField;
//Esta clase crea un formulario con texfields para ingresar una nueva experiencia como docente, que se iran almacenando en la ventana Experiencia

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

