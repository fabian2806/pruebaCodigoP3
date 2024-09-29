/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.softrh.prendas.bo;

import java.util.ArrayList;
import pe.edu.pucp.softrh.prendas.dao.PrendaDAO;
import pe.edu.pucp.softrh.prendas.daoimplementacion.PrendaDAOImplementacion;
import pe.edu.pucp.softrh.prendas.modelo.Genero;
import pe.edu.pucp.softrh.prendas.modelo.Prenda;
import pe.edu.pucp.softrh.prendas.modelo.Talla;
import pe.edu.pucp.softrh.prendas.modelo.TipoPrenda;

public class PrendasBO {
    private PrendaDAO prendaDAO;
    
    public PrendaBO()
    {
        this.prendaDAO = new PrendaDAOImplementacion();
    }

    public Integer insertar(String nombre, String descripcion, TipoPrenda tipo,
            String imagen, Talla talla, Genero genero, String color,
            double precio, int stock)
    {
        Prenda prenda = new Prenda(nombre, descripcion, tipo, imagen,
                talla, genero, color, precio, stock);
        return this.prendaDAO.insertar(prenda);
    }
    
    public Integer actualizarPorId(Integer id, Prenda prendaModificada){
        prendaModificada.setId(id);
        
        return this.prendaDAO.actualizarPorId(id, prendaModificada);
    }
    
    public Integer eliminacionLogica(Integer id){
        return this.prendaDAO.eliminar(id);
    }
    
    public ArrayList<Prenda> obtenerTodos() {
        return this.prendaDAO.obtenerTodos();
    }
}
