/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.softrh.prendas.dao;

/**
 *
 * @author Fabián
 */
public interface PromocionDAO {
    
    public Integer insertar(Promocion promocion);
    
    public Integer modificar(Promocion promocionModificada);
    
    public Integer eliminar(Promocion promocion);
    
    public ArrayList<Promocion> obtenerTodos();
    
    public Promocion obtenerPorId(String idPromocion);
}
