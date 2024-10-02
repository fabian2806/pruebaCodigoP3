package pe.edu.pucp.softrh.compras.model;

public class Carrito {
    private static Integer id=1;
    private Integer idCarrito;
    private Integer cantidadTotal;
    private Double precioTotal;

    public Carrito(Integer idCarrito, Integer cantidadTotal, Double precioTotal) {
        this.idCarrito = id;
        this.cantidadTotal = cantidadTotal;
        this.precioTotal = precioTotal;
        id++;
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
}
