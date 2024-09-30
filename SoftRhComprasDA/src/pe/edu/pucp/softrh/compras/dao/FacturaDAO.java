/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softrh.compras.dao;
import pe.edu.pucp.softrh.compras.model.Factura;
import java.util.ArrayList;

/**
 *
 * @author JP
 */
public interface FacturaDAO {
    public Integer insertar(Factura documento);
    
    public Integer modificar(Factura documentoModificada);
    
    public Integer eliminar(Factura documento);
    
    public ArrayList<Factura> obtenerTodos();
    
    public Factura obtenerPorId(Integer idComprobante);
}
