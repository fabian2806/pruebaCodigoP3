package pe.edu.pucp.softrh.compras.model;

import java.util.Date;

public class OrdenCompra {
    private static Integer id=1;
    private Integer idOrden;
    private Date fechaPedido;
    private Date fechaPago;
    private Estado estado;
    private String dni;
    private String correo;
    private Double subtotal;

    public OrdenCompra(Integer idOrden, Date fechaPedido, Date fechaPago,
            Estado estado, String dni, String correo, Double subtotal) {
        this.idOrden = id;
        this.fechaPedido = fechaPedido;
        this.fechaPago = fechaPago;
        this.estado = estado;
        this.dni = dni;
        this.correo = correo;
        this.subtotal = subtotal;
        id++;
    }

    public Integer getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Integer idOrden) {
        this.idOrden = idOrden;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }
}
