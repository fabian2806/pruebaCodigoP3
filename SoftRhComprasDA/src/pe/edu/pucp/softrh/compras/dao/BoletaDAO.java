/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softrh.compras.dao;
import pe.edu.pucp.softrh.compras.model.Boleta;
import java.util.ArrayList;
/**
 *
 * @author JP
 */
public interface BoletaDAO {
    public Integer insertar(Boleta documento);
    
    public Integer modificar(Boleta documentoModificada);
    
    public Integer eliminar(Boleta documento);
    
    public ArrayList<Boleta> obtenerTodos();
    
    public Boleta obtenerPorId(Integer idComprobante);
}
