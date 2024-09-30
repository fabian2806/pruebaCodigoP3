/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softrh.compras.dao;
import pe.edu.pucp.softrh.compras.model.PrendaSeleccionada;
import java.util.ArrayList;
/**
 *
 * @author JP
 */
public interface PrendaSeleccionadaDAO {
    public Integer insertar(PrendaSeleccionada prenda);
    
    public Integer modificar(PrendaSeleccionada prendaModificada);
    
    public Integer eliminar(PrendaSeleccionada prenda);
    
    public ArrayList<PrendaSeleccionada> obtenerTodos();
    
    //public PrendaSeleccionada obtenerPorId(String idPrendaS);
}
