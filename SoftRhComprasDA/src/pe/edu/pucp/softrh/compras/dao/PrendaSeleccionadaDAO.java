package pe.edu.pucp.softrh.compras.dao;

import pe.edu.pucp.softrh.compras.model.PrendaSeleccionada;
import java.util.ArrayList;

public interface PrendaSeleccionadaDAO {
    int insertar(PrendaSeleccionada prenda);

    int modificar(PrendaSeleccionada prenda);

    int eliminar(int idPrenda);

    ArrayList<PrendaSeleccionada> listarTodos();

    PrendaSeleccionada obtenerPorId(int idPrenda);
}
