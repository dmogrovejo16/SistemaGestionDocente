package TareaFinCurso.GestionCurriculoDocente.View;

import java.util.ArrayList;

import TareaFinCurso.GestionCurriculoDocente.App;
import TareaFinCurso.GestionCurriculoDocente.Model.Docente;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VentanaDocentes {

	
	public  Scene EscenaListaDocentes(Stage stage, App app) { 
		
		 Button volver = new Button("Volver");
	        volver.setId("btn-volver2");  
	        volver.setOnAction(e -> {
	            stage.setScene(app.EscenaPrincipal(stage));
	        });
	        VBox vbox1 = new VBox();
	        vbox1.setId("vbox-btn-volver");
	        vbox1.setAlignment(Pos.TOP_LEFT);
	        vbox1.setMargin(volver, new Insets(10));
	        
	        VBox vbox2 = new VBox(10);
	        vbox2.setId("vbox-inputs");  
	        vbox2.setAlignment(Pos.CENTER);
	        vbox2.setId("inner");

	        
	        vbox1.getChildren().addAll(volver);
	        vbox1.setAlignment(Pos.TOP_LEFT);
	        vbox1.setMargin(volver, new Insets(10));
	        
	        
	       
	    
		ArrayList<Docente> docentes = app.getDocentes();
		TilePane tilePane = new TilePane();
		tilePane.setAlignment(Pos.CENTER);
		tilePane.setPrefColumns(4); // máximo 4 docentes por fila
		tilePane.setHgap(10);
		tilePane.setVgap(10);
		for (Docente d: docentes) {
			Label name = new Label();
		    name.setId("nombre");
		    name.setText(d.getNombres());
			VBox imagen = new VBox();
			name.setWrapText(true);
			HBox.setHgrow(name, Priority.ALWAYS);
			imagen.setId("imagen");
			imagen.setPrefSize(100, 100);
			imagen.setMinSize(100, 100);
			imagen.setMaxSize(150, 150);
			VBox vbox = new VBox();
			vbox.getChildren().addAll(imagen, name);
			vbox.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
			vbox.setAlignment(Pos.CENTER);
			Button btn = new Button();
			btn.setGraphic(vbox);
			btn.setId("btn-docente");
			btn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
			btn.setOnAction(e -> {
             Scene escenaInfo = app.getVentanaInformacionDocente().EscenaVisualizacion(stage, app, d);
             stage.setScene(escenaInfo);
             stage.setMaximized(true);
			});
			tilePane.getChildren().add(btn);
		}
		
		
		
		VBox contenedorP =  new VBox();
        contenedorP.getChildren().addAll(vbox1,tilePane);
        
        
	       
        contenedorP.setId("fondo");
		
		Scene scene = new Scene(contenedorP,1530, 780); // Agregamos el contenedor con las datos a la escena
        scene.getStylesheets().add(//Le asignamos una hoja de estilos a esta escena para darle dise!no
                getClass().getResource("/TareaFinCurso/GestionCurriculoDocente/View/Css/docentes.css")
                        .toExternalForm()
            );
            return scene; 
	}
	
}
