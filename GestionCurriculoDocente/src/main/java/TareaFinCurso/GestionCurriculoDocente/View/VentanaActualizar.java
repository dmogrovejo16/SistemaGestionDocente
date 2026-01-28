package TareaFinCurso.GestionCurriculoDocente.View;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.property.SimpleStringProperty;
import java.util.ArrayList;

import TareaFinCurso.GestionCurriculoDocente.App;
import TareaFinCurso.GestionCurriculoDocente.Controller.Components.CrearEditor;
import TareaFinCurso.GestionCurriculoDocente.Controller.Components.MostrarModal;
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

public class VentanaActualizar {
    
  
    
    CrearEditor crearEditor = new CrearEditor();
    MostrarModal mostrarModal = new MostrarModal();
    
    
    public Scene EscenaEdicion(Stage stage, App app, Docente docenteAEditar) {
        
        TabPane tabPane = new TabPane();
        
        // Pestaña Datos Personales
        Tab tabDatos = new Tab("Datos Personales");
        tabDatos.setClosable(false);
        tabDatos.setContent(crearEditor.crearFormularioDatos(docenteAEditar));
        
        // Pestaña Títulos
        Tab tabTitulos = new Tab("Títulos");
        tabTitulos.setClosable(false);
        tabTitulos.setContent(crearEditor.crearEditorTitulos(docenteAEditar)); 
        
        // Pestaña Experiencia
        Tab tabExperiencia = new Tab("Experiencia");
        tabExperiencia.setClosable(false);
        tabExperiencia.setContent(crearEditor.crearEditorExperiencias(docenteAEditar));

        // Pestaña Capacitaciones 
        Tab tabCapacitacion = new Tab("Capacitación");
        tabCapacitacion.setClosable(false);
        tabCapacitacion.setContent(crearEditor.crearEditorCapacitaciones(docenteAEditar));

        // Pestaña Producción Académica (NUEVA - Investigaciones y Publicaciones)
        Tab tabProduccion = new Tab("Producción");
        tabProduccion.setClosable(false);
        tabProduccion.setContent(crearEditor.crearEditorProducciones(docenteAEditar));

        // Mostramos las pestañas creadas
        tabPane.getTabs().addAll(tabDatos, tabTitulos, tabExperiencia, tabCapacitacion, tabProduccion);
        mostrarModal.inicializarReferencias(crearEditor); 
        // BOTÓN GUARDAR
        Button btnGuardar = new Button("Guardar Todos los Cambios");
        btnGuardar.setStyle("-fx-background-color: #28a745; -fx-text-fill: white; -fx-font-size: 14px;");
        btnGuardar.setOnAction(e -> { //Definimos accion del boton guardar
            mostrarModal.guardarCambios(docenteAEditar, app, stage);
        });

        VBox layoutPrincipal = new VBox(15);
        layoutPrincipal.setPadding(new Insets(20));
        layoutPrincipal.getChildren().addAll(
            new Label("EDITAR DOCENTE CÉDULA: " + docenteAEditar.getCedula()), 
            tabPane, 
            btnGuardar
        );

        layoutPrincipal.setStyle("-fx-background-color: linear-gradient(to right,  #4a7be6, #1b1f9c);");;
        return new Scene(layoutPrincipal, 1530, 780);
    }

  

 
    }

