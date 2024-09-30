package pe.edu.pucp.softrh.usuarios.model;

public abstract class Usuario {
	protected static Integer id = 1;
	protected Integer idUsuario;
	protected String dni;
	protected String nombres;
	protected String apellidos;
	protected String correo;
	protected String contrasenha;
	protected Boolean activo;

	public Usuario(){}

	public Usuario(String dni, String nombres, String apellidos, String correo, String contrasenha) {
		this.dni = dni;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.correo = correo;
		this.contrasenha = contrasenha;
		this.activo = true;
	}
}
