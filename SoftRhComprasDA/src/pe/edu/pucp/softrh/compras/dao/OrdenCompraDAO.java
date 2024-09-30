/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softrh.compras.dao;
import pe.edu.pucp.softrh.compras.model.OrdenCompra;
import java.util.ArrayList;
/**
 *
 * @author JP
 */
public interface OrdenCompraDAO {
    public Integer insertar(OrdenCompra documento);
    
    public Integer modificar(OrdenCompra documentoModificada);
    
    public Integer eliminar(OrdenCompra documento);
    
    public ArrayList<OrdenCompra> obtenerTodos();
    
    public OrdenCompra obtenerPorId(Integer idOrden);  
}
