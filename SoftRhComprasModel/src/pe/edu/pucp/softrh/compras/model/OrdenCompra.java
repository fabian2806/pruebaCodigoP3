package pe.edu.pucp.softrh.compras.model;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.softrh.usuarios.model.Cliente;
import pe.edu.pucp.softrh.usuarios.model.Cupon;

public class OrdenCompra {
    private Integer idOrden;
    private Date fechaRegistro;
    private Date fechaProcesado;
    private Date fechaEntregado;
    private Date fechaAnulado;
    private Estado estado;
    private String dni;
    private String correo;
    private Double subtotal;
    private Cliente cliente;
    private Cupon cupon;
    private Carrito carrito;
    private Comprobante comprobante;
    private ArrayList<PrendaSeleccionada> prendas;

    public OrdenCompra() {}

    public OrdenCompra(Date fechaRegistro, String dni, String correo, Double subtotal, Cliente cliente, Carrito carrito) {
        this.fechaRegistro = fechaRegistro;
        this.fechaProcesado = null;
        this.fechaEntregado = null;
        this.fechaAnulado = null;
        this.estado = Estado.Registrado;
        this.dni = dni;
        this.correo = correo;
        this.subtotal = subtotal;
        this.cliente = cliente;
        this.cupon = null;
        this.carrito = carrito;
        this.comprobante = null;
        this.prendas = new ArrayList<>();
    }

    public Integer getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Integer idOrden) {
        this.idOrden = idOrden;
    }

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Date getFechaProcesado() {
		return fechaProcesado;
	}

	public void setFechaProcesado(Date fechaProcesado) {
		this.fechaProcesado = fechaProcesado;
	}

	public Date getFechaEntregado() {
		return fechaEntregado;
	}

	public void setFechaEntregado(Date fechaEntregado) {
		this.fechaEntregado = fechaEntregado;
	}

	public Date getFechaAnulado() {
		return fechaAnulado;
	}

	public void setFechaAnulado(Date fechaAnulado) {
		this.fechaAnulado = fechaAnulado;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cupon getCupon() {
		return cupon;
	}

	public void setCupon(Cupon cupon) {
		this.cupon = cupon;
	}

	public Carrito getCarrito() {
		return carrito;
	}

	public void setCarrito(Carrito carrito) {
		this.carrito = carrito;
	}

	public Comprobante getComprobante() {
		return comprobante;
	}

	public void setComprobante(Comprobante comprobante) {
		this.comprobante = comprobante;
	}

	public void agregarPrendaSeleccionada(PrendaSeleccionada prenda) {
		prendas.add(prenda);
	}
}
