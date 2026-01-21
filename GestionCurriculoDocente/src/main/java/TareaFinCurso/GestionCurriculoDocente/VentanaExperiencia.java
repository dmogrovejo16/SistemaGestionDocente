package TareaFinCurso.GestionCurriculoDocente;

import java.util.ArrayList;

import TareaFinCurso.GestionCurriculoDocente.VentanaRegistrar.TituloForm;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class VentanaExperiencia {
	
	   ArrayList<ExperienciaDocente> experienciasDocente = new ArrayList<>();
	  ArrayList<ExperienciaNoDocente> experienciasNoDocente = new ArrayList<>();
    ArrayList<ReferenciaLaboral> referenciasLaborales = new ArrayList<>();
    
    ArrayList<Experiencia> experiencia = new ArrayList<>();
	App app;
    
    public void pasarExperiencia() {
       
        app.getVentanaProduccion().usarExperiencia(experiencia);  // Pasas la persona
    }
    
	public  Scene EscenaRegistroExperienciaDocente(Stage stage, App app) {
		 experiencia.clear();
this.app=app;
		
	  	  Integer cantidad = VentanaRegistrar.mostrarVentana("Ingrese la cantidad de trabajos como decente que presenta");
	  	  
	  	 if (cantidad==0) {
		  		
	  		experienciasDocente.clear();
	  		experiencia.addAll(experienciasDocente);
	  		return EscenaRegistroExperienciaNoDocente(stage,  app);
	        
	  	  }
	  	  VBox contenedorP =  new VBox();
	  	ArrayList<ExperienciaDocenteForm> formularios = new ArrayList<>();
		  
	        Button volver = new Button("Volver");
	        volver.setId("btn-volver2");  
	        volver.setOnAction(e -> {
	        	 experiencia.clear();
	        	
	            stage.setScene(app.getVentanaRegistrar().EscenaRegistro4(stage, app));
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
	        	    TextField catedra = new TextField();
	        	    TextField fechaIni = new TextField();
	        	    TextField fechaFin = new TextField();

	        	    VBox vbox = new VBox(5);
	        	    vbox.setId("back-inner");
	        	    vbox.setAlignment(Pos.CENTER);
	        	    VBox.setMargin(vbox, new Insets(15, 0, 15, 0));

	        	    vbox.getChildren().addAll(
	        	        new Label("Institución"), institucion,
	        	        new Label("Catedra"), catedra,
	        	        new Label("Fecha de Inicio"), fechaIni,
	        	        new Label("Fecha de Fin"), fechaFin
	        	    );

	        	    // Guardar referencias, NO valores
	        	    formularios.add(new ExperienciaDocenteForm(institucion, catedra, fechaIni, fechaFin));

	        	    vbox2.getChildren().add(vbox);
	     
	        }
	        
	        ScrollPane scroll = new ScrollPane();
	        scroll.setContent(vbox2);
	        scroll.setFitToWidth(true);
	        scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
	        scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
	        contenedorP.getChildren().addAll(vbox1,scroll, vbox4);
	        
	        
	       
	        contenedorP.setId("fondo");
	        siguiente.setOnAction(e -> {
	        	 experienciasDocente.clear();

	        	    for (ExperienciaDocenteForm f : formularios) {

	        	        ExperienciaDocente t = new ExperienciaDocente(
	        	            f.institucion.getText(),
	        	            f.catedra.getText(),
	        	            f.fechaIni.getText(),
	        	            f.fechaFin.getText()
	        	        );

	        	        experienciasDocente.add(t);
	        	    }
	        	    experiencia.addAll(experienciasDocente);
	        	    experienciasDocente.forEach(System.out::println);
	        	    

		            stage.setScene(EscenaRegistroExperienciaNoDocente(stage, app));
	        	});
	        
	        Scene scene = new Scene(contenedorP,  1530, 1080);
	        stage.setMaximized(true);
	        scene.getStylesheets().add(
	                getClass().getResource("/TareaFinCurso/GestionCurriculoDocente/app_registrar2.css")
	                        .toExternalForm()
	            );
	        return  scene;
    }
	
	
	
	public  Scene EscenaRegistroExperienciaNoDocente(Stage stage, App app) {

		stage.setMaximized(true);
		
	  	  Integer cantidad = VentanaRegistrar.mostrarVentana("Ingrese la cantidad de trabajos no-docente que presenta");
	  	  
	  	if (cantidad==0) {
	  		
	  		experienciasNoDocente.clear();
	  		experiencia.addAll(experienciasNoDocente);
	  		return EscenaRegistroReferenciasLaborales(stage,  app);
	        
	  	  }
	  	  
	  	  VBox contenedorP =  new VBox();
	  	ArrayList<ExperienciaNoDocenteForm> formularios = new ArrayList<>();
		  
	        Button volver = new Button("Volver");
	        volver.setId("btn-volver2");  
	        volver.setOnAction(e -> {
	        	VentanaRegistrar ventanaRegistrar = new VentanaRegistrar();
	            stage.setScene(app.getVentanaExperiencia().EscenaRegistroExperienciaDocente(stage, app));
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
	        	    TextField funcion = new TextField();
	        	    TextField fechaIni = new TextField();
	        	    TextField fechaFin = new TextField();

	        	    VBox vbox = new VBox(5);
	        	    vbox.setId("back-inner");
	        	    vbox.setAlignment(Pos.CENTER);
	        	    VBox.setMargin(vbox, new Insets(15, 0, 15, 0));

	        	    vbox.getChildren().addAll(
	        	        new Label("Institución"), institucion,
	        	        new Label("Funcion"), funcion,
	        	        new Label("Fecha de Inicio"), fechaIni,
	        	        new Label("Fecha de Fin"), fechaFin
	        	    );

	        	    // Guardar referencias, NO valores
	        	    formularios.add(new ExperienciaNoDocenteForm(institucion, funcion, fechaIni, fechaFin));

	        	    vbox2.getChildren().add(vbox);
	     
	        }
	        
	        ScrollPane scroll = new ScrollPane();
	        scroll.setContent(vbox2);
	        scroll.setFitToWidth(true);
	        scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
	        scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
	        contenedorP.getChildren().addAll(vbox1,scroll, vbox4);
	        
	        contenedorP.setId("fondo");
	       
	        
	        siguiente.setOnAction(e -> {
	        	 experienciasNoDocente.clear();

	        	    for (ExperienciaNoDocenteForm f : formularios) {

	        	        ExperienciaNoDocente t = new ExperienciaNoDocente(
	        	            f.institucion.getText(),
	        	            f.funcion.getText(),
	        	            f.fechaIni.getText(),
	        	            f.fechaFin.getText()
	        	        );

	        	        experienciasNoDocente.add(t);
	        	    }

	        	    experiencia.addAll(experienciasNoDocente);
	        	    experienciasNoDocente.forEach(System.out::println);
	        	    

		            stage.setScene(EscenaRegistroReferenciasLaborales(stage, app));
	        	});
	        
	        Scene scene = new Scene(contenedorP,  1530, 1080);

	        scene.getStylesheets().add(
	                getClass().getResource("/TareaFinCurso/GestionCurriculoDocente/app_registrar2.css")
	                        .toExternalForm()
	            );
	        return  scene;
  }
	
	
	public  Scene EscenaRegistroReferenciasLaborales(Stage stage,  App app) {

		stage.setMaximized(true);
		
	  	  Integer cantidad = VentanaRegistrar.mostrarVentana("Ingrese la cantidad de referencias laborales que presenta");
	  	  
	  	if (cantidad==0) {
	  		
	  		referenciasLaborales.clear();
	  		experiencia.addAll(referenciasLaborales);
	  		 pasarExperiencia();
	  		return app.getVentanaCapacitacion().EscenaRegistroCapacitacionRecibida(stage, app);
	        
	  	  }
	  	  
	  	  VBox contenedorP =  new VBox();
	  	ArrayList<ReferenciasLaboralesForm> formularios = new ArrayList<>();
		  
	        Button volver = new Button("Volver");
	        volver.setId("btn-volver2");  
	        volver.setOnAction(e -> {
	        	VentanaRegistrar ventanaRegistrar = new VentanaRegistrar();
	            stage.setScene(app.getVentanaExperiencia().EscenaRegistroExperienciaDocente(stage, app));
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
	        	    TextField jefeInmediato = new TextField();
	        	    TextField telefono = new TextField();

	        	    VBox vbox = new VBox(5);
	        	    vbox.setId("back-inner");
	        	    vbox.setAlignment(Pos.CENTER);
	        	    VBox.setMargin(vbox, new Insets(15, 0, 15, 0));

	        	    vbox.getChildren().addAll(
	        	        new Label("Institución"), institucion,
	        	        new Label("Jefe Inmediato"), jefeInmediato,
	        	        new Label("Telefono"), telefono

	        	    );

	        	    // Guardar referencias, NO valores
	        	    formularios.add(new ReferenciasLaboralesForm(institucion, jefeInmediato, telefono));

	        	    vbox2.getChildren().add(vbox);
	     
	        }
	        
	        ScrollPane scroll = new ScrollPane();
	        scroll.setContent(vbox2);
	        scroll.setFitToWidth(true);
	        scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
	        scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
	        contenedorP.getChildren().addAll(vbox1,scroll, vbox4);
	        
	        contenedorP.setId("fondo");
	       
	        
	        siguiente.setOnAction(e -> {
	        	 referenciasLaborales.clear();

	        	    for (ReferenciasLaboralesForm f : formularios) {

	        	        ReferenciaLaboral t = new ReferenciaLaboral(
	        	            f.institucion.getText(),
	        	            f.jefeInmediato.getText(),
	        	            f.telefono.getText()
	        	        );

	        	        referenciasLaborales.add(t);
	        	    }
	        	    experiencia.addAll(referenciasLaborales);
	        	    pasarExperiencia();
	        	    referenciasLaborales.forEach(System.out::println);
	        	    
		            stage.setScene(app.getVentanaCapacitacion().EscenaRegistroCapacitacionRecibida(stage, app));
	        	});
	        
	        Scene scene = new Scene(contenedorP,  1530, 1080);

	        scene.getStylesheets().add(
	                getClass().getResource("/TareaFinCurso/GestionCurriculoDocente/app_registrar2.css")
	                        .toExternalForm()
	            );
	        return  scene;
  }
	
	
	
	public class ExperienciaDocenteForm {
	    TextField institucion;
	    TextField catedra;
	    
	    TextField fechaIni;
	    TextField fechaFin;

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
	
	public class ExperienciaNoDocenteForm {
	    TextField institucion;
	    TextField funcion;
	    
	    TextField fechaIni;
	    TextField fechaFin;

	    public ExperienciaNoDocenteForm( 
	    TextField institucion,
	    TextField funcion,
	    TextField fechaIni,
	    TextField fechaFin) {
	        this.institucion = institucion;
	        this.funcion = funcion;
	        this.fechaIni = fechaIni;
	        this.fechaFin = fechaFin;
	    }
	}
	
	public class ReferenciasLaboralesForm {
	    TextField institucion;
	    TextField jefeInmediato;
	    TextField telefono;

	    public ReferenciasLaboralesForm( 
	    TextField institucion,
	    TextField jefeInmediato,
	    TextField telefono) {
	        this.institucion = institucion;
	        this.jefeInmediato = jefeInmediato;
	        this.telefono = telefono;
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
