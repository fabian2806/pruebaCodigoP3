package pe.edu.pucp.softrh.compras.model;

import java.util.ArrayList;

public class Carrito {
    private Integer idCarrito;
    private Integer cantidadTotal;
    private Double precioTotal;
	private OrdenCompra orden;
	private ArrayList<PrendaSeleccionada> prendas;

	public Carrito() {}

    public Carrito(Integer cantidadTotal, Double precioTotal) {
        this.cantidadTotal = cantidadTotal;
        this.precioTotal = precioTotal;
		this.orden = null;
		this.prendas = new ArrayList<>();
    }

    public Integer getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(Integer idCarrito) {
        this.idCarrito = idCarrito;
    }

    public Integer getCantidadTotal() {
        return cantidadTotal;
    }

    public void setCantidadTotal(Integer cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
    }

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
	}

	public OrdenCompra getOrden() {
		return orden;
	}

	public void setOrden(OrdenCompra orden) {
		this.orden = orden;
	}

	public void agregarPrendas(PrendaSeleccionada prenda) {
		prendas.add(prenda);
	}

	public void calcularCantidadTotal() {
		setCantidadTotal(prendas.size());
	}

	public void calcularPrecioTotal() {
		Double precio = 0.0;
		for(PrendaSeleccionada prenda : prendas) {
			precio += prenda.getPrecio();
		}
		setPrecioTotal(precio);
	}
}
