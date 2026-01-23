package TareaFinCurso.GestionCurriculoDocente.View;

import java.util.ArrayList;

import TareaFinCurso.GestionCurriculoDocente.App;
import TareaFinCurso.GestionCurriculoDocente.Model.Capacitacion;
import TareaFinCurso.GestionCurriculoDocente.Model.Docente;
import TareaFinCurso.GestionCurriculoDocente.Model.Experiencia;
import TareaFinCurso.GestionCurriculoDocente.Model.Investigacion;
import TareaFinCurso.GestionCurriculoDocente.Model.Persona;
import TareaFinCurso.GestionCurriculoDocente.Model.ProduccionAcademica;
import TareaFinCurso.GestionCurriculoDocente.Model.Publicacion;
import TareaFinCurso.GestionCurriculoDocente.Model.Titulo;
import TareaFinCurso.GestionCurriculoDocente.View.VentanaCapacitacion.CapacitacionImpartidaForm;
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

public class VentanaProduccion {
	 ArrayList<Investigacion> investigaciones = new ArrayList<>();
	  ArrayList<Publicacion> publicaciones = new ArrayList<>();
		ArrayList<ProduccionAcademica> producciones = new ArrayList<>();

	  App app;
	  public Persona persona = new Persona();
	  public Docente docente = new Docente();
	  public ArrayList< Titulo> titulos = new ArrayList<>();
	  public ArrayList< Experiencia> experiencia = new ArrayList<>();
	  public ArrayList< Capacitacion> capacitaciones = new ArrayList<>();
	  
	  
	  
	  public  Scene EscenaRegistroInvestigaciones(Stage stage, App app) {
this.app=app;

			
	  	  Integer cantidad = VentanaRegistrar.mostrarVentana("Ingrese la cantidad de investigaciones que ha realizado");
	  	  
	    	if (cantidad==0) {
		  		
	    		investigaciones.clear();
	    		producciones.addAll(investigaciones);
				return EscenaRegistroPublicaciones(stage, app);
			        
			  	  }
	  	  
	  	  VBox contenedorP =  new VBox();
	  	ArrayList<InvestigacionForm> formularios = new ArrayList<>();
		  
	        Button volver = new Button("Volver");
	        volver.setId("btn-volver2");  
	        volver.setOnAction(e -> {
	        	VentanaCapacitacion ventanaExperiencia = new VentanaCapacitacion();
	            stage.setScene(app.getVentanaCapacitacion(). EscenaRegistroCapacitacionImpartida(stage, app));
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
	        	
	        	    TextField titulo = new TextField();
	        	    TextField institucion = new TextField();
	        	    TextField anio = new TextField();

	        	    VBox vbox = new VBox(5);
	        	    vbox.setAlignment(Pos.CENTER);
	        	    VBox.setMargin(vbox, new Insets(15, 0, 15, 0));
	        	    vbox.setId("back-inner");
	        	    vbox.getChildren().addAll(
	        	        new Label("Titulo de la Investigacion"), titulo,
	        	        new Label("Institucion"), institucion,
	        	        new Label("Año de invetigacion"), anio
	        	        
	        	    );

	        	    // Guardar referencias, NO valores
	        	    formularios.add(new InvestigacionForm(titulo, institucion, anio));

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
	        	 investigaciones.clear();

	        	    for (InvestigacionForm f : formularios) {

	        	        Investigacion t = new Investigacion(
	        	            f.titulo.getText(),
	        	           
	        	            Integer.parseInt(f.anio.getText()),
	        	            f.institucion.getText()
	        	        );

	        	        investigaciones.add(t);
	        	    }

	        	    investigaciones.forEach(System.out::println);
	        	    producciones.addAll(investigaciones);
	        	    

		            stage.setScene(EscenaRegistroPublicaciones(stage, app));
	        	});
	        
	        Scene scene = new Scene(contenedorP,  1530, 780);
	        stage.setMaximized(true);
	        scene.getStylesheets().add(
	                getClass().getResource("/TareaFinCurso/GestionCurriculoDocente/View/Css/app_registrar2.css")
	                        .toExternalForm()
	            );
	        return  scene;
    }
	  
	  
	  
	  public  Scene EscenaRegistroPublicaciones(Stage stage,  App app) {


			
	  	  Integer cantidad = VentanaRegistrar.mostrarVentana("Ingrese la cantidad de publicaciones que ha realizado");
	  	  
	  	if (cantidad==0) {
	  		
	  		publicaciones.clear();
	  		 producciones.addAll(publicaciones);
	  		docente = new Docente( persona.getNombres(),persona.getApellidos(), persona.getFechaNac(), 
    	    		persona.getNacionalidad(), persona.getEstadoCivil(), persona.getTipoSangre(), persona.getCiudadNac(), 
    	    		persona.getDireccion(), persona.getCorreo(),persona.getCedula(), persona.getTelefonoCel(), 
    	    		persona.getTelefonoConv(), capacitaciones, experiencia, titulos, producciones);
    	    
	  		app.getDocentes().add(docente);
   	     app.escribirDocente(docente);
    	    
    	    mostrarVentanaConf();
			return app.EscenaPrincipal(stage);
		        
		  	  }
	  	  
	  	  VBox contenedorP =  new VBox();
	  	ArrayList<PublicacionForm> formularios = new ArrayList<>();
		  
	        Button volver = new Button("Volver");
	        volver.setId("btn-volver2");  
	        volver.setOnAction(e -> {
	        	VentanaCapacitacion ventanaExperiencia = new VentanaCapacitacion();
	            stage.setScene(app.getVentanaProduccion().EscenaRegistroInvestigaciones(stage, app));
	        });

	        Button siguiente = new Button("Terminar");
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
	        	
	        	    TextField titulo = new TextField();
	        	    TextField editorial = new TextField();
	        	    TextField anio = new TextField();

	        	    VBox vbox = new VBox(5);
	        	    vbox.setAlignment(Pos.CENTER);
	        	    VBox.setMargin(vbox, new Insets(15, 0, 15, 0));
	        	    vbox.setId("back-inner");
	        	    vbox.getChildren().addAll(
	        	        new Label("Titulo de la Publicacion"), titulo,
	        	        new Label("Editorial"), editorial,
	        	        new Label("Año de invetigacion"), anio
	        	        
	        	    );

	        	    // Guardar referencias, NO valores
	        	    formularios.add(new PublicacionForm(titulo, editorial, anio));

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
	        	publicaciones.clear();

	        	    for (PublicacionForm f : formularios) {

	        	        Publicacion t = new Publicacion(
	        	            f.titulo.getText(),
	        	           
	        	            Integer.parseInt(f.anio.getText()),
	        	            f.editorial.getText()
	        	        );

	        	        publicaciones.add(t);
	        	    }

	        	    publicaciones.forEach(System.out::println);
	        	    
	        	    producciones.addAll(publicaciones);
	        	   
	        	    
	        	     docente = new Docente( persona.getNombres(),persona.getApellidos(), persona.getFechaNac(), 
	        	    		persona.getNacionalidad(), persona.getEstadoCivil(), persona.getTipoSangre(), persona.getCiudadNac(), 
	        	    		persona.getDireccion(), persona.getCorreo(),persona.getCedula(), persona.getTelefonoCel(), 
	        	    		persona.getTelefonoConv(), capacitaciones, experiencia, titulos, producciones);
	        	    
	        	    
	        	     app.getDocentes().add(docente);
	        	     app.escribirDocente(docente);
	        	    mostrarVentanaConf();
                    
	        	    
	        	    
		            stage.setScene(app.EscenaPrincipal(stage));
	        	});
	        
	        Scene scene = new Scene(contenedorP,  1530, 780);
	        stage.setMaximized(true);
	        scene.getStylesheets().add(
	                getClass().getResource("/TareaFinCurso/GestionCurriculoDocente/View/Css/app_registrar2.css")
	                        .toExternalForm()
	            );
	        return  scene;
    }
	  
	  
	  
	  public void usarPersona(Persona persona) {
		  System.out.println(persona.getApellidos());
	       this.persona = persona;
	    }
	  public void usarTitulo(ArrayList<Titulo> titulos) {
	       this.titulos = titulos;
	    }
	  public void usarExperiencia(ArrayList<Experiencia> experiencia) {
	       this.experiencia = experiencia;
	    }
	  public void usarCapacitacion(ArrayList<Capacitacion> capacitacion) {
	       this.capacitaciones = capacitacion;
	    }
	  
	  
	  
	  
	  
	  public class InvestigacionForm {
		    TextField titulo;
		    TextField institucion;
		    TextField anio;


		    public InvestigacionForm( 
		    		 TextField titulo,
		    		 TextField institucion,
		    		 TextField anio) {
		        this.institucion = institucion;
		        this.titulo = titulo;
		        this.anio = anio;

		    }
		}
	  
	  public class PublicacionForm {
		    TextField titulo;
		    TextField editorial;
		    TextField anio;


		    public PublicacionForm( 
		    		 TextField titulo,
		    		 TextField editorial,
		    		 TextField anio) {
		        this.editorial = editorial;
		        this.titulo = titulo;
		        this.anio = anio;

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
		
	  
	  public static void mostrarVentanaConf() {

	        Stage ventana = new Stage();
	        ventana.initModality(Modality.APPLICATION_MODAL);
	        ventana.setTitle("Registro Exitoso");
	        ventana.setMinWidth(250);

            Label label = new Label("El docente ha sido agregado con éxito!");
	        Button btnEnviar = new Button("Entendido");

	        btnEnviar.setOnAction(e -> {
	             
	                ventana.close();
	        });

	        VBox layout = new VBox(10);
	        layout.setPadding(new Insets(15));
	        layout.getChildren().addAll(label, btnEnviar);

	        Scene scene = new Scene(layout);
	        ventana.setScene(scene);
	        ventana.showAndWait(); // Espera hasta que se cierre

	    }
		
	  
	  
}
