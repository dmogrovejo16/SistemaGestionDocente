package TareaFinCurso.GestionCurriculoDocente.Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class EventoEliminar {
	
	public Boolean EventoEliminar(String identificador) {
		 File archivo = new File("/GestionCurriculoDocente/src/main/java/TareaFinCurso/GestionCurriculoDocente/View/Documents/docentes.txt");
		    List<String> resultado = new ArrayList<>();
		    List<String> bloqueDocente = new ArrayList<>();

		    boolean eliminar = false;
		    boolean encontrado = false;
		    boolean dentroDocente = false;

		    try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
		        String linea;

		        while ((linea = br.readLine()) != null) {

		            // Inicio de un docente
		            if (linea.equals("DOCENTE")) {
		                dentroDocente = true;
		                bloqueDocente.clear();
		            }

		            if (dentroDocente) {
		                bloqueDocente.add(linea);

		                // Buscar la cédula
		                if (linea.equals("CEDULA=" + identificador)) {
		                    eliminar = true;
		                    encontrado = true;
		                }

		                // Fin del docente
		                if (linea.equals("FIN_DOCENTE")) {

		                    // Si NO es el docente a eliminar, se guarda
		                    if (!eliminar) {
		                        resultado.addAll(bloqueDocente);
		                        resultado.add(""); // línea en blanco entre docentes
		                    }

		                    // Reset
		                    eliminar = false;
		                    dentroDocente = false;
		                    bloqueDocente.clear();
		                }

		            } else {
		                // Líneas sueltas fuera de DOCENTE (por seguridad)
		                resultado.add(linea);
		            }
		        }

		    } catch (IOException e) {
		        System.err.println("Error al leer el archivo: " + e.getMessage());
		        return false;
		    }

		    // Reescribir archivo SOLO si se encontró la cédula
		    if (encontrado) {
		        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
		            for (String l : resultado) {
		                pw.println(l);
		            }
		        } catch (IOException e) {
		            System.err.println("Error al escribir el archivo: " + e.getMessage());
		            return false;
		        }
		    }

		    return encontrado;
    }

}
