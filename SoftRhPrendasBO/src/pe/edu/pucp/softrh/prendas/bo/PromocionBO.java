/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softrh.prendas.bo;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.softrh.prendas.dao.PromocionDAO;
import pe.edu.pucp.softrh.prendas.daoimp.PromocionDAOImplementacion;
import pe.edu.pucp.softrh.prendas.model.Prenda;
import pe.edu.pucp.softrh.prendas.model.Promocion;
import pe.edu.pucp.softrh.prendas.model.TipoPromocion;


public class PromocionBO {
    
    private PromocionDAO promocionDAO;
    
    public PromocionBO(){
        this.promocionDAO = new PromocionDAOImplementacion();
    }

    public Integer insertar(String nombre, String descripcion, Double valorDescuento, TipoPromocion tipo, 
            Date fechaInicio, Date fechaFin, Integer idTrabajador, Prenda prenda){
        Promocion promocion = new Promocion(nombre, descripcion, valorDescuento, tipo,
                fechaInicio, fechaFin, idTrabajador, prenda);
        return this.promocionDAO.insertar(promocion);
    }
    
    public Integer modificar(Promocion promocion){ //la prenda ya modificada
        return this.promocionDAO.modificar(promocion);
    }
    
    public Integer eliminar(Promocion promocion){
        return this.promocionDAO.eliminar(promocion);
    }
    
    public ArrayList<Promocion> listarTodos() {
        return this.promocionDAO.listarTodos();
    }
    
    public Promocion obtenerPorId(String idPromocion) {
        return this.promocionDAO.obtenerPorId(idPromocion);
    }
    
}
