/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softrh.compras.model;

/**
 *
 * @author JP
 */
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
