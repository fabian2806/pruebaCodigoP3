package pe.edu.pucp.softrh.prendas.bo;

import java.util.ArrayList;
import pe.edu.pucp.softrh.prendas.dao.PrendaDAO;

import pe.edu.pucp.softrh.prendas.daoimp.PrendaDAOImplementacion;
import pe.edu.pucp.softrh.prendas.model.Genero;
import pe.edu.pucp.softrh.prendas.model.Prenda;
import pe.edu.pucp.softrh.prendas.model.Talla;
import pe.edu.pucp.softrh.prendas.model.TipoPrenda;

public class PrendaBO {
    private PrendaDAO prendaDAO;

    public PrendaBO(){
        this.prendaDAO = new PrendaDAOImplementacion();
    }

    public Integer insertar(String nombre, String descripcion, TipoPrenda tipo, String imagen,
            Talla talla, Genero genero, String color, Double precio, Integer stock){
        Prenda prenda = new Prenda(nombre, descripcion, tipo, imagen,
                talla, genero, color, precio, stock);
        return this.prendaDAO.insertar(prenda);
    }

    public Integer modificar(Prenda prenda){ //la prenda ya modificada
        return this.prendaDAO.modificar(prenda);
    }

    public Integer eliminar(Prenda prenda){
        return this.prendaDAO.eliminar(prenda);
    }

    public ArrayList<Prenda> listarTodos() {
        return this.prendaDAO.listarTodos();
    }

    public Prenda obtenerPorId(String idPrenda) {
        return this.prendaDAO.obtenerPorId(idPrenda);
    }

}
