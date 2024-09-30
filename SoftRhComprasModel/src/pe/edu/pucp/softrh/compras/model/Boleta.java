/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softrh.compras.model;

/**
 *
 * @author JP
 */
public class Boleta extends Comprobante{
    private String dni;
    private String nombres;
    private String apellidos;
    
    public Boleta(String dni, String nombres, String apellidos, Integer idComprobante, Double totalPagar) {
        super(idComprobante, totalPagar);
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }   
    
    
}