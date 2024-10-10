package pe.edu.pucp.softrh.usuarios.model;

public abstract class Usuario {
	protected Integer idUsuario;
	protected String dni;
	protected String nombres;
	protected String apellidos;
	protected String correo;
	protected String contrasenha;
	protected Boolean activo;

	public Usuario() {
		this.idUsuario = null;
		this.dni = null;
		this.nombres = null;
		this.apellidos = null;
		this.correo = null;
		this.contrasenha = null;
		this.activo = null;
	}

	public Usuario(String dni, String nombres, String apellidos, String correo, String contrasenha) {
		this.dni = dni;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.correo = correo;
		this.contrasenha = contrasenha;
		this.activo = true;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasenha() {
		return contrasenha;
	}

	public void setContrasenha(String contrasenha) {
		this.contrasenha = contrasenha;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
}
