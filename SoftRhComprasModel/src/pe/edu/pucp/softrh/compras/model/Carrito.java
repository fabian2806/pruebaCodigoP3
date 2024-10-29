package pe.edu.pucp.softrh.compras.model;

import java.util.ArrayList;
import pe.edu.pucp.softrh.usuarios.model.Cliente;

public class Carrito {
    private Integer idCarrito;
    private Integer cantidadTotal;
    private Double precioTotal;
    private Cliente cliente;
    //private OrdenCompra orden;
    private ArrayList<PrendaSeleccionada> prendas;

	public Carrito() {}

    public Carrito(Integer cantidadTotal, Double precioTotal, Cliente cliente) {
        this.cantidadTotal = cantidadTotal;
        this.precioTotal = precioTotal;
        //this.orden = null;
        this.cliente = cliente;
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

//    public OrdenCompra getOrden() {
//            return orden;
//    }
//
//    public void setOrden(OrdenCompra orden) {
//            this.orden = orden;
//    }
    
    public Cliente getCliente() {
            return cliente;    
    }

    public void setCliente(Cliente cliente) {
            this.cliente = cliente;
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
