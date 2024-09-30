/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softrh.prendas.bo;

/**
 *
 * @author Fabián
 */
public class PromocionBO {
    
    private PromocionDAO promocionDAO;
    
    public PromocionBO(){
        this.PromocionDAO = new PromocionDAOImplementacion();
    }

    public Integer insertar(String nombre, String descripcion, Double valorDescuento, TipoPromocion tipo, 
            Date fechaInicio, Date fechaFin, Integer idTrabajador, Prenda prenda, Boolean activo){
        Promocion promocion = new Promocion(nombre, descripcion, valorDescuento, tipo,
                fechaInicio, fechaFin, idTrabajador, prenda, activo);
        return this.promocionDAO.insertar(promocion);
    }
    
    public Integer modificar(Promocion promocion){ //la prenda ya modificada
        return this.promocionDAO.modificar(promocion);
    }
    
    public Integer eliminar(Promocion promocion){
        return this.promocionDAO.eliminar(promocion);
    }
    
    public ArrayList<Promocion> obtenerTodos() {
        return this.promocionDAO.obtenerTodos();
    }
    
    public Promocion obtenerPorId(String idPromocion) {
        return this.promocionDAO.obtenerPorId(idPromocion);
    }
    
}
