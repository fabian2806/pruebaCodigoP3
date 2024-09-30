/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softrh.compras.model;

/**
 *
 * @author JP
 */
public abstract class Comprobante {
    protected static Integer id=1;
    protected Integer idComprobante;
    protected Double totalPagar;
    
    public Comprobante(Integer idComprobante, Double totalPagar) {
        this.idComprobante = id;
        this.totalPagar = totalPagar;
        id++;
    }
    
    public Integer getIdComprobante() {
        return idComprobante;
    }

    public void setIdComprobante(Integer idComprobante) {
        this.idComprobante = idComprobante;
    }

    public Double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(Double totalPagar) {
        this.totalPagar = totalPagar;
    } 
    
}
