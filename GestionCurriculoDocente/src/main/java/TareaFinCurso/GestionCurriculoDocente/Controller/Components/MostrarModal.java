package TareaFinCurso.GestionCurriculoDocente.Controller.Components;

import java.util.ArrayList;

import TareaFinCurso.GestionCurriculoDocente.App;
import TareaFinCurso.GestionCurriculoDocente.Controller.FileController;
import TareaFinCurso.GestionCurriculoDocente.Model.Capacitacion;
import TareaFinCurso.GestionCurriculoDocente.Model.Docente;
import TareaFinCurso.GestionCurriculoDocente.Model.Experiencia;
import TareaFinCurso.GestionCurriculoDocente.Model.ProduccionAcademica;
import TareaFinCurso.GestionCurriculoDocente.Model.Titulo;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MostrarModal {
	  private TextField txtNombres;
	    private TextField txtApellidos;
	    private TextField txtCorreo;
	    private TextField txtCelular;
	    private TextField txtConvencional;
	    FileController fileController = new FileController();
	    private TableView<Titulo> tablaTitulos;
	    private TableView<Experiencia> tablaExp;
	    private TableView<Capacitacion> tablaCapacitaciones;
	    private TableView<ProduccionAcademica> tablaProducciones;

	    // Método que inicializa las referencias despues de crear el formulario
	    public void inicializarReferencias(CrearEditor crearEditor) {
	    	 this.txtNombres = CrearEditor.getTxtNombres();
	         this.txtApellidos = CrearEditor.getTxtApellidos();
	         this.txtCorreo = CrearEditor.getTxtCorreo();
	         this.txtCelular = CrearEditor.getTxtCelular();
	         this.txtConvencional = CrearEditor.getTxtConvencional();
	         
	         // Inicializamos las tablas
	         this.tablaTitulos = crearEditor.getTablaTitulos();
	         this.tablaExp = crearEditor.getTablaExp();
	         this.tablaCapacitaciones = crearEditor.getTablaCapacitaciones();
	         this.tablaProducciones = crearEditor.getTablaProducciones();
	    }

	
	public void guardarCambios(Docente d, App app, Stage stage) {
        try {
            // Gurdamos los datos personales con los setters
            d.setNombres(txtNombres.getText());
            d.setApellidos(txtApellidos.getText());
            d.setCorreo(txtCorreo.getText());
            if(!txtCelular.getText().isEmpty()) d.setTelefonoCel(Integer.parseInt(txtCelular.getText()));
            if(!txtConvencional.getText().isEmpty()) d.setTelefonoConv(Integer.parseInt(txtConvencional.getText()));

            // Guardamos los titulos y capacitaciones q esten en las tablas
            d.setTitulos(new ArrayList<>(tablaTitulos.getItems()));
            d.setExperiencias(new ArrayList<>(tablaExp.getItems()));
            d.setCapacitaciones(new ArrayList<>(tablaCapacitaciones.getItems())); // Guardamos Capacitaciones
            d.setProducciones(new ArrayList<>(tablaProducciones.getItems()));     // Guardamos Producciones
            
            // Pasamos las actualizacions al archivo
            fileController.actualizarArchivo(); 

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
	
	
	public static Integer mostrarVentana(String txt) {//Cuando se ingrese un numero de titulos, experiencias, referencias, publicaciones, se genera un alerto donde se deben ingresar la cantidad 
		  //de los mismos

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
	
	
	
	  public static void mostrarError(String mensaje) { //Metodo para mostrar un alerto de error perzonalizado
		    Alert alert = new Alert(Alert.AlertType.ERROR);
		    alert.setHeaderText(null);
		    alert.setContentText(mensaje);
		    alert.showAndWait();
		}
	
}

