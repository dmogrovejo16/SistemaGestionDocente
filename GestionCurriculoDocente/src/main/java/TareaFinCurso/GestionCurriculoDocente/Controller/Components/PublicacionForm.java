package TareaFinCurso.GestionCurriculoDocente.Controller.Components;

import javafx.scene.control.TextField;

public class PublicacionForm {
	public TextField titulo;
	public  TextField editorial;
	public TextField anio;


    public PublicacionForm( 
    		 TextField titulo,
    		 TextField editorial,
    		 TextField anio) {
        this.editorial = editorial;
        this.titulo = titulo;
        this.anio = anio;

    }
}
