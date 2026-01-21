package TareaFinCurso.GestionCurriculoDocente;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;

public class AccionEliminar {//Esta clase muestra el recuador de tecto para ingresar el numero de cedula del docente a liminar y confirmar dicho proceso
    EventoEliminar Eliminar = new EventoEliminar();
    Boolean Sacar;

	public void AccionEliminar(Button b) {
		b.setOnAction(event -> {
        	TextInputDialog interaccion = new TextInputDialog();
        	interaccion.setTitle("Eliminar Docente");
        	interaccion.setHeaderText("Ingrese el número de cédula del docente a eliminar:");
        	interaccion.setContentText("Cédula:");
        	
        	interaccion.showAndWait().ifPresent(cedula -> {
            // Mostrar confirmación al usuario
            Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
            confirmacion.setTitle("Confirmar eliminación");
            confirmacion.setHeaderText("¿Está seguro que desea eliminar al docente con N° de cédula: " + cedula + "?");

            confirmacion.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    Sacar= Eliminar.EventoEliminar(cedula); //llamamos a la clase eliminar
                    
                    if(Sacar==true) {
                    	Alert alertaExito = new Alert(Alert.AlertType.INFORMATION);
                        alertaExito.setTitle("Éxito");
                        alertaExito.setHeaderText(null);
                        alertaExito.setContentText("Docente eliminado correctamente.");
                        alertaExito.showAndWait();
                    } else {
                        Alert alertaError = new Alert(Alert.AlertType.WARNING);
                        alertaError.setTitle("No encontrado");
                        alertaError.setHeaderText("Error al eliminar");
                        alertaError.setContentText("No se encontró ningún docente con la cédula: " + cedula);
                        alertaError.showAndWait();
                }
                    
                }
            });
        });
        
    });
	}

}
