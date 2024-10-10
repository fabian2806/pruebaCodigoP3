package pe.edu.pucp.softrh.usuarios.model;

import java.util.ArrayList;

public class Cliente extends Usuario {
	private ArrayList<Direccion> direcciones;
	private ArrayList<Cupon> cupones;

	public Cliente() {
		super();
		this.direcciones = new ArrayList<>();
		this.cupones = new ArrayList<>();
	}

	public Cliente(String dni, String nombres, String apellidos, String correo, String contrasenha) {
		super(dni, nombres, apellidos, correo, contrasenha);
		this.direcciones = new ArrayList<>();
		this.cupones = new ArrayList<>();
	}

	public void agregarDireccion(Direccion direccion) {
		direcciones.add(direccion);
	}

	public void agregarCupon(Cupon cupon) {
		cupones.add(cupon);
	}

	public void pagar() {}
}
