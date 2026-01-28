package TareaFinCurso.GestionCurriculoDocente.View;



import java.util.ArrayList;

import TareaFinCurso.GestionCurriculoDocente.App;
import TareaFinCurso.GestionCurriculoDocente.Controller.Components.MostrarModal;
import TareaFinCurso.GestionCurriculoDocente.Controller.Components.TituloForm;
import TareaFinCurso.GestionCurriculoDocente.Model.Persona;
import TareaFinCurso.GestionCurriculoDocente.Model.Titulo;
import TareaFinCurso.GestionCurriculoDocente.Model.TituloCuartoNivel;
import TareaFinCurso.GestionCurriculoDocente.Model.TituloSegundoNivel;
import TareaFinCurso.GestionCurriculoDocente.Model.TituloTercerNivel;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class VentanaRegistrar{
	///Creamos arraylist para guardar la informacion de los diferentes tipos de titulos
	  ArrayList<TituloCuartoNivel> carrerasSeleccionadas4 = new ArrayList<>();
	  ArrayList<TituloTercerNivel> carrerasSeleccionadas3 = new ArrayList<>();
    ArrayList<TituloSegundoNivel> carrerasSeleccionadas2 = new ArrayList<>();
    ArrayList<Titulo> carreras = new ArrayList<>();
    //Creamos un persona para poder agregarle sus atributos
   public Persona persona = new Persona();
   private App app; //Creamos un objeto de app pero no lo inicializamos
   
   public void pasarPersona() { //Metodos para pasar los arrays y el objeto persona
       System.out.println(persona.getApellidos());
       app.getVentanaProduccion().usarPersona(persona);  
   }
   
   public void pasarTitulos() {
       app.getVentanaProduccion().usarTitulo(carreras);  
   }
	
	  public  Scene EscenaRegistro(Stage stage, App app) { //Creamos un metodo de devuelve una ecena, como parametro tiene el escenario donde tiene que mostrarse y la instancia de la clase App
		 this.app=app;
	        Button volver = new Button("Volver"); //Creamos botones, contenedores verticales y contenedores horizontales, con sus respectivos ID para estilos
	        volver.setId("btn-volver");
	        Button siguiente = new Button("Siguiente");
	        siguiente.setId("btn-siguiente");
	        VBox vbox1 = new VBox();
	        vbox1.setId("vbox-btn-volver");
	        VBox vbox4 = new VBox();
	        vbox4.setId("vbox-btn-siguiente");
	        
	       
	        VBox vbox2 = new VBox(10);
	        vbox2.setId("vbox-inputs");  
	        VBox vbox3 = new VBox(10);
	        vbox3.setId("vbox-inputs");
	        HBox hbox1 = new HBox(20, vbox2,vbox3);
	        hbox1.setAlignment(Pos.CENTER);

	        HBox containerH = new HBox();
	        containerH.setId("containerH");
	        
	        
	        VBox imagen = new VBox();
	        imagen.setId("imagen");
	        
	        
	        containerH.getChildren().addAll(hbox1,imagen);//Añadimos los elementos a lso contenedores
	        containerH.setAlignment(Pos.CENTER);//Decimos que se alinean en el centro
	        
        TextField nombres = new TextField();//Creamos recuadros para que el usuario ingrese textos de los atributos con su repectivo ID para disenos
	        nombres.setId("nombres");
	        TextField apellidos = new TextField();
	        TextField fechaNac = new TextField();
	        fechaNac.setPromptText("13-01-2007");
	        TextField cedula = new TextField();
	        TextField nacionalidad = new TextField();
	        TextField estadoCivil = new TextField();
	        ComboBox<String> tipoSangre = new ComboBox<>(); //Creamos un menu desplegable paraa ingresar el tipo de sangre
	        tipoSangre.getItems().addAll(
	            "O+",
	            "O-",
	            "A+",
	            "A-",
	            "B",
	            "B-",
	            "AB+",
	            "AB-"
	        );
	        tipoSangre.setPromptText("Tipo de sangre");
	        TextField ciudadNac = new TextField();
	        TextField direccion = new TextField();
	        TextField telefonoCel = new TextField();
	        TextField telefonoConv = new TextField();
	        TextField correo = new TextField();
	        
	        Label nombresl = new Label("Nombres"); //Creamos etiquetas para indicar al usuario que informacion debe ingresar
	        Label apellidosl = new Label("Apellidos");
	        Label fechaNacl = new Label("Fecha de Nacimiento");
	        Label cedulal = new Label("Numero de Cédula");
	        Label nacionalidadl= new Label("Nacionalidad");
	        Label estadoCivill = new Label("Estado Civil");
	        Label tipoSangrel = new Label("Tipo de Sangre");
	        Label ciudadNacl= new Label("Ciudad de Nacimiento");
	        Label direccionl= new Label("Direccion Actual");
	        Label telefonoCell = new Label("Telefono Celular");
	        Label telefonoConvl = new Label("Telefono Convencional");
	        Label correol = new Label("Correo Electronico");
	        
	        vbox1.getChildren().addAll(volver); //Añadimos elementos a los contenedores
	        vbox1.setAlignment(Pos.TOP_LEFT);//Alineacion al centro
	        vbox1.setMargin(volver, new Insets(10));//Definimos un margen para el boton
	        
	        vbox4.getChildren().addAll(siguiente);
	        vbox4.setAlignment(Pos.CENTER);
	        vbox4.setMargin(volver, new Insets(10));
	        

	        vbox2.getChildren().addAll(nombresl,nombres,apellidosl,apellidos,fechaNacl,fechaNac,cedulal,cedula,nacionalidadl,nacionalidad,estadoCivill, estadoCivil);
	        vbox2.setAlignment(Pos.CENTER);
	        vbox2.setSpacing(10);//Definimos un espaciado entre los elementos del contenedor
	        
	        vbox3.getChildren().addAll(tipoSangrel,tipoSangre,ciudadNacl,ciudadNac, direccionl,direccion, telefonoCell,telefonoCel,  telefonoConvl,telefonoConv, correol,correo);
	        vbox3.setAlignment(Pos.CENTER);
	        vbox3.setSpacing(10);//Definimos un espaciado entre los elementos del contenedor
	        
	        volver.setOnAction(e -> { //Funcion lambda para cuando el boton sea presionado
	        	
	            stage.setScene(app.EscenaPrincipal(stage));//Cambio de escena
	            stage.setMaximized(true);
	            
	        });

	        siguiente.setOnAction(e -> {//Funcion lambda para cuando el boton siguiente sea presionado
	        	//Inicializamos el objeto persona con los atributos y la pasamos los datos
	        	
	        	 if (nombres.getText().isEmpty()|| apellidos.getText().isEmpty()||
	        			 fechaNac.getText().isEmpty()||nacionalidad.getText().isEmpty()|| 
	        			 estadoCivil.getText().isEmpty() ||tipoSangre.getValue().isEmpty()||
	        			 ciudadNac.getText().isEmpty()||direccion.getText().isEmpty() ||correo.getText().isEmpty()||
	        			 cedula.getText().isEmpty()|| telefonoCel.getText().isEmpty()||
	        			 telefonoConv.getText().isEmpty()){//Validamos que los campos este completo
	        		 MostrarModal.mostrarError("Los campos no pueden estar vacíos");
	        	        return;
	        	    }

	        	    //Validamos que solo contenga números
	        	    if (!cedula.getText().matches("\\d+")) {
	        	    	MostrarModal.mostrarError("El campo CEDULA solo debe contener números");
	        	        return;
	        	    }
	        	    
	        	    if (!telefonoCel.getText().matches("\\d+")) {
	        	    	MostrarModal.mostrarError("El campo TELEFONO CELULAR solo debe contener números");
	        	        return;
	        	    }
	        	    
	        	    if (!telefonoConv.getText().matches("\\d+")) {
	        	    	MostrarModal.mostrarError("El campo TELEFONO CONVENCIONAL solo debe contener números");
	        	        return;
	        	    }
	        	    
	        	    //Definimos una expresion que valide el correo con su dominio y el @
	        	    if (!correo.getText().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
	        	    	MostrarModal.mostrarError("El campo CORREO debe estar en el formato correcto");
	        	    	return;
	        	    }
	        	    //Definimos una expresion que valide la fecha en el formato 
	        	    if (!fechaNac.getText().matches(
	        	            "^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-(19|20)\\d\\d$"
	        	    	    )) {
	        	    	MostrarModal.mostrarError("El campo FECHA debe estar en el formato correcto");
	        	    	return;
	        	    }
	        	
	        	persona = new Persona (nombres.getText(), apellidos.getText(), fechaNac.getText(),nacionalidad.getText(), estadoCivil.getText(), tipoSangre.getValue(), ciudadNac.getText(),direccion.getText() ,correo.getText(),Integer.parseInt(cedula.getText()), Integer.parseInt(telefonoCel.getText()),Integer.parseInt(telefonoConv.getText()));
	        	System.out.println(persona.getApellidos());
	        	pasarPersona();
	        	
	            stage.setScene(EscenaRegistro2(stage, app));
	            stage.setMaximized(true);
	        });
	        
	        StackPane fondo = new StackPane();//Apliador de elementos
	        fondo.setId("fondo");

	        VBox contenido = new VBox(20, vbox1, containerH, vbox4);

	        fondo.getChildren().add(contenido);

	        Scene scene = new Scene(fondo, 1530, 900); //Definimos una escena con un tamaño fijo
	        
	        scene.getStylesheets().add( //Añadimos hojas de estilo a la escena
	                getClass().getResource("/TareaFinCurso/GestionCurriculoDocente/View/Css/app_registrar.css")
	                        .toExternalForm()
	            );
	        stage.setMaximized(true);
	        return  scene;
	    }

	
      
	  public Scene EscenaRegistro2(Stage stage, App app) {

		    // Muestra una ventana modal pidiendo la cantidad de títulos de segundo nivel
		    Integer cantidad = MostrarModal.mostrarVentana(
		            "Ingrese su cantidad de titulos de segundo nivel"
		    );

		    // Si el usuario ingresa 0, no se crean formularios
		    // Se limpia la lista y se pasa directamente a la siguiente escena
		    if (cantidad == 0) {
		        carrerasSeleccionadas2.clear();               // Limpia títulos de segundo nivel
		        carreras.addAll(carrerasSeleccionadas2);      // Agrega (vacío) a la lista general
		        return EscenaRegistro3(stage, app);            // Pasa a la escena de tercer nivel
		    }

		    // Contenedor principal vertical
		    VBox contenedorP = new VBox();

		    // Lista para guardar los formularios creados dinámicamente
		    ArrayList<TituloForm> formularios = new ArrayList<>();

		    // Botón Volver
		    Button volver = new Button("Volver");
		    volver.setId("btn-volver2");
		    volver.setOnAction(e -> {
		        // Regresa a la primera escena de registro
		        stage.setScene(app.getVentanaRegistrar().EscenaRegistro(stage, app));
		        stage.setMaximized(true);
		    });

		    // Botón Siguiente
		    Button siguiente = new Button("Siguiente");
		    siguiente.setId("btn-siguiente2");

		    // VBox que contiene el botón Volver
		    VBox vbox1 = new VBox();
		    vbox1.setId("vbox-btn-volver");
		    vbox1.setAlignment(Pos.TOP_LEFT);
		    vbox1.setMargin(volver, new Insets(10));

		    // VBox donde se agregan los formularios
		    VBox vbox2 = new VBox(10);
		    vbox2.setAlignment(Pos.CENTER);
		    vbox2.setId("inner");

		    // VBox que contiene el botón Siguiente
		    VBox vbox4 = new VBox();
		    vbox4.setId("vbox-btn-siguiente");

		    // Se agregan los botones a sus contenedores
		    vbox1.getChildren().addAll(volver);
		    vbox4.getChildren().addAll(siguiente);
		    vbox4.setAlignment(Pos.CENTER);
		    vbox4.setMargin(volver, new Insets(10));

		    // Se crean tantos formularios como indique el usuario
		    for (int i = 1; i <= cantidad; i++) {

		        // Campo de texto para la institución
		        TextField institucion = new TextField();

		        // ComboBox para seleccionar el título
		        ComboBox<String> titulo = new ComboBox<>();
		        titulo.getItems().addAll(
		                "Tecnología en Desarrollo de Software",
		                "Tecnología en Sistemas de Información",
		                "Tecnología en Redes y Telecomunicaciones",
		                "Tecnología en Análisis de Datos",
		                "Tecnología en Ciberseguridad",
		                "Tecnología en Electrónica",
		                "Tecnología en Electricidad",
		                "Tecnología en Mecánica Industrial",
		                "Tecnología en Automatización Industrial",
		                "Tecnología en Contabilidad",
		                "Tecnología en Administración de Empresas",
		                "Tecnología en Marketing Digital",
		                "Tecnología en Diseño Gráfico",
		                "Tecnología en Logística y Transporte",
		                "Tecnología en Gastronomía"
		        );
		        titulo.setPromptText("Seleccione un título");

		        // Campos de ciudad y fecha
		        TextField ciudad = new TextField();
		        TextField fecha = new TextField();

		        // VBox que agrupa un formulario individual
		        VBox vbox = new VBox(5);
		        vbox.setId("back-inner");
		        vbox.setAlignment(Pos.CENTER);
		        VBox.setMargin(vbox, new Insets(15, 0, 15, 0));

		        // Se agregan las etiquetas y campos al formulario
		        vbox.getChildren().addAll(
		                new Label("Institución"), institucion,
		                new Label("Titulo Segundo Nivel"), titulo,
		                new Label("Ciudad"), ciudad,
		                new Label("Fecha de Grado"), fecha
		        );

		        // Se guardan las referencias a los campos (no los valores aún)
		        formularios.add(new TituloForm(institucion, titulo, ciudad, fecha));

		        // Se agrega el formulario al contenedor principal
		        vbox2.getChildren().add(vbox);
		    }

		    // ScrollPane para permitir desplazamiento vertical
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

		    // Se arma la estructura final de la escena
		    contenedorP.getChildren().addAll(vbox1, scroll, vbox4);
		    contenedorP.setId("fondo");

		    // Acción del botón Siguiente
		    siguiente.setOnAction(e -> {

		        // Limpia la lista antes de volver a llenarla
		        carrerasSeleccionadas2.clear();

		        // Recorre cada formulario y crea los objetos TituloSegundoNivel
		        for (TituloForm f : formularios) {

		            TituloSegundoNivel t = new TituloSegundoNivel(
		                    f.institucion.getText(),
		                    f.titulo.getValue(),
		                    f.ciudad.getText(),
		                    f.fecha.getText()
		            );

		            System.out.println(t.getCiudad());   // Debug
		            carrerasSeleccionadas2.add(t);       // Se guarda el título
		        }

		        // Se agregan los títulos a la lista general
		        carreras.addAll(carrerasSeleccionadas2);

		        // Muestra los títulos en consola
		        carrerasSeleccionadas2.forEach(System.out::println);

		        // Avanza a la siguiente escena
		        stage.setScene(EscenaRegistro3(stage, app));
		        stage.setMaximized(true);
		    });

		    // Se crea la escena
		    Scene scene = new Scene(contenedorP, 1530, 780);
		    stage.setMaximized(true);

		    // Se carga el CSS
		    scene.getStylesheets().add(
		            getClass().getResource(
		                    "/TareaFinCurso/GestionCurriculoDocente/View/Css/app_registrar2.css"
		            ).toExternalForm()
		    );

		    // Se retorna la escena
		    return scene;
		}


	  
	  
	  public Scene EscenaRegistro3(Stage stage, App app) {

		    // Maximiza la ventana
		    stage.setMaximized(true);

		    // Muestra una ventana modal para ingresar la cantidad de títulos de tercer nivel
		    Integer cantidad = MostrarModal.mostrarVentana(
		            "Ingrese su cantidad de titulos de tercer nivel"
		    );

		    // Si el usuario ingresa 0, no se crean formularios
		    // Se limpia la lista y se pasa directamente a la escena de cuarto nivel
		    if (cantidad == 0) {

		        carrerasSeleccionadas3.clear();              // Limpia la lista de títulos de tercer nivel
		        carreras.addAll(carrerasSeleccionadas3);     // Agrega (vacía) a la lista general
		        return EscenaRegistro4(stage, app);           // Avanza a la siguiente escena
		    }

		    // Contenedor principal vertical
		    VBox contenedorP = new VBox();

		    // Lista para almacenar los formularios creados dinámicamente
		    ArrayList<TituloForm> formularios = new ArrayList<>();

		    // Botón Volver
		    Button volver = new Button("Volver");
		    volver.setId("btn-volver2");
		    volver.setOnAction(e -> {
		        // Regresa a la primera escena de registro
		        stage.setScene(app.getVentanaRegistrar().EscenaRegistro(stage, app));
		        stage.setMaximized(true);
		    });

		    // Botón Siguiente
		    Button siguiente = new Button("Siguiente");
		    siguiente.setId("btn-siguiente2");

		    // VBox que contiene el botón Volver
		    VBox vbox1 = new VBox();
		    vbox1.setId("vbox-btn-volver");
		    vbox1.setAlignment(Pos.TOP_LEFT);
		    vbox1.setMargin(volver, new Insets(10));

		    // VBox donde se agregan los formularios de títulos
		    VBox vbox2 = new VBox(10);
		    vbox2.setId("vbox-inputs");
		    vbox2.setAlignment(Pos.CENTER);
		    vbox2.setId("inner");

		    // VBox que contiene el botón Siguiente
		    VBox vbox4 = new VBox();
		    vbox4.setId("vbox-btn-siguiente");

		    // Se agregan los botones a sus contenedores
		    vbox1.getChildren().addAll(volver);
		    vbox1.setAlignment(Pos.TOP_LEFT);
		    vbox1.setMargin(volver, new Insets(10));

		    vbox4.getChildren().addAll(siguiente);
		    vbox4.setAlignment(Pos.CENTER);
		    vbox4.setMargin(volver, new Insets(10));

		    // Se crean dinámicamente los formularios según la cantidad ingresada
		    for (int i = 1; i <= cantidad; i++) {

		        // Campo de texto para la institución
		        TextField institucion = new TextField();

		        // ComboBox para seleccionar el título de tercer nivel
		        ComboBox<String> titulo = new ComboBox<>();
		        titulo.getItems().addAll(
		                "Ingeniería de Sistemas",
		                "Medicina",
		                "Derecho",
		                "Administración de Empresas",
		                "Arquitectura",
		                "Ingeniería Civil",
		                "Psicología",
		                "Economía",
		                "Contabilidad",
		                "Comunicación Social",
		                "Ingeniería Industrial",
		                "Educación"
		        );
		        titulo.setPromptText("Seleccione un título");

		        // Campos de ciudad y fecha
		        TextField ciudad = new TextField();
		        TextField fecha = new TextField();

		        // VBox que agrupa un formulario individual
		        VBox vbox = new VBox(5);
		        vbox.setId("back-inner");
		        vbox.setAlignment(Pos.CENTER);
		        VBox.setMargin(vbox, new Insets(15, 0, 15, 0));

		        // Se agregan etiquetas y campos al formulario
		        vbox.getChildren().addAll(
		                new Label("Institución"), institucion,
		                new Label("Titulo Tercer Nivel"), titulo,
		                new Label("Ciudad"), ciudad,
		                new Label("Fecha de Grado"), fecha
		        );

		        // Se guardan las referencias de los campos (no los valores aún)
		        formularios.add(new TituloForm(institucion, titulo, ciudad, fecha));

		        // Se agrega el formulario al contenedor principal
		        vbox2.getChildren().add(vbox);
		    }

		    // ScrollPane para permitir desplazamiento vertical
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
		    contenedorP.setId("fondo");

		    // Acción del botón Siguiente
		    siguiente.setOnAction(e -> {

		        // Limpia la lista antes de volver a llenarla
		        carrerasSeleccionadas3.clear();

		        // Recorre cada formulario y crea los objetos TituloTercerNivel
		        for (TituloForm f : formularios) {

		            TituloTercerNivel t = new TituloTercerNivel(
		                    f.institucion.getText(),
		                    f.titulo.getValue(),
		                    f.ciudad.getText(),
		                    f.fecha.getText()
		            );

		            // Agrega el título a la lista de títulos de tercer nivel
		            carrerasSeleccionadas3.add(t);
		        }

		        // Se agregan los títulos a la lista general
		        carreras.addAll(carrerasSeleccionadas3);

		        // Imprime los títulos en consola (debug)
		        carrerasSeleccionadas3.forEach(System.out::println);

		        // Avanza a la escena de cuarto nivel
		        stage.setScene(EscenaRegistro4(stage, app));
		        stage.setMaximized(true);
		    });

		    // Se crea la escena
		    Scene scene = new Scene(contenedorP, 1530, 780);

		    // Se carga el archivo CSS
		    scene.getStylesheets().add(
		            getClass().getResource(
		                    "/TareaFinCurso/GestionCurriculoDocente/View/Css/app_registrar2.css"
		            ).toExternalForm()
		    );

		    // Se retorna la escena
		    return scene;
		}

	  
	  public Scene EscenaRegistro4(Stage stage, App app) {

		    // Maximiza la ventana
		    stage.setMaximized(true);

		    // Muestra una ventana modal para ingresar la cantidad de títulos de cuarto nivel
		    Integer cantidad = MostrarModal.mostrarVentana(
		            "Ingrese su cantidad de titulos de cuartos nivel"
		    );

		    // Si el usuario ingresa 0, no se crean formularios
		    // Se limpian los títulos de cuarto nivel y se continúa con el flujo
		    if (cantidad == 0) {

		        carrerasSeleccionadas4.clear();              // Limpia la lista de títulos de cuarto nivel
		        carreras.addAll(carrerasSeleccionadas3);     // Agrega los títulos anteriores a la lista general
		        pasarTitulos();                              // Pasa los títulos a la siguiente ventana
		        return app.getVentanaExperiencia()
		                  .EscenaRegistroExperienciaDocente(stage, app); // Avanza a la escena de experiencia
		    }

		    // Contenedor principal vertical
		    VBox contenedorP = new VBox();

		    // ArrayList para almacenar los formularios creados dinámicamente
		    ArrayList<TituloForm> formularios = new ArrayList<>();

		    // Botón Volver
		    Button volver = new Button("Volver");
		    volver.setId("btn-volver2");
		    volver.setOnAction(e -> {
		        // Regresa a la primera escena de registro
		        stage.setScene(app.getVentanaRegistrar().EscenaRegistro(stage, app));
		        stage.setMaximized(true);
		    });

		    // Botón Siguiente
		    Button siguiente = new Button("Siguiente");
		    siguiente.setId("btn-siguiente2");

		    // VBox que contiene el botón Volver
		    VBox vbox1 = new VBox();
		    vbox1.setId("vbox-btn-volver");
		    vbox1.setAlignment(Pos.TOP_LEFT);
		    vbox1.setMargin(volver, new Insets(10));

		    // VBox donde se agregan los formularios de títulos
		    VBox vbox2 = new VBox(10);
		    vbox2.setId("vbox-inputs");
		    vbox2.setAlignment(Pos.CENTER);
		    vbox2.setId("inner");

		    // VBox que contiene el botón Siguiente
		    VBox vbox4 = new VBox();
		    vbox4.setId("vbox-btn-siguiente");

		    // Se agregan los botones a sus respectivos contenedores
		    vbox1.getChildren().addAll(volver);
		    vbox1.setAlignment(Pos.TOP_LEFT);
		    vbox1.setMargin(volver, new Insets(10));

		    vbox4.getChildren().addAll(siguiente);
		    vbox4.setAlignment(Pos.CENTER);
		    vbox4.setMargin(volver, new Insets(10));

		    // Se crean dinámicamente los formularios según la cantidad ingresada
		    for (int i = 1; i <= cantidad; i++) {

		        // Campo de texto para la institución
		        TextField institucion = new TextField();

		        // ComboBox para seleccionar el título de cuarto nivel
		        ComboBox<String> titulo = new ComboBox<>();
		        titulo.getItems().addAll(
		                "Doctorado en Ciencias de la Computación",
		                "Doctorado en Ingeniería de Software",
		                "Doctorado en Inteligencia Artificial",
		                "Doctorado en Administración de Empresas",
		                "Doctorado en Educación",
		                "Doctorado en Psicología",
		                "Doctorado en Derecho",
		                "Doctorado en Economía",
		                "Doctorado en Ciencias Sociales",
		                "Maestría en Gestión de Proyectos",
		                "Maestría en Seguridad Informática",
		                "Maestría en Análisis de Datos",
		                "Maestría en Marketing Digital",
		                "Maestría en Finanzas",
		                "Maestría en Recursos Humanos",
		                "Maestría en Educación Superior",
		                "Maestría en Ingeniería Industrial",
		                "Maestría en Comercio Internacional",
		                "Maestría en Desarrollo de Software",
		                "Maestría en Auditoría y Contabilidad"
		        );
		        titulo.setPromptText("Seleccione un título");

		        // Campos para ciudad y fecha de grado
		        TextField ciudad = new TextField();
		        TextField fecha = new TextField();

		        // VBox que agrupa un formulario individual
		        VBox vbox = new VBox(5);
		        vbox.setId("back-inner");
		        VBox.setMargin(vbox, new Insets(15, 0, 15, 0));

		        // Se agregan etiquetas y campos al formulario
		        vbox.getChildren().addAll(
		                new Label("Institución"), institucion,
		                new Label("Titulo Tercer Nivel"), titulo,
		                new Label("Ciudad"), ciudad,
		                new Label("Fecha de Grado"), fecha
		        );

		        vbox.setAlignment(Pos.CENTER);

		        // Guardar referencias de los campos, no los valores aún
		        formularios.add(new TituloForm(institucion, titulo, ciudad, fecha));

		        // Se agrega el formulario al contenedor principal
		        vbox2.getChildren().add(vbox);
		        
		    }

		    // ScrollPane para permitir desplazamiento vertical
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

		    // Acción del botón Siguiente
		    siguiente.setOnAction(e -> {

		        // Limpia la lista antes de volver a llenarla
		        carrerasSeleccionadas4.clear();

		        // Recorre los formularios y crea los objetos TituloCuartoNivel
		        for (TituloForm f : formularios) {

		            TituloCuartoNivel t = new TituloCuartoNivel(
		                    f.institucion.getText(),
		                    f.titulo.getValue(),
		                    f.ciudad.getText(),
		                    f.fecha.getText()
		            );

		            // Agrega el título a la lista de cuarto nivel
		            carrerasSeleccionadas4.add(t);
		        }

		        // Se agregan los títulos a la lista general
		        carreras.addAll(carrerasSeleccionadas4);

		        // Se pasan los títulos a la siguiente ventana
		        pasarTitulos();

		        // Se imprime en consola para depuración
		        carrerasSeleccionadas4.forEach(System.out::println);

		        // Se avanza a la escena de experiencia docente
		        stage.setScene(
		                app.getVentanaExperiencia()
		                   .EscenaRegistroExperienciaDocente(stage, app)
		        );
		        stage.setMaximized(true);
		    });

		    // Se crea la escena
		    Scene scene = new Scene(contenedorP, 1530, 780);

		    // Se carga la hoja de estilos CSS
		    scene.getStylesheets().add(
		            getClass().getResource(
		                    "/TareaFinCurso/GestionCurriculoDocente/View/Css/app_registrar2.css"
		            ).toExternalForm()
		    );

		    // Se retorna la escena
		    return scene;
		}

	  
	  
	  
}
