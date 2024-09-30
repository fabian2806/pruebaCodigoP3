package pe.edu.pucp.softrh.usuarios.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

public class Trabajador extends Usuario implements Funciones {
	private Date fechaContrato;
	private LocalTime horario;
	private ArrayList<Cupon> cupones;

	public Trabajador() {}

	public Trabajador(String dni, String nombres, String apellidos, String correo, String contrasenha, Date fechaContrato, LocalTime horario) {
		super(dni, nombres, apellidos, correo, contrasenha);
		this.fechaContrato = fechaContrato;
		this.horario = horario;
		this.cupones = new ArrayList<>();
	}

	@Override
	public void crearPrendas() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public void crearPromociones() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public void crearCupon() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public void listarPromocion() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public void listarCupones() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public void listarBoletas() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public void listarFacturas() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}
}
