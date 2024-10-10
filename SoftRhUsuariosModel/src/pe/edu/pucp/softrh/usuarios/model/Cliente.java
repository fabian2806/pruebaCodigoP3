package pe.edu.pucp.softrh.usuarios.model;

import java.util.ArrayList;

public class Cliente extends Usuario {
	private ArrayList<Direccion> direcciones;
	private ArrayList<Cupon> cupones;

	public Cliente() {}

	public Cliente(String dni, String nombres, String apellidos, String correo, String contrasenha) {
		super(dni, nombres, apellidos, correo, contrasenha);
		direcciones = new ArrayList<>();
		cupones = new ArrayList<>();
	}

	public ArrayList<Direccion> getDirecciones() {
		return direcciones;
	}

	public ArrayList<Cupon> getCupones() {
		return cupones;
	}

	public void agregarDireccion(Direccion direccion) {
		direcciones.add(direccion);
	}

	public void usarCupon(){}

	public void agregarProductoAlCarrito(){}

	public void pagar(){}

	public void visualizarComprasRealizadas(){}
}
