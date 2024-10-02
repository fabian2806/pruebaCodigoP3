package pe.edu.pucp.softrh.compras.dao;

import pe.edu.pucp.softrh.compras.model.PrendaSeleccionada;
import java.util.ArrayList;

public interface PrendaSeleccionadaDAO {
    public Integer insertar(PrendaSeleccionada prenda);

    public Integer modificar(PrendaSeleccionada prendaModificada);

    public Integer eliminar(PrendaSeleccionada prenda);

    public ArrayList<PrendaSeleccionada> obtenerTodos();

    //public PrendaSeleccionada obtenerPorId(String idPrendaS);
}
