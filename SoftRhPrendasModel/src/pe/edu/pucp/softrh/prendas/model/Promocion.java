package pe.edu.pucp.softrh.prendas.model;

import java.util.ArrayList;
import java.util.Date;

public class Promocion {
    private static Integer id=1;
    private Integer idPromocion;
    private String nombre;
    private String descripcion;
    private Double valorDescuento;
    private TipoPromocion tipo;
    private Date fechaInicio;
    private Date fechaFin;
    private Integer idTrabajador;
    private ArrayList<Prenda> prendas;
    private Boolean activo;

    public Promocion(){}

    public Promocion(String nombre, String descripcion, Double valorDescuento,
            TipoPromocion tipo, Date fechaInicio, Date fechaFin,
            Integer idTrabajador, Prenda prenda){
        this.idPromocion = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.valorDescuento = valorDescuento;
        this.tipo = tipo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.idTrabajador = idTrabajador;
        this.prendas = new ArrayList<>();
        this.agregarPrenda(prenda);
        this.activo = true;
        id++;
    }

    public int getIdPromocion() {
            return idPromocion;
    }

    public void setIdPromocion(int idPromocion) {
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

    public double getValorDescuento() {
            return valorDescuento;
    }

    public void setValorDescuento(double valorDescuento) {
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

    public int getIdTrabajador() {
            return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
            this.idTrabajador = idTrabajador;
    }

    public void agregarPrenda(Prenda prenda) {
            prendas.add(prenda);
            prenda.aplicarPromocion(this);
    }

    public boolean isActivo() {
            return activo;
    }

    public void setActivo(boolean activo) {
            this.activo = activo;
    }
}
