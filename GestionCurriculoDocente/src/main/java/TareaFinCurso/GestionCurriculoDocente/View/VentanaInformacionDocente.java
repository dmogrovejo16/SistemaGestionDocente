package TareaFinCurso.GestionCurriculoDocente.View;

import java.util.ArrayList;

import TareaFinCurso.GestionCurriculoDocente.App;
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
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VentanaInformacionDocente {
	//Creamos tablas para cada atributo de un docente
	
	    
	    private TableView<Titulo> tablaTitulos;
	    private TableView<Experiencia> tablaExp;
	    private TableView<Capacitacion> tablaCapacitaciones;   
	    private TableView<ProduccionAcademica> tablaProducciones; 

	    public Scene EscenaVisualizacion(Stage stage, App app, Docente docenteAEditar) {//Scena que muestra los datos de un docente en pestañas
	        
	        TabPane tabPane = new TabPane();
	        
	        // Pestaña Datos Personales
	        Tab tabDatos = new Tab("Datos Personales");
	        tabDatos.setClosable(false);
	        tabDatos.setContent(crearFormularioDatos(docenteAEditar));
	        
	        // Pestaña Títulos
	        Tab tabTitulos = new Tab("Títulos");
	        tabTitulos.setClosable(false);
	        tabTitulos.setContent(crearEditorTitulos(docenteAEditar)); 
	        
	        // Pestaña Experiencia
	        Tab tabExperiencia = new Tab("Experiencia");
	        tabExperiencia.setClosable(false);
	        tabExperiencia.setContent(crearEditorExperiencias(docenteAEditar));

	        // Pestaña Capacitaciones 
	        Tab tabCapacitacion = new Tab("Capacitación");
	        tabCapacitacion.setClosable(false);
	        tabCapacitacion.setContent(crearEditorCapacitaciones(docenteAEditar));

	        // Pestaña Producción Académica (NUEVA - Investigaciones y Publicaciones)
	        Tab tabProduccion = new Tab("Producción");
	        tabProduccion.setClosable(false);
	        tabProduccion.setContent(crearEditorProducciones(docenteAEditar));

	        // Mostramos las pestañas creadas
	        tabPane.getTabs().addAll(tabDatos, tabTitulos, tabExperiencia, tabCapacitacion, tabProduccion);

	        // BOTÓN GUARDAR
	        Button btnGuardar = new Button("Volver");
	        btnGuardar.setStyle("-fx-background-color: #28a745; -fx-text-fill: white; -fx-font-size: 14px;");
	        btnGuardar.setOnAction(e -> {
	        	stage.setScene(app.getVentanaDocentes().EscenaListaDocentes(stage, app));
	        });

	        VBox layoutPrincipal = new VBox(15);
	        layoutPrincipal.setPadding(new Insets(20));
	        layoutPrincipal.getChildren().addAll(
	           
	            tabPane, 
	            btnGuardar
	        );

	        layoutPrincipal.setStyle("-fx-background-color: linear-gradient(to right,  #4a7be6, #1b1f9c);");;
	        return new Scene(layoutPrincipal,1530, 780);
	    }

	    // Metodo para mostrar la informacion personal del docente
	    private VBox crearFormularioDatos(Docente d) {
	        VBox vbox = new VBox(10);
	        vbox.setPadding(new Insets(15));
	        
	        TableView<Docente> table = new TableView<>();

 /*
* Al aplicar un property value factory, lllamamos al metodo get correspondiente al texto ingresado a su instanciacion, 
 * haciendo que por cada elemento en este se cree una fila para mostrar la informacion del mismo, y ademas
* permite la actualizacion constante de cualquier dato agregado
 */
	        
TableColumn<Docente, String> colNombre = new TableColumn<>("Nombre");
colNombre.setCellValueFactory(new PropertyValueFactory<>("nombres"));


TableColumn<Docente, String> colApellido = new TableColumn<>("Apellido");
colApellido.setCellValueFactory(new PropertyValueFactory<>("apellidos"));


TableColumn<Docente, String> colCorreo = new TableColumn<>("Correo");
colCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));


TableColumn<Docente, String> colTelefono = new TableColumn<>("Fecha de Nacimiento");
colTelefono.setCellValueFactory(new PropertyValueFactory<>("fechaNac"));


TableColumn<Docente, String> colCarrera = new TableColumn<>("Nacionalidad");
colCarrera.setCellValueFactory(new PropertyValueFactory<>("nacionalidad"));


TableColumn<Docente, String> colEstado = new TableColumn<>("Estado Civil");
colEstado.setCellValueFactory(new PropertyValueFactory<>("estadoCivil"));

TableColumn<Docente, String> colCedula = new TableColumn<>("# Cedula");
colEstado.setCellValueFactory(new PropertyValueFactory<>("cedula"));

table.getItems().add(d);//Asignamos el objeto docente de parametro para la tabla
table.getColumns().addAll(
colNombre, colApellido, colCorreo,
colTelefono, colCarrera, colEstado
);

	        vbox.getChildren().addAll(
	            table
	        );
	        return vbox;
	    }

	    // Metodo para editar los titulos del docente
	    private VBox crearEditorTitulos(Docente docente) {
	        VBox vbox = new VBox(10);
	        vbox.setPadding(new Insets(15));
	        
	        tablaTitulos = new TableView<>();
	        tablaTitulos.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
	        tablaTitulos.setPrefHeight(200);
	        
	        // Llamamos a los geters de la clase docente
	        TableColumn<Titulo, String> colTitulo = new TableColumn<>("Título");
	        colTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
	        
	        TableColumn<Titulo, String> colInst = new TableColumn<>("Institución");
	        colInst.setCellValueFactory(new PropertyValueFactory<>("institucion"));

	        tablaTitulos.getColumns().addAll(colTitulo, colInst);
	        
	        
	        ObservableList<Titulo> datos = FXCollections.observableArrayList(docente.getTitulos());
	        tablaTitulos.setItems(datos);
	        
	        
	        
	        
	       
	        vbox.getChildren().addAll(
	            new Label("Títulos:"), tablaTitulos, 
	            new Separator()
	        );
	        return vbox;
	    }

	    // Metodo para editar las experiencias del docente
	    private VBox crearEditorExperiencias(Docente docente) {
	        VBox vbox = new VBox(10);
	        vbox.setPadding(new Insets(15));
	        
	        tablaExp = new TableView<>();
	        tablaExp.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
	        tablaExp.setPrefHeight(200);
	        
	        TableColumn<Experiencia, String> colTipo = new TableColumn<>("Tipo");
	        colTipo.setCellValueFactory(cellData -> {
	            Experiencia exp = cellData.getValue();
	            if (exp instanceof ExperienciaDocente) return new SimpleStringProperty("Docente");
	            if (exp instanceof ExperienciaNoDocente) return new SimpleStringProperty("Profesional");
	            if (exp instanceof ReferenciaLaboral) return new SimpleStringProperty("Referencia");
	            return new SimpleStringProperty("Otro");
	        });
	        
	        TableColumn<Experiencia, String> colInst = new TableColumn<>("Institución");
	        colInst.setCellValueFactory(new PropertyValueFactory<>("institucion"));
	        
	        tablaExp.getColumns().addAll(colTipo, colInst);
	        
	        ObservableList<Experiencia> datos = FXCollections.observableArrayList(docente.getExperiencias());
	        tablaExp.setItems(datos);
	        
	       
	        vbox.getChildren().addAll(new Label("Experiencias:"), tablaExp, new Separator());
	       
	        
	       
	        return vbox;
	    }

	    private VBox crearEditorCapacitaciones(Docente docente) {
	        VBox vbox = new VBox(10);
	        vbox.setPadding(new Insets(15));
	        
	        tablaCapacitaciones = new TableView<>();
	        tablaCapacitaciones.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
	        tablaCapacitaciones.setPrefHeight(200);

	        // Columna Tipo -  Para que el usuaruio sepa q tipo de capacitacion va a editar
	        TableColumn<Capacitacion, String> colTipo = new TableColumn<>("Tipo");
	        colTipo.setCellValueFactory(cellData -> {
	            Capacitacion c = cellData.getValue();
	            if (c instanceof CapacitacionRecibida) return new SimpleStringProperty("Recibida");
	            if (c instanceof CapacitacionImpartida) return new SimpleStringProperty("Impartida");
	            return new SimpleStringProperty("General");
	        });

	//Asignamos los datos que tengamos en Docente con ayuda  de los setters y la modularizacion
	        TableColumn<Capacitacion, String> colTema = new TableColumn<>("Temática");
	        colTema.setCellValueFactory(new PropertyValueFactory<>("tematica")); 
	        
	        TableColumn<Capacitacion, String> colInst = new TableColumn<>("Institución");
	        colInst.setCellValueFactory(new PropertyValueFactory<>("institucion"));
	        
	        tablaCapacitaciones.getColumns().addAll(colTipo, colTema, colInst);
	        
	        ObservableList<Capacitacion> datos = FXCollections.observableArrayList(docente.getCapacitaciones());
	        tablaCapacitaciones.setItems(datos);


	        vbox.getChildren().addAll(new Label("Capacitaciones:"), tablaCapacitaciones, 
	            new Separator());
	        return vbox;
	    }

	 
	    private VBox crearEditorProducciones(Docente docente) {
	        VBox vbox = new VBox(10);
	        vbox.setPadding(new Insets(15));
	        
	        tablaProducciones = new TableView<>();
	        tablaProducciones.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
	        tablaProducciones.setPrefHeight(200);

	        // Llamamos a los getters de la clase Docent para diferenciar la produccion academica
	        TableColumn<ProduccionAcademica, String> colTipo = new TableColumn<>("Tipo");
	        colTipo.setCellValueFactory(cellData -> {
	            ProduccionAcademica p = cellData.getValue();
	            if (p instanceof Investigacion) return new SimpleStringProperty("Investigación");
	            if (p instanceof Publicacion) return new SimpleStringProperty("Publicación");
	            return new SimpleStringProperty("Otro");
	        });

	        // Llamamos a los getters de la clase Docente para ir mostrando los cambios
	        TableColumn<ProduccionAcademica, String> colTitulo = new TableColumn<>("Título / Proyecto");
	        colTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
	        
	        tablaProducciones.getColumns().addAll(colTipo, colTitulo);
	        
	        ObservableList<ProduccionAcademica> datos = FXCollections.observableArrayList(docente.getProducciones());
	        tablaProducciones.setItems(datos);

	       

	        vbox.getChildren().addAll(new Label("Investigaciones y Publicaciones:"), tablaProducciones, 
	            new Separator());
	        return vbox;
	    }

	 
	    
}
