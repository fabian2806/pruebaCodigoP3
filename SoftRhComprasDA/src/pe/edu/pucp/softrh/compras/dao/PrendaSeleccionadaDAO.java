package pe.edu.pucp.softrh.compras.dao;

import pe.edu.pucp.softrh.compras.model.PrendaSeleccionada;
import java.util.ArrayList;

public interface PrendaSeleccionadaDAO {
    Integer insertar(PrendaSeleccionada prenda);

    Integer modificar(PrendaSeleccionada prenda);

    Integer eliminar(Integer idPrenda);

    ArrayList<PrendaSeleccionada> listarTodos();

    PrendaSeleccionada obtenerPorId(Integer idPrenda);
}
