package pe.edu.pucp.softrh.usuarios.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

public class Trabajador extends Usuario implements Funciones {
	private String puesto;
	private Double salario;
	private Date fechaIngreso;
	private LocalTime horarioInicio;
	private LocalTime horarioFin;
	private ArrayList<Cupon> cupones;

	public Trabajador() {}

	public Trabajador(String dni, String nombres, String apellidos, String correo, String contrasenha, String puesto, Double salario, Date fechaIngreso, LocalTime horarioInicio, LocalTime horarioFin) {
		super(dni, nombres, apellidos, correo, contrasenha);
		this.puesto = puesto;
		this.salario = salario;
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

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
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

	public ArrayList<Cupon> getCupones() {
		return cupones;
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
