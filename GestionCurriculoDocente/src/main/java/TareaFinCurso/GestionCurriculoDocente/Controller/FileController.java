package TareaFinCurso.GestionCurriculoDocente.Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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

public class FileController {

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
		  ArrayList<Docente> docentes =  App.getDocentes();
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
	  
	  
	  
	  public void actualizarArchivo() { //Metodo que sobreescribe todo el archivo txt
	        System.out.println("Iniciando actualización de archivo..."); 
	        ArrayList<Docente> docentes =  App.getDocentes();
	        String rutaArchivo = App.getRutaArchivo();
	        try (PrintWriter pw = new PrintWriter(new FileWriter(rutaArchivo, false))) { //Try y catch para abrir el archivo en modo escritua
	            for (Docente d : docentes) { //Por cada docente que haya en el array llamar s u metodo toString e imprimirlo en el txtr
	                pw.print(d.toString()); 
	            }
	            System.out.println("Archivo actualizado correctamente.");  
	        } catch (IOException e) {//Lanzamos el error
	            e.printStackTrace();
	            System.out.println("Error al guardar los cambios: " + e.getMessage());
	        }
	    } 
	  
}
