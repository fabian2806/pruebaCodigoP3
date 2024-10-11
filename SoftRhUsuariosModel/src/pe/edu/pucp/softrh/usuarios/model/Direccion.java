package pe.edu.pucp.softrh.usuarios.model;

public class Direccion {
	private Integer idDireccion;
	private String direccion;
	private String distrito;
	private String provincia;
	private String departamento;
	private String codigoPostal;
	private String referencia;
	private Boolean activo;
	private Cliente cliente;

	public Direccion() {
		this.idDireccion = null;
		this.direccion = null;
		this.distrito = null;
		this.provincia = null;
		this.departamento = null;
		this.codigoPostal = null;
		this.referencia = null;
		this.activo = null;
		this.cliente = new Cliente();
	};

	public Direccion(String direccion, String distrito, String provincia, String departamento, String codigoPostal, String referencia, Cliente cliente) {
		this.direccion = direccion;
		this.distrito = distrito;
		this.provincia = provincia;
		this.departamento = departamento;
		this.codigoPostal = codigoPostal;
		this.referencia = referencia;
		this.activo = true;
		this.cliente = cliente;
	}

	public Integer getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(Integer idDireccion) {
		this.idDireccion = idDireccion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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

	public Boolean isActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "idDireccion=" + idDireccion + ", idCliente=" + cliente.getIdUsuario() + ", direccion=" + direccion + ", distrito=" + distrito + ", provincia=" + provincia + ", departamento=" + departamento + ", codigoPostal=" + codigoPostal + ", referencia=" + referencia + ".";
	}
}
