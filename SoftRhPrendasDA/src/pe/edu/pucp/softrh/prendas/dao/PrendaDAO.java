/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softrh.prendas.dao;

/**
 *
 * @author Fabián
 */
public class PrendaDAO {
    public Integer insertar(Prenda prenda);
    
    public Integer actualizarPorId(Integer id, Prenda prendaModificada);
    
    public Integer eliminar(Integer id);
    
    public ArrayList<Prenda> obtenerTodos();
    
    public Prenda obtenerPorId(String idPrenda);
}
