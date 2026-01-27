package TareaFinCurso.GestionCurriculoDocente.View;

import java.util.ArrayList;

import TareaFinCurso.GestionCurriculoDocente.App;
import TareaFinCurso.GestionCurriculoDocente.Controller.Components.CapacitacionImpartidaForm;
import TareaFinCurso.GestionCurriculoDocente.Controller.Components.CapacitacionRecibidaForm;
import TareaFinCurso.GestionCurriculoDocente.Controller.Components.MostrarModal;
import TareaFinCurso.GestionCurriculoDocente.Model.Capacitacion;
import TareaFinCurso.GestionCurriculoDocente.Model.CapacitacionImpartida;
import TareaFinCurso.GestionCurriculoDocente.Model.CapacitacionRecibida;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class VentanaCapacitacion {

	//Creamos array list para ir guardando las capacitaciones ingresadas, junto con sus geters para encapsulacion
	 ArrayList<CapacitacionImpartida> capacitacionesImpartidas = new ArrayList<>();
	  ArrayList<CapacitacionRecibida> capacitacionesRecibidas = new ArrayList<>();
	  ArrayList<Capacitacion> capacitaciones = new ArrayList<>();
	  App app;
	  public void pasarCapacitacion() {
	        
	       
			app.getVentanaProduccion().usarCapacitacion(capacitaciones);  // Pasar la persona
	    }
	  
	  
	  
	  
	  public  Scene EscenaRegistroCapacitacionRecibida(Stage stage,  App app) {//Scena para registrar capacitacion recibidas

this.app=app;
			
	  	  Integer cantidad = MostrarModal.mostrarVentana("Ingrese la cantidad de capacitaciones que ha recibido"); //Mostramos el cuadro de
	  	  //dialogo para obtener la cantidad de formularios a generar o para pasar a la sigiuente
	  	  
	if (cantidad==0) { //Si no tiene capacitacion, cabiamos a la siguiente escena 
	  		
		capacitacionesRecibidas.clear();//Borramos lo residual
		capacitaciones.addAll(capacitacionesRecibidas);//Cambianos de escena 
	  		return EscenaRegistroCapacitacionImpartida(stage, app);
	        
	  	  }
	  	  
	  	  VBox contenedorP =  new VBox();
	  	ArrayList<CapacitacionRecibidaForm> formularios = new ArrayList<>();//ArrayList para guardar los formularios
		  
	        Button volver = new Button("Volver");//Creamos un boton para volver y definimos su accion
	        volver.setId("btn-volver2");  
	        volver.setOnAction(e -> {
	        	VentanaExperiencia ventanaExperiencia = new VentanaExperiencia();
	            stage.setScene(app.getVentanaExperiencia().EscenaRegistroReferenciasLaborales(stage, app));//Pasamos a la anterior escena
	        });

	        Button siguiente = new Button("Siguiente");//Creamos un boton de siguiente y le asinamos un id para los estills
	        siguiente.setId("btn-siguiente2");
	        //Generamos contenedores para organizar el contenido y les asignamos id y eleemntos para el diseño
	        VBox vbox1 = new VBox();
	        vbox1.setId("vbox-btn-volver");
	        vbox1.setAlignment(Pos.TOP_LEFT);
	        vbox1.setMargin(volver, new Insets(10));
	        
	        VBox vbox2 = new VBox(10);
	        vbox2.setId("vbox-inputs");  
	        vbox2.setAlignment(Pos.CENTER);
	        vbox2.setId("inner");
	        
	        VBox vbox4 = new VBox();
	        vbox4.setId("vbox-btn-siguiente");
	     
	        
	        vbox1.getChildren().addAll(volver);
	        vbox1.setAlignment(Pos.TOP_LEFT);
	        vbox1.setMargin(volver, new Insets(10));
	        
	        vbox4.getChildren().addAll(siguiente);
	        vbox4.setAlignment(Pos.CENTER);
	        vbox4.setMargin(volver, new Insets(10));
	        
	       
	        for (int i = 1; i <= cantidad; i++) { //Creamos formularios segun la cantidad de capacitaciones que ha recibido
	        	
	        	    TextField institucion = new TextField();
	        	    TextField tipoEvento = new TextField();
	        	    TextField numHoras = new TextField();
	        	    TextField fechaIni = new TextField();
	        	    TextField fechaFin = new TextField();

	        	    VBox vbox = new VBox(5);
	        	    vbox.setAlignment(Pos.CENTER);
	        	    VBox.setMargin(vbox, new Insets(15, 0, 15, 0));
	        	    vbox.setId("back-inner");
	        	    vbox.getChildren().addAll(
	        	        new Label("Institución"), institucion,
	        	        new Label("Tipo de Evento"), tipoEvento,
	        	        new Label("Numero de Horas"), numHoras,
	        	        new Label("Fecha de Inicio"), fechaIni,
	        	        new Label("Fecha de Fin"), fechaFin
	        	    );

	        	    // Guardar los formularios en el array de formularios 
	        	    formularios.add(new CapacitacionRecibidaForm(institucion, tipoEvento, numHoras, fechaIni, fechaFin));

	        	    vbox2.getChildren().add(vbox);
	     
	        }
	        
	        ScrollPane scroll = new ScrollPane();//Creamos un panel scrolleable para mostra x cantida de formularios 
		    StackPane stackPane = new StackPane();
		    stackPane.setId("cont-inner");
		    stackPane.getChildren().add(vbox2);//Añadimos los formularios 
		    stackPane.setAlignment(vbox2, Pos.CENTER);
		    scroll.setContent(stackPane);
		    scroll.setFitToWidth(true);
		    scroll.setPrefWidth(500);
		    scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		    scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
	        contenedorP.getChildren().addAll(vbox1,scroll, vbox4);
	        
	        
	        contenedorP.setId("fondo");
	        
	        siguiente.setOnAction(e -> {//Definimos la funcion del boton siguiente
	        	 capacitacionesRecibidas.clear();

	        	    for (CapacitacionRecibidaForm f : formularios) {//Por cada formulario creado, sus valores los vamos pasando al array de capacitaciones
	        	    	//con el objetivo de depues para el array de capacitaciones y crear el objeto docente

	        	        CapacitacionRecibida t = new CapacitacionRecibida(
	        	        		//Obtenemos los valores de todos los  texts
	        	        		 f.tipoEvento.getText(),
f.institucion.getText(),
	        	            f.fechaFin.getText(),
	        	            f.fechaIni.getText(),
	        	            Integer.parseInt(f.numHoras.getText())
	        	        );

	        	        capacitacionesRecibidas.add(t);
	        	        capacitaciones.addAll(capacitacionesRecibidas);
	        	    }

	        	    
	        	    capacitacionesRecibidas.forEach(System.out::println);
	        	    
	        	    stage.setMaximized(true);
		            stage.setScene(app.getVentanaCapacitacion().EscenaRegistroCapacitacionImpartida(stage, app));
	        	});
	        
	        Scene scene = new Scene(contenedorP,  1530, 780);

	        scene.getStylesheets().add(//Añadimos una hoja de estilos a la escena
	                getClass().getResource("/TareaFinCurso/GestionCurriculoDocente/View/Css/app_registrar2.css")
	                        .toExternalForm()
	            );
	        return  scene;//Retornamos la escena
    }
	  
	  
	  
	  public  Scene EscenaRegistroCapacitacionImpartida(Stage stage,  App app) {


			
	  	  Integer cantidad = MostrarModal.mostrarVentana("Ingrese la cantidad de capacitaciones que ha impartido");
	  	  
	  	if (cantidad==0) {
	  		capacitacionesImpartidas.clear();
	  		capacitaciones.addAll(capacitacionesImpartidas);
    	    pasarCapacitacion();
			
			return app.getVentanaProduccion().EscenaRegistroInvestigaciones(stage, app);
		        
		  	  }
	  	  VBox contenedorP =  new VBox();
	  	ArrayList<CapacitacionImpartidaForm> formularios = new ArrayList<>();
		  
	        Button volver = new Button("Volver");
	        volver.setId("btn-volver2");  
	        volver.setOnAction(e -> {
	        	VentanaExperiencia ventanaExperiencia = new VentanaExperiencia();
	            stage.setScene(app.getVentanaCapacitacion(). EscenaRegistroCapacitacionRecibida(stage, app));
	        });

	        Button siguiente = new Button("Siguiente");
	        siguiente.setId("btn-siguiente2");
	        VBox vbox1 = new VBox();
	        vbox1.setId("vbox-btn-volver");
	        vbox1.setAlignment(Pos.TOP_LEFT);
	        vbox1.setMargin(volver, new Insets(10));
	        
	        VBox vbox2 = new VBox(10);
	        vbox2.setId("vbox-inputs");  
	        vbox2.setAlignment(Pos.CENTER);
	        vbox2.setId("inner");
	        
	        VBox vbox4 = new VBox();
	        vbox4.setId("vbox-btn-siguiente");
	     
	        
	        vbox1.getChildren().addAll(volver);
	        vbox1.setAlignment(Pos.TOP_LEFT);
	        vbox1.setMargin(volver, new Insets(10));
	        
	        vbox4.getChildren().addAll(siguiente);
	        vbox4.setAlignment(Pos.CENTER);
	        vbox4.setMargin(volver, new Insets(10));
	        
	       
	        for (int i = 1; i <= cantidad; i++) {
	        	
	        	    TextField institucion = new TextField();
	        	    TextField tipoEvento = new TextField();
	        	    TextField numHoras = new TextField();
	        	    TextField fechaIni = new TextField();
	        	    TextField fechaFin = new TextField();

	        	    VBox vbox = new VBox(5);
	        	    vbox.setAlignment(Pos.CENTER);
	        	    VBox.setMargin(vbox, new Insets(15, 0, 15, 0));
	        	    vbox.setId("back-inner");
	        	    vbox.getChildren().addAll(
	        	        new Label("Institución"), institucion,
	        	        new Label("Tipo de Evento"), tipoEvento,
	        	        new Label("Numero de Horas"), numHoras,
	        	        new Label("Fecha de Inicio"), fechaIni,
	        	        new Label("Fecha de Fin"), fechaFin
	        	    );

	        	    // Guardar referencias, NO valores
	        	    formularios.add(new CapacitacionImpartidaForm(institucion, tipoEvento, numHoras, fechaIni, fechaFin));

	        	    vbox2.getChildren().add(vbox);
	     
	        }
	        
	        ScrollPane scroll = new ScrollPane();
		    StackPane stackPane = new StackPane();
		    stackPane.setId("cont-inner");
		    stackPane.getChildren().add(vbox2);
		    stackPane.setAlignment(vbox2, Pos.CENTER);
		    scroll.setContent(stackPane);
		    scroll.setFitToWidth(true);
		    scroll.setPrefWidth(500);
		    scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		    scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
	        contenedorP.getChildren().addAll(vbox1,scroll, vbox4);
	        
	        
	        contenedorP.setId("fondo");
	        
	        siguiente.setOnAction(e -> {
	        	 capacitacionesImpartidas.clear();

	        	    for (CapacitacionImpartidaForm f : formularios) {

	        	        CapacitacionImpartida t = new CapacitacionImpartida(
	        	        		f.tipoEvento.getText(),
	        	        		f.institucion.getText(),
	        	            
	        	            f.fechaFin.getText(),
	        	            f.fechaIni.getText(),
	        	            Integer.parseInt(f.numHoras.getText())
	        	        );

	        	        capacitacionesImpartidas.add(t);
	        	        
	        	    }
	        	    capacitaciones.addAll(capacitacionesImpartidas);
	        	    pasarCapacitacion();
	        	    capacitacionesImpartidas.forEach(System.out::println);
	        	    
		            stage.setScene(app.getVentanaProduccion().EscenaRegistroInvestigaciones(stage, app));
	        	});
	        
	        Scene scene = new Scene(contenedorP,  1530, 780);
	        stage.setMaximized(true);
	        scene.getStylesheets().add(
	                getClass().getResource("/TareaFinCurso/GestionCurriculoDocente/View/Css/app_registrar2.css")
	                        .toExternalForm()
	            );
	        return  scene;
    }
	
	
	

	public static Integer mostrarVentana(String txt) {

        Stage ventana = new Stage();
        ventana.initModality(Modality.APPLICATION_MODAL);
        ventana.setTitle("Ingresar cantidad");
        ventana.setMinWidth(250);

        Label label = new Label(txt);
        TextField txtCantidad = new TextField();
        txtCantidad.setPromptText("Ej: 5");

        Button btnEnviar = new Button("Enviar");

        final Integer[] cantidad = new Integer[1];

        btnEnviar.setOnAction(e -> {
            try {
                cantidad[0] = Integer.parseInt(txtCantidad.getText());
                ventana.close();
            } catch (NumberFormatException ex) {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setHeaderText(null);
                alerta.setContentText("Ingrese un número válido");
                alerta.showAndWait();
            }
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(15));
        layout.getChildren().addAll(label, txtCantidad, btnEnviar);

        Scene scene = new Scene(layout);
        ventana.setScene(scene);
        ventana.showAndWait(); // Espera hasta que se cierre

        return cantidad[0];
    }
	
}
