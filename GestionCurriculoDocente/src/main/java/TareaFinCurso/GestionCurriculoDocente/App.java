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
	   String rutaArchivo = "C:\\Users\\mathi\\git\\SistemaGestionDocente\\GestionCurriculoDocente\\docentes.txt";
	 //Creamos el arrray de docentes
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
	    
	    public ArrayList<Docente> getDocentes() {
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
        cargarDocentes(rutaArchivo);
        //Inicializamos el escenario
        stage.setScene(EscenaPrincipal(stage));
        stage.setMaximized(true);
        stage.show();
    }


  
  public void escribirDocente(Docente d) {


	  File archivo = new File("docentes.txt");


	  try (PrintWriter pw = new PrintWriter(
	  new FileWriter(archivo, true))) {


	  pw.println(d.toString());


	  } catch (IOException e) {
	  e.printStackTrace();
	  }
	  }
 

  public  ArrayList<Docente> cargarDocentes(String ruta) { //Metodo para importar los docentes al array local
	  
          try (BufferedReader br = new BufferedReader(new FileReader(ruta))) { //Inicializamos una clase para leer el texto en el archivo

             //Declaramos variables, objetos y ArrayLists
        	  String linea;
              Docente docente = null;

              ArrayList<Titulo> titulos = null;
              ArrayList<Capacitacion> capacitaciones = null;
              ArrayList<Experiencia> experiencias = null;
              ArrayList<ProduccionAcademica> producciones = null;

              while ((linea = br.readLine()) != null) { //Bucle se repite mientras la linea leida no este en blanco

                  if (linea.equals("DOCENTE")) { //La linea DOCENTE indica que se empezo a escribir informacion de un docente, por lo que podemos empezar a inicializar
                	  //variables para guardar los datos a continuacion
                      docente = new Docente();
                      titulos = new ArrayList<>();
                      capacitaciones = new ArrayList<>();
                      experiencias = new ArrayList<>();
                      producciones = new ArrayList<>();
                  }

                  else if (linea.startsWith("NOMBRES=")) { //Cada linea de informacion empieza ocn un identificador ne mayusculas, que nos indica que variable pasar al objeto
                      docente.setNombres(linea.split("=", 2)[1]);//Pasamos al objeto el nombre
                  }
                  else if (linea.startsWith("APELLIDOS=")) {
                      docente.setApellidos(linea.split("=", 2)[1]);
                  }
                  else if (linea.startsWith("CEDULA=")) {
                      docente.setCedula(Integer.parseInt(linea.split("=", 2)[1]));
                  }
                  else if (linea.startsWith("FECHA_NAC=")) {
                      docente.setFechaNac(linea.split("=", 2)[1]);
                  }
                  else if (linea.startsWith("NACIONALIDAD=")) {
                      docente.setNacionalidad(linea.split("=", 2)[1]);
                  }
                  else if (linea.startsWith("ESTADO_CIVIL=")) {
                      docente.setEstadoCivil(linea.split("=", 2)[1]);
                  }
                  else if (linea.startsWith("TIPO_SANGRE=")) {
                      docente.setTipoSangre(linea.split("=", 2)[1]);
                  }
                  else if (linea.startsWith("CIUDAD_NAC=")) {
                      docente.setCiudadNac(linea.split("=", 2)[1]);
                  }
                  else if (linea.startsWith("DIRECCION=")) {
                      docente.setDireccion(linea.split("=", 2)[1]);
                  }
                  else if (linea.startsWith("CORREO=")) {
                      docente.setCorreo(linea.split("=", 2)[1]);
                  }
                  else if (linea.startsWith("TEL_CEL=")) {
                      docente.setTelefonoCel(Integer.parseInt(linea.split("=", 2)[1]));
                  }
                  else if (linea.startsWith("TEL_CONV=")) {
                      docente.setTelefonoConv(Integer.parseInt(linea.split("=", 2)[1]));
                  }

                  // ---------- TITULOS ----------
                  else if (linea.equals("TITULOS")) {
                      while (!(linea = br.readLine()).equals("FIN_TITULOS")) { //Bucle que se repite mientras nos encontremos en la seccion de titulos
                          String[] d = linea.split(";");
                          titulos.add(new Titulo(d[0], d[1], d[2], d[3]));
                      }
                  }

                  // ---------- CAPACITACIONES ----------
                  else if (linea.equals("CAPACITACIONES")) {
                      while (!(linea = br.readLine()).equals("FIN_CAPACITACIONES")) {//Bucle que se repite mientras nos encontremos en la seccion de capacitacion
                          String[] d = linea.split(";"); //Concatenamos la informacion de capacitacion con un ; de separacion
                          Capacitacion c;

                          if (d[0].equals("RECIBIDA")) {//Vemos si la informacion a continuacion corresponde a capacitacion recibidas, de lo contrario seran impartidas
                              c = new CapacitacionRecibida(d[1], d[2], d[3], d[4],
                                      Integer.parseInt(d[5]));
                          } else {
                              c = new CapacitacionImpartida(d[1], d[2], d[3], d[4],
                                      Integer.parseInt(d[5]));
                          }

                          capacitaciones.add(c);
                      }
                  }

                  // ---------- EXPERIENCIAS ----------
                  else if (linea.equals("EXPERIENCIAS")) {
                      while (!(linea = br.readLine()).equals("FIN_EXPERIENCIAS")) {//Bucle que se repite mientras nos encontremos en la seccion de experiencia
                          String[] d = linea.split(";");//Concatenamos la informacion de capacitacion con un ; de separacion

                          switch (d[0]) { //El vector d se inicialiizara en 0 siempre, permieitndonos recorrer todo el bloque de experiencias
                              case "DOCENTE"://Vemos si la informacion a continuacion corresponde a experiencia docente
                                  experiencias.add(new ExperienciaDocente( //Anadimos al array de experiencias lo encontrado
                                          d[1], d[2], d[3], d[4]));
                                  break;

                              case "NO_DOCENTE"://Vemos si la informacion a continuacion corresponde a experiencia no docente
                                  experiencias.add(new ExperienciaNoDocente(
                                          d[1], d[2], d[3], d[4]));
                                  break;

                              case "REFERENCIA"://Vemos si la informacion a continuacion corresponde a referencias
                                  experiencias.add(new ReferenciaLaboral(
                                          d[1], d[2], d[3]));
                                  break;
                          }
                      }
                  }

                  // ---------- PRODUCCIONES ----------
                  else if (linea.equals("PRODUCCIONES")) {
                      while (!(linea = br.readLine()).equals("FIN_PRODUCCIONES")) {//Bucle que se repite mientras nos encontremos en la seccion de producciones
                          String[] d = linea.split(";");

                          if (d[0].equals("PUBLICACION")) {//Vemos si la informacion a continuacion corresponde a una publicacion
                              producciones.add(new Publicacion(
                                      d[1], Integer.parseInt(d[2]), d[3]));
                          } else if (d[0].equals("INVESTIGACION")) {//Vemos si la informacion a continuacion corresponde a una investigacion
                              producciones.add(new Investigacion(
                                      d[1], Integer.parseInt(d[2]), d[3]));
                          }
                      }
                  }

                  // ---------- FIN DOCENTE ----------
                  else if (linea.equals("FIN_DOCENTE")) { //Cuando llegemos al final del bloque docente, pasamos todos lo arrays con la informacion complemnentaria
                      docente.setTitulos(titulos);
                      docente.setCapacitaciones(capacitaciones);
                      docente.setExperiencias(experiencias);
                      docente.setProducciones(producciones);

                      docentes.add(docente);//Finalmente añadimos el docente al array de docentes local
                      docente = null;//Reiniciamos el docente
                  }
              }

          } catch (Exception e) { //Agarramos un excepcion y mostramos su localizacion
              e.printStackTrace();
          }

          return docentes;
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
        
        
        actB.setOnAction(e -> {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Buscar Docente");
            dialog.setHeaderText("Módulo de Actualización");
            dialog.setContentText("Por favor, ingrese el número de Cédula del Docente:");

            Optional<String> result = dialog.showAndWait();
            
            if (result.isPresent()){
                String cedulaBuscada = result.get();
                Docente docenteEncontrado = null;
                System.out.println(docentes.get(0));
                for (Docente d : docentes) {
                	System.out.println(d.getCedula());
                	System.out.println(cedulaBuscada);
                    if (String.valueOf(d.getCedula()).equals(cedulaBuscada)) {
                    	
                        docenteEncontrado = d;
                        break;
                    }
                }

                if (docenteEncontrado != null) {
                    VentanaActualizar ventana = new VentanaActualizar();
                    Scene escenaEdicion = ventana.EscenaEdicion(stage, this, docenteEncontrado);
                    stage.setScene(escenaEdicion);
                    stage.setMaximized(true);
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("No se encontró ningún docente con la cédula: " + cedulaBuscada);
                    alert.showAndWait();
                }
            }
        });
        
        vizB.setOnAction(e -> {
        	Scene escenaDocentes = ventanaDocentes.EscenaListaDocentes(stage, this);
        	
            stage.setScene(escenaDocentes);
            stage.setMaximized(true);
        });
        
        AccionEliminar Borrar = new AccionEliminar(); //Instanciamos la calse AccionEliminar para acceder a sus metodos
        Borrar.AccionEliminar(delB);//Le pasamos el boton con el que se realiza la accion de eliminar

        StackPane root = new StackPane(vboxP); //Creamos un contenedor apilador para nuestro elementos
        stage.setMaximized(true);//La escena ocupa toda la pantalla
        Scene scene = new Scene(root); // Agregamos el contenedor con las datos a la escena
        scene.getStylesheets().add(//Le asignamos una hoja de estilos a esta escena para darle dise!no
                getClass().getResource("/TareaFinCurso/GestionCurriculoDocente/View/Css/app.css")
                        .toExternalForm()
            );
            return scene; //Devolvemos la escena
    }
    
  
    public void actualizarTodaLaBaseDeDatos() {
        System.out.println("Iniciando actualización de archivo..."); 
        try (PrintWriter pw = new PrintWriter(new FileWriter(rutaArchivo, false))) {
            for (Docente d : docentes) {
                pw.print(d.toString()); 
            }
            System.out.println("Archivo actualizado correctamente.");  
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al guardar los cambios: " + e.getMessage());
        }
    } 
    public static void main(String[] args) {
        launch();
    }

}