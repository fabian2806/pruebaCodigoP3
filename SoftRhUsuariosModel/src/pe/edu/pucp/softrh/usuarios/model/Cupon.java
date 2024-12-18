package pe.edu.pucp.softrh.usuarios.model;

import java.util.ArrayList;
import java.util.Date;

public class Cupon {
	private Integer idCupon;
	private String codigo;
	private String descripcion;
	private Date fechaInicio;
	private Date fechaFin;
	private Boolean activo;
	private Trabajador trabajador;
	private ArrayList<Cliente> clientes;

	public Cupon() {
		this.idCupon = null;
		this.codigo = null;
		this.descripcion = null;
		this.fechaInicio = null;
		this.fechaFin = null;
		this.activo = null;
		this.trabajador = new Trabajador();
		this.clientes = new ArrayList<>();
	}

	public Cupon(String codigo, String descripcion, Date fechaInicio, Date fechaFin, Trabajador trabajador) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.activo = true;
		this.trabajador = trabajador;
		this.clientes = new ArrayList<>();
	}

	public Integer getIdCupon() {
		return idCupon;
	}

	public void setIdCupon(int idCupon) {
		this.idCupon = idCupon;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Trabajador getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}

	public void agregarCliente(Cliente cliente) {
		clientes.add(cliente);
	}

	@Override
	public String toString() {
		return "idCupon=" + idCupon + ", idTrabajador=" + trabajador.getIdUsuario() + ", codigo=" + codigo + ", descripcion=" + descripcion + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ".";
	}
}
