package pe.edu.pucp.softrh.prendas.dao;

import java.util.ArrayList;
import pe.edu.pucp.softrh.prendas.model.Prenda;

public interface PrendaDAO {
    int insertar(Prenda prenda);

    int modificar(Prenda prendaModificada);

    int eliminar(int idPrenda);

    ArrayList<Prenda> listarTodos();

    Prenda obtenerPorId(int idPrenda);

	ArrayList<Prenda> listarPorNombreDescripcion(String cadena);

	ArrayList<Prenda> listarPrendasFiltradas(Double minPrice, Double maxPrice, Boolean filterHombre, Boolean filterMujer, Boolean filterUnisex, String tallas, String colores);

}
