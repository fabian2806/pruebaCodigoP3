package pe.edu.pucp.softrh.prendas.model;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.softrh.usuarios.model.Trabajador;

public class Promocion {

    private Integer idPromocion;
    private String nombre;
    private String descripcion;
    private Double valorDescuento;
    private TipoPromocion tipo;
    private Date fechaInicio;
    private Date fechaFin;
    private Boolean activo;
    private Trabajador trabajador;
    private ArrayList<Prenda> prendas;

    public Promocion() {
        this.idPromocion = null;
        this.nombre = null;
        this.descripcion = null;
        this.valorDescuento = null;
        this.tipo = null;
        this.fechaInicio = null;
        this.fechaFin = null;
        this.activo = null;
        this.trabajador = new Trabajador();
        this.prendas = new ArrayList<>();
    }

    public Promocion(String nombre, String descripcion, Double valorDescuento, TipoPromocion tipo, Date fechaInicio, Date fechaFin, Trabajador trabajador) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.valorDescuento = valorDescuento;
        this.tipo = tipo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.activo = true;
        this.trabajador = trabajador;
        this.prendas = new ArrayList<>();
    }

    public Integer getIdPromocion() {
        return idPromocion;
    }

    public void setIdPromocion(Integer idPromocion) {
        this.idPromocion = idPromocion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getValorDescuento() {
        return valorDescuento;
    }

    public void setValorDescuento(Double valorDescuento) {
        this.valorDescuento = valorDescuento;
    }

    public TipoPromocion getTipo() {
        return tipo;
    }

    public void setTipo(TipoPromocion tipo) {
        this.tipo = tipo;
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

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public void agregarPrenda(Prenda prenda) {
        prendas.add(prenda);
        prenda.aplicarPromocion(this);
    }

    public Prenda getPrenda(int indice){
        return prendas.get(indice);
    }

	public ArrayList<Prenda> getPrendas() {
		return this.prendas;
	}

    @Override
    public String toString() {
        return "idPromocion=" + idPromocion + ", idTrabajador=" + trabajador.getIdUsuario() + ", nombre=" + nombre + ", descripcion=" + descripcion + ", valorDescuento=" + valorDescuento + ", tipo=" + tipo + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ".";
    }
}
