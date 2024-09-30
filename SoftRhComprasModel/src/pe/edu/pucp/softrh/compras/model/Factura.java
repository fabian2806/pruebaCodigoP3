/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softrh.compras.model;

/**
 *
 * @author JP
 */
public class Factura extends Comprobante{
    private String ruc;
    private String razonSocial;
    private String repreLegal;
    
    public Factura(String ruc, String razonSocial, String repreLegal, Integer idComprobante, Double totalPagar) {
        super(idComprobante, totalPagar);
        this.ruc = ruc;
        this.razonSocial = razonSocial;
        this.repreLegal = repreLegal;
    }
 
    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRepreLegal() {
        return repreLegal;
    }
    
    public void setRepreLegal(String repreLegal) {
        this.repreLegal = repreLegal;
    }   
    
    
}
