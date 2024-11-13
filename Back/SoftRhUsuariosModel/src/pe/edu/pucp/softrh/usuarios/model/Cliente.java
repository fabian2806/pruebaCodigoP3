package pe.edu.pucp.softrh.usuarios.model;

import java.util.ArrayList;
import java.util.Date;

public class Cliente extends Usuario {
	private String telefono;
	private Date fechaRegistro;
	private Boolean recibePromociones;
	private ArrayList<Direccion> direcciones;
	private ArrayList<Cupon> cupones;

	public Cliente() {
		super();
		this.telefono = null;
		this.fechaRegistro = null;
		this.recibePromociones = null;
		this.direcciones = new ArrayList<>();
		this.cupones = new ArrayList<>();
	}

	public Cliente(String dni, String nombres, String apellidos, String correo, String contrasenha, String telefono, Date fechaRegistro, Boolean recibePromociones) {
		super(dni, nombres, apellidos, correo, contrasenha);
		this.telefono = telefono;
		this.fechaRegistro = fechaRegistro;
		this.recibePromociones = recibePromociones;
		this.direcciones = new ArrayList<>();
		this.cupones = new ArrayList<>();
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Boolean getRecibePromociones() {
		return recibePromociones;
	}

	public void setRecibePromociones(Boolean recibePromociones) {
		this.recibePromociones = recibePromociones;
	}

	public void agregarDireccion(Direccion direccion) {
		direcciones.add(direccion);
	}

	public void agregarCupon(Cupon cupon) {
		cupones.add(cupon);
	}

	public void pagar() {}
}
