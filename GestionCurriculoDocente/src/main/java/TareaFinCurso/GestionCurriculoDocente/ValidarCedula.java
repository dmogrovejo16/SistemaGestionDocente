package TareaFinCurso.GestionCurriculoDocente;

import javafx.scene.control.Alert;

public class ValidarCedula {//Esta clase sirve para ver si la cedula ingresada a eliminar tiene el formato correcto
	
	public Boolean ValidarCedula (String cedula) {
		if(cedula == null || cedula.length()!=10) {  //Longitud de números, o variable vacia
			Alert alertaExito = new Alert(Alert.AlertType.INFORMATION);
            alertaExito.setTitle("Error");
            alertaExito.setHeaderText(null); // Sin encabezado para que sea más limpio
            alertaExito.setContentText("Error al ingresar la cédula");
            alertaExito.showAndWait();
			return false;
		}
		
		if (!cedula.matches("\\d+")) {  //Comprobar si contiene solo dígitos
			Alert alertaError = new Alert(Alert.AlertType.WARNING);
            alertaError.setTitle("Validación");
            alertaError.setHeaderText(null);
            alertaError.setContentText("Error al ingresar la cédula");
            alertaError.showAndWait();
        }
		
		//Verificación del ultimo digito de la cedula 
		return DigitoVerificador(cedula);
	}
	
	//Calculo de verificacion.
	private Boolean DigitoVerificador(String cedula) {
		int[] Valores = {2, 1, 2, 1, 2, 1, 2, 1, 2};
		int suma=0;
		int digitoRecibido = Character.getNumericValue(cedula.charAt(9));
		
		for ( int i= 0; i<Valores.length; i++) {
			int newValor = Character.getNumericValue(cedula.charAt(i)) * Valores[i];
			if (newValor>9) {
				suma+= newValor-9;
			}else {
				suma+=newValor;
			}
		}
		int DigitoObtenido = (suma % 10 == 0) ? 0 : 10 - (suma % 10);
		return DigitoObtenido == digitoRecibido;
		
		}

}
