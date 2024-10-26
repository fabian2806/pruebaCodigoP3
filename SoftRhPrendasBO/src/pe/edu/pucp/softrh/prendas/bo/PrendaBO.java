package pe.edu.pucp.softrh.prendas.bo;

import java.util.ArrayList;
import pe.edu.pucp.softrh.prendas.dao.PrendaDAO;
import pe.edu.pucp.softrh.prendas.daoimp.PrendaDAOImp;
import pe.edu.pucp.softrh.prendas.model.Genero;
import pe.edu.pucp.softrh.prendas.model.Prenda;
import pe.edu.pucp.softrh.prendas.model.Talla;
import pe.edu.pucp.softrh.prendas.model.TipoPrenda;

public class PrendaBO {
    private PrendaDAO prendaDAO;

    public PrendaBO(){
        this.prendaDAO = new PrendaDAOImp();
    }

    public Integer insertar(String nombre, String descripcion, TipoPrenda tipo, String imagen, Talla talla, Genero genero, String color, Double precioOriginal, Integer stock){
        Prenda prenda = new Prenda(nombre, descripcion, tipo, imagen, talla, genero, color, precioOriginal, stock);
        return this.prendaDAO.insertar(prenda);
    }

    public Integer modificar(Integer idPrenda, String nombre, String descripcion, TipoPrenda tipo, String imagen, Talla talla, Genero genero, String color, Double precioOriginal, Double precioDescontado, Integer stock, Integer cantVendida){
        Prenda prenda = new Prenda(nombre, descripcion, tipo, imagen, talla, genero, color, precioOriginal, stock);
		prenda.setIdPrenda(idPrenda);
		prenda.setPrecioDescontado(precioDescontado);
		prenda.setCantVendida(cantVendida);
		return this.prendaDAO.modificar(prenda);
    }

    public Integer eliminar(Integer idPrenda){
        return this.prendaDAO.eliminar(idPrenda);
    }

    public ArrayList<Prenda> listarTodos() {
        return this.prendaDAO.listarTodos();
    }

    public Prenda obtenerPorId(Integer idPrenda) {
        return this.prendaDAO.obtenerPorId(idPrenda);
    }
}
