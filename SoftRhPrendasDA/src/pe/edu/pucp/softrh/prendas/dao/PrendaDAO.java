/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.softrh.prendas.dao;

/**
 *
 * @author Fabián
 */
public interface PrendaDAO {
    public Integer insertar(Prenda prenda);
    
    public Integer modificar(Prenda prendaModificada);
    
    public Integer eliminar(Prenda prenda);
    
    public ArrayList<Prenda> obtenerTodos();
    
    public Prenda obtenerPorId(String idPrenda);
}
