package TareaFinCurso.GestionCurriculoDocente.Controller.Components;

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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class CrearEditor {
	
	
	    private TextField txtNombres, txtApellidos, txtCorreo;
	    private TextField txtCelular, txtConvencional;
	    
	    private TableView<Titulo> tablaTitulos;
	    private TableView<Experiencia> tablaExp;
	    private TableView<Capacitacion> tablaCapacitaciones;   
	    private TableView<ProduccionAcademica> tablaProducciones; 
	
	  // Metodo para editar la informacion personal del docente
    public VBox crearFormularioDatos(Docente d) {
        VBox vbox = new VBox(10); //Creamos un vbox para ir insertando y ordenando los elementos
        vbox.setPadding(new Insets(15));
        
        txtNombres = new TextField(d.getNombres()); //Inicializamos los texfields con los valores pregrabados
        txtApellidos = new TextField(d.getApellidos());
        txtCorreo = new TextField(d.getCorreo());
        txtCelular = new TextField(String.valueOf(d.getTelefonoCel()));
        txtConvencional = new TextField(String.valueOf(d.getTelefonoConv()));
        
        TextField txtCedula = new TextField(String.valueOf(d.getCedula()));
        txtCedula.setDisable(true); 

        vbox.getChildren().addAll( //Añadimos los text fields al contenedor
            new Label("Cédula (No editable):"), txtCedula, //Creamos labels para indicar al usuario que debe ingresar
            new Label("Nombres:"), txtNombres,
            new Label("Apellidos:"), txtApellidos,
            new Label("Correo Institucional:"), txtCorreo,
            new Label("Celular:"), txtCelular,
            new Label("Telf. Convencional:"), txtConvencional
        );
        return vbox;
    }

    // Metodo para editar los titulos del docente
     public VBox crearEditorTitulos(Docente docente) {
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(15));
        
        tablaTitulos = new TableView<>(); //Creamos una tabla para mostrar los datos existentes y los que se van agregando
        tablaTitulos.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);//Le asignamos el tamaño de la pantalla 
        tablaTitulos.setPrefHeight(200);
        
        // Llamamos a los geters de la clase docente
        TableColumn<Titulo, String> colTitulo = new TableColumn<>("Título");//Creamos una columna para la tabla que contenga el titulo
        colTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));//Le asignamos por defecto el valor de titulo del docente
        /*
         * Al aplicar un property value factory, lllamamos al metodo get correspondiente al texto ingresado a su instanciacion, 
         * haciendo que por cada elemento en este se cree una fila para mostrar la informacion del mismo, y ademas
         * permite la actualizacion constante de cualquier dato agregado
         */
        
        TableColumn<Titulo, String> colInst = new TableColumn<>("Institución");//Creamos una columna para la tabla que contenga la institucion 
        colInst.setCellValueFactory(new PropertyValueFactory<>("institucion"));//Le asignamos por defecto el valor de la institucion  del docente

        tablaTitulos.getColumns().addAll(colTitulo, colInst); //Añadimos las columnas a la tabla
        
        
        ObservableList<Titulo> datos = FXCollections.observableArrayList(docente.getTitulos());//Creamos una lista observable que contenga los titulos
        tablaTitulos.setItems(datos);//Mandamos la lista observable  a la tabla para ir leyendo y mostrando los valores 
        
        Button btnEliminar = new Button("Eliminar Seleccionado"); //Creamos un boton para eliminar
        btnEliminar.setStyle("-fx-background-color: #dc3545; -fx-text-fill: white;");//Le asignamos un estilo
        btnEliminar.setOnAction(e -> {//Definimos la accion del boton eliminar 
            Titulo t = tablaTitulos.getSelectionModel().getSelectedItem();//Obtenemos el elemento en la tabla y lo retiramos si no esta vacio
            if(t != null) datos.remove(t);
        });
        
        TextField txtNewTitulo = new TextField(); txtNewTitulo.setPromptText("Nombre Título");//Generamos los campos para que el usuairo ingrese nuevo titulo
        TextField txtNewInst = new TextField(); txtNewInst.setPromptText("Institución");
        
        Button btnAgregar = new Button("Agregar"); //Creamos un boton agregar y definimos su funcion
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
        return vbox; //Retornamos el vbox con la tabla, labels y textfild a la escena
    }

    // Metodo para editar las experiencias del docente
     public VBox crearEditorExperiencias(Docente docente) {
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
        
        
        
        TextField txtNewInst = new TextField(); txtNewInst.setPromptText("Institución");
        TextField txtNewFunc = new TextField(); txtNewFunc.setPromptText("Funcion");
        
        Button btnAgregar = new Button("Agregar");
        btnAgregar.setOnAction(e -> {
            if(!txtNewInst.getText().isEmpty()){
                // Ajusta los parámetros según tu constructor de Titulo
                ExperienciaNoDocente nuevo = new ExperienciaNoDocente(txtNewInst.getText(), txtNewFunc.getText() );
                datos.add(nuevo);
                docente.getExperiencias().add(nuevo);
                txtNewInst.clear();txtNewFunc.clear();
            }
        });
        
        vbox.getChildren().addAll(new Label("Experiencias:"), tablaExp, btnEliminar, new Separator(), new Label("Agregar:"), txtNewInst, txtNewFunc, btnAgregar);
       
        
       
        return vbox;
    }
 // Metodo para editar las capacitaciones del docente
     public VBox crearEditorCapacitaciones(Docente docente) {
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

 // Metodo para editar las producciones del docente
     public VBox crearEditorProducciones(Docente docente) {
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
    
    
    
}



