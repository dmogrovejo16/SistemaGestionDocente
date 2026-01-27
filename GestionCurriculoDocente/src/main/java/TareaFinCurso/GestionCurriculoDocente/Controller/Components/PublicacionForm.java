package TareaFinCurso.GestionCurriculoDocente.Controller.Components;

import javafx.scene.control.TextField;
//Esta clase crea un formulario para ingresar pubicaciones, que se iran apliando en la ventana de Publicaciones
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
