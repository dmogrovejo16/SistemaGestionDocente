package TareaFinCurso.GestionCurriculoDocente;

import java.util.ArrayList;

public class Docente extends Persona {
//Creamos arrays con la informacion profesional del docente, arrays de objetos
	ArrayList<Capacitacion> capacitaciones = new ArrayList<>();
	ArrayList<Experiencia> experiencias = new ArrayList<>();
	ArrayList<Titulo> titulos = new ArrayList<>();
	ArrayList<ProduccionAcademica> producciones = new ArrayList<>();
	
	public Docente() { //Constructor vacio
		super();
	}

	
//Constructor con atributos
	public Docente(String nombres, String apellidos, String fechaNac, String nacionalidad, String estadoCivil,
			String tipoSangre, String ciudadNac, String direccion, String correo, int cedula, int telefonoCel,
			int telefonoConv, ArrayList<Capacitacion> capacitaciones, ArrayList<Experiencia> experiencias,
			ArrayList<Titulo> titulos, ArrayList<ProduccionAcademica> producciones) {
		super(nombres, apellidos, fechaNac, nacionalidad, estadoCivil, tipoSangre, ciudadNac, direccion, correo, cedula,
				telefonoCel, telefonoConv); //Docene llama al constrictor de Persona, la clase padre
		this.capacitaciones = capacitaciones;
		this.experiencias = experiencias;
		this.titulos = titulos;
	}

	
	
	
	public ArrayList<ProduccionAcademica> getProducciones() { //Getters y seters para los atributos
		return producciones;
	}



	public void setProducciones(ArrayList<ProduccionAcademica> producciones) {
		this.producciones = producciones;
	}



	@Override
	public String toString() { //Creamos un metod toString que será el que se pase al archivo txt, el formato facilita la lectura
	    StringBuilder sb = new StringBuilder(); //Creamos un contructor de texto, que nos permite agregar diferentes lineas en momento de ejecuccion

	    sb.append("DOCENTE\n");
	    sb.append("NOMBRES=").append(nombres).append("\n"); //Cada cmapo posee un identificador de la informacion a continuacino, facilita la lectura
	    sb.append("APELLIDOS=").append(apellidos).append("\n");
	    sb.append("CEDULA=").append(cedula).append("\n");
	    sb.append("FECHA_NAC=").append(fechaNac).append("\n");
	    sb.append("NACIONALIDAD=").append(nacionalidad).append("\n");
	    sb.append("ESTADO_CIVIL=").append(estadoCivil).append("\n");
	    sb.append("TIPO_SANGRE=").append(tipoSangre).append("\n");
	    sb.append("CIUDAD_NAC=").append(ciudadNac).append("\n");
	    sb.append("DIRECCION=").append(direccion).append("\n");
	    sb.append("CORREO=").append(correo).append("\n");
	    sb.append("TEL_CEL=").append(telefonoCel).append("\n");
	    sb.append("TEL_CONV=").append(telefonoConv).append("\n");

	    // ---------- TITULOS ----------
	    sb.append("TITULOS\n"); //Cada subacampo posee un identificador para indicarle en un futuro al bufferReader que aqui empieza la seccion, para empezar a ahcer arrays
	    for (Titulo t : titulos) {
	        sb.append(t.getInstitucion()).append(";")
	          .append(t.getTitulo()).append(";")
	          .append(t.getCiudad()).append(";")
	          .append(t.getFecha()).append("\n");
	    }
	    sb.append("FIN_TITULOS\n");

	    // ---------- CAPACITACIONES ----------
	    sb.append("CAPACITACIONES\n");
	    for (Capacitacion c : capacitaciones) {
	        sb.append(c.tipoCapacitacion()).append(";")
	          .append(c.getTipoEvento()).append(";")
	          .append(c.getInstitucion()).append(";")
	          .append(c.getFechaIni()).append(";")
	          .append(c.getFechaFin()).append(";")
	          .append(c.getNumHoras()).append("\n");
	    }
	    sb.append("FIN_CAPACITACIONES\n");

	    // ---------- EXPERIENCIAS ----------
	    sb.append("EXPERIENCIAS\n");
	    for (Experiencia e : experiencias) {
	        if (e instanceof ExperienciaDocente) {
	        	ExperienciaDocente ed = (ExperienciaDocente) e;
	            sb.append("DOCENTE;")
	              .append(ed.getInstitucion()).append(";")
	              .append(ed.getCatedra()).append(";")
	              .append(ed.getFechaIni()).append(";")
	              .append(ed.getFechaFin()).append("\n");
	        } else if (e instanceof ExperienciaNoDocente ) {
	        	ExperienciaNoDocente en = (ExperienciaNoDocente) e;
	            sb.append("NO_DOCENTE;")
	              .append(en.getInstitucion()).append(";")
	              .append(en.getFuncion()).append(";")
	              .append(en.getFechaIni()).append(";")
	              .append(en.getFechaFin()).append("\n");
	        } else if (e instanceof ReferenciaLaboral) {
	        	ReferenciaLaboral r = (ReferenciaLaboral ) e;
	            sb.append("REFERENCIA;")
	              .append(r.getInstitucion()).append(";")
	              .append(r.getJefeInmediato()).append(";")
	              .append(r.getTelefonoJefe()).append("\n");
	        }
	    }
	    sb.append("FIN_EXPERIENCIAS\n");

	    // ---------- PRODUCCIONES ----------
	    sb.append("PRODUCCIONES\n");
	    for (ProduccionAcademica p : producciones) {
	        if (p instanceof Publicacion ) {
	        	Publicacion pub = (Publicacion)p;
	            sb.append("PUBLICACION;")
	              .append(pub.getTitulo()).append(";")
	              .append(pub.getAnio()).append(";")
	              .append(pub.getEditorial()).append("\n");
	        } else if (p instanceof Investigacion) {
	        	Investigacion inv = (Investigacion) p;
	            sb.append("INVESTIGACION;")
	              .append(inv.getTitulo()).append(";")
	              .append(inv.getAnio()).append(";")
	              .append(inv.getInstitucion()).append("\n");
	        }
	    }
	    sb.append("FIN_PRODUCCIONES\n");

	    sb.append("FIN_DOCENTE\n\n");

	    return sb.toString(); //Transformamos todo el bloque de texto a una cadena y la devolvemos
	}

	
	//GETTERS y SETTERS para atributos
	public ArrayList<Capacitacion> getCapacitaciones() {
		return capacitaciones;
	}

	public void setCapacitaciones(ArrayList<Capacitacion> capacitaciones) {
		this.capacitaciones = capacitaciones;
	}

	public ArrayList<Experiencia> getExperiencias() {
		return experiencias;
	}

	public void setExperiencias(ArrayList<Experiencia> experiencias) {
		this.experiencias = experiencias;
	}

	public ArrayList<Titulo> getTitulos() {
		return titulos;
	}

	public void setTitulos(ArrayList<Titulo> titulos) {
		this.titulos = titulos;
	}

}
