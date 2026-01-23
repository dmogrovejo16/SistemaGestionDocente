package TareaFinCurso.GestionCurriculoDocente.View;

import java.util.ArrayList;

import TareaFinCurso.GestionCurriculoDocente.App;
import TareaFinCurso.GestionCurriculoDocente.Model.Capacitacion;
import TareaFinCurso.GestionCurriculoDocente.Model.CapacitacionImpartida;
import TareaFinCurso.GestionCurriculoDocente.Model.CapacitacionRecibida;
import TareaFinCurso.GestionCurriculoDocente.View.VentanaExperiencia.ExperienciaDocenteForm;
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

	
	 ArrayList<CapacitacionImpartida> capacitacionesImpartidas = new ArrayList<>();
	  ArrayList<CapacitacionRecibida> capacitacionesRecibidas = new ArrayList<>();
	  ArrayList<Capacitacion> capacitaciones = new ArrayList<>();
	  App app;
	  public void pasarCapacitacion() {
	        
	       
			app.getVentanaProduccion().usarCapacitacion(capacitaciones);  // Pasas la persona
	    }
	  
	  
	  
	  
	  public  Scene EscenaRegistroCapacitacionRecibida(Stage stage,  App app) {

this.app=app;
			
	  	  Integer cantidad = VentanaRegistrar.mostrarVentana("Ingrese la cantidad de capacitaciones que ha recibido");
	  	  
	if (cantidad==0) {
	  		
		capacitacionesRecibidas.clear();
		capacitaciones.addAll(capacitacionesRecibidas);
	  		return EscenaRegistroCapacitacionImpartida(stage, app);
	        
	  	  }
	  	  
	  	  VBox contenedorP =  new VBox();
	  	ArrayList<CapacitacionRecibidaForm> formularios = new ArrayList<>();
		  
	        Button volver = new Button("Volver");
	        volver.setId("btn-volver2");  
	        volver.setOnAction(e -> {
	        	VentanaExperiencia ventanaExperiencia = new VentanaExperiencia();
	            stage.setScene(app.getVentanaExperiencia().EscenaRegistroReferenciasLaborales(stage, app));
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
	        	    formularios.add(new CapacitacionRecibidaForm(institucion, tipoEvento, numHoras, fechaIni, fechaFin));

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
	        	 capacitacionesRecibidas.clear();

	        	    for (CapacitacionRecibidaForm f : formularios) {

	        	        CapacitacionRecibida t = new CapacitacionRecibida(
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
	        
	        Scene scene = new Scene(contenedorP,  1530, 1080);

	        scene.getStylesheets().add(
	                getClass().getResource("/TareaFinCurso/GestionCurriculoDocente/View/Css/app_registrar2.css")
	                        .toExternalForm()
	            );
	        return  scene;
    }
	  
	  
	  
	  public  Scene EscenaRegistroCapacitacionImpartida(Stage stage,  App app) {


			
	  	  Integer cantidad = VentanaRegistrar.mostrarVentana("Ingrese la cantidad de capacitaciones que ha impartido");
	  	  
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
	        
	        Scene scene = new Scene(contenedorP,  1530, 1080);
	        stage.setMaximized(true);
	        scene.getStylesheets().add(
	                getClass().getResource("/TareaFinCurso/GestionCurriculoDocente/View/Css/app_registrar2.css")
	                        .toExternalForm()
	            );
	        return  scene;
    }
	
	public class CapacitacionImpartidaForm {
	    TextField tipoEvento;
	    TextField institucion;
	    TextField numHoras;
	    TextField fechaIni;
	    TextField fechaFin;

	    public CapacitacionImpartidaForm( 
	    		 TextField tipoEvento,
	    		 TextField institucion,
	    		 TextField numHoras,
	    		 TextField fechaIni,
	    		 TextField fechaFin) {
	        this.institucion = institucion;
	        this.tipoEvento = tipoEvento;
	        this.numHoras = numHoras;
	        this.fechaIni = fechaIni;
	        this.fechaFin = fechaFin;
	    }
	}
	
	public class CapacitacionRecibidaForm {
		TextField institucion;
		TextField tipoEvento;
		    TextField numHoras;
		    TextField fechaIni;
		    TextField fechaFin;

	    public CapacitacionRecibidaForm( 
	    		 TextField tipoEvento,
	    		 TextField institucion,
	    		 TextField numHoras,
	    		 TextField fechaIni,
	    		 TextField fechaFin) {
	        this.institucion = institucion;
	        this.tipoEvento = tipoEvento;
	        this.numHoras = numHoras;
	        this.fechaIni = fechaIni;
	        this.fechaFin = fechaFin;
	    }
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
