package pe.edu.pucp.softrh.prendas.dao;

import java.util.ArrayList;
import pe.edu.pucp.softrh.prendas.model.Prenda;

public interface PrendaDAO {
    Integer insertar(Prenda prenda);

    Integer modificar(Prenda prendaModificada);

    Integer eliminar(Integer idPrenda);

    ArrayList<Prenda> listarTodos();

    Prenda obtenerPorId(Integer idPrenda);
}
