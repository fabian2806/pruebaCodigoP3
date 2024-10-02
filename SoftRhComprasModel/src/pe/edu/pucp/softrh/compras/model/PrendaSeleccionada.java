package pe.edu.pucp.softrh.compras.model;

public class PrendaSeleccionada {
    private Integer cantidad;
    private Double precio;

    public PrendaSeleccionada(Integer cantidad, Double precio) {
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
