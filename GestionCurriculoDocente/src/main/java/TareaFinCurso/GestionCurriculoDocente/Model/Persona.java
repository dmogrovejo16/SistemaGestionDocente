package TareaFinCurso.GestionCurriculoDocente.Model;

public class Persona {
	String nombres, apellidos, fechaNac,nacionalidad, estadoCivil, tipoSangre, ciudadNac, direccion,correo;
	int cedula, telefonoCel, telefonoConv;
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public Persona() {
		super();
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public String getTipoSangre() {
		return tipoSangre;
	}
	public void setTipoSangre(String tipoSangre) {
		this.tipoSangre = tipoSangre;
	}
	public String getCiudadNac() {
		return ciudadNac;
	}
	public void setCiudadNac(String ciudadNac) {
		this.ciudadNac = ciudadNac;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public int getCedula() {
		return cedula;
	}
	public void setCedula(int cedula) {
		this.cedula = cedula;
	}
	public int getTelefonoCel() {
		return telefonoCel;
	}
	public void setTelefonoCel(int telefonoCel) {
		this.telefonoCel = telefonoCel;
	}
	public int getTelefonoConv() {
		return telefonoConv;
	}
	public void setTelefonoConv(int telefonoConv) {
		this.telefonoConv = telefonoConv;
	}
	public Persona(String nombres, String apellidos, String fechaNac, String nacionalidad, String estadoCivil,
			String tipoSangre, String ciudadNac, String direccion, String correo, int cedula, int telefonoCel,
			int telefonoConv) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.fechaNac = fechaNac;
		this.nacionalidad = nacionalidad;
		this.estadoCivil = estadoCivil;
		this.tipoSangre = tipoSangre;
		this.ciudadNac = ciudadNac;
		this.direccion = direccion;
		this.correo = correo;
		this.cedula = cedula;
		this.telefonoCel = telefonoCel;
		this.telefonoConv = telefonoConv;
	}
}
