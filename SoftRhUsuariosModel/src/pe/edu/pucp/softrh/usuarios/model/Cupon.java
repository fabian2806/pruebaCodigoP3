package pe.edu.pucp.softrh.usuarios.model;

import java.util.ArrayList;
import java.util.Date;

public class Cupon {
	private static int id = 1;
	private int idCupon;
	private String codigo;
	private String descripcion;
	private Date fechaInicio;
	private Date fechaFin;
	private boolean usado;
	private boolean activo;
	private ArrayList<Cliente> clientes;

	public Cupon(String codigo, String descripcion, Date fechaInicio, Date fechaFin, boolean usado, boolean activo) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.usado = usado;
		this.activo = activo;
		this.clientes = new ArrayList<>();
	}

	public int getIdCupon() {
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

	public boolean isUsado() {
		return usado;
	}

	public void setUsado(boolean usado) {
		this.usado = usado;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public void agregarCliente(Cliente cliente) {
		clientes.add(cliente);
	}
}
