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
    
  
    private TextField txtNombres, txtApellidos, txtCorreo;
    private TextField txtCelular, txtConvencional;
    
    private TableView<Titulo> tablaTitulos;
    private TableView<Experiencia> tablaExp;
    private TableView<Capacitacion> tablaCapacitaciones;   
    private TableView<ProduccionAcademica> tablaProducciones; 

    public Scene EscenaEdicion(Stage stage, App app, Docente docenteAEditar) {
        
        TabPane tabPane = new TabPane();
        
        // 1. Datos Personales
        Tab tabDatos = new Tab("Datos Personales");
        tabDatos.setClosable(false);
        tabDatos.setContent(crearFormularioDatos(docenteAEditar));
        
        // 2. Títulos
        Tab tabTitulos = new Tab("Títulos");
        tabTitulos.setClosable(false);
        tabTitulos.setContent(crearEditorTitulos(docenteAEditar)); 
        
        // 3. Experiencia
        Tab tabExperiencia = new Tab("Experiencia");
        tabExperiencia.setClosable(false);
        tabExperiencia.setContent(crearEditorExperiencias(docenteAEditar));

        // 4. Capacitaciones (NUEVA)
        Tab tabCapacitacion = new Tab("Capacitación");
        tabCapacitacion.setClosable(false);
        tabCapacitacion.setContent(crearEditorCapacitaciones(docenteAEditar));

        // 5. Producción Académica (NUEVA - Investigaciones y Publicaciones)
        Tab tabProduccion = new Tab("Producción");
        tabProduccion.setClosable(false);
        tabProduccion.setContent(crearEditorProducciones(docenteAEditar));

        // AGREGAR LAS 5 PESTAÑAS
        tabPane.getTabs().addAll(tabDatos, tabTitulos, tabExperiencia, tabCapacitacion, tabProduccion);

        // BOTÓN GUARDAR
        Button btnGuardar = new Button("Guardar Todos los Cambios");
        btnGuardar.setStyle("-fx-background-color: #28a745; -fx-text-fill: white; -fx-font-size: 14px;");
        btnGuardar.setOnAction(e -> {
            guardarCambios(docenteAEditar, app, stage);
        });

        VBox layoutPrincipal = new VBox(15);
        layoutPrincipal.setPadding(new Insets(20));
        layoutPrincipal.getChildren().addAll(
            new Label("EDITAR DOCENTE CÉDULA: " + docenteAEditar.getCedula()), 
            tabPane, 
            btnGuardar
        );

        return new Scene(layoutPrincipal, 800, 600);
    }

    // --------------------------------------------------------------------------------
    // SECCIÓN 1: DATOS PERSONALES
    // --------------------------------------------------------------------------------
    private VBox crearFormularioDatos(Docente d) {
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(15));
        
        txtNombres = new TextField(d.getNombres());
        txtApellidos = new TextField(d.getApellidos());
        txtCorreo = new TextField(d.getCorreo());
        txtCelular = new TextField(String.valueOf(d.getTelefonoCel()));
        txtConvencional = new TextField(String.valueOf(d.getTelefonoConv()));
        
        TextField txtCedula = new TextField(String.valueOf(d.getCedula()));
        txtCedula.setDisable(true); 

        vbox.getChildren().addAll(
            new Label("Cédula (No editable):"), txtCedula,
            new Label("Nombres:"), txtNombres,
            new Label("Apellidos:"), txtApellidos,
            new Label("Correo Institucional:"), txtCorreo,
            new Label("Celular:"), txtCelular,
            new Label("Telf. Convencional:"), txtConvencional
        );
        return vbox;
    }

    // --------------------------------------------------------------------------------
    // SECCIÓN 2: TÍTULOS
    // --------------------------------------------------------------------------------
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
        
        Button btnEliminar = new Button("Eliminar Seleccionado");
        btnEliminar.setStyle("-fx-background-color: #dc3545; -fx-text-fill: white;");
        btnEliminar.setOnAction(e -> {
            Titulo t = tablaTitulos.getSelectionModel().getSelectedItem();
            if(t != null) datos.remove(t);
        });
        
        TextField txtNewTitulo = new TextField(); txtNewTitulo.setPromptText("Nombre Título");
        TextField txtNewInst = new TextField(); txtNewInst.setPromptText("Institución");
        
        Button btnAgregar = new Button("Agregar");
        btnAgregar.setOnAction(e -> {
            if(!txtNewTitulo.getText().isEmpty()){
                // Ajusta los parámetros según tu constructor de Titulo
                Titulo nuevo = new Titulo(txtNewInst.getText(), txtNewTitulo.getText(), "Quito", "2024");
                datos.add(nuevo);
                docente.getTitulos().add(nuevo);
                txtNewTitulo.clear(); txtNewInst.clear();
            }
        });
        
        vbox.getChildren().addAll(
            new Label("Títulos:"), tablaTitulos, btnEliminar, 
            new Separator(), new Label("Agregar:"), txtNewTitulo, txtNewInst, btnAgregar
        );
        return vbox;
    }

    // --------------------------------------------------------------------------------
    // SECCIÓN 3: EXPERIENCIA
    // --------------------------------------------------------------------------------
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
        
        Button btnEliminar = new Button("Eliminar Seleccionado");
        btnEliminar.setStyle("-fx-background-color: #dc3545; -fx-text-fill: white;");
        btnEliminar.setOnAction(e -> {
            Experiencia exp = tablaExp.getSelectionModel().getSelectedItem();
            if(exp != null) datos.remove(exp);
        });
        
        vbox.getChildren().addAll(new Label("Experiencias:"), tablaExp, btnEliminar);
        return vbox;
    }

    private VBox crearEditorCapacitaciones(Docente docente) {
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(15));
        
        tablaCapacitaciones = new TableView<>();
        tablaCapacitaciones.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tablaCapacitaciones.setPrefHeight(200);

        // Columna Tipo (Recibida vs Impartida)
        TableColumn<Capacitacion, String> colTipo = new TableColumn<>("Tipo");
        colTipo.setCellValueFactory(cellData -> {
            Capacitacion c = cellData.getValue();
            if (c instanceof CapacitacionRecibida) return new SimpleStringProperty("Recibida");
            if (c instanceof CapacitacionImpartida) return new SimpleStringProperty("Impartida");
            return new SimpleStringProperty("General");
        });

        // NOTA: Asegúrate que tu clase Capacitacion tenga getters para 'tematica' e 'institucion'
        // Si se llaman diferente, cambia "tematica" por el nombre correcto del atributo en tu clase.
        TableColumn<Capacitacion, String> colTema = new TableColumn<>("Temática");
        colTema.setCellValueFactory(new PropertyValueFactory<>("tematica")); 
        
        TableColumn<Capacitacion, String> colInst = new TableColumn<>("Institución");
        colInst.setCellValueFactory(new PropertyValueFactory<>("institucion"));
        
        tablaCapacitaciones.getColumns().addAll(colTipo, colTema, colInst);
        
        ObservableList<Capacitacion> datos = FXCollections.observableArrayList(docente.getCapacitaciones());
        tablaCapacitaciones.setItems(datos);

        // Formulario Agregar
        ComboBox<String> comboTipo = new ComboBox<>();
        comboTipo.getItems().addAll("Recibida", "Impartida");
        comboTipo.getSelectionModel().selectFirst();
        
        TextField txtTema = new TextField(); txtTema.setPromptText("Temática");
        TextField txtInst = new TextField(); txtInst.setPromptText("Institución");
        TextField txtHoras = new TextField(); txtHoras.setPromptText("Horas (num)");
        
        Button btnAgregar = new Button("Agregar Capacitación");
        btnAgregar.setOnAction(e -> {
            if(!txtTema.getText().isEmpty() && !txtHoras.getText().isEmpty()){
                try {
                    int horas = Integer.parseInt(txtHoras.getText());
                    Capacitacion nueva;
                
                    if(comboTipo.getValue().equals("Recibida")){
                        nueva = new CapacitacionRecibida(txtInst.getText(), txtTema.getText(), "2024", "2024", horas);
                    } else {
                        nueva = new CapacitacionImpartida(txtInst.getText(), txtTema.getText(), "2024", "2024", horas);
                    }
                    datos.add(nueva);
                    docente.getCapacitaciones().add(nueva);
                    txtTema.clear(); txtInst.clear(); txtHoras.clear();
                } catch(Exception ex) {
                    Alert err = new Alert(Alert.AlertType.ERROR);
                    err.setContentText("Horas debe ser un número.");
                    err.show();
                }
            }
        });

        Button btnEliminar = new Button("Eliminar Seleccionada");
        btnEliminar.setStyle("-fx-background-color: #dc3545; -fx-text-fill: white;");
        btnEliminar.setOnAction(e -> {
            Capacitacion c = tablaCapacitaciones.getSelectionModel().getSelectedItem();
            if(c != null) datos.remove(c);
        });

        vbox.getChildren().addAll(new Label("Capacitaciones:"), tablaCapacitaciones, btnEliminar, 
            new Separator(), new Label("Nueva Capacitación:"), comboTipo, txtTema, txtInst, txtHoras, btnAgregar);
        return vbox;
    }

 
    private VBox crearEditorProducciones(Docente docente) {
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(15));
        
        tablaProducciones = new TableView<>();
        tablaProducciones.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tablaProducciones.setPrefHeight(200);

        // Columna Tipo (Investigación vs Publicación)
        TableColumn<ProduccionAcademica, String> colTipo = new TableColumn<>("Tipo");
        colTipo.setCellValueFactory(cellData -> {
            ProduccionAcademica p = cellData.getValue();
            if (p instanceof Investigacion) return new SimpleStringProperty("Investigación");
            if (p instanceof Publicacion) return new SimpleStringProperty("Publicación");
            return new SimpleStringProperty("Otro");
        });

        // Asegúrate que ProduccionAcademica tenga getTitulo()
        TableColumn<ProduccionAcademica, String> colTitulo = new TableColumn<>("Título / Proyecto");
        colTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        
        tablaProducciones.getColumns().addAll(colTipo, colTitulo);
        
        ObservableList<ProduccionAcademica> datos = FXCollections.observableArrayList(docente.getProducciones());
        tablaProducciones.setItems(datos);

        // Formulario Agregar
        ComboBox<String> comboTipo = new ComboBox<>();
        comboTipo.getItems().addAll("Publicación (Artículo/Texto)", "Investigación");
        comboTipo.getSelectionModel().selectFirst();
        
        TextField txtTitulo = new TextField(); txtTitulo.setPromptText("Título o Nombre del Proyecto");
        TextField txtDesc = new TextField(); txtDesc.setPromptText("Descripción / Link");
        
        Button btnAgregar = new Button("Agregar Producción");
        btnAgregar.setOnAction(e -> {
            if(!txtTitulo.getText().isEmpty()){
                ProduccionAcademica nueva;
                // Constructor asumido: (Titulo, Año, Descripción)
                if(comboTipo.getValue().contains("Publicación")){
                    nueva = new Publicacion(txtTitulo.getText(), 2024, txtDesc.getText());
                } else {
                    nueva = new Investigacion(txtTitulo.getText(), 2024, txtDesc.getText());
                }
                datos.add(nueva);
                docente.getProducciones().add(nueva);
                txtTitulo.clear(); txtDesc.clear();
            }
        });

        Button btnEliminar = new Button("Eliminar Seleccionada");
        btnEliminar.setStyle("-fx-background-color: #dc3545; -fx-text-fill: white;");
        btnEliminar.setOnAction(e -> {
            ProduccionAcademica p = tablaProducciones.getSelectionModel().getSelectedItem();
            if(p != null) datos.remove(p);
        });

        vbox.getChildren().addAll(new Label("Investigaciones y Publicaciones:"), tablaProducciones, btnEliminar, 
            new Separator(), new Label("Nueva Producción:"), comboTipo, txtTitulo, txtDesc, btnAgregar);
        return vbox;
    }

 
    private void guardarCambios(Docente d, App app, Stage stage) {
        try {
            // 1. Datos Simples
            d.setNombres(txtNombres.getText());
            d.setApellidos(txtApellidos.getText());
            d.setCorreo(txtCorreo.getText());
            if(!txtCelular.getText().isEmpty()) d.setTelefonoCel(Integer.parseInt(txtCelular.getText()));
            if(!txtConvencional.getText().isEmpty()) d.setTelefonoConv(Integer.parseInt(txtConvencional.getText()));

            // 2. Listas (Sincronización forzada desde las tablas visuales)
            d.setTitulos(new ArrayList<>(tablaTitulos.getItems()));
            d.setExperiencias(new ArrayList<>(tablaExp.getItems()));
            d.setCapacitaciones(new ArrayList<>(tablaCapacitaciones.getItems())); // Guardamos Capacitaciones
            d.setProducciones(new ArrayList<>(tablaProducciones.getItems()));     // Guardamos Producciones
            
            // 3. Escribir archivo
            app.actualizarTodaLaBaseDeDatos(); 

            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Éxito");
            alerta.setHeaderText(null);
            alerta.setContentText("Todos los datos, incluyendo capacitaciones y producciones, han sido guardados.");
            alerta.showAndWait();
            
            stage.setScene(app.EscenaPrincipal(stage));
            
        } catch (NumberFormatException e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setContentText("Verifique que los campos numéricos (teléfono, horas) contengan solo números.");
            alerta.showAndWait();
        }
    }
}
