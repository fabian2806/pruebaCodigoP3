package pe.edu.pucp.softrh.usuarios.model;

public class Direccion {
	private static int id = 1;
	private int idDireccion;
	private String calle;
	private String numero;
	private String distrito;
	private String provincia;
	private String departamento;
	private String codigoPostal;
	private String referencia;
	private boolean activo;
	private Cliente cliente;

	public Direccion(){};

	public Direccion(String calle, String numero, String distrito, String provincia, String departamento, String codigoPostal, String referencia, boolean activo, Cliente cliente) {
		this.calle = calle;
		this.numero = numero;
		this.distrito = distrito;
		this.provincia = provincia;
		this.departamento = departamento;
		this.codigoPostal = codigoPostal;
		this.referencia = referencia;
		this.activo = activo;
		this.cliente = cliente;
	}

	public int getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(int idDireccion) {
		this.idDireccion = idDireccion;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}


}
