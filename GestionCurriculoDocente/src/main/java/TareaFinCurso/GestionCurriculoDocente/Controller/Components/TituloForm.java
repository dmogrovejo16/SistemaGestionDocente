package TareaFinCurso.GestionCurriculoDocente.Controller.Components;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class TituloForm { 
	  
	   // Este metodo crea un formulario para ingresar los titulos, por cada cantidad de titulos que presenta el usuario se genera un formulario, uno debajo de otro

	    public TextField institucion;
	    public ComboBox<String> titulo;
	    
	    public TextField ciudad;
	    public TextField fecha;

	    public TituloForm(TextField institucion, ComboBox<String> titulo,
	                      TextField ciudad, TextField fecha) {
	        this.institucion = institucion;
	        this.titulo = titulo;
	        this.ciudad = ciudad;
	        this.fecha = fecha;
	    }
	}
