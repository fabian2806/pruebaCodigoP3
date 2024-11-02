package pe.edu.pucp.softrh.usuarios.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

public class Trabajador extends Usuario implements Funciones {
	private String puesto;
	private Double sueldo;
	private Date fechaIngreso;
	private LocalTime horarioInicio;
	private LocalTime horarioFin;
	private ArrayList<Cupon> cupones;

	public Trabajador() {
		super();
		this.puesto = null;
		this.sueldo = null;
		this.fechaIngreso = null;
		this.horarioInicio = null;
		this.horarioFin = null;
		this.cupones = new ArrayList<>();
	}

	public Trabajador(String dni, String nombres, String apellidos, String correo, String contrasenha, String puesto, Double sueldo, Date fechaIngreso, LocalTime horarioInicio, LocalTime horarioFin) {
		super(dni, nombres, apellidos, correo, contrasenha);
		this.puesto = puesto;
		this.sueldo = sueldo;
		this.fechaIngreso = fechaIngreso;
		this.horarioInicio = horarioInicio;
		this.horarioFin = horarioFin;
		this.cupones = new ArrayList<>();
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public Double getSueldo() {
		return sueldo;
	}

	public void setSueldo(Double sueldo) {
		this.sueldo = sueldo;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public LocalTime getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(LocalTime horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public LocalTime getHorarioFin() {
		return horarioFin;
	}

	public void setHorarioFin(LocalTime horarioFin) {
		this.horarioFin = horarioFin;
	}

	public void agregarCupon(Cupon cupon) {
		cupones.add(cupon);
	}

	@Override
	public void crearPrenda() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public void crearPromocion() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public void crearCupon() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public void listarPromociones() {
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
