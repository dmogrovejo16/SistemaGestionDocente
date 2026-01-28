package TareaFinCurso.GestionCurriculoDocente;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Optional;

import TareaFinCurso.*;
import TareaFinCurso.GestionCurriculoDocente.Controller.AccionEliminar;
import TareaFinCurso.GestionCurriculoDocente.Controller.FileController;
import TareaFinCurso.GestionCurriculoDocente.Model.Capacitacion;
import TareaFinCurso.GestionCurriculoDocente.Model.CapacitacionImpartida;
import TareaFinCurso.GestionCurriculoDocente.Model.CapacitacionRecibida;
import TareaFinCurso.GestionCurriculoDocente.Model.Docente;
import TareaFinCurso.GestionCurriculoDocente.Model.Experiencia;
import TareaFinCurso.GestionCurriculoDocente.Model.ExperienciaDocente;
import TareaFinCurso.GestionCurriculoDocente.Model.ExperienciaNoDocente;
import TareaFinCurso.GestionCurriculoDocente.Model.Investigacion;
import TareaFinCurso.GestionCurriculoDocente.Model.ProduccionAcademica;
import TareaFinCurso.GestionCurriculoDocente.Model.Publicacion;
import TareaFinCurso.GestionCurriculoDocente.Model.ReferenciaLaboral;
import TareaFinCurso.GestionCurriculoDocente.Model.Titulo;
import TareaFinCurso.GestionCurriculoDocente.View.VentanaActualizar;
import TareaFinCurso.GestionCurriculoDocente.View.VentanaCapacitacion;
import TareaFinCurso.GestionCurriculoDocente.View.VentanaDocentes;
import TareaFinCurso.GestionCurriculoDocente.View.VentanaExperiencia;
import TareaFinCurso.GestionCurriculoDocente.View.VentanaInformacionDocente;
import TareaFinCurso.GestionCurriculoDocente.View.VentanaProduccion;
import TareaFinCurso.GestionCurriculoDocente.View.VentanaRegistrar;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {
	//Creamos instancias de las ventanas para evitar perdidas de datos
	   private VentanaRegistrar ventanaRegistrar;
	   private VentanaExperiencia ventanaExperiencia;
	   private VentanaCapacitacion ventanaCapacitacion;
	   private VentanaProduccion ventanaProduccion;
	   private  VentanaInformacionDocente ventanaInformacionDocente;
	   private VentanaDocentes ventanaDocentes;
	   private static String rutaArchivo = "docentes.txt";
	   FileController fileController = new FileController();
	 public static String getRutaArchivo() {
		return rutaArchivo;
	}

	   public static void setRutaArchivo(String rutaArchivo) {
		   App.rutaArchivo = rutaArchivo;
	   }



	 static //Creamos el arrray de docentes
	   ArrayList<Docente> docentes = new ArrayList<>();
	   //Getters y setter para las instancias, poder llamarlas de cualquier clase
	   public VentanaRegistrar getVentanaRegistrar() {
	        return ventanaRegistrar;
	    }
	    
	    public VentanaExperiencia getVentanaExperiencia() {
	        return ventanaExperiencia;
	    }
	    
	    public VentanaCapacitacion getVentanaCapacitacion() {
	        return ventanaCapacitacion;
	    }
	    
	    public VentanaProduccion getVentanaProduccion() {
	        return ventanaProduccion;
	    }
	    
	    public static ArrayList<Docente> getDocentes() {
	        return docentes;
	    }
	    public VentanaDocentes getVentanaDocentes() {
			return ventanaDocentes;
		}

		   public void setVentanaDocentes(VentanaDocentes ventanaDocentes) {
			   this.ventanaDocentes = ventanaDocentes;
		   }
		
		   public VentanaInformacionDocente getVentanaInformacionDocente() {
				return ventanaInformacionDocente;
			}

			   public void setVentanaInformacionDocente(VentanaInformacionDocente ventanaInformacionDocente) {
				   this.ventanaInformacionDocente = ventanaInformacionDocente;
			   }
	    
    @Override
    public void start(Stage stage) {
        //Inicializamos variables
        ventanaProduccion = new VentanaProduccion();
        ventanaCapacitacion = new VentanaCapacitacion();
        ventanaExperiencia = new VentanaExperiencia();
        ventanaRegistrar = new VentanaRegistrar();
        ventanaDocentes = new VentanaDocentes();
        ventanaInformacionDocente = new VentanaInformacionDocente();
        //Llamamos al metodo para importar la lista de docentes a un array local
        System.out.println(new File(".").getAbsolutePath());
        fileController.cargarDocentes(rutaArchivo);
        //Inicializamos el escenario
        stage.setScene(EscenaPrincipal(stage));
        stage.setMaximized(true);
        stage.show();
    }


  
 

  
  

  
    public  Scene EscenaPrincipal(Stage stage) { //Creamos un metodo de devuelve una ecena, como parametro tiene el escenario donde tiene que mostrarse
    	 
  
    	
        Button regB = new Button("Registrar Informacion Docente"); //Creamos botnes y les asignamos un ID para darle estilos
        regB.setId("btn-registrar");
        Button vizB = new Button("Vizualizar Informacion Docentes");
        vizB.setId("btn-visualizar");
        Button actB = new Button("Actualizar Informacion Docente");
        actB.setId("btn-actualizar");
        Button delB = new Button("Eliminar Informacion Docente");
        delB.setId("btn-eliminar");
        
        HBox contenedorH = new HBox(); //Creamos un contenedor horizontal y le asignamos un ID para darle estilos
        contenedorH.setId("contenedorH");
        
        VBox imagen = new VBox(); //Creamo sun contenedor vertical y le agregamos un ID para darle estilos
        imagen.setId("imagen");
        
        Label l1 = new Label("SISTEMA DE REGISTRO DOCENTE"); //Creamos un label para mostrar el titulo y le asignamos un ID para darle estilos
        l1.setId("l1-title");
        
        VBox vbox1 = new VBox(10);
        vbox1.getChildren().addAll(l1,regB, vizB, actB, delB); //Obtenemos los elementos dentro del contenedor y le añadimos extras
        vbox1.setAlignment(Pos.CENTER);//Definimos que los elementos dentro del contenedor se alinean en el centro
        vbox1.setId("vbox-menu");
     
        VBox vboxP = new VBox();
        vboxP.setId("vbox-principal");
        
        contenedorH.getChildren().addAll(vbox1,imagen);
        contenedorH.setAlignment(Pos.CENTER);
        
        vboxP.getChildren().addAll(contenedorH);
        vboxP.setAlignment(Pos.CENTER);
        
        
        
        regB.setOnAction(e -> { //Funcion lambda para indicar la accion del boton al ser presionado
            stage.setScene(ventanaRegistrar.EscenaRegistro(stage,this)); //Mandamos la escena de registro al escenario para mostrarla
            stage.setMaximized(true);//La ventana se muestra abarcando toda la pantalla
            
        });
        
        
        actB.setOnAction(e -> {//Definimos la accion para el boton visualizar al ser pesionado
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Buscar Docente"); //Mostramos un cuadro de dialogo para ingresar informacion con titulo y contenido
            dialog.setHeaderText("Módulo de Actualización");
            dialog.setContentText("Por favor, ingrese el número de Cédula del Docente:");

            Optional<String> result = dialog.showAndWait(); //Definimos un objeto que puede o no contener informacion de tipo stirng
            
            if (result.isPresent()){ //Si el objeto contiene informacion, procedemos a leerlo
                String cedulaBuscada = result.get();
                Docente docenteEncontrado = null;
                System.out.println(docentes.get(0));
                for (Docente d : docentes) { //Recorremos el array de los docentes
                	System.out.println(d.getCedula());
                	System.out.println(cedulaBuscada);
                    if (String.valueOf(d.getCedula()).equals(cedulaBuscada)) {//Hasta que la cedula coincida ocn la buscada
                    	
                        docenteEncontrado = d; //Asignamos el docente a la variable y terminamos la busqueda
                        break;
                    }
                }

                if (docenteEncontrado != null) { //Si se termino el bucle y se encontro que ninguno coincida
                    VentanaActualizar ventana = new VentanaActualizar(); //Nos dirijimos a la ventana par aactualizar su informacion
                    Scene escenaEdicion = ventana.EscenaEdicion(stage, this, docenteEncontrado);//Llamamos a la escena que realiza el proceso
                    stage.setScene(escenaEdicion);
                    stage.setMaximized(true);
                } else {//Si no se encontro
                    Alert alert = new Alert(Alert.AlertType.ERROR);//Mostramos un modal de error
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("No se encontró ningún docente con la cédula: " + cedulaBuscada);
                    alert.showAndWait();
                }
            }
        });
        
        vizB.setOnAction(e -> {//Definimos la accion para el boton visualizar al ser pesionado
        	Scene escenaDocentes = ventanaDocentes.EscenaListaDocentes(stage, this);//Cambiamos la escena a mostrar los docentes que hay
        	
            stage.setScene(escenaDocentes);
            stage.setMaximized(true);
        });
        
        AccionEliminar Borrar = new AccionEliminar(); //Instanciamos la calse AccionEliminar para acceder a sus metodos
        Borrar.AccionEliminar(delB);//Le pasamos el boton con el que se realiza la accion de eliminar

        StackPane root = new StackPane(vboxP); //Creamos un contenedor apilador para nuestro elementos
        stage.setMaximized(true);//La escena ocupa toda la pantalla
        Scene scene = new Scene(root,1530, 900); // Agregamos el contenedor con las datos a la escena
        scene.getStylesheets().add(//Le asignamos una hoja de estilos a esta escena para darle dise!no
                getClass().getResource("/TareaFinCurso/GestionCurriculoDocente/View/Css/app.css")
                        .toExternalForm()
            );
            return scene; //Devolvemos la escena
    }
    
  
   
    public static void main(String[] args) {//Iniciamos el programa
        launch();
    }

}