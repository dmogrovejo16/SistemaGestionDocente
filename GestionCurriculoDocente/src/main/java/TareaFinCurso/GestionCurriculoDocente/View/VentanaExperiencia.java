package TareaFinCurso.GestionCurriculoDocente.View;

import java.util.ArrayList;

import TareaFinCurso.GestionCurriculoDocente.App;
import TareaFinCurso.GestionCurriculoDocente.Controller.Components.ExperienciaDocenteForm;
import TareaFinCurso.GestionCurriculoDocente.Controller.Components.ExperienciaNoDocenteForm;
import TareaFinCurso.GestionCurriculoDocente.Controller.Components.MostrarModal;
import TareaFinCurso.GestionCurriculoDocente.Controller.Components.ReferenciasLaboralesForm;
import TareaFinCurso.GestionCurriculoDocente.Model.Experiencia;
import TareaFinCurso.GestionCurriculoDocente.Model.ExperienciaDocente;
import TareaFinCurso.GestionCurriculoDocente.Model.ExperienciaNoDocente;
import TareaFinCurso.GestionCurriculoDocente.Model.ReferenciaLaboral;
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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class VentanaExperiencia {
	//Creamos array list para ir guardando las experiencias ingresadas, junto con sus geters para encapsulacion
	   ArrayList<ExperienciaDocente> experienciasDocente = new ArrayList<>();
	  ArrayList<ExperienciaNoDocente> experienciasNoDocente = new ArrayList<>();
    ArrayList<ReferenciaLaboral> referenciasLaborales = new ArrayList<>();
    
    ArrayList<Experiencia> experiencia = new ArrayList<>();
	App app;
    ExperienciaDocenteForm experienciaDocenteForm;
    ExperienciaNoDocenteForm experienciaNoDocenteForm;
    ReferenciasLaboralesForm referenciasLaboralesForm;
    public void pasarExperiencia() {
       
        app.getVentanaProduccion().usarExperiencia(experiencia);  // Pasas la persona
    }
    
	public  Scene EscenaRegistroExperienciaDocente(Stage stage, App app) {//Escena para ingresar las experiencias docentes
		 experiencia.clear();
this.app=app;
		
	  	  Integer cantidad = MostrarModal.mostrarVentana("Ingrese la cantidad de trabajos como decente que presenta");//Mostramos el cuadro de
	  	  //dialogo para obtener la cantidad de formularios a generar o para pasar a la sigiuente
	  	  
	  	 if (cantidad==0) {//Si no tiene experiencia docente, cabiamos a la siguiente escena
		  		
	  		experienciasDocente.clear();
	  		experiencia.addAll(experienciasDocente);
	  		return EscenaRegistroExperienciaNoDocente(stage,  app);
	        
	  	  }
	  	  VBox contenedorP =  new VBox();
	  	ArrayList<ExperienciaDocenteForm> formularios = new ArrayList<>();//ArrayList para guardar los formularios
		  
	        Button volver = new Button("Volver");//Creamos un boton para volver y definimos su accion
	        volver.setId("btn-volver2");  
	        volver.setOnAction(e -> {
	        	 experiencia.clear();
	        	
	            stage.setScene(app.getVentanaRegistrar().EscenaRegistro4(stage, app));
	        });

	        Button siguiente = new Button("Siguiente");//Creamos un boton de siguiente y le asinamos un id para los estilos
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
	        
	       
	        for (int i = 1; i <= cantidad; i++) {//Creamos formularios segun la cantidad de capacitaciones que ha recibido
	        	
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

	        	    // Guardar los formularios en el array de formularios 
	        	    formularios.add(new ExperienciaDocenteForm(institucion, catedra, fechaIni, fechaFin));

	        	    vbox2.getChildren().add(vbox);
	     
	        }
	      //Creamos un panel scrolleable para mostra x cantida de formularios 
	        ScrollPane scroll = new ScrollPane();
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
	        	 experienciasDocente.clear();

	        	    for (ExperienciaDocenteForm f : formularios) {//Por cada formulario creado, sus valores los vamos pasando al array de capacitaciones
	        	    	//con el objetivo de depues para el array de capacitaciones y crear el objeto docente

	        	        ExperienciaDocente t = new ExperienciaDocente(
	        	        		//Obtenemos los valores de todos los  texts
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
	        
	        Scene scene = new Scene(contenedorP,  1530, 780);//Definimos a la scena con un tamaño fijo
	        stage.setMaximized(true);
	        scene.getStylesheets().add(//Añadimos una hoja de estilos a la escena
	                getClass().getResource("/TareaFinCurso/GestionCurriculoDocente/View/Css/app_registrar2.css")
	                        .toExternalForm()
	            );
	        return  scene;//Retornamos la escena
    }
	
	
	
	public  Scene EscenaRegistroExperienciaNoDocente(Stage stage, App app) {

		stage.setMaximized(true);
		
	  	  Integer cantidad = MostrarModal.mostrarVentana("Ingrese la cantidad de trabajos no-docente que presenta");
	  	  
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
	        
	        Scene scene = new Scene(contenedorP,  1530, 780);

	        scene.getStylesheets().add(
	                getClass().getResource("/TareaFinCurso/GestionCurriculoDocente/View/Css/app_registrar2.css")
	                        .toExternalForm()
	            );
	        return  scene;
  }
	
	
	public  Scene EscenaRegistroReferenciasLaborales(Stage stage,  App app) {

		stage.setMaximized(true);
		
	  	  Integer cantidad = MostrarModal.mostrarVentana("Ingrese la cantidad de referencias laborales que presenta");
	  	  
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
		    StackPane stackPane = new StackPane();
		    stackPane.setId("cont-inner");
		    stackPane.getChildren().add(vbox2);
		    stackPane.setAlignment(vbox2, Pos.CENTER);
		    scroll.setContent(stackPane);
		    scroll.setFitToWidth(true);
		    scroll.setPrefWidth(500);
		    scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		    scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
	        
		    // Se arma la estructura principal de la escena
		    contenedorP.getChildren().addAll(vbox1, scroll, vbox4);
		    contenedorP.setFillWidth(true);
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
	        
	        Scene scene = new Scene(contenedorP,  1530, 780);

	        scene.getStylesheets().add(
	                getClass().getResource("/TareaFinCurso/GestionCurriculoDocente/View/Css/app_registrar2.css")
	                        .toExternalForm()
	            );
	        return  scene;
  }
	
	
	

	

	
	
	 
	  
	  
	
}
